package pl.team.carrent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.team.carrent.model.Client;

import java.util.List;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 14:19
 * *
 * @className: ClientRepository
 * *
 * *
 ******************************************************/
public interface ClientRepository extends JpaRepository<Client, Integer>{
    
    List<Client> findByNameContainsIgnoreCase(String name);
    List<Client> findByAddressContainsIgnoreCase(String address);
    List<Client> findByTelephoneNrContainsIgnoreCase(String telephoneNr);
    
    
}
