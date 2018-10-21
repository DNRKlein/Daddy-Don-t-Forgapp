package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;
import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.domain.core.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Repository implementation for the {@link nl.davidklein.daddydontforgapp.domain.core.TimedToDo}
 */
@Repository
public class TimedToDoRepository  {

    private Set<TimedToDo> timedToDos;


    public TimedToDoRepository() {
        this.timedToDos = new HashSet<>();

        timedToDos.add(new TimedToDo(1L, new User(1L, "David"), new User(2L, "Debbie"), "DavidToDebbie1", new PeriodWithTime(LocalDateTime.now())));
        timedToDos.add(new TimedToDo(2L, new User(1L, "David"), new User(2L, "Debbie"), "DavidToDebbie2", new PeriodWithTime(LocalDateTime.now())));
        timedToDos.add(new TimedToDo(3L, new User(2L, "Debbie"), new User(1L, "David"), "DebbieToDavid1", new PeriodWithTime(LocalDateTime.now())));
    }

    /**
     * Gets a single {@link TimedToDo} by the id.
     * @param id
     *      The id of the {@link TimedToDo}.
     * @return
     *      The {@link TimedToDo} with the given id.
     */
    public TimedToDo get(final Long id) {
        return timedToDos.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    /**
     * Gets a list of all the {@link TimedToDo} a sender
     * @param senderId
     *      The id of the {@link User} which send the {@link TimedToDo}.
     * @return
     */
    public Set<TimedToDo> findBySender(final Long senderId) {
        return timedToDos.stream().filter(s -> s.getSender().getId().equals(senderId)).collect(Collectors.toSet());
    }
}
