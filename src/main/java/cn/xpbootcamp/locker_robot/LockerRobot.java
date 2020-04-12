package cn.xpbootcamp.locker_robot;

import java.util.List;

public class LockerRobot extends Robot{
    List<Locker> lockerList;
    public LockerRobot(List<Locker> lockerList) {
        super(lockerList);
        this.lockerList = lockerList;
    }

    public Ticket save() {
        if (lockerList.size() > 0) {
            for (Locker locker : lockerList) {
                if (locker.available > 0) {
                    return locker.save();
                }
            }
        }
        throw new LockerFullException();
    }

}
