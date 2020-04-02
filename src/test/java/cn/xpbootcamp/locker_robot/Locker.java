package cn.xpbootcamp.locker_robot;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class Locker {
    int available;
    int availableExtension;
    int capacity;
    int capacityExtension;
    List<Ticket> ticketList = new ArrayList<>();

    public Locker(int capacity) {
        this.capacity = capacity;
        this.available = capacity;
    }

    public Locker(int capacity, int capacityExtension) {
        this.capacity = capacity;
        this.capacityExtension = capacityExtension;
        this.available = capacity;
        this.availableExtension = capacityExtension;
    }

    public Ticket save() {
        if (available > 0) {
            Ticket ticket = generateTicket("group-1");
            available--;
            return ticket;
        } else if (availableExtension > 0) {
            Ticket ticket = generateTicket("group-2");
            availableExtension--;
            return ticket;
        } else {
            return null;
        }
    }

    private Ticket generateTicket(String groupName) {
        Ticket ticket = new Ticket(groupName);
        ticketList.add(ticket);
        log.info("print ticket...... ");
        return ticket;
    }

    public boolean validTicket(Ticket ticket) {
        if (ticketList.contains(ticket)) {
            ticketList.remove(ticket);
            if ("group-1".equals(ticket.groupName)) {
                available++;
            } else {
                availableExtension++;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean fetch(Ticket ticket) {
        return validTicket(ticket);
    }
}
