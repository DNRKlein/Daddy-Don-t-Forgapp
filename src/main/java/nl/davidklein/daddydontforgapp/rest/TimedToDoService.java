package nl.davidklein.daddydontforgapp.rest;

import nl.davidklein.daddydontforgapp.domain.core.TimedToDo;
import nl.davidklein.daddydontforgapp.repository.TimedToDoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

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
}
