import java.util.ArrayList;
import java.util.List;

class Menu<T, U> {
    private final List<Dish<T, U>> menu = new ArrayList<>();

    public void addDishToMenu(T name, U price) {
        menu.add(new Dish<>(name, price));
    }

    public void displayMenu() {
        System.out.println("Menu:");
        for (int id = 0; id < menu.size(); id++) {
            Dish<T, U> dish = menu.get(id);
            System.out.println(id + 1 + ". " + dish);
        }
    }

    public Dish<T, U> getDishByNumber(int dishNumber) {
        return menu.get(dishNumber - 1);
    }

    public int getMenuSize() {
        return menu.size();
    }
}

