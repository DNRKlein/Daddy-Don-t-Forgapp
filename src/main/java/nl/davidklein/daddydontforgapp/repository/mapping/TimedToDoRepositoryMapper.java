package nl.davidklein.daddydontforgapp.repository.mapping;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;
import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.domain.core.User;
import nl.davidklein.daddydontforgapp.repository.jpa.TimedToDoJpa;
import nl.davidklein.daddydontforgapp.repository.jpa.UserJpa;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Repository mapper to map {@link TimedToDo} to {@link TimedToDoJpa} and otherway around
 */
@Component
public class TimedToDoRepositoryMapper implements RepositoryMapper<TimedToDo, TimedToDoJpa> {
    private UserRepositoryMapper userRepositoryMapper;

    @Inject
    public TimedToDoRepositoryMapper(final UserRepositoryMapper userRepositoryMapper) {
        this.userRepositoryMapper = userRepositoryMapper;
    }


    /**
     * Maps a {@link TimedToDoJpa} to a {@link TimedToDo}
     * @param source
     *      The {@link TimedToDoJpa} that needs to be mapped
     * @return
     *      The mapped {@link TimedToDo}
     */
    @Override
    public TimedToDo mapToDomain(final TimedToDoJpa source) {
        if(source == null){
            return null;
        }

        final User sender = userRepositoryMapper.mapToDomain(source.getSender());
        final User receiver = userRepositoryMapper.mapToDomain(source.getReceiver());


        return new TimedToDo(source.getId(), sender, receiver, source.getTitle(),
                new PeriodWithTime(source.getStartDate(), source.getEndDate()), source.getText());
    }

    /**
     * Maps a {@link TimedToDo} to a {@link TimedToDoJpa}
     * @param source
     *      The {@link TimedToDo} that needs to be mapped
     * @return
     *      The mapped {@link TimedToDoJpa}
     */
    @Override
    public TimedToDoJpa mapToJpa(final TimedToDo source) {
        if(source == null) {
            return null;
        }

        final UserJpa sender = userRepositoryMapper.mapToJpa(source.getSender());
        final UserJpa receiver = userRepositoryMapper.mapToJpa(source.getReceiver());

        return new TimedToDoJpa(source.getId(), source.getTitle(), source.getText(), source.getPeriod().getStartDate(), source.getPeriod().getEndDate(),
                sender, receiver);
    }
}
