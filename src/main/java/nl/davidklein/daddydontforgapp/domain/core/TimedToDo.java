package nl.davidklein.daddydontforgapp.domain.core;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;

import static java.util.Objects.requireNonNull;

/**
 * A ToDo that is characterized by it's time. It has a start and enddate.
 */
public class TimedToDo extends ToDo {
    private PeriodWithTime period;
    private String text;

    /**
     * For deserialization purposes. FIXME this needs to be fixed, because it is ugly and makes it possible
     * to create empty DomainEntities
     */
    public TimedToDo() {
    }

    /**
     * Constructor
     * @param sender
     *      The {@link User} which send the ToDo.
     * @param receiver
     *      The {@link User} which is to receive the ToDo.
     * @param title
     *      The title of the ToDo.
     * @param period
     *      The {@link PeriodWithTime} in which this ToDo is valid.
     * @param text
     *      The text of the ToDO
     */
    public TimedToDo(final User sender, final User receiver, final String title, final PeriodWithTime period, final String text) {
        this(null, sender, receiver, title, period, text);
    }

    /**
     * Constructor
     * @param id
     *      The id of the ToDo.
     * @param sender
     *      The {@link User} which send the ToDo.
     * @param receiver
     *      The {@link User} which is to receive the ToDo.
     * @param title
     *      The title of the ToDo.
     * @param period
     *      The {@link PeriodWithTime} in which this ToDo is valid.
     * @param text
     *      The text of the ToDO
     */
    public TimedToDo(final Long id, final User sender, final User receiver, final String title, final PeriodWithTime period, final String text) {
        super(id, sender, receiver, title);
        requireNonNull(period);

        this.text = text;
        this.period = period;
    }

    public PeriodWithTime getPeriod() {
        return period;
    }

    public String getText() {
        return text;
    }
}
