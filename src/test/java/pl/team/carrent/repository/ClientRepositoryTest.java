package pl.team.carrent.repository;


import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.model.Client;

import java.util.List;




/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-10-27 15:13
 * *
 * @className: ClientRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRepositoryTest{
    
    @Autowired
    private ClientRepository clientRepository;

    
    @Test
    public void shouldBeAddedClient(){
        Client addedClient = new Client("King Julien XIII", "64th Street and Sixth Avenue", "10021", "New York", "0000000000", "cpzinfo@wcs.org", "(212) 439-6550");
        clientRepository.save(addedClient);
        List<Client> clients = clientRepository.findAll();
        Assert.assertEquals(5, clients.size());
    }
    
    
    @Test
    public void shouldFindByPartialName(){
        List<Client> clients = clientRepository.findByNameContainsIgnoreCase("kowals");
        Assert.assertEquals(clients.get(0).getName(), "Kowalsky");
    }
    
    @Test
    public void shouldFindByPartialAddress(){
        List<Client> clients = clientRepository.findByAddressContainsIgnoreCase("street and fifth avenue");
        Assert.assertEquals(4, clients.size());
    }
    
    @Test
    public void shouldFindByPartialNumber(){
        List<Client> clients = clientRepository.findByTelephoneNrContainsIgnoreCase("6500");
        Assert.assertEquals(2, clients.size());
    }
    
    @Test
    public void shouldBeNoFoundClient(){
        List<Client> clients = clientRepository.findByNameContainsIgnoreCase("mietek");
        Assert.assertEquals(0, clients.size());
    }
    

    
}