package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.repository.jpa.TimedToDoJpa;
import nl.davidklein.daddydontforgapp.repository.mapping.TimedToDoRepositoryMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

/**
 * Repository implementation for the {@link nl.davidklein.daddydontforgapp.domain.core.TimedToDo}
 */
@Repository
public class TimedToDoRepository extends AbstractRepository<TimedToDo, TimedToDoJpa> {

    private TimedToDoRepositoryMapper repositoryMapper;

    @Inject
    public TimedToDoRepository(final TimedToDoRepositoryMapper repositoryMapper) {
        this.repositoryMapper = repositoryMapper;
    }

    @Override
    public TimedToDoJpa doGetJpa(final Long identity) {
        return getEntityManager().find(identity, TimedToDoJpa.class);
    }

    @Override
    public TimedToDoRepositoryMapper getRepositoryMapper() {
        return repositoryMapper;
    }
}
