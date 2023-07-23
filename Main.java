import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToyList toyList = new ToyList();
        String userChoice = null;
        Scanner scanner = new Scanner(System.in);
        while (!Objects.equals(userChoice, "q")){
            UserHandler.printMenu();
            System.out.println("Enter command: ");
            userChoice = scanner.nextLine();
            switch (userChoice) {
                case "p":
                    UserHandler.printToyList(toyList);
                    break;
                case "a":
                    UserHandler.a(toyList);
                    break;
                case "e":
                    UserHandler.e(toyList);
                    break;
                case "d":
                    UserHandler.d(toyList);
                    break;
                case "g":
                    UserHandler.printToyList(new ToyRoulette(toyList).startGame());
                    // да, я знаю что веса как-бы ни те, иначе бы программа не работала.
            }
        }
    }
}
