package org.emmek.beu2w1p.exceptions;


import java.util.UUID;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(UUID id) {
        super("Item with id " + id + " not found!");
    }

    public ItemNotFoundException() {
        super("Item not Found!");
    }
}