package utility;


import dto.TicketType;
import dto.VenueType;

public enum TypesOfArgs {
    Long(Long.class),
    Double(Double.class),
    String(String.class),
    Boolean(Boolean.class),
    Command(Comands.class),

    VenueType(VenueType.class),
    TicketType(TicketType.class);
    private Class<?> clas;


    TypesOfArgs(Class<?> clas) {
        this.clas=clas;
    }

    public Class<?> getClas() {
        return clas;
    }
}
