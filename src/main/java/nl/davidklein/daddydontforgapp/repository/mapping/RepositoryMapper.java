package nl.davidklein.daddydontforgapp.repository.mapping;

import nl.davidklein.daddydontforgapp.repository.jpa.JpaEntity;

/**
 * Repository mapper which maps a domain entity to jpa and back
 */
public interface RepositoryMapper<ENTITY, JPA extends JpaEntity> {

    ENTITY mapToDomain(final JPA source);

    JPA mapToJpa(final ENTITY source);
}
