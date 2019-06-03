package nl.davidklein.daddydontforgapp.domain.core;

import static java.util.Objects.requireNonNull;

/**
 * Representation of a user of the system
 */
public class User {

    private Long id;
    private String name;
    private String email;

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
     * @param email
     */
    public User(final String name, final String email) {
        this(null, name, email);
    }

    /**
     * Constructor
     * @param id
     *      The id of the user
     * @param name
     *      The name of the user
     * @param email
     */
    public User(final Long id, final String name, final String email) {
        this.id = id;
        this.name = requireNonNull(name);
        this.email = requireNonNull(email);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
