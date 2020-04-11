package cn.xpbootcamp.locker_robot;

public class InvalidTicketException extends RuntimeException {
    public InvalidTicketException() {
        super("无效的ticket");
    }
}
