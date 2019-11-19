package pl.team.carrent.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.team.carrent.invoice.Invoice;
import pl.team.carrent.invoice.InvoiceRepository;

import javax.transaction.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 15:38
 * *
 * @className: InvoiceRepositoryTest
 * *
 * *
 ******************************************************/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class InvoiceRepositoryTest{
    
    @Autowired
    private InvoiceRepository     invoiceRepository;
    @Autowired
    private RentHistoryRepository rentHistory;
    @Autowired
    private ClientRepository      clientRepository;
    
    private Invoice invoice1 = new Invoice("abc1", BigDecimal.valueOf(12.30), LocalDate.of(2019, 11, 9),
                                           LocalDate.of(2019, 11, 9), LocalDate.of(2019, 11, 9));
    
    
    @Test
    public void shouldAddInvoice(){
        Invoice actual = invoiceRepository.save(invoice1);
        assertThat(actual).isEqualTo(invoice1);
    }
    
    
    @Test
    public void shouldFindInvoiceByNumber(){
        Set<Invoice> actual = invoiceRepository.findByNumberContains("2018");
        
        assertThat(actual.size()).isEqualTo(2);
    }
    
    
    @Test
    public void shouldFindInvoiceById(){
        Optional<Invoice> actual = invoiceRepository.findById(3);
        
        assertThat(actual.get().getNumber()).isEqualTo("2019/1");
    }
    
    
    @Test
    public void shouldFindTwoInvoicesByClientId(){
        Set<Invoice> actual = invoiceRepository.findByClientId(1);
        
        assertThat(actual.size()).isEqualTo(2);
    }
}