package nl.davidklein.daddydontforgapp.repository.jpa;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "timed_to_do")
public class TimedToDoJpa {

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
     */
    public TimedToDoJpa(Long id, String title, String text, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
