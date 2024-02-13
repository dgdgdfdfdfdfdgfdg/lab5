public interface AbleToExecute {
    void help();
    void insert(String idstr, String args);
    void remove_key(String idstr);
    void update(String idstr, String args);
    void exit();
    void clear();
    void save();
    void show();
    void info();
    void remove_greater(String priceStr);
    void remove_greater_key(String idstr);
    void average_of_price();
    void print_descending();
    void execute_script(String filename);
    void replace_if_greater(String idstr, String priceStr);
    void filter_less_than_venue(String capacityStr);
}
