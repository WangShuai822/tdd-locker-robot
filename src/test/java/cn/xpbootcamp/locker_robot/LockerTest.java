package cn.xpbootcamp.locker_robot;

import lombok.extern.java.Log;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

@Log
public class LockerTest {

    @Test
    public void should_return_fail_when_saving_given_available_is_zero() {
        Locker locker = new Locker();
        locker.setAvailable(0);
        assertFalse(locker.save());
    }
}