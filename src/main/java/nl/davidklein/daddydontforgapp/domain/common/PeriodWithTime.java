package nl.davidklein.daddydontforgapp.domain.common;

import java.time.LocalDateTime;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.Objects.requireNonNull;

/**
 * Represents a period, start and enddate with times.
 */
public class PeriodWithTime {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    /**
     * Constructor that only takes a startDate. EndDate will be {@code null}, meaning the period is an open period.
     * @param startDate
     *      The datetime that this period starts
     */
    public PeriodWithTime(final LocalDateTime startDate) {
        this(startDate, null);
    }

    /**
     * Constructor
     * @param startDate
     *      The startDate of the period.
     * @param endDate
     *      The endDate of the period.
     */
    public PeriodWithTime(final LocalDateTime startDate, final LocalDateTime endDate){
        requireNonNull(startDate);

        if(endDate != null) {
            checkArgument(startDate.isBefore(endDate), "Startdate must be before endDate");
        }

        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * Checks whether a specific date is within the range of this period.
     * @param dateTime
     *          The date to check
     * @return
     *      {@code true} if the date is within the range, {@code false} otherwise.
     */
    public boolean includes(final LocalDateTime dateTime){
        return dateTime.isAfter(startDate) && dateTime.isBefore(endDate);
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }
}
