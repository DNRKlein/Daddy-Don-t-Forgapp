package nl.davidklein.daddydontforgapp.domain.core;

import nl.davidklein.daddydontforgapp.domain.common.PeriodWithTime;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class TimedToDoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private TimedToDo classUnderTest;

    @Test
    public void timedToDoSuccessfulConstruction(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        final PeriodWithTime period = new PeriodWithTime(startDate, startDate.plusDays(1));
        final User sender = new User("Sender");
        final User receiver = new User("Receiver");

        // Act
        classUnderTest = new TimedToDo(sender, receiver, "ToDo title", period, "ToDo text");

        // Assert
        assertEquals(sender, classUnderTest.getSender());
        assertEquals(receiver, classUnderTest.getReceiver());
        assertEquals("ToDo title", classUnderTest.getTitle());
        assertEquals(period, classUnderTest.getPeriod());
        assertEquals("ToDo text", classUnderTest.getText());
    }

    @Test
    public void timedToDoSuccessfulConstructionWithId(){
        // Arrange
        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        final PeriodWithTime period = new PeriodWithTime(startDate, startDate.plusDays(1));
        final User sender = new User("Sender");
        final User receiver = new User("Receiver");

        // Act
        classUnderTest = new TimedToDo(new Long(1), sender, receiver, "ToDo title", period, "ToDo text");

        // Assert
        assertEquals(new Long(1), classUnderTest.getId());
        assertEquals(sender, classUnderTest.getSender());
        assertEquals(receiver, classUnderTest.getReceiver());
        assertEquals("ToDo title", classUnderTest.getTitle());
        assertEquals(period, classUnderTest.getPeriod());
        assertEquals("ToDo text", classUnderTest.getText());
    }

    @Test
    public void timedToDoPeriodNull(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        final User sender = new User("Sender");
        final User receiver = new User("Receiver");

        // Act
        classUnderTest = new TimedToDo(sender, receiver, "ToDo title", null, "ToDo text");

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void timedToDoSenderNull(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        final PeriodWithTime period = new PeriodWithTime(startDate, startDate.plusDays(1));
        final User receiver = new User("Receiver");

        // Act
        classUnderTest = new TimedToDo(null, receiver, "ToDo title", period, "ToDo text");

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void timedToDoReceiverNull(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        final PeriodWithTime period = new PeriodWithTime(startDate, startDate.plusDays(1));
        final User sender = new User("Sender");

        // Act
        classUnderTest = new TimedToDo(sender, null, "ToDo title", period, "ToDo text");

        // Assert - wordt gedaan door expectedException
    }

    @Test
    public void timedToDoTitleNull(){
        // Arrange
        expectedException.expect(NullPointerException.class);

        final LocalDateTime startDate = LocalDateTime.of(2018, 1, 1, 18, 30, 1);
        final PeriodWithTime period = new PeriodWithTime(startDate, startDate.plusDays(1));
        final User sender = new User("Sender");
        final User receiver = new User("Receiver");

        // Act
        classUnderTest = new TimedToDo(sender, receiver, null, period, "ToDo text");

        // Assert - wordt gedaan door expectedException
    }

}
