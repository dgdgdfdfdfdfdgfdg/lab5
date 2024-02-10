public enum Comands {
    help(0),
    info(0),
    show(0),
    insert(5),
    update(5),
    remove_key(1),
    clear(0),
    save(0),
    execute_script(1),
    exit(0),
    remove_greater(1),
    replace_if_greater(5),
    remove_greater_key(1),
    average_of_price(0),
    filter_less_than_venue(1),
    print_descending(0);
    private final int countArgs;

    Comands(int countArgs) {
        this.countArgs = countArgs;

    }

    public int getCountArgs() {
        return countArgs;
    }
}
