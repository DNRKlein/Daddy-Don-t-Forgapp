package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.repository.jpa.TimedToDoJpa;
import nl.davidklein.daddydontforgapp.repository.jpa.UserJpa;
import nl.davidklein.daddydontforgapp.repository.mapping.TimedToDoRepositoryMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * Repository implementation for the {@link nl.davidklein.daddydontforgapp.domain.core.TimedToDo}
 */
@Repository
public class TimedToDoRepository extends AbstractRepository<TimedToDo, TimedToDoJpa> {

    private UserRepository userRepository;
    private TimedToDoRepositoryMapper repositoryMapper;

    @Inject
    public TimedToDoRepository(final TimedToDoRepositoryMapper repositoryMapper, final UserRepository userRepository) {
        requireNonNull(repositoryMapper);
        requireNonNull(userRepository);

        this.repositoryMapper = repositoryMapper;
        this.userRepository = userRepository;
    }

    @Override
    public TimedToDoJpa doGetJpa(final Long identity) {
        return getEntityManager().find(identity, TimedToDoJpa.class);
    }

    @Override
    public TimedToDoRepositoryMapper getRepositoryMapper() {
        return repositoryMapper;
    }

    public List<TimedToDo> getTimedToDosBySender(final Long senderId){
        final UserJpa sender = userRepository.doGetJpa(senderId);

        final String getBySenderQueryString = "select t from TimedToDoJpa t where sender = :sender";

        final TypedQuery<TimedToDoJpa> query = getEntityManager().createEntityQuery(getBySenderQueryString, TimedToDoJpa.class);
        query.setParameter("sender", sender);
        return doMapFoundEntities(query.getResultList());
    }
}
