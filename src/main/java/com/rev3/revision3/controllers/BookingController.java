package com.rev3.revision3.controllers;

import com.rev3.revision3.objects.Booking;
import com.rev3.revision3.objects.Results;
import com.rev3.revision3.objects.Root;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookingController {

    Results results = new Results();


    /* GET */

    @RequestMapping(value = "/booking/", method = RequestMethod.GET)
    public ResponseEntity<Map<String, List<Booking>>> getBookings() {
        List<Booking> booking = results.getBooking();
        if (booking.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        Map<String, List<Booking>> result = new HashMap<>();
        result.put(Booking.class.getAnnotation(Root.class).value(), booking);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/booking/id/{id}", method = RequestMethod.GET)
    public Booking getID(@PathVariable("id") String i) {
        return results.getBookingID(i);
    }

    @RequestMapping(value = "/booking/name/{name}", method = RequestMethod.GET)
    public List<Booking> getBookings(@PathVariable(value = "name") String name) {
        return results.getBooking(name);
    }

    /* DELETE */
    @RequestMapping(value = "/booking/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") String i) {
        results.remove(i);
    }
    @RequestMapping(value = "/booking/bankruptcy", method = RequestMethod.DELETE)
    public void delete() {
        results.deleteAll();
    }

    /* PUT */
    @RequestMapping(value = "/booking/update/{name}", method = RequestMethod.PUT)
    public Booking updateUser(@PathVariable("name") String id, @RequestBody Booking booking) {
        results.updateBooking(id, booking);
        return booking;
    }
}
