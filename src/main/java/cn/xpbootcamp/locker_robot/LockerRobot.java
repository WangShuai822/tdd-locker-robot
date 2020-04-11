package cn.xpbootcamp.locker_robot;

import java.util.List;

public class LockerRobot {
    List<Locker> lockerList;
    public LockerRobot(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Ticket save() {
        if (lockerList.size() <= 0) {
            throw new LockerFullException();
        }

        int available = 0;
        Locker maxLocker = new Locker(0);
        for (Locker locker : lockerList) {
            if (locker.available > available) {
                available = locker.available;
                maxLocker = locker;
            }
        }
        return maxLocker.save();
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
