import java.util.*;

public class Collection {
    private Date currentDate;
    private HashMap<Long,Ticket> hashMap = new HashMap<>();
    private ArrayList<Ticket> arrayList = new ArrayList<>();


    public Collection(){
        currentDate = new Date();

    }
    public Collection(Date date){
        currentDate = date;
    }
    public void clearCollection(){
        hashMap.clear();
        arrayList.clear();
    }
    public void insertElement(Ticket ticket){
        hashMap.put(ticket.getId(),ticket);
        arrayList.add(ticket);

    }
    public void addHashMap(HashMap<Long,Ticket> anotherHashMap){
        hashMap.putAll(anotherHashMap);
        for (Ticket ticket : anotherHashMap.values()){
            if (!arrayList.contains(ticket)) {
                arrayList.add(ticket);
            }
        }
        update();
    }
    public void showCollection() {
        for (Ticket ticket : arrayList) {
            System.out.println(ticket);
        }
    }

    public Ticket getElement(Long id) {
        return hashMap.get(id);
    }
    public void insertTicket(Ticket ticket){
        hashMap.put(ticket.getId(),ticket);
        arrayList.add(ticket);
        update();
    }
    public void removeGreater(Long id){
        for (Ticket ticket : arrayList){
            if (ticket.getId()>id){
                removeElement(ticket.getId());
            }
        }
    }

    public  void removeElement(Long id){
        hashMap.remove(id);
        for (Ticket ticket : arrayList){
            if (ticket.getId()==id){
                arrayList.remove(ticket);
                return;
            }
        }
        throw new IllegalStateException("arrayList не имеет элемента с таким id, а hashmap имеет.");
    }
public void update(){
    Collections.sort(arrayList);
}
    public HashMap<Long, Ticket>  getHashMap() {
        return hashMap;
    }

    public ArrayList<Ticket> arrayListgetArrayList() {return arrayList;}

    public Date getCurrentDate() {
        return currentDate;
    }
    public int getCountOfElements(){
        return hashMap.size();
    }
}

