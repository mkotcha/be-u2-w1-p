package org.emmek.beu2w1p.exceptions;

import org.emmek.beu2w1p.entities.Station;

public class NotAvailableException extends RuntimeException {

    public NotAvailableException(Station station) {
        super("Station " + station.getId() + " not available");
    }

    public NotAvailableException() {
        super("Station not available");
    }
}
