package pl.team.carrent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Client;

import java.util.List;
import java.util.Set;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 14:19
 * *
 * @className: ClientRepository
 * *
 * *
 ******************************************************/
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
    Set<Client> findByNameContainsIgnoreCase(String name);
    Set<Client> findByAddressContainsIgnoreCase(String address);
    Set<Client> findByTelephoneNrContainsIgnoreCase(String telephoneNr);
    
    
}
