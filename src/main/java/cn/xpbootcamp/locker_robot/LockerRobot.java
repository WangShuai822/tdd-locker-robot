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
            int capacity = 0;
            Locker maxLocker = new Locker(0);
            for (Locker locker : lockerList) {
                if (locker.capacity > capacity) {
                    capacity = locker.capacity;
                    maxLocker = locker;
                }
            }
            ticket = maxLocker.save();
        }
        return ticket;
    }

    public boolean fetch(Ticket ticket) {
        for (Locker locker : lockerList) {
            if (locker.fetch(ticket)) {
                return true;
            }
        }
        return false;
    }
}
