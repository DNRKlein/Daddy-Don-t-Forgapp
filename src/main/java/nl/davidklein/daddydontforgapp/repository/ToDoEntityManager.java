package nl.davidklein.daddydontforgapp.repository;

import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Application specific {@link EntityManager} to keep database/session/transaction in one place
 */
@Component
public class ToDoEntityManager {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Constructor
     *
     * @param entityManager The entitymanager used to perform database operations
     */
    @Inject
    public ToDoEntityManager(final EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persists an entity to the database
     * @param entity
     *          The entity that needs to be persisted
     */
    public void persist(final Object entity){
        entityManager.persist(entity);
    }

    /**
     * Merges an entity and persists that merge to the database
     * @param entity
     *          The entity that is to be merged
     */
    public void merge(final Object entity){
        entityManager.merge(entity);
    }

    /**
     * Finds the entity with the identity and of type clazz
     * @param identity
     *          The identity of the entity
     * @param clazz
     *          The Class of the entity
     * @return
     *          The entity if found, null if not found
     */
    //TODO if the entity is not found, null shouldnt be returned, but an exception should be thrown
    public <T> T find(final Long identity, final Class<T> clazz){
        return entityManager.find(clazz, identity);
    }


}
