import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Menu<String, Double> menu = new Menu<>();

        menu.addDishToMenu("Zupa pomidorowa", 4.0);
        menu.addDishToMenu("Krupnik", 4.0);
        menu.addDishToMenu("Gulasz", 9.0);
        menu.addDishToMenu("Pierogi", 9.5);
        menu.addDishToMenu("Rolada z kurczaka", 9.0);
        menu.addDishToMenu("Ziemniaki", 4.0);
        menu.addDishToMenu("Kasza gryczana", 3.5);
        menu.addDishToMenu("Kasza jęczmienna", 3.5);
        menu.addDishToMenu("Surówka z kapusty kiszonej", 4.0);
        menu.addDishToMenu("Buraki", 4.0);
        menu.addDishToMenu("Sernik", 6.0);

        menu.displayMenu();

        Scanner scanner = new Scanner(System.in);
        boolean successfulOrder = false;

        while (!successfulOrder) {
            System.out.println("Do you want to make the order? (yes/no)");
            String tryAgain = scanner.nextLine().trim().toLowerCase();

            if (!tryAgain.equals("yes")) {
                if (!successfulOrder) {
                    System.out.println("We hope you will visit us later!");
                }
                break;
            }

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            System.out.println("Enter your surname: ");
            String surname = scanner.nextLine();

            if (isValid(name) && isValid(surname)) {
                Client client = new Client(name, surname);
                System.out.println(name + " " + surname + ", please enter numbers of dishes you want to order (type 'done' to finish):");

                while (scanner.hasNext()) {
                    if (scanner.hasNextInt()) {
                        int n = scanner.nextInt();
                        client.addDishToOrder(n, menu);
                    } else {
                        String input = scanner.next();
                        if (input.equalsIgnoreCase("done")) {
                            break;
                        } else {
                            System.out.println("Invalid input. Enter dish numbers or type 'done' to finish.");
                        }
                    }
                }

                System.out.println("Number of dishes: " + client.getNumberOfDishes());
                System.out.println("Total price: " + client.getTotalPrice() + " zł");

                System.out.println("Has chosen 'Zupa pomidorowa': " + client.hasChosenDish("Zupa pomidorowa"));

                System.out.println("Thank you for your order!");
                System.out.println("Your order:");
                client.displayOrder();

                successfulOrder = true;
            } else {
                System.out.println("Invalid input data!");
            }
        }
    }

    public static boolean isValid(String name) {
        return Pattern.matches("^[A-Z][a-zA-Z]*$", name);
    }
}
