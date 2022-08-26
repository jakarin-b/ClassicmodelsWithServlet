package sit.int202.classicmodelweb.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

class EntityManagerService {
     static EntityManager getEntityManager(){
          return Persistence.createEntityManagerFactory("classic-model").createEntityManager();
     }
}
