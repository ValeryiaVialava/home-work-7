class Dish<T, U> {
    private final T name;
    private final U price;

    public Dish(T name, U price) {
        this.name = name;
        this.price = price;
    }

    public T getName() {
        return name;
    }

    public U getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " zł";
    }
}

