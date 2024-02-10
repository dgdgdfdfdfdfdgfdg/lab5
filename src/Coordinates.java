public class Coordinates {
    private Double x; //Поле не может быть null
    private long y; //Значение поля должно быть больше -618
    public Coordinates(Double x, long y) {
        this.x = x;
        if (x==null){throw new NullPointerException("Поле x null");}
        this.y=y;

    }
    @Override
    public String toString(){
        return x+";"+y;
    }
}