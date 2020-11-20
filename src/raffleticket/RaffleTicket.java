package raffleticket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;

public class RaffleTicket {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static HashMap<Integer, String> tickets = new HashMap<>();

    public static void main(String[] args) {

        System.out.println("Welcome to my raffle game.");

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Purchase a ticket");
            System.out.println("2. Check a ticket");
            System.out.println("3. Exit");
            System.out.println("Tickets given out so far " + tickets.keySet());

            try {
                int userChoice = Integer.parseInt(input.readLine());
                switch (userChoice) {
                    case (1):
                        System.out.println("You have chosen to purchase a ticket");
                        purchaseTicket();
                        break;
                    case (2):
                        System.out.println("You have chosen to check a ticket");
                        checkTicket();
                        break;
                    case (3):
                        System.exit(0);

                    default:
                        System.out.println("That is not a valid choice");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }

    }

    public static void purchaseTicket() {
        try {
            System.out.println("What is your name?");
            String name = input.readLine();

            while (true) {
                Random random = new Random();
                int ticketNumber = random.nextInt(1000);
                if (!tickets.containsKey(ticketNumber)) {
                    System.out.println("Your ticket number is: " + ticketNumber);
                    tickets.put(ticketNumber, name);
                    break;
                }

            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }

    }

    public static void checkTicket() {
        try {

            System.out.println("What is your ticket number");
            int ticketNumber = Integer.parseInt(input.readLine());

            System.out.println("What is your name?");
            String name = input.readLine();

            boolean valid = false;
            for (int key : tickets.keySet()) {
                if (key == ticketNumber) {
                    if (tickets.get(key).equals(name)) {
                        valid = true;
                        break;
                    }
                }
            }

            if (valid) {
                if (isPrime(ticketNumber)) {
                    System.out.println("Well done you have won a prize!");
                } else {
                    System.out.println("Sorry, you have not won a prize.");
                }
            } else {
                System.out.println("You do not appear to have a valid ticket");
            }

        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public static boolean isPrime(int ticketNumber) {

        boolean isPrime = true;
        for (int i = 2; i < 10; i++) {
            if (ticketNumber == i) {
                continue;
            }
            if (ticketNumber % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
