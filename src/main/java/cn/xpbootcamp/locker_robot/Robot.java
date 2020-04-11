package cn.xpbootcamp.locker_robot;

import java.util.List;

public class Robot {
    List<Locker> lockerList;
    public Robot(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public boolean fetch(Ticket ticket) {
        for (Locker locker : lockerList) {
            if (locker.fetch(ticket)) {
                return true;
            }
        }
        throw new InvalidTicketException();
    }
}
