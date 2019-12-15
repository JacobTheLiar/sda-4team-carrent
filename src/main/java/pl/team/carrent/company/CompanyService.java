package pl.team.carrent.company;


import org.springframework.stereotype.Service;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-15 17:33
 * *
 * @className: CompanyService
 * *
 * *
 ******************************************************/
@Service
public class CompanyService{
    
    private final CompanyRepository companyRepository;
    
    
    public CompanyService(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
    
    
    public Company getCompanyDetail(){
        return companyRepository.getOne(1);
    }
    
    public Company setCompanyData(Company company){
        company.setId(1);
        return companyRepository.save(company);
    }
    
}
