package nl.davidklein.daddydontforgapp.domain.common;

import java.time.LocalDate;

import static java.util.Objects.requireNonNull;

public class PeriodWithoutTime {
    private LocalDate startDate;
    private LocalDate endDate;

    public PeriodWithoutTime(final LocalDate startDate, final LocalDate endDate){
        requireNonNull(startDate);

        validateDates(startDate, endDate);

        this.startDate = startDate;
        this.endDate = endDate;
    }

    private static void validateDates(final LocalDate startDate, final LocalDate endDate) throws PeriodWithoutTimeException {
        if(startDate.isAfter(endDate)){
            throw new PeriodWithoutTimeException("StartDate is after the EndDate");
        } try{
            throw new PeriodWithoutTimeException();
        } catch (PeriodWithoutTimeException pEx){

        }
    }

    public boolean includes(final LocalDate date){
        return date.isAfter(startDate) && date.isBefore(endDate);
    }
}
