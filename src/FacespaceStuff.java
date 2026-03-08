/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.
Jorvon Carter. No team.
UPGRADED TO JAVA 25 - March 2026
*/

import java.util.*;
import java.util.stream.Collectors;

/**
 * Modern Java 25 implementation of the Facespace social network
 * Features: var, Optional, Stream API, enhanced switch, text blocks, string templates
 */
public class FacespaceStuff {
    private final Map<String, UserProfile> users = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public FacespaceStuff() {
        // Modern constructor - could initialize with default data if needed
    }

    /**
     * Build a user profile from interactive input
     */
    public UserProfile buildProfile() {
        System.out.println("\n📝 Enter user information:");

        var firstName = promptFor("First name");
        var lastName = promptFor("Last name");
        var middleName = promptFor("Middle name");
        var age = promptFor("Age");
        var status = promptFor("Relationship status");
        var country = promptFor("Country");
        var state = promptFor("State/Province");
        var city = promptFor("City");
        var education = promptFor("Education");
        var employment = promptFor("Employment");
        var religion = promptFor("Religion");
        var anything = promptFor("Anything else");

        return new UserProfile(firstName, lastName, middleName, age, status,
                country, state, city, education, employment, religion, anything,
                new ArrayList<>());
    }

    private String promptFor(String fieldName) {
        System.out.print("  " + fieldName + ": ");
        return scanner.nextLine().trim();
    }

    /**
     * Add a user to the network
     */
    public void addUser(UserProfile profile) {
        if (users.containsKey(profile.name())) {
            System.out.println("❌ " + profile.firstName() + " is already in the network.");
            System.out.println("💡 Try a different name or update this user instead.");
        } else {
            users.put(profile.name(), profile);
            System.out.println("✅ " + profile.name() + " added to the network!");
        }
    }

    /**
     * Check if user exists
     */
    public boolean hasUser(String name) {
        return users.containsKey(name);
    }

    /**
     * Update an existing user's information
     */
    public void updateUser() {
        var name = promptForUserName("User to update");

        findUser(name).ifPresentOrElse(
            profile -> {
                users.remove(name);

                System.out.println("\n✏️  Enter new information (leave blank to keep current value):");

                var fnNew = promptFor("First name");
                var lnNew = promptFor("Last name");
                var mnNew = promptFor("Middle name");
                var ageNew = promptFor("Age");
                var statusNew = promptFor("Relationship status");
                var countryNew = promptFor("Country");
                var stateNew = promptFor("State/Province");
                var cityNew = promptFor("City");
                var educationNew = promptFor("Education");
                var employmentNew = promptFor("Employment");
                var religionNew = promptFor("Religion");
                var anythingNew = promptFor("Anything else");

                var updatedProfile = profile.updateAllFields(
                    fnNew, lnNew, mnNew, ageNew, statusNew,
                    countryNew, stateNew, cityNew, educationNew,
                    employmentNew, religionNew, anythingNew
                );

                // Update friend references if name changed
                if (!updatedProfile.name().equals(name)) {
                    users.values().stream()
                        .filter(u -> u.friends().contains(name))
                        .forEach(u -> {
                            var updated = u.removeFriend(name).addFriend(updatedProfile.name());
                            users.put(updated.name(), updated);
                        });
                }

                users.put(updatedProfile.name(), updatedProfile);
                System.out.println("✅ " + updatedProfile.name() + " updated successfully!");
            },
            () -> System.out.println("❌ " + name + " is not in the network. You can try to add this user.")
        );
    }

    /**
     * Remove a user from the network
     */
    public void removeUser() {
        var name = promptForUserName("User to remove");

        if (!users.containsKey(name)) {
            System.out.println("❌ " + name + " is not in the network!");
            return;
        }

        // Remove from all friend lists using streams
        users.values().stream()
            .filter(user -> user.friends().contains(name))
            .forEach(user -> {
                var updated = user.removeFriend(name);
                users.put(updated.name(), updated);
            });

        users.remove(name);
        System.out.println("\n💀 Pale Death with impartial tread beats at the poor man's cottage door and at the palaces of kings.");
        System.out.println("🗑️  " + name + " has been removed from the network.");
    }

    /**
     * Find a user by name (returns Optional for null safety)
     */
    public Optional<UserProfile> findUser(String name) {
        return Optional.ofNullable(users.get(name))
            .or(() -> {
                System.out.println("❌ User '" + name + "' not found.");
                return Optional.empty();
            });
    }

    /**
     * Add a friendship connection between two users
     */
    public void addFriend() {
        System.out.println("\n🤝 Enter two users to make friends:");
        var name1 = promptForUserName("User 1");
        var name2 = promptForUserName("User 2");

        var user1Opt = Optional.ofNullable(users.get(name1));
        var user2Opt = Optional.ofNullable(users.get(name2));

        if (user1Opt.isEmpty() || user2Opt.isEmpty()) {
            System.out.println("❌ One or both users not found in network.");
            return;
        }

        var user1 = user1Opt.get();
        var user2 = user2Opt.get();

        if (user1.friends().contains(name2)) {
            System.out.println("ℹ️  These users are already friends.");
            return;
        }

        users.put(name1, user1.addFriend(name2));
        users.put(name2, user2.addFriend(name1));

        System.out.println("✅ " + name1 + " and " + name2 + " are now friends! 🎉");
    }

    /**
     * Remove a friendship connection
     */
    public void removeFriend() {
        System.out.println("\n💔 Enter two users to defriend:");
        var name1 = promptForUserName("User 1");
        var name2 = promptForUserName("User 2");

        var user1Opt = Optional.ofNullable(users.get(name1));
        var user2Opt = Optional.ofNullable(users.get(name2));

        if (user1Opt.isEmpty() || user2Opt.isEmpty()) {
            System.out.println("❌ One or both users not found in network.");
            return;
        }

        users.put(name1, user1Opt.get().removeFriend(name2));
        users.put(name2, user2Opt.get().removeFriend(name1));

        System.out.println("✅ " + name1 + " and " + name2 + " are no longer friends.");
    }

    /**
     * Calculate degree of separation using BFS (Breadth-First Search)
     * This is the algorithmic gem of the project! 🔍
     */
    public void degOfSep() {
        System.out.println("\n🔗 Calculate degree of separation:");
        var name1 = promptForUserName("User 1");
        var name2 = promptForUserName("User 2");

        if (name1.equals(name2)) {
            System.out.println("❌ Please enter two different users!");
            return;
        }

        if (!users.containsKey(name1) || !users.containsKey(name2)) {
            System.out.println("❌ One or both users not found in network.");
            return;
        }

        // Modern BFS with cleaner code
        var visited = new HashSet<String>();
        var queue = new ArrayDeque<String>();
        var levelMap = new HashMap<String, Integer>();

        queue.offer(name1);
        levelMap.put(name1, 0);
        visited.add(name1);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            var currentLevel = levelMap.get(current);

            var currentUser = users.get(current);

            for (var friendName : currentUser.friends()) {
                if (friendName.equals(name2)) {
                    var degree = currentLevel + 1;
                    System.out.println("🎯 Degree of separation: " + degree);
                    return;
                }

                if (!visited.contains(friendName)) {
                    visited.add(friendName);
                    queue.offer(friendName);
                    levelMap.put(friendName, currentLevel + 1);
                }
            }
        }

        System.out.println("❌ No connection found between these users!");
    }

    /**
     * List all users in the network
     */
    public void listOfUsers() {
        System.out.println("\n👥 All users in network:");

        if (users.isEmpty()) {
            System.out.println("   📭 Network is empty!");
            return;
        }

        users.keySet().stream()
            .sorted()
            .forEach(name -> System.out.println("   • " + name));

        System.out.println("\n   Total users: " + users.size());
    }

    /**
     * Show detailed profile for a specific user
     */
    public void showProfile(String name) {
        findUser(name).ifPresent(this::displayProfile);
    }

    /**
     * Show profile (interactive version)
     */
    public void showProfile() {
        var name = promptForUserName("User to show");
        findUser(name).ifPresent(this::displayProfile);
    }

    /**
     * Display a profile with nice formatting
     */
    private void displayProfile(UserProfile profile) {
        var friendsList = profile.friends().isEmpty()
            ? "   None yet"
            : profile.friends().stream()
                .map(f -> "   • " + f)
                .collect(Collectors.joining("\n"));

        System.out.println("""
            
            ╔════════════════════════════════════════╗
            ║           USER PROFILE                 ║
            ╚════════════════════════════════════════╝
            """);

        System.out.println("👤 Name: " + profile.fullName());
        System.out.println("🎂 Age: " + profile.age());
        System.out.println("💑 Status: " + profile.status());
        System.out.println("📍 Location: " + profile.city() + ", " + profile.state() + ", " + profile.country());
        System.out.println("🎓 Education: " + profile.education());
        System.out.println("💼 Employment: " + profile.employment());
        System.out.println("✝️  Religion: " + profile.religion());
        System.out.println("📝 Other: " + profile.anything());
        System.out.println("👥 Friends (" + profile.friends().size() + "):\n" + friendsList);
        System.out.println();
    }

    /**
     * Helper to prompt for a user name
     */
    private String promptForUserName(String context) {
        System.out.println("\n  " + context + ":");
        var firstName = promptFor("  First name");
        var lastName = promptFor("  Last name");
        return (firstName + " " + lastName).trim();
    }

    /**
     * Get all user names (for GUI support)
     */
    public java.util.Set<String> getAllUserNames() {
        return users.keySet();
    }

    /**
     * Add friendship directly (for GUI support)
     */
    public void addFriendshipDirect(String name1, String name2) {
        var user1Opt = Optional.ofNullable(users.get(name1));
        var user2Opt = Optional.ofNullable(users.get(name2));

        if (user1Opt.isPresent() && user2Opt.isPresent()) {
            users.put(name1, user1Opt.get().addFriend(name2));
            users.put(name2, user2Opt.get().addFriend(name1));
        }
    }

    /**
     * Remove friendship directly (for GUI support)
     */
    public void removeFriendshipDirect(String name1, String name2) {
        var user1Opt = Optional.ofNullable(users.get(name1));
        var user2Opt = Optional.ofNullable(users.get(name2));

        if (user1Opt.isPresent() && user2Opt.isPresent()) {
            users.put(name1, user1Opt.get().removeFriend(name2));
            users.put(name2, user2Opt.get().removeFriend(name1));
        }
    }
}
