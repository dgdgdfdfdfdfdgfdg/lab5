package managers;

import dto.Ticket;
import dto.Venue;
import dto.VenueType;
import utility.Console;
import utility.InvalidFormatExeption;

import java.util.*;

public class ValidatorOfCollection {

    public void validateCollection(Console console,Collection collection) {
        Set<Long> setTicketId = new HashSet<>();
        Set<Long> setVenueId = new HashSet<>();

        for (Ticket ticket: Ticket.getInstancesTicket()){
            setTicketId.add(ticket.getId());
        }
        for (Venue venue: Venue.getInstancesVenue()){
            setVenueId.add(venue.getId());
        }
        if (setVenueId.size()!=Venue.getInstancesVenue().size() || setTicketId.size()!=Ticket.getInstancesTicket().size()){
            console.print("Ошибка уникальности id в файле");
            collection.clearCollection();
            console.print("Коллекция очищена");
        }
        for (Long id: collection.getHashMap().keySet()){
            if (!Objects.equals(id, collection.getHashMap().get(id).getId())){
                console.print("Ошибка. Не совпадает id билета с ключом");
                collection.clearCollection();
                console.print("Коллекция очищена");
                break;

            }
        }



    }
}