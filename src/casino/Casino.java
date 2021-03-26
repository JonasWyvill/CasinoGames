package casino;

import static casino.Main.getOut;
import static casino.Main.hub;
import java.util.Random;
import java.util.Scanner;

public class Casino {

    int casinoCoins = Main.casinoCoins;

    public static void rouletteGame() {
        getOut();
        //Play with 5 other "players" - each puts 10CC in the pot
        //1/6 chance to lose, option to exit with current winnings at any time
        //Losing = dividing remaining money among remaining players

        int pot = 60;
        int playerInput;
        int playersRemaining = 6;
        int potEarnings = (pot / playersRemaining);
        int playerTurn;
        boolean lost = true;

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Welcome to British Roulette! Now with blanks and no health concerns!");
        System.out.println("You sit down at a table with 5 other people, you each put 10CC in the pot");
        Main.casinoCoins = Main.casinoCoins - 10;

        while (playersRemaining != 0 && lost == true) {
            if (playersRemaining == 1) {
                System.out.println("You win!");
            }
            System.out.println("There are " + playersRemaining + " players remaining. Choose an action: 1 = Pull trigger, 2 = Exit with current cash split");
            playerInput = input.nextInt();
            if (playerInput == 2 || playersRemaining == 1) {
                Main.casinoCoins = Main.casinoCoins + potEarnings;
                hub();
            } else {
                playerTurn = rand.nextInt(playersRemaining) + 1;
                if (playerTurn == 1) {
                    System.out.println("You lose! Nothing is gained");
                    lost = false;

                } else {
                    System.out.println("Nothing happens! One player leaves.");
                    playersRemaining = playersRemaining - 1;
                }

            }

        }
    }

    public static void higherOrLower() {
        getOut();
        //Spend 5 CC to play
        //If you get 3 wins, gain 30 CC
        //Every loss = -10 CC until exit
        //Every draw = -5 CC until exit

        Main.casinoCoins = Main.casinoCoins - 5;
        int dealtCard;
        int dealtCardTwo;
        int higherOrLowerResult;
        int playerInput;
        int winStreakCounter = 0;

        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Higher or Lower! Guess correctly three times in a row to win!");

        while (winStreakCounter != 3) {
            getOut();
            dealtCard = rand.nextInt(13) + 1;
            System.out.println("Your dealt card is a " + dealtCard + ". Higher or Lower? (1 = Higher, 2 = Lower, 3 = Exit)");
            playerInput = input.nextInt();
            if (playerInput == 3) {
                hub();
            }
            dealtCardTwo = rand.nextInt(13) + 1;
            higherOrLowerResult = dealtCard - dealtCardTwo;
            if (higherOrLowerResult == 0) {
                Main.casinoCoins = Main.casinoCoins - 5;
                System.out.println("Draw!");
            }
            if (higherOrLowerResult > 0) {
                switch (playerInput) {
                    case 1: //Higher
                        Main.casinoCoins = Main.casinoCoins - 10;
                        System.out.println("You lose!");
                        break;
                    case 2: //Lower
                        System.out.println("You win!");
                        winStreakCounter = winStreakCounter + 1;
                        break;
                }
            }
            if (higherOrLowerResult < 0) {
                switch (playerInput) {
                    case 1: //Higher
                        System.out.println("You win!");
                        winStreakCounter = winStreakCounter + 1;
                        break;
                    case 2: //Lower
                        Main.casinoCoins = Main.casinoCoins - 10;
                        System.out.println("You lose!");
                        break;
                }
            }
            System.out.println("Your dealt card was a " + dealtCardTwo);
            System.out.println("");
            if (winStreakCounter == 3) {
                Main.casinoCoins = Main.casinoCoins + 30;
            }
        }
    }

    public static void slotMachine() {
        getOut();
        // pay 10CC to play
        // 3 paylines are rolled, with 3 different symbols
        // symbols = diamond, cherry and grape (descending order of importance)

        boolean slotPlaying = true;
        int slotOne;
        int slotTwo;
        int slotThree;
        int userChoiceOne;
        String slotOneString = null;
        String slotTwoString = null;
        String slotThreeString = null;

        Random rand = new Random();
        Scanner input = new Scanner(System.in);

        while (slotPlaying = true) {

            System.out.println("Welcome to the Slot Machine! To roll, enter 1. To exit, enter 2");
            userChoiceOne = input.nextInt();

            if (userChoiceOne == 2) {
                hub();
            }

            Main.casinoCoins = Main.casinoCoins - 10;
            slotOne = rand.nextInt(3) + 1;
            slotTwo = rand.nextInt(3) + 1;
            slotThree = rand.nextInt(3) + 1;

            switch (slotOne) {
                case 1:
                    slotOneString = "Grape";
                    break;
                case 2:
                    slotOneString = "Cherry";
                    break;
                case 3:
                    slotOneString = "Diamond";
                    break;
            }

            switch (slotTwo) {
                case 1:
                    slotTwoString = "Grape";
                    break;
                case 2:
                    slotTwoString = "Cherry";
                    break;
                case 3:
                    slotTwoString = "Diamond";
                    break;
            }

            switch (slotThree) {
                case 1:
                    slotThreeString = "Grape";
                    break;
                case 2:
                    slotThreeString = "Cherry";
                    break;
                case 3:
                    slotThreeString = "Diamond";
                    break;
            }

            System.out.println("|" + slotOneString + "|" + slotTwoString + "|" + slotThreeString + "|");
            if (slotOne != slotTwo && slotTwo != slotThree) {
                System.out.println("Nothing gained. Better luck next time!");
            } else {
                if (slotOne == slotTwo && slotTwo == slotThree) {
                    System.out.println("Jackpot!");
                    Main.casinoCoins = Main.casinoCoins + 30;
                } else {
                    System.out.println("You got one match!");
                    Main.casinoCoins = Main.casinoCoins + 15;
                }
            }

        }

    }

}
