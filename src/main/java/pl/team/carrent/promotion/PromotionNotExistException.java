package pl.team.carrent.promotion;

/******************************************************
 * @author: Michal S.  
 * [https://github.com/DreamDoer86]
 * @date : 16.11.2019 09:58
 * *
 * @className: PromotionNotExistException
 * *
 ******************************************************/
public class PromotionNotExistException  extends RuntimeException{

    public PromotionNotExistException(String message){
        super(message);
    }
}
