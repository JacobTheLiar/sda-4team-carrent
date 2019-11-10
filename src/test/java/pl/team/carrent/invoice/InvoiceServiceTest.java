package pl.team.carrent.invoice;


import org.junit.Test;
import org.mockito.internal.util.collections.Sets;
import pl.team.carrent.model.Invoice;
import pl.team.carrent.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 14:37
 * *
 * @className: InvoiceServiceTest
 * *
 * *
 ******************************************************/
public class InvoiceServiceTest{
    
    private static String FIND_NUMBER = "abc";
    private static String FIND_NONE   = "match draw";
    private static int    FIND_ID     = 1;
    
    private Invoice invoice1 = new Invoice(1, "abc1", BigDecimal.valueOf(12.30), LocalDate.of(2019, 11, 9),
                                           LocalDate.of(2019, 11, 9), LocalDate.of(2019, 11, 9));
    private Invoice invoice2 = new Invoice(2, "abc2", BigDecimal.valueOf(23.40), LocalDate.of(2019, 10, 9),
                                           LocalDate.of(2019, 11, 8), LocalDate.of(2019, 10, 8));
    private Invoice invoice3 = new Invoice(3, "cde3", BigDecimal.valueOf(34.50), LocalDate.of(2019, 9, 9),
                                           LocalDate.of(2019, 9, 10), LocalDate.of(2019, 9, 9));
    private Invoice invoice4 = new Invoice(4, "cde4", BigDecimal.valueOf(45.60), LocalDate.of(2019, 9, 9),
                                           LocalDate.of(2019, 9, 10), LocalDate.of(2019, 9, 9));
    
    
    private InvoiceRepository getInvoiceRepository(){
        InvoiceRepository mock = mock(InvoiceRepository.class);
        
        when(mock.findByNumberContains(FIND_NUMBER)).thenReturn(Sets.newSet(invoice1, invoice2));
        when(mock.findByClientId(FIND_ID)).thenReturn(Sets.newSet(invoice3));
        when(mock.findAll()).thenReturn(Arrays.asList(invoice1, invoice2, invoice3));
        when(mock.findById(1)).thenReturn(Optional.of(invoice1));
        when(mock.save(invoice4)).thenReturn(invoice4);
        
        return mock;
    }
    
    
    private InvoiceService invoiceService = new InvoiceService(getInvoiceRepository());
    
    
    @Test
    public void shouldReturnAllInvoices(){
        Set<Invoice> actual = invoiceService.getAllInvoices();
        assertThat(actual).containsExactlyInAnyOrder(invoice1, invoice2, invoice3);
    }
    
    
    @Test
    public void shouldReturnTwoInvoicesBySearchNumber(){
        Set<Invoice> actual = invoiceService.searchInvoicesByNumber(FIND_NUMBER);
        assertThat(actual).containsExactlyInAnyOrder(invoice1, invoice2);
    }
    
    
    @Test
    public void shouldReturnEmptyResultBySearchNumber(){
        Set<Invoice> actual = invoiceService.searchInvoicesByNumber(FIND_NONE);
        assertThat(actual).isEmpty();
    }
    
    
    @Test
    public void shouldAddInvoice(){
        Invoice actual = invoiceService.saveInvoice(invoice4);
        assertThat(actual).isEqualTo(invoice4);
    }
    
    
    @Test
    public void shouldFindInvoiceById(){
        Invoice actual = invoiceService.getInvoiceById(FIND_ID);
        assertThat(actual).isEqualTo(invoice1);
    }
    
    
    @Test(expected = InvoiceNotExistException.class)
    public void shouldRaiseExceptionByIdSearch(){
        invoiceService.getInvoiceById(4);
    }
}
