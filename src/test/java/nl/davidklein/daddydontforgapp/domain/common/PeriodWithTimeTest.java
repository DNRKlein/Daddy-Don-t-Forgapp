package nl.davidklein.daddydontforgapp.domain.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.time.Month;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class PeriodWithTimeTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private PeriodWithTime classUnderTest;

    @Test
    public void createPeriodWithTimeOnlyStartDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);

        // Act
        classUnderTest = new PeriodWithTime(startDate);

        // Assert - wordt gedaan door expectedException, er wordt geen exception gegooid
        assertEquals(startDate, classUnderTest.getStartDate());
        assertNull(classUnderTest.getEndDate());

    }

    @Test
    public void createPeriodWithTimeNullStartDate(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        // Act
        classUnderTest = new PeriodWithTime(null);

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void createPeriodWithTimeNullDates(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        // Act
        classUnderTest = new PeriodWithTime(null, null);

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void createPeriodWithTimeStartAndEndDate(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);

        // Act
        classUnderTest = new PeriodWithTime(startDate, startDate.plusDays(1));

        // Assert - wordt gedaan door expectedException, er wordt geen exception gegooid
        assertEquals(startDate, classUnderTest.getStartDate());
        assertEquals(startDate.plusDays(1), classUnderTest.getEndDate());
    }

    @Test
    public void createPeriodWithTimeEqualStartAndEndDate(){
        // Arrange
        final LocalDateTime dateTime = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        expectedException.expect(IllegalArgumentException.class);

        // Act
        classUnderTest = new PeriodWithTime(dateTime, dateTime);

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void periodIncludesDateTime(){
        // Arrange
        final LocalDateTime dateTime = LocalDateTime.of(2018, Month.JANUARY, 1, 12, 0, 0);
        final LocalDateTime startDate = LocalDateTime.of(2018, Month.JANUARY, 1, 11, 0, 0);
        final LocalDateTime endDate = LocalDateTime.of(2018, Month.JANUARY, 1, 13, 0, 0);
        classUnderTest = new PeriodWithTime(startDate, endDate);

        // Act
        final boolean result = classUnderTest.includes(dateTime);

        // Assert
        assertTrue(result);
    }

    @Test
    public void periodDoesNotIncludeDateTime(){
        // Arrange
        final LocalDateTime dateTime = LocalDateTime.of(2018, Month.JANUARY, 2, 12, 0, 0);
        final LocalDateTime startDate = LocalDateTime.of(2018, Month.JANUARY, 1, 11, 0, 0);
        final LocalDateTime endDate = LocalDateTime.of(2018, Month.JANUARY, 1, 13, 0, 0);
        classUnderTest = new PeriodWithTime(startDate, endDate);

        // Act
        final boolean result = classUnderTest.includes(dateTime);

        // Assert
        assertFalse(result);
    }

}
