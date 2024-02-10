public class Venue extends ElementsWithId{
    private Long id;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long capacity; //Поле может быть null, Значение поля должно быть больше 0
    private VenueType type; //Поле может быть null
    private static final Counter counter=new Counter();

    public Venue(VenueType type,Long capacity,String name) {
        this.type = type;
        this.capacity=capacity;
        this.name = name;
        this.id = counter.count();
    }
    @Override
    public String toString(){
        return  "venueName " + name+
                ", venueType "+type+
                ", venueId " + id+
                ", venueCapacity " + capacity;


    }
    @Override
    public Long getId() {
        return id;
    }

}
