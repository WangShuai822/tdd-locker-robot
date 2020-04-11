package cn.xpbootcamp.locker_robot;

import java.util.List;

public class LockerRobot extends Robot{
    List<Locker> lockerList;
    public LockerRobot(List<Locker> lockerList) {
        super(lockerList);
        this.lockerList = lockerList;
    }

    public Ticket save() {
        if (lockerList.size() <= 0) {
            throw new LockerFullException();
        }
        Ticket ticket = new Ticket();
        for (Locker locker : lockerList) {
            ticket = locker.save();
            if (ticket != null) {
                break;
            }
        }
        return ticket;
    }

}
