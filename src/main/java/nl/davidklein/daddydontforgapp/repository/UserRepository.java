package nl.davidklein.daddydontforgapp.repository;

import nl.davidklein.daddydontforgapp.domain.core.User;
import nl.davidklein.daddydontforgapp.repository.jpa.UserJpa;
import nl.davidklein.daddydontforgapp.repository.mapping.RepositoryMapper;
import nl.davidklein.daddydontforgapp.repository.mapping.UserRepositoryMapper;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository extends AbstractRepository<User, UserJpa> {

    private UserRepositoryMapper userRepositoryMapper;

    @Inject
    public UserRepository(final UserRepositoryMapper userRepositoryMapper) {
        this.userRepositoryMapper = userRepositoryMapper;
    }

    @Override
    protected RepositoryMapper<User, UserJpa> getRepositoryMapper() {
        return userRepositoryMapper;
    }

    @Override
    protected UserJpa doGetJpa(final Long identity) {
        return getEntityManager().find(identity, UserJpa.class);
    }

    public List<User> findAllUsers(){
        final String getAllQueryString = "select u from UserJpa u";

        final TypedQuery<UserJpa> query = getEntityManager().createEntityQuery(getAllQueryString, UserJpa.class);
        return doMapFoundEntities(query.getResultList());
    }
}
