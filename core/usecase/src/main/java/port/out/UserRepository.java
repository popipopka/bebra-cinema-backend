package port.out;

import it.bebra.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);

    Optional<User> findById(int id);

    List<User> findAll();

    void deleteById(int id);
}
