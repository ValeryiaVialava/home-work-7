import java.util.ArrayList;
import java.util.List;

class Client {
    private final String name;
    private final String surname;
    private final List<Dish<String, Double>> order = new ArrayList<>();

    public Client(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void addDishToOrder(int dishNumber, Menu<String, Double> menu) {
        if (dishNumber > 0 && dishNumber <= menu.getMenuSize()) {
            Dish<String, Double> dish = menu.getDishByNumber(dishNumber);
            order.add(dish);
            System.out.println("Added: " + dish);
        } else {
            System.out.println("Invalid dish number!");
        }
    }

    public boolean hasChosenDish(String dishName) {
        for (Dish<String, Double> dish : order) {
            if (dish.getName().equalsIgnoreCase(dishName)) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfDishes() {
        return order.size();
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Dish<String, Double> dish : order) {
            total += dish.getPrice();
        }
        return total;
    }

    public void displayOrder() {
        for (Dish<String, Double> dish : order) {
            System.out.println(dish);
        }
    }
}
