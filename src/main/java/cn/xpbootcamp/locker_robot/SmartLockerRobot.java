package cn.xpbootcamp.locker_robot;

import java.util.List;

public class SmartLockerRobot extends Robot{
    List<Locker> lockerList;
    public SmartLockerRobot(List<Locker> lockerList) {
        super(lockerList);
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

}
