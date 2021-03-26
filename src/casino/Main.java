package casino;

import static casino.Casino.higherOrLower;
import static casino.Casino.rouletteGame;
import static casino.Casino.slotMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Person> userInfo = new ArrayList<>();
    private static int accountID;
    private static String userName;
    public static int casinoCoins;
    private static int CasinoCoins;
    public static boolean t = true;
    public static boolean x = true;

    public static void main(String[] args) {
        while (t == true) {
            accountManagement();
        }
    }

    public static void hub() {

        boolean i = true;
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome, valued customer! We have three games for you today.");
        while (i == true) {
            getOut();

            System.out.println("You have " + casinoCoins + " coins left");

            System.out.println("Please choose a game you wish to play:\n1 - Roulette\n2 - Higher or Lower\n3 - Slot Machine\n4 - Exit");
            int userChoiceOne = input.nextInt();

            switch (userChoiceOne) {
                case 1:
                    rouletteGame();
                    break;
                case 2:
                    higherOrLower();
                    break;
                case 3:
                    slotMachine();
                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input recieved. System terminating");
                    System.exit(0);
            }
        }

    }

    public static void getOut() {
        if (casinoCoins <= 0) {
            System.out.println("You have run out of coins.");
            System.exit(0);
        }
    }

    public static void accountManagement() {
        Scanner input = new Scanner(System.in);

        System.out.println("Please sign in or create an account. (1 = Log in, 2 = Create account, 3 = View accounts, 4 = Exit to hub");
        int userAccountInput = input.nextInt();
        switch (userAccountInput) {
            case 1:
                logIn();
                break;
            case 2:
                createAccount();
                break;
            case 3:
                viewAccounts();
                break;
            case 4:
                hub();
                break;

            default:
                System.out.println("Invalid input recieved. System terminating");
                System.exit(0);

        }

    }

    public static void createAccount() {

        Scanner input = new Scanner(System.in);

        System.out.println("Please type in your first name");
        String firstName = input.next();
        System.out.println("Please type in your last name");
        String lastName = input.next();
        System.out.println("Please type in a username");
        userName = input.next();
        System.out.println("Please type in your account ID");
        accountID = input.nextInt();
        CasinoCoins = 50;

        Person myUser = new Person(userName, firstName, lastName, accountID, CasinoCoins);
        userInfo.add(myUser);
    }

    public static void viewAccounts() {
        if (userInfo.isEmpty()) {
            System.out.println("Sorry there are no users");
        } else {
            for (int i = 0; i < (userInfo.size()); i++) {
                System.out.println(userInfo.get(i).toString());
            }
        }

    }

    public static void logIn() {
        Scanner input = new Scanner(System.in);
        if (userInfo.isEmpty()) {
            System.out.println("Sorry there are no users");
        } else {
            System.out.println("Please input your account ID");
            int accountIDCheck = input.nextInt();
            if (accountIDCheck == accountID) {
                System.out.println("Logging in as " + userName);
                casinoCoins = CasinoCoins;

            }
        }
    }
}
