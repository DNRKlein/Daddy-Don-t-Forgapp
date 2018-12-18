package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.repository.mapping.RepositoryMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

import static java.util.Objects.requireNonNull;

/**
 * Abstract repository which presents a couple of standard functionalities for reading and writing Domain objects
 */
@Repository
public abstract class AbstractRepository<ENTITY, JPA> {

    @Inject
    private ToDoEntityManager entityManager;

    /**
     * Returns the repositorymapper used to map the JPA to the ENTITY
     * @return
     *      The {@link RepositoryMapper}
     */
    protected abstract RepositoryMapper<ENTITY, JPA> getRepositoryMapper();

    /**
     * Gets the JPA of the entity with this id
     * @param identity
     *          The id of the entity to get
     * @return
     *      Returns the JPA of the entity
     */
    protected abstract JPA doGetJpa(final Long identity);

    /**
     * Gets the entity manager
     * @return
     *      The {@link ToDoEntityManager}
     */
    protected final ToDoEntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Gets an entity by its id
     * @param identity
     *      The id of the entity
     * @return
     *      The entity
     */
    public ENTITY get(final Long identity) {
        requireNonNull(identity);

        final JPA jpaEntity = doGetJpa(identity);
        return getRepositoryMapper().mapToDomain(jpaEntity);
    }
}
