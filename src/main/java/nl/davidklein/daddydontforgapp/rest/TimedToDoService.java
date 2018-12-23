package nl.davidklein.daddydontforgapp.rest;

import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.repository.TimedToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

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

    @GetMapping(value = "/{id}")
    public ResponseEntity<TimedToDo> getTimedToDo(@PathVariable("id") final Long id){
        final TimedToDo timedToDo = timedToDoRepository.get(id);

        if(timedToDo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(timedToDo, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<TimedToDo> addTimedToDo(@RequestBody final TimedToDo timedToDo){
        final TimedToDo addedTimedToDo = timedToDoRepository.add(timedToDo);

        return new ResponseEntity<>(addedTimedToDo, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimedToDo>> getTimedToDosBySender(@RequestParam(value = "sender") final Long senderId){
        final List<TimedToDo> timedToDos = timedToDoRepository.getTimedToDosBySender(senderId);

        if(timedToDos == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(timedToDos, HttpStatus.OK);
        }
    }
}
