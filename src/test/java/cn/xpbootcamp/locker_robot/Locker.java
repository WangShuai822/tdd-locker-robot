package cn.xpbootcamp.locker_robot;

import lombok.Data;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;

@Data
@Log
public class Locker {
    int available;
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
        this.available = capacity + capacityExtension;
    }

    public Ticket save() {
        if (available > 0) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
            log.info("print ticket...... ");

            if (capacity > 0) {
                capacity--;
            } else {
                capacityExtension--;
            }
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
