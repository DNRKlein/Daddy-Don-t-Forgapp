package nl.davidklein.daddydontforgapp.domain.core;

import static java.util.Objects.requireNonNull;

/**
 * Representation of a user of the system
 */
public class User {

    private Long id;
    private String name;

    /**
     * For deserialization purposes. FIXME this needs to be fixed, because it is ugly and makes it possible
     * to create empty DomainEntities
     */
    public User() {
    }

    /**
     * Constuctor
     * @param name
     *      The name of the user
     */
    public User(final String name) {
        this(null, name);
    }

    /**
     * Constructor
     * @param name
     *      The name of the user
     * @param id
     *      The id of the user
     */
    public User(final Long id, final String name) {
        requireNonNull(name);

        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
