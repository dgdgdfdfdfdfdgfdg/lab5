import java.util.*;

public class Collection {
    private Date currentDate;
    private HashMap<Long,Ticket> hashMap = new HashMap<>();
    private LinkedList<Ticket> linkedList = new LinkedList<Ticket>();


    public Collection(){
        currentDate = new Date();

    }
    public Collection(Date date){
        currentDate = date;
    }
    public void clearCollection(){
        hashMap.clear();
        linkedList.clear();
    }
    public void insertCollection(Ticket ticket){
        hashMap.put(ticket.getId(),ticket);
        linkedList.add(ticket);

    }
    public void showCollection() {
        for (Ticket ticket : linkedList) {
            System.out.println(ticket);
        }
    }
    public  void removeElement(Long id){
        hashMap.remove(id);
        for (Ticket ticket : linkedList){
            if (ticket.getId()==id){
                linkedList.remove(ticket);
            }
            return;
        }
        throw new IllegalStateException("Linkedlist не имеет элемента с таким id, а hashmap имеет.");
    }
public void update(){
    Collections.sort(linkedList);
}
    public HashMap<Long, Ticket>  getHashMap() {
        return hashMap;
    }

    public LinkedList<Ticket> getLinkedList() {return linkedList;}

    public Date getCurrentDate() {
        return currentDate;
    }
    public int getCountOfElements(){
        return hashMap.size();
    }
}

