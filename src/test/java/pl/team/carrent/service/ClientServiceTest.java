package pl.team.carrent.service;


import org.assertj.core.util.Sets;
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
    private Client client4 = new Client(4, "Gąska", "Arachidowa 87", "00-003", "Warszawa", "PL3334445566",
                                        "noiwak@poczta.pl", "4822999887766");
    
    
    
    private ClientRepository getClientRepositoryMock(){
        ClientRepository mock = mock(ClientRepository.class);
        
        when(mock.findByNameContainsIgnoreCase(FIND_NAME)).thenReturn(Sets.newLinkedHashSet(client1, client2));
        when(mock.findByAddressContainsIgnoreCase(FIND_ADDRESS)).thenReturn(Sets.newLinkedHashSet(client2));
        when(mock.findByTelephoneNrContainsIgnoreCase(FIND_TELEPHONE)).thenReturn(
                Sets.newLinkedHashSet(client2, client3));
        when(mock.findAll()).thenReturn(Arrays.asList(client1, client2, client3));
        when(mock.findById(1)).thenReturn(Optional.of(client1));
        when(mock.save(client4)).thenReturn(client4);
        
        return mock;
    }
    
    
    private ClientService clientService = new ClientService(getClientRepositoryMock());
    
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
    
    
    @Test
    public void shouldAddClient(){
        Client actual = clientService.saveClient(client4);
        assertThat(actual).isEqualTo(client4);
    }
}