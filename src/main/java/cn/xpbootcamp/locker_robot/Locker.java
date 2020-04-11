package cn.xpbootcamp.locker_robot;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Log
public class Locker {
    int available;
    int capacity;
    List<Ticket> ticketList = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
    }

    public Ticket save(){
        if (available >= 1) {
            Ticket ticket = new Ticket(UUID.randomUUID().toString());
            ticketList.add(ticket);
            log.info("print ticket...... ");
            available--;
            return ticket;
        } else {
            throw new LockerFullException();
        }
    }

    public boolean validTicket(Ticket ticket) {
        if (ticket != null && ticketList.contains(ticket)) {
            available++;
            ticketList.remove(ticket);
            return true;
        } else {
            throw new InvalidTicketException();
        }
    }

    public boolean fetch(Ticket ticket) {
        return validTicket(ticket);
    }
}
