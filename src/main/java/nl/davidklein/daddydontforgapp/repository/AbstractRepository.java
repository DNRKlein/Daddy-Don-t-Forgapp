package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.repository.mapping.RepositoryMapper;
import org.springframework.stereotype.Repository;

import static java.util.Objects.requireNonNull;

/**
 * Abstract repository which presents a couple of standard functionalities for reading and writing Domain objects
 */
@Repository
public abstract class AbstractRepository<ENTITY, JPA> {
    //private EntityManager entityManager;

    protected abstract RepositoryMapper<ENTITY, JPA> getRepositoryMapper();

    protected abstract JPA doGetJpa(final long identity);

    /*protected final EntityManager getEntityManager() {
        return entityManager;
    }*/

    public ENTITY get(final long identity) {
        requireNonNull(identity);

        final JPA jpaEntity = doGetJpa(identity);
        return getRepositoryMapper().mapToDomain(jpaEntity);
    }
}
