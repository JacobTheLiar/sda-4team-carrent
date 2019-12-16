package pl.team.carrent.company;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


/**
 * @author: Jakub O.  [https://github.com/JacobTheLiar]
 * @date : 2019-12-15 17:26
 * *
 * @className: CompanyRepository
 * *
 * *
 ******************************************************/
public interface CompanyRepository extends JpaRepository<Company, Integer>{

}
