package pl.team.carrent.client;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-11-09 10:45
 * *
 * @className: SearchClientMethod
 * *
 * *
 ******************************************************/
public enum SearchClientOption{
    
    BY_NAME("po nazwie"), BY_ADDRESS("po adresie"), BY_TELEPHONE("po numerze telefonu");
    
    
    private String description;
    
    
    SearchClientOption(String description){
        this.description = description;
    }
    
    
    public String getDescription(){
        return description;
    }
    
    
    @Override
    public String toString(){
        return description;
    }
    
}
