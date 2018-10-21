package nl.davidklein.daddydontforgapp.domain.core;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;

/**
 * A ToDo that is characterized by it's time. It has a start and enddate.
 */
public class TimedToDo extends ToDo {
    private PeriodWithTime period;

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
     */
    public TimedToDo(final Long id, final User sender, final User receiver, final String title, final PeriodWithTime period) {
        super(id, sender, receiver, title);
        this.period = period;
    }

    public PeriodWithTime getPeriod() {
        return period;
    }
}
