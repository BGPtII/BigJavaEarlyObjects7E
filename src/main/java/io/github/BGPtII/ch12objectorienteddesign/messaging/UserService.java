package bigjavaearlyobjectsexercisesprojects.chaptertwelve.practiceexercises.messaging;

public class UserService {

    public UserService() {

    }

    /**
     * Registers & persists the created User in the repository of all users.
     * Returns whether the user created was successfully added to the user repository.
     */
    public boolean register(String enteredUsername, String enteredPassword) {
        String hashedPassword = hashPassword(enteredPassword);
        return false;
    }

    /**
     * Sets the loggedInUser to the User specified, if it is a valid User contained in the user repository.
     * Returns the logged-in User if successful, null otherwise
     */
    public String login(String enteredUsername, String enteredPassword) {
        String passwordHash = hashPassword(enteredPassword);
        return null;
    }

    /**
     * Searches the repository of users for a username match; returns whether a match is found
     */
    public boolean isUsernamePresent(String username) {
        return false;
    }

    /**
     * Returns the hashed cleartext password
     */
    public String hashPassword(String password) {
        return password;
    }

}
