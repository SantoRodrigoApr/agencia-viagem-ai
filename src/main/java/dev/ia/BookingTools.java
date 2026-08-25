package dev.ia;

import dev.langchain4j.agent.tool.Tool;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class BookingTools {

    @Inject
    BookingService bookingService;

    @Tool("Obtem os detalhes completos de uma reserva com base em seu numero de identificacao (bookingId).")
    public String getBookingDetails(long bookingId) {
        return bookingService.getBookingDetails(bookingId)
                .map(Booking::toString)
                .orElse("Reserva com ID" + bookingId + " nao encontrada.");
    }

    @Tool("""
        Cancela uma reserva existente.
        Para configurar o cancelamento, e necessario fornecer o ID da reserva (bookingId)
        e o ultimo nome do cliente (customerName).
    """)
    public String cancelBooking(long bookingId, String customerName) {
        return bookingService.cancelBooking(bookingId)
                .map(booking -> "Reserva " + bookingId + "cancelada com sucesso. Status atual: " + booking.status())
                .orElse("Nao foi possivel cancelar a reserva. Verifique se o ID da reserva e o sobrenome do cliente estao corretos.");
    }

    @Tool("Lista os pacotes de viagem disponiveis para uma determinada categoria (ex: ADVENTURE, TREASURES).")
    public String listPackagesByCategory(Category category) {
        List<Booking> packages = bookingService.findPackagesByCategory(category);
        if (packages.isEmpty()) {
            return "Nenhum pacote encontrado para a categoria: " + category;
        }
        return "Pacages encontrados para a cateogria '" + category + "': " + packages.stream()
                .map(Booking::toString)
                .toList().toString();
    }


}
