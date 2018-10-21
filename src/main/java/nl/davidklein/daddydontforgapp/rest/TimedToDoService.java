package nl.davidklein.daddydontforgapp.rest;

import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.repository.TimedToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Set;

/**
 * Provides the backend with a rest interface that services {@link TimedToDo}.
 */
@RestController
@RequestMapping("/todo/timed")
public class TimedToDoService {
    private TimedToDoRepository timedToDoRepository;

    /**
     * Constructor
     * @param timedToDoRepository
     *      The repository used to create, read, update and delete the todo's.
     */
    @Inject
    public TimedToDoService(final TimedToDoRepository timedToDoRepository) {
        this.timedToDoRepository = timedToDoRepository;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TimedToDo> getTimedToDo(@PathVariable("id") final Long id){
        final TimedToDo timedToDo = timedToDoRepository.get(id);

        if(timedToDo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(timedToDo, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Set<TimedToDo>> getTimedToDosBySender(@RequestParam(value = "user") final Long userId){
        final Set<TimedToDo> timedToDos = timedToDoRepository.findBySender(userId);

        return new ResponseEntity<>(timedToDos, HttpStatus.OK);
    }

}
