package pl.team.carrent.client;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 11:00
 * *
 * @className: ClientNotExistException
 * *
 * *
 ******************************************************/
public class ClientNotExistException extends RuntimeException{
    
    public ClientNotExistException(String message){
        super(message);
    }
}
