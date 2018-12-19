package nl.davidklein.daddydontforgapp.domain.core;

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
     * Constructor
     * @param name
     *      The name of the user
     */
    public User(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
