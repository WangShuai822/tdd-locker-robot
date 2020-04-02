package cn.xpbootcamp.locker_robot;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class Locker {
    String name;
    int available;
    int capacity;
    List<Ticket> ticketList = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
    }

    public Locker(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.available = capacity;
    }

    public Ticket save() {
        if (available >= 1) {
            Ticket ticket = new Ticket(name);
            ticketList.add(ticket);
            log.info("print ticket...... ");
            available--;
            return ticket;
        } else {
            return null;
        }
    }

    public boolean validTicket(Ticket ticket) {
        if (ticketList.contains(ticket)) {
            available++;
            ticketList.remove(ticket);
            return true;
        } else {
            return false;
        }
    }

    public boolean fetch(Ticket ticket) {
        return validTicket(ticket);
    }
}
