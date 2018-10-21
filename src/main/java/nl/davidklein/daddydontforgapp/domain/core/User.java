package nl.davidklein.daddydontforgapp.domain.core;

/**
 * Representation of a user of the system
 */
public class User {

    private Long id;
    private String name;

    /**
     * Constructor
     * @param id
     *      The id of the user
     * @param name
     *      The name of the user
     */
    public User(final Long id, final String name) {
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
