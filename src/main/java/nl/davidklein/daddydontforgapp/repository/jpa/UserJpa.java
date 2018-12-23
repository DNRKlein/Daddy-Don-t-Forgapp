package nl.davidklein.daddydontforgapp.repository.jpa;

import javax.persistence.*;
import java.util.Set;

@Table(name = "USERS")
@Entity
public class UserJpa extends JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USR_ID")
    private Long id;

    @Column(name = "USR_NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "TTD_USR_ID_SENDER")
    private Set<TimedToDoJpa> sendTimedToDos;

    @OneToMany
    @JoinColumn(name = "TTD_USR_ID_RECEIVER")
    private Set<TimedToDoJpa> receivedTimedToDos;

    /**
     * Default constructor needed for JPA
     */
    public UserJpa() {
    }

    /**
     * Constructor
     * @param id
     *      The id of this user
     * @param name
     *      The name of this user
     * @param sendTimedToDos
     *      The {@link TimedToDoJpa}s this user has send to others
     * @param receivedTimedToDos
     *      The {@link TimedToDoJpa}s this user has received from others
     */
    public UserJpa(final Long id, final String name, final Set<TimedToDoJpa> sendTimedToDos, final Set<TimedToDoJpa> receivedTimedToDos) {
        this.id = id;
        this.name = name;
        this.sendTimedToDos = sendTimedToDos;
        this.receivedTimedToDos = receivedTimedToDos;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Set<TimedToDoJpa> getSendTimedToDos() {
        return sendTimedToDos;
    }

    public void setSendTimedToDos(Set<TimedToDoJpa> sendTimedToDos) {
        this.sendTimedToDos = sendTimedToDos;
    }

    public Set<TimedToDoJpa> getReceivedTimedToDos() {
        return receivedTimedToDos;
    }

    public void setReceivedTimedToDos(Set<TimedToDoJpa> receivedTimedToDos) {
        this.receivedTimedToDos = receivedTimedToDos;
    }
}
