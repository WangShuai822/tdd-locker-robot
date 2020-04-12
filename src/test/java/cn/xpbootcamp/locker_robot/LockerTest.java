package cn.xpbootcamp.locker_robot;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Log
public class LockerTest {

    @Test
    public void should_return_ticket_when_saving_given_locker_is_not_available() {
        Locker locker = new Locker(1);
        locker.save();
        assertThrows(LockerFullException.class, locker::save);
    }

    @Test
    public void should_return_ticket_when_saving_given_available_is_available() {
        Locker locker = new Locker(10);
        assertNotNull(locker.save());
    }

    @Test
    public void should_return_true_when_fetching_given_ticket_is_valid() {
        Locker locker = new Locker(10);
        Ticket ticket = locker.save();
        assertTrue(locker.fetch(ticket));
    }
    @Test
    public void should_return_exception_when_fetching_given_ticket_is_not_valid() {
        Locker locker = new Locker(10);
        Ticket ticket = new Ticket();
        assertThrows(InvalidTicketException.class, () -> locker.fetch(ticket));
    }

    @Test
    public void should_return_exception_when_fetching_given_ticket_is_used() {
        Locker locker = new Locker(10);
        Ticket ticket = locker.save();
        locker.fetch(ticket);
        assertThrows(InvalidTicketException.class, () -> locker.fetch(ticket));
    }

}
