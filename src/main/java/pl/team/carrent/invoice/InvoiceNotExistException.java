package pl.team.carrent.invoice;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 14:23
 * *
 * @className: InvoiceNotExistException
 * *
 * *
 ******************************************************/
public class InvoiceNotExistException extends RuntimeException{
    
    public InvoiceNotExistException(String message){
        super(message);
    }
}
