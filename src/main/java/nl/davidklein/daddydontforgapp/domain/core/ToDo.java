package nl.davidklein.daddydontforgapp.domain.core;

import static java.util.Objects.requireNonNull;

/**
 * Base class
 */
public abstract class ToDo {
    private Long id;
    private User sender;
    private User receiver;
    private String title;

    /**
     * Constructor
     * @param id
     *      The id of the ToDo
     * @param sender
     *      The {@link User} which send the ToDo.
     * @param receiver
     *      The {@link User} which is to receive the ToDo.
     * @param title
     *      The title of the ToDo.
     */
    public ToDo(final Long id, final User sender, final User receiver, final String title) {
        requireNonNull(sender);
        requireNonNull(receiver);
        requireNonNull(title);

        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
    }

    public Long getId() {
        return id;
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
