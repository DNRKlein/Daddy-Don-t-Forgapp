package nl.davidklein.daddydontforgapp.repository.mapping;

import nl.davidklein.daddydontforgapp.domain.core.User;
import nl.davidklein.daddydontforgapp.repository.jpa.UserJpa;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryMapper implements RepositoryMapper<User, UserJpa> {

    @Override
    public User mapToDomain(final UserJpa source) {
        if(source == null){
            return null;
        }

        return new User(source.getId(), source.getName());
    }

    /**
     * @param source
     * @return
     */
    @Override
    public UserJpa mapToJpa(final User source) {
        if(source == null){
            return null;
        }

        return new UserJpa(source.getId(), source.getName(), null, null);
    }
}
