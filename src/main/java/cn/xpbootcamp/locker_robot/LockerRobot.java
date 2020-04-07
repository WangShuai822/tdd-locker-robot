package cn.xpbootcamp.locker_robot;

import java.util.List;

public class LockerRobot {
    List<Locker> lockerList;
    public LockerRobot(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Ticket save() {
        Ticket ticket = new Ticket();
        if (lockerList.size() > 0) {
            for (Locker locker : lockerList) {
                ticket = locker.save();
                if (ticket != null) {
                    break;
                }
            }
        }
        return ticket;
    }
}
