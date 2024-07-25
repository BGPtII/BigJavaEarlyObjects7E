package bigjavaearlyobjectsexercisesprojects.chaptertwelve.practiceexercises.messaging;

import java.util.ArrayList;

public class Client {

    private UserService userService;
    private MessageService messageService;
    private String loggedInUserUsername;
    private ArrayList<Message> loggedInUserInbox;

    public Client() {
        this.userService = new UserService();
        this.messageService = new MessageService();
        loggedInUserUsername = null;
        loggedInUserInbox = new ArrayList<>();
    }

    public String getLoggedInUserUsername() {
        return loggedInUserUsername;
    }

    public ArrayList<Message> getLoggedInUserInbox() {
        return loggedInUserInbox;
    }

    /**
     * Updates the loggedInUserInbox
     */
    public void updateLoggedInUserInbox() {
        if (loggedInUserUsername != null) {
            loggedInUserInbox = messageService.getUserInbox(loggedInUserUsername);
        }
        else {
            loggedInUserInbox.clear();
        }
    }

    /**
     * Updates the loggedInUserUsername with the result from userService's login
     */
    public void login(String enteredUsername, String enteredPassword) {
        loggedInUserUsername = userService.login(enteredUsername, enteredPassword);
        if (loggedInUserUsername != null) {
            updateLoggedInUserInbox();
        }
    }

    /**
     * Brings the User back to the entry section, updates the variables used to keep track of the logged-in user
     */
    public void logout() {
        loggedInUserUsername = null;
        loggedInUserInbox.clear();
    }

    /**
     * Update the loggedInUserUsername if userService's register returns true
     */
    public void register(String enteredUsername, String enteredPassword) {
        if (userService.register(enteredUsername, enteredPassword)) {
            login(enteredUsername, enteredPassword);
        }
    }

    public boolean sendMessage(String senderUsername, String recipientUsername, String messageContent) {
        if (userService.isUsernamePresent(senderUsername) && userService.isUsernamePresent(recipientUsername)) {
            if (messageService.sendMessage(senderUsername, recipientUsername, messageContent)) {
                updateLoggedInUserInbox();
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean deleteMessage() {
        if (loggedInUserUsername != null) {
            if (messageService.deleteMessage(loggedInUserUsername)) {
                updateLoggedInUserInbox();
                return true;
            }
            return false;
        }
        return false;
    }

}
