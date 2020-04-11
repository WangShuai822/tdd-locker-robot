package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    public void should_return_ticket_of_locker1_when_saving_given_locker1_is_available_and_locker2_is_available() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);

        Ticket ticket = smartLockerRobot.save();
        assertNotNull(ticket);
        assertEquals(0, locker1.available);
    }

    @Test
    public void should_return_ticket_of_locker2_when_saving_given_locker1_is_not_available_and_locker2_is_available() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);
        smartLockerRobot.save();
        assertEquals(0, locker1.available); //locker1 is full

        Ticket ticket = smartLockerRobot.save();
        assertNotNull(ticket);
        assertEquals(0, locker2.available);
    }

    @Test
    public void should_return_false_when_saving_given_locker1_is_not_available_and_locker2_is_not_available() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);
        smartLockerRobot.save();
        smartLockerRobot.save();

        Ticket ticket = smartLockerRobot.save();
        assertNull(ticket);
    }


    @Test
    public void should_return_true_when_fetching_given_ticket_is_valid() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);
        Ticket ticket = smartLockerRobot.save();

        assertTrue(smartLockerRobot.fetch(ticket));
    }

    @Test
    public void should_return_false_when_fetching_given_ticket_is_not_valid() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);
        smartLockerRobot.save();

        Ticket ticket = new Ticket();
        assertFalse(smartLockerRobot.fetch(ticket));
    }

    @Test
    public void should_return_false_when_fetching_given_ticket_is_used() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        SmartLockerRobot smartLockerRobot = new SmartLockerRobot(lockerList);
        Ticket ticket = smartLockerRobot.save();

        smartLockerRobot.fetch(ticket);
        assertFalse(smartLockerRobot.fetch(ticket));
    }


}
