package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import sit.int202.classicmodelweb.entities.Product;

import java.util.List;

public class ProductRepository {
    private final static int PAGE_SIZE = 10;
    private EntityManager getEntityManager(){
        return EntityManagerService.getEntityManager();
    }

    public int getDefaultPageSize(){
        return PAGE_SIZE;
    }
    public List<Product> findAll(int page, int pageSize) {
        EntityManager em = getEntityManager();
        int startPosition = (page - 1) * pageSize;
        Query query = em.createNamedQuery("Product.findAll");
        query.setFirstResult(startPosition);
        query.setMaxResults(pageSize);
        List<Product> productList = query.getResultList();
        em.close();
        return productList;
    }
    public Product find(String productCode) {
        EntityManager em = getEntityManager();
        Product product = em.find(Product.class, productCode);
        em.close();
        return product;
    }

    public Product findProduct(String productCode) {
        return find(productCode);
    }

    public int countAll() {
        EntityManager em = getEntityManager();
        int number = ((Number) em.createNamedQuery("Product.count").getSingleResult()).intValue();
        em.close();
        return number;
    }

}
