package pl.team.carrent.repository;


import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.client.Client;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


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
@Transactional
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
        Set<Client> clients = clientRepository.findByNameContainsIgnoreCase("kowals");
        assertThat(clients.size()).isEqualTo(1);
    }
    
    @Test
    public void shouldFindByPartialAddress(){
        Set<Client> clients = clientRepository.findByAddressContainsIgnoreCase("street and fifth avenue");
        Assert.assertEquals(4, clients.size());
    }
    
    @Test
    public void shouldFindByPartialNumber(){
        Set<Client> clients = clientRepository.findByTelephoneNrContainsIgnoreCase("6500");
        Assert.assertEquals(2, clients.size());
    }
    
    @Test
    public void shouldBeNoFoundClient(){
        Set<Client> clients = clientRepository.findByNameContainsIgnoreCase("mietek");
        Assert.assertEquals(0, clients.size());
    }
    

    
}