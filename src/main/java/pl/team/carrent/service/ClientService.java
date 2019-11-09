package pl.team.carrent.service;


import org.springframework.stereotype.Service;
import pl.team.carrent.client.ClientNotExistException;
import pl.team.carrent.model.Client;
import pl.team.carrent.repository.ClientRepository;
import pl.team.carrent.client.SearchClientOption;

import java.util.HashSet;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 10:11
 * *
 * @className: ClientService
 * *
 * *
 ******************************************************/
@Service
public class ClientService{
    
    private final ClientRepository clientRepository;
    
    
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    
    
    public Set<Client> getAllClients(){
        return new HashSet<>(clientRepository.findAll());
    }
    
    
    public Set<Client> searchClients(String searchWhat, SearchClientOption searchClientOption){
        
        switch (searchClientOption) {
            case BY_NAME:
                return clientRepository.findByNameContainsIgnoreCase(searchWhat);
            case BY_ADDRESS:
                return clientRepository.findByAddressContainsIgnoreCase(searchWhat);
            case BY_TELEPHONE:
                return clientRepository.findByTelephoneNrContainsIgnoreCase(searchWhat);
        }
        
        return new HashSet<>();
    }
    
    
    public Client getClient(int clientId){
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ClientNotExistException("clientID: " + clientId));
    }
    
    public Client saveClient(Client client){
        return clientRepository.save(client);
    }
}
