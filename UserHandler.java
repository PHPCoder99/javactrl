import java.util.Objects;
import java.util.Scanner;

public class UserHandler { // thats right kids, handle your users! (that sounds so bad-)
    // import from / export to file
    // add toy
    // del toy
    // edit toy
    // quit

    public static void printMenu(){
        // пишу на английском тк русский не отображается нормально
        System.out.println("p - Print all");
        System.out.println("a - Add toy");
        System.out.println("e - Edit toy weight");
        System.out.println("d - Delete toy");
        System.out.println("g - Run giveaway");
        System.out.println("q - Exit program");
    }

    public static void printToyList(ToyList toyList){
        int k = 0;
        for (Toy toy : toyList.getToyList()) {
            System.out.println(k + " " + toy);
            k++;
        }
    }

    private static boolean isIntConvertible(String str){
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isDoubleConvertible(String str){
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static ToyList a(ToyList toyList){
        Scanner scanner = new Scanner(System.in);
        String newName;
        String newAmount = null;
        String newWeight = null;
        System.out.println("Enter new toy name: ");
        newName = scanner.nextLine();
        System.out.println("Enter new toy amount: ");
        newAmount = scanner.nextLine();
        while (!isIntConvertible(newAmount)) {
            System.out.println("Invalid input. Enter new toy amount: ");
            newAmount = scanner.nextLine();
        }
        System.out.println("Enter new toy weight as decimal: ");
        newWeight = scanner.nextLine();
        while (!isDoubleConvertible(newWeight)) {
            System.out.println("Invalid input. Enter new toy weight as decimal: ");
            newWeight = scanner.nextLine();
        }
        toyList.addToy(new Toy(newName, Integer.parseInt(newAmount), Double.parseDouble(newWeight)));
        return toyList;
    }

    public static ToyList e(ToyList toyList){
        Scanner scanner = new Scanner(System.in);
        printToyList(toyList);
        System.out.println("Enter index of the toy you would like to modify: ");
        String k = scanner.nextLine();
        while (!isIntConvertible(k) || Integer.parseInt(k) >= toyList.getToyList().size()){
            System.out.println("Invalid input, either you didn't enter an integer or the index is out of bounds. Please try again: ");
            k = scanner.nextLine();
        }
        System.out.println("You are currently modifying: " + toyList.getToyList().get(Integer.parseInt(k)));
        System.out.println("Enter new toy weight as decimal: ");
        String newWeight = scanner.nextLine();
        while (!isDoubleConvertible(newWeight)) {
            System.out.println("Invalid input. Enter new toy weight as decimal: ");
            newWeight = scanner.nextLine();
        }
        toyList.editToy(Integer.parseInt(k), new Toy(toyList.getToyList().get(Integer.parseInt(k)).getName(), toyList.getToyList().get(Integer.parseInt(k)).getAmount(), Double.parseDouble(newWeight)));
        return toyList;
    }

    public static ToyList d(ToyList toyList){
        Scanner scanner = new Scanner(System.in);
        printToyList(toyList);
        System.out.println("Enter index of the toy you would like to delete: ");
        String k = scanner.nextLine();
        while (!isIntConvertible(k) || Integer.parseInt(k) >= toyList.getToyList().size()){
            System.out.println("Invalid input, either you didn't enter an integer or the index is out of bounds. Please try again: ");
            k = scanner.nextLine();
        }
        System.out.println("You are trying to delete: " + toyList.getToyList().get(Integer.parseInt(k)));
        System.out.println("Are you sure you want to delete that toy? (y/n)");
        if (Objects.equals(scanner.nextLine(), "y")){
            toyList.deleteToy(Integer.parseInt(k));
        } else {
            System.out.println("Not deleting then!");
        }
        return toyList;
    }
}
