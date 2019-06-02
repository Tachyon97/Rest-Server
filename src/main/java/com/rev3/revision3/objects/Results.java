package com.rev3.revision3.objects;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Results {
    ArrayList<Booking> bookings;


    public Results(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    public Results() {
        /* create new arraylist*/
        bookings = new ArrayList<>();
        mock();
    }

    public Booking getBookingID(String id) {
        for (Booking i : bookings) {
            if (i.id.equals(id)) {
                return i;
            }
        }
        return null;
    }

    public List<Booking> getBooking() {
        return bookings;
    }

    public List<Booking> getBooking(String name) {
        ArrayList<Booking> booking = new ArrayList<>();
        if (name.isEmpty()) {
            return bookings;
        } else {
            for (Booking i : bookings) {
                if (i.name.equals(name)) {
                    booking.add(i);
                }
            }
        }

        return booking;
    }
    public void deleteAll() {
        bookings.clear();
    }

    public void updateBooking(String name, Booking booking) {
        Booking old = getBookingID(name);
        bookings.remove(old);
        booking.setId(old.getId());
        bookings.add(booking);

    }


    public void add(Booking booking) {
        bookings.add(booking);
    }

    public void remove(Booking booking) {
        bookings.remove(booking);
    }

    public void remove(String i) {
        for (Booking b : bookings) {
            if (b.id.equals(i)) {
                bookings.remove(b);
            }
        }
    }

    private void mock() {
        ArrayList<Booking> booking1 = new ArrayList<>();
        booking1.add(new Booking("0", "Farhad", "6/1/2019", "Lax"));
        booking1.add(new Booking("1", "David", "6/2/2019", "Lax med vitköksbröd"));
        for (int i = 0; i < booking1.size(); i++) {
            bookings.add(booking1.get(i));
        }

        //bookings.add(booking1);
    }
}
