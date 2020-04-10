package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartLockerRobot {
    @Test
    public void should_return_ticket_of_locker1_when_saving_given_capacity1_more_than_capacity2() {
        Locker locker1 = new Locker(2);
        Locker locker2 = new Locker(1);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        LockerRobot lockerRobot = new LockerRobot(lockerList);

        Ticket ticket = lockerRobot.save();
        assertNotNull(ticket);
        assertEquals(1, locker1.available);
    }

    @Test
    public void should_return_ticket_of_locker1_when_saving_given_capacity1_equals_to_capacity2() {
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
    public void should_return_ticket_of_locker2_when_saving_given_capacity1_less_than_capacity2() {
        Locker locker1 = new Locker(1);
        Locker locker2 = new Locker(2);
        List<Locker> lockerList = new ArrayList<>();
        lockerList.add(locker1);
        lockerList.add(locker2);
        LockerRobot lockerRobot = new LockerRobot(lockerList);

        Ticket ticket = lockerRobot.save();
        assertNotNull(ticket);
        assertEquals(1, locker2.available);
    }
}
