package dto;

import java.util.ArrayList;
import java.util.List;

public abstract class ElementsWithId {

    protected static ArrayList<Ticket> instancesTicket = new ArrayList<>();
    protected static ArrayList<Venue> instancesVenue = new ArrayList<>();

    protected Long id;
    public Long getId(){
        return this.id;
    }
    protected <T extends ElementsWithId> Long getFreeId(ArrayList<T> arrayList) {
        Long max = 0L;
        for (int i=0;i<arrayList.size()-1;i++) {
            max = arrayList.get(i).getId() > max ?  arrayList.get(i).getId()  : max;
        }
        return max+1L;
    }

    public static void setInstancesVenue(ArrayList<Venue> instancesVenue) {
        ElementsWithId.instancesVenue = instancesVenue;
    }

    public static ArrayList<Ticket> getInstancesTicket() {
        return instancesTicket;
    }

    public static ArrayList<Venue> getInstancesVenue() {
        return instancesVenue;
    }

    public static void setInstancesTicket(ArrayList<Ticket> instancesTicket) {
        ElementsWithId.instancesTicket = instancesTicket;
    }
}



