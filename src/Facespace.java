/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.
Jorvon Carter. No team.
UPGRADED TO JAVA 25 - March 2026
*/

import java.util.Scanner;

public class Facespace {

    private static final String HELP_TEXT = """
            
            ╔════════════════════════════════════════════════════════════╗
            ║                    FACESPACE COMMANDS                      ║
            ╚════════════════════════════════════════════════════════════╝
            
            📝 add      - Add a user to the network
            🗑️  remove   - Remove a user from the network
            ✏️  update   - Update an existing user's information
            🔍 find     - Show a user's profile
            👥 findall  - Show a list of all users
            🤝 addf     - Make a friendship connection
            💔 removef  - Sever a friendship connection
            🔗 deg      - Show degree of separation between two users
            ❓ help     - Show this command list
            🚪 exit     - Terminate the program
            
            """;

    private static final String WELCOME = """
            
            ══════════════════════════════════════
            🌐  Welcome to Facespace 2026!  🌐
            ══════════════════════════════════════
            
            A modern social network built with Java 25
            """;

    public static void main(String[] args) {
        var network = new FacespaceStuff();

        try (var scan = new Scanner(System.in)) {
            System.out.println(WELCOME);
            System.out.println(HELP_TEXT);

            String command;
            do {
                System.out.println("\n💬 Enter a command (type 'help' for options): ");
                command = scan.nextLine().toLowerCase().trim();

                var result = switch (command) {
                    case "add" -> {
                        var profile = network.buildProfile();
                        if (network.hasUser(profile.name())) {
                            System.out.println("❌ " + profile.name() + " already in network.");
                            System.out.println("💡 Try a different name or use 'update' instead.");
                            yield "duplicate";
                        }
                        network.addUser(profile);
                        network.showProfile(profile.name());
                        yield "added";
                    }
                    case "remove" -> {
                        network.removeUser();
                        yield "removed";
                    }
                    case "update" -> {
                        network.updateUser();
                        yield "updated";
                    }
                    case "find" -> {
                        network.showProfile();
                        yield "found";
                    }
                    case "findall" -> {
                        network.listOfUsers();
                        yield "listed";
                    }
                    case "addf" -> {
                        network.addFriend();
                        yield "friend_added";
                    }
                    case "removef" -> {
                        network.removeFriend();
                        yield "friend_removed";
                    }
                    case "deg" -> {
                        network.degOfSep();
                        yield "degree_checked";
                    }
                    case "help" -> {
                        System.out.println(HELP_TEXT);
                        yield "help";
                    }
                    case "exit" -> {
                        System.out.println("\n👋 Thanks for using Facespace 2026! Goodbye!");
                        yield "exit";
                    }
                    case "" -> "empty";
                    default -> {
                        System.out.println("❌ Unknown command. Type 'help' for available commands.");
                        yield "invalid";
                    }
                };

            } while (!command.equals("exit"));
        }
    }
}
