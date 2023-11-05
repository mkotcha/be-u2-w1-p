package org.emmek.beu2w1p.exceptions;


import org.emmek.beu2w1p.entities.ReservationId;

import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(UUID id) {
        super("Item with id " + id + " not found!");
    }

    public ItemNotFoundException() {
        super("Item not Found!");
    }

    public ItemNotFoundException(ReservationId id) {
        super("Item with id " + id + " not found!");
    }
}