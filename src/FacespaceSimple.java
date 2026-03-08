/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.
Jorvon Carter. No team.
UPGRADED TO JAVA 25 - March 2026
*/

import java.util.Scanner;

public class FacespaceSimple {

    private static final String HELP_TEXT = """
            
            ================================================
                        FACESPACE COMMANDS                      
            ================================================
            
            add      - Add a user to the network
            remove   - Remove a user from the network
            update   - Update an existing user's information
            find     - Show a user's profile
            findall  - Show a list of all users
            addf     - Make a friendship connection
            removef  - Sever a friendship connection
            deg      - Show degree of separation between two users
            help     - Show this command list
            exit     - Terminate the program
            
            """;

    private static final String WELCOME = """
            
            ======================================
              Welcome to Facespace 2026!
            ======================================
            
            A modern social network built with Java 25
            """;

    public static void main(String[] args) {
        var network = new FacespaceStuff();

        try (var scan = new Scanner(System.in)) {
            System.out.println(WELCOME);
            System.out.println(HELP_TEXT);

            String command;
            do {
                System.out.println("\nEnter a command (type 'help' for options): ");
                command = scan.nextLine().toLowerCase().trim();

                switch (command) {
                    case "add" -> {
                        var profile = network.buildProfile();
                        if (network.hasUser(profile.name())) {
                            System.out.println("ERROR: " + profile.name() + " already in network.");
                            System.out.println("Try a different name or use 'update' instead.");
                        } else {
                            network.addUser(profile);
                            network.showProfile(profile.name());
                        }
                    }
                    case "remove" -> network.removeUser();
                    case "update" -> network.updateUser();
                    case "find" -> network.showProfile();
                    case "findall" -> network.listOfUsers();
                    case "addf" -> network.addFriend();
                    case "removef" -> network.removeFriend();
                    case "deg" -> network.degOfSep();
                    case "help" -> System.out.println(HELP_TEXT);
                    case "exit" -> System.out.println("\nThanks for using Facespace 2026! Goodbye!");
                    case "" -> {}
                    default -> System.out.println("Unknown command. Type 'help' for available commands.");
                }

            } while (!command.equals("exit"));
        }
    }
}

