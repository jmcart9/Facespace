/*
THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING
A TUTOR OR CODE WRITTEN BY OTHER STUDENTS.
Jorvon Carter. No team.
UPGRADED TO JAVA 25 - March 2026
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Modern Java 25 Record-based UserProfile
 * Using records for immutability and built-in methods
 */
public record UserProfile(
    String firstName,
    String lastName,
    String middleName,
    String age,
    String status,
    String country,
    String state,
    String city,
    String education,
    String employment,
    String religion,
    String anything,
    List<String> friends
) {
    // Compact constructor for validation and normalization
    public UserProfile {
        firstName = firstName == null ? "" : firstName.toLowerCase().trim();
        lastName = lastName == null ? "" : lastName.toLowerCase().trim();
        middleName = middleName == null ? "" : middleName.toLowerCase().trim();
        age = age == null ? "" : age.toLowerCase().trim();
        status = status == null ? "" : status.toLowerCase().trim();
        country = country == null ? "" : country.toLowerCase().trim();
        state = state == null ? "" : state.toLowerCase().trim();
        city = city == null ? "" : city.toLowerCase().trim();
        education = education == null ? "" : education.toLowerCase().trim();
        employment = employment == null ? "" : employment.toLowerCase().trim();
        religion = religion == null ? "" : religion.toLowerCase().trim();
        anything = anything == null ? "" : anything.toLowerCase().trim();
        friends = friends == null ? new ArrayList<>() : new ArrayList<>(friends);
    }

    // Convenience constructors
    public UserProfile(String fn, String ln, String age) {
        this(fn, ln, "", age, "", "", "", "", "", "", "", "", new ArrayList<>());
    }

    // Derived properties
    public String name() {
        return (firstName + " " + lastName).trim();
    }

    public String fullName() {
        return middleName.isEmpty()
            ? (firstName + " " + lastName).trim()
            : (firstName + " " + middleName + " " + lastName).trim();
    }

    // Since records are immutable, we need methods to create modified copies
    public UserProfile addFriend(String friendName) {
        var newFriends = new ArrayList<>(friends);
        if (!newFriends.contains(friendName)) {
            newFriends.add(friendName);
        }
        return new UserProfile(firstName, lastName, middleName, age, status,
            country, state, city, education, employment, religion, anything, newFriends);
    }

    public UserProfile removeFriend(String friendName) {
        var newFriends = new ArrayList<>(friends);
        newFriends.remove(friendName);
        return new UserProfile(firstName, lastName, middleName, age, status,
            country, state, city, education, employment, religion, anything, newFriends);
    }

    public UserProfile updateName(String newFirstName, String newLastName, String newMiddleName) {
        return new UserProfile(
            newFirstName.isEmpty() ? firstName : newFirstName,
            newLastName.isEmpty() ? lastName : newLastName,
            newMiddleName.isEmpty() ? middleName : newMiddleName,
            age, status, country, state, city, education, employment, religion, anything, friends
        );
    }

    public UserProfile updateAllFields(String fn, String ln, String mn, String a, String s,
                                      String c, String st, String ci, String ed, String em,
                                      String rel, String any) {
        return new UserProfile(
            fn.isEmpty() ? firstName : fn,
            ln.isEmpty() ? lastName : ln,
            mn.isEmpty() ? middleName : mn,
            a.isEmpty() ? age : a,
            s.isEmpty() ? status : s,
            c.isEmpty() ? country : c,
            st.isEmpty() ? state : st,
            ci.isEmpty() ? city : ci,
            ed.isEmpty() ? education : ed,
            em.isEmpty() ? employment : em,
            rel.isEmpty() ? religion : rel,
            any.isEmpty() ? anything : any,
            friends
        );
    }

    @Override
    public List<String> friends() {
        return Collections.unmodifiableList(friends);
    }
}
