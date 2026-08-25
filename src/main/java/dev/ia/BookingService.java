package dev.ia;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingService() {
        bookings.put(12345L, new Booking(12345L
                , "John Doe", "Tesouros do Egito"
                , LocalDate.now().plusMonths(2)
                , LocalDate.now().plusMonths(2).plusDays(30)
                , BookingStatus.CONFIRMED));
        bookings.put(67890L, new Booking(67890L
                , "Jane Smith", "Aventura Amazonica"
                , LocalDate.now().plusMonths(3)
                , LocalDate.now().plusMonths(3).plusDays(15)
                , BookingStatus.PENDING));
    }

    public Optional<Booking> getBookingDetails(long id) {
        return Optional.ofNullable(bookings.get(id));
    }

    public Optional<Booking> cancelBooking(long bookingId, String costumerLastName) {
        if(bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            if (booking.customerName().endsWith(costumerLastName)) {
                Booking cancelledBooking = new Booking(bookingId, booking.customerName(), booking.destination()
                        , booking.startDate(), booking.endDate(), BookingStatus.CANCELLED);
                bookings.put(bookingId, cancelledBooking);
                return Optional.of(cancelledBooking);
            }
        }
        return Optional.empty();
    }
}