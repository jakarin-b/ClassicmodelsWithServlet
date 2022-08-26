package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Employee;

import java.util.List;

public class EmployeeRepository {
    private EntityManager em;

    public EmployeeRepository(){
        this.em = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public Employee find(Integer employeeNumber){
        return  em.find(Employee.class, employeeNumber);
    }

    private static final String FIND_DESC = "select e from Employee e where e.firstName like :fname OR e.lastName like :lname";
    public List<Employee> findByDescreption(String findString){
        Query query = em.createQuery(FIND_DESC);
        query.setParameter("fname",findString+"%");
        query.setParameter("lname",findString+"%");
        return query.getResultList();
    }
}
