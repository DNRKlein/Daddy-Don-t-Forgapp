package nl.davidklein.daddydontforgapp.domain.common;

public class PeriodWithoutTimeException extends Exception {
    public PeriodWithoutTimeException() {
        super();
    }

    public PeriodWithoutTimeException(final String message) {
        super(message);
    }
}
