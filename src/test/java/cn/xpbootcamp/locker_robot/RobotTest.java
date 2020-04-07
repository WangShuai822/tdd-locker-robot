package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    public void should_return_ticket_when_saving_given_first_locker_is_available_and_second_locker_is_available() {
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


}
