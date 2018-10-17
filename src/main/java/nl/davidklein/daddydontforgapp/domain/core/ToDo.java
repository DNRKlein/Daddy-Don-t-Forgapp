package nl.davidklein.daddydontforgapp.domain.core;

import static java.util.Objects.requireNonNull;

public abstract class ToDo {
    private User sender;
    private User receiver;
    private String title;

    public ToDo(User sender, User receiver, String title) {
        requireNonNull(sender);
        requireNonNull(title);

        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getTitle() {
        return title;
    }
}
