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
        LockerRobot lockerRobot = new LockerRobot(lockerList);

        Ticket ticket = lockerRobot.save();
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
        LockerRobot lockerRobot = new LockerRobot(lockerList);
        lockerRobot.save();
        assertEquals(0, locker1.available); //locker1 is full

        Ticket ticket = lockerRobot.save();
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
        LockerRobot lockerRobot = new LockerRobot(lockerList);
        lockerRobot.save();
        lockerRobot.save();

        Ticket ticket = lockerRobot.save();
        assertNull(ticket);
    }




}
