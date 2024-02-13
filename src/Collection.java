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
    public void removeGreater(Long price){
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getPrice()>price){
                removeElement(arrayList.get(i).getId());
                i--;
            }
        }

    }
    public void removeGreaterKey(Long id){
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getId()>id){
                removeElement(arrayList.get(i).getId());
                i--;
            }
        }
    }
    public void replaceIfGreater(Long id,Long price){
        if (price>hashMap.get(id).getPrice()){
            hashMap.get(id).setPrice(price);
            for (Ticket ticket : arrayList){
                if (ticket.getId().equals(id)){
                    ticket.setPrice(price);
                    return;
                }
            }
           throw new  IllegalStateException("arrayList не имеет элемента с таким id, а hashmap имеет.");
        }
    }
    public double getAveragePrice(){
        double s = 0;
        for (Ticket ticket : arrayList){
            s+=ticket.getPrice();
            }
        s /= arrayList.size();
        return s;
    }
    public ArrayList<Ticket> filterLessThanVenue(Long capacity){
        ArrayList<Ticket> filtered = new ArrayList<Ticket>();
        Long capacityOther;
        for (Ticket ticket : arrayList){
            if (ticket.getVenue().getCapacity()==null) {
                capacityOther = -1L;
            }else {
                capacityOther=ticket.getVenue().getCapacity();
            }
            if (capacityOther<capacity){
                filtered.add(ticket);
            }
        }
        return filtered;
    }

    public  void removeElement(Long id){
        hashMap.remove(id);
        for (int i=0;i<arrayList.size();i++){
            if (arrayList.get(i).getId().equals(id)){
                arrayList.remove(i);
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

    public ArrayList<Ticket> getArrayList() {return arrayList;}

    public Date getCurrentDate() {
        return currentDate;
    }
    public int getCountOfElements(){
        return hashMap.size();
    }
}

