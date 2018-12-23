package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.repository.jpa.JpaEntity;
import nl.davidklein.daddydontforgapp.repository.mapping.RepositoryMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Abstract repository which presents a couple of standard functionalities for reading and writing Domain objects
 */
@Repository
public abstract class AbstractRepository<ENTITY, JPA extends JpaEntity> {

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
        requireNonNull(identity, "Cannot search for an entity with null id");

        final JPA jpaEntity = doGetJpa(identity);
        return getRepositoryMapper().mapToDomain(jpaEntity);
    }

    /**
     * Adds an entity to the repository
     * @param entityToAdd
     *      The ENTITY to add
     * @return
     *      Returns the entity after it's been added to the repository. This means that the identity property of the entity
     *      should be set.
     */
    public ENTITY add(final ENTITY entityToAdd){
        requireNonNull(entityToAdd, "You may not add a null entity");

        final JPA jpaEntity = getRepositoryMapper().mapToJpa(entityToAdd);
        return getRepositoryMapper().mapToDomain(getEntityManager().merge(jpaEntity));
    }

    protected List<ENTITY> doMapFoundEntities(final Collection<? extends JPA> jpaCollection){
        requireNonNull(jpaCollection);

        final List<ENTITY> domainEntities = new ArrayList<>();
        //TODO rewrite naar java8 streaming
        for(final JPA jpaEntity : jpaCollection) {
            domainEntities.add(doMapFoundEntity(jpaEntity));
        }

        return domainEntities;
    }

    protected ENTITY doMapFoundEntity(final JPA jpaEntity){
        requireNonNull(jpaEntity);

        final RepositoryMapper<ENTITY, JPA> repositoryMapper = getRepositoryMapper();

        return repositoryMapper.mapToDomain(jpaEntity);
    }
}
