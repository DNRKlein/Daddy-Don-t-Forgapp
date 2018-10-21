package nl.davidklein.daddydontforgapp.repository.mapping;

/**
 * Repository mapper which maps a domain entity to jpa and back
 */
public interface RepositoryMapper<ENTITY, JPA> {

    ENTITY mapToDomain(final JPA source);

    JPA mapToJpa(final ENTITY source);
}
