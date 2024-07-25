package bigjavaearlyobjectsexercisesprojects.chaptertwelve.practiceexercises.messaging;

import java.util.ArrayList;

public class MessageService {

    public MessageService() {

    }

    /**
     * Returns the messages that involve the user as either the sender or recipient as an ArrayList that will be
     * displayed to the associatedUser as the userInbox.
     */
    public ArrayList<Message> getUserInbox(String username) {
        return new ArrayList<>();
    }

    /**
     * Sends a message, returns whether it was successfully sent
     */
    public boolean sendMessage(String senderUsername, String recipientUsername, String messageContent) {
        return false;
    }

    /**
     * Deletes a message from a user's inbox, returns whether it was successfully deleted
     */
    public boolean deleteMessage(String username) {
        return false;
    }

}
