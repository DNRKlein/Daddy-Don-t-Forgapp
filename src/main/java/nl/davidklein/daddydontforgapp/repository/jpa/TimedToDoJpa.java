package nl.davidklein.daddydontforgapp.repository.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TIMED_TO_DO")
public class TimedToDoJpa extends JpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TTD_ID")
    private Long id;

    @Column(name = "TTD_TITLE")
    private String title;

    @Column(name = "TTD_TEXT")
    private String text;

    @Column(name = "TTD_START_DATE")
    private LocalDateTime startDate;

    @Column(name = "TTD_END_DATE")
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "TTD_USR_ID_SENDER")
    private UserJpa sender;

    @ManyToOne
    @JoinColumn(name = "TTD_USR_ID_RECEIVER")
    private UserJpa receiver;

    /**
     * Default constructor needed for JPA
     */
    public TimedToDoJpa() {
    }

    /**
     * Constructor
     * @param id
     *      The id
     * @param title
     *      The title
     * @param text
     *      The text
     * @param startDate
     *      The startDate
     * @param endDate
     *      The endDate
     * @param sender
     *      The sender
     * @param receiver
     *      The receiver
     */
    public TimedToDoJpa(final Long id, final String title, final String text, final LocalDateTime startDate, final LocalDateTime endDate,
                        final UserJpa sender, final UserJpa receiver) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.startDate = startDate;
        this.endDate = endDate;
        this.sender = sender;
        this.receiver = receiver;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(final LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(final LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public UserJpa getSender() {
        return sender;
    }

    public void setSender(UserJpa sender) {
        this.sender = sender;
    }

    public UserJpa getReceiver() {
        return receiver;
    }

    public void setReceiver(UserJpa receiver) {
        this.receiver = receiver;
    }
}
