package pl.team.carrent.service;


import org.junit.Before;
import org.junit.Test;
import pl.team.carrent.client.ClientNotExistException;
import pl.team.carrent.model.Client;
import pl.team.carrent.repository.ClientRepository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;
import static pl.team.carrent.client.SearchClientOption.*;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 11:06
 * *
 * @className: ClientServiceTest
 * *
 * *
 ******************************************************/
public class ClientServiceTest{
    
    private final ClientRepository clientRepository = mock(ClientRepository.class);
    private       ClientService    clientService    = new ClientService(clientRepository);
    
    private static String FIND_NAME      = "kowal";
    private static String FIND_ADDRESS   = "rumia";
    private static String FIND_TELEPHONE = "8776";
    private static String FIND_NONE      = "abra cadabra";
    
    private Client client1 = new Client(1, "Kowalski", "Łubinowa 4", "00-001", "Warszawa", "PL1112223344",
                                        "kowalski@poczta.pl", "4822111223344");
    private Client client2 = new Client(2, "Kowalski", "Rumiankowa 4", "00-002", "Warszawa", "PL2223334455",
                                        "kowalski2@poczta.pl", "4822118776344");
    private Client client3 = new Client(3, "Nowak", "Arachidowa 87", "00-003", "Warszawa", "PL3334445566",
                                        "noiwak@poczta.pl", "4822999887766");
    
    
    @Before
    public void setUp() throws Exception{
        
        when(clientRepository.findByNameContainsIgnoreCase(FIND_NAME)).thenReturn(Arrays.asList(client1, client2));
        when(clientRepository.findByAddressContainsIgnoreCase(FIND_ADDRESS)).thenReturn(Arrays.asList(client2));
        when(clientRepository.findByTelephoneNrContainsIgnoreCase(FIND_TELEPHONE)).thenReturn(
                Arrays.asList(client2, client3));
        when(clientRepository.findAll()).thenReturn(Arrays.asList(client1, client2, client3));
        when(clientRepository.findById(1)).thenReturn(Optional.of(client1));
    }
    
    
    @Test
    public void shouldReturnAllClients(){
        Set<Client> actual = clientService.getAllClients();
        assertThat(actual).containsExactlyInAnyOrder(client1, client2, client3);
    }
    
    
    @Test
    public void shouldReturnTwoClientsByNameSearch(){
        Set<Client> actual = clientService.searchClients(FIND_NAME, BY_NAME);
        assertThat(actual).containsExactlyInAnyOrder(client1, client2);
    }
    
    
    @Test
    public void shouldReturnOneClientByAddressSearch(){
        Set<Client> actual = clientService.searchClients(FIND_ADDRESS, BY_ADDRESS);
        assertThat(actual).containsExactly(client2);
    }
    
    
    @Test
    public void shouldReturnTwoClientsByTelephoneSearch(){
        Set<Client> actual = clientService.searchClients(FIND_TELEPHONE, BY_TELEPHONE);
        assertThat(actual).containsExactly(client2, client3);
    }
    
    
    @Test
    public void shouldReturnOneClientByIdSearch(){
        Client actual = clientService.getClient(1);
        assertThat(actual).isEqualTo(client1);
    }
    
    
    @Test(expected = ClientNotExistException.class)
    public void shouldRaiseExceptionByIdSearch(){
        clientService.getClient(4);
    }
    
    
    @Test
    public void shouldNotFindAnyClientByNameSearch(){
        Set<Client> actual = clientService.searchClients(FIND_NONE, BY_NAME);
        assertThat(actual).isEmpty();
    }
    
    
    @Test
    public void shouldNotFindAnyClientByAddressSearch(){
        Set<Client> actual = clientService.searchClients(FIND_NONE, BY_ADDRESS);
        assertThat(actual).isEmpty();
    }

    @Test
    public void shouldNotFindAnyClientByTelephoneSearch(){
        Set<Client> actual = clientService.searchClients(FIND_NONE, BY_TELEPHONE);
        assertThat(actual).isEmpty();
    }
}