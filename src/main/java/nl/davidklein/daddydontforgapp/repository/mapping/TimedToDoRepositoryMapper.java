package nl.davidklein.daddydontforgapp.repository.mapping;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;
import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.domain.core.User;
import nl.davidklein.daddydontforgapp.repository.jpa.TimedToDoJpa;
import org.springframework.stereotype.Component;

/**
 * Repository mapper to map {@link TimedToDo} to {@link TimedToDoJpa} and otherway around
 */
@Component
public class TimedToDoRepositoryMapper implements RepositoryMapper<TimedToDo, TimedToDoJpa> {

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

        return new TimedToDo(source.getId(), new User( "David"), new User( "Debbie"), source.getTitle(),
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

        return new TimedToDoJpa(source.getId(), source.getTitle(), source.getText(), source.getPeriod().getStartDate(), source.getPeriod().getEndDate());
    }
}
