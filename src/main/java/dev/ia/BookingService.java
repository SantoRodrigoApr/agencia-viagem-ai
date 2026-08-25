package dev.ia;

import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class BookingService {

    private final Map<Long, Booking> bookings = new HashMap<>();

    public BookingService() {
        bookings.put(12345L, new Booking(12345L
                , "John Doe", "Tesouros do Egito"
                , LocalDate.now().plusMonths(2)
                , LocalDate.now().plusMonths(2).plusDays(10)
                , BookingStatus.CONFIRMED, Category.TREASURES));
        bookings.put(67890L, new Booking(67890L
                , "Jane Smith", "Aventura Amazonica"
                , LocalDate.now().plusMonths(3)
                , LocalDate.now().plusMonths(3).plusDays(7)
                , BookingStatus.PENDING, Category.ADVENTURE));
        bookings.put(98765L, new Booking(98765L
                , "Peter Jones", "Trila Inca"
                , LocalDate.now().plusMonths(4)
                , LocalDate.now().plusMonths(4).plusDays(8)
                , BookingStatus.CONFIRMED, Category.ADVENTURE));
    }

    public List<Booking> findPackagesByCategory(Category category) {
        return bookings.values().stream()
                .filter(booking -> category.equals(booking.category()))
                .toList();
    }

    public Optional<Booking> getBookingDetails(long id) {
        return Optional.ofNullable(bookings.get(id));
    }

    public Optional<Booking> cancelBooking(long bookingId) {
        String currentUser = SecurityContext.getCurrentUser();

        if(bookings.containsKey(bookingId)) {
            Booking booking = bookings.get(bookingId);
            if (booking.customerName().equals(currentUser)) {
                Booking cancelledBooking = new Booking(
                        bookingId,
                        booking.customerName(),
                        booking.destination(),
                        booking.startDate(),
                        booking.endDate(),
                        booking.status() == BookingStatus.CONFIRMED ? BookingStatus.CANCELLED : BookingStatus.PENDING,
                        Category.ADVENTURE
                );
                this.bookings.replace(bookingId, cancelledBooking);
                return Optional.of(cancelledBooking);
            }
        }
        return Optional.empty();
    }
}