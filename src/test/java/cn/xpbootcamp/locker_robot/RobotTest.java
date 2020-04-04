package cn.xpbootcamp.locker_robot;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {

    @Test
    public void should_return_ticket_when_saving_given_first_locker_is_available_and_second_locker_is_available() {
        LockerRobot lockerRobot = new LockerRobot(2);
        assertNotNull(lockerRobot.save());
    }


}
