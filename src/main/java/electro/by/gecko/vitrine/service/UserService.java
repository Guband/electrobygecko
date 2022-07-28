package electro.by.gecko.vitrine.service;

import electro.by.gecko.vitrine.entity.User;
import electro.by.gecko.vitrine.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDAO userDAO;

    public User createUser(String name, String password) {
        return userDAO.save(new User(name, passwordEncoder.encode(password)));
    }

    public User updateUser(long id, String name, String password) {
        return userDAO.save(new User(id, name, passwordEncoder.encode(password)));
    }

    public User updateUser(User user) {
        return userDAO.save(user);
    }

    public void deleteUser(long id) {
        userDAO.deleteById(id);
    }

    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    public User findUser(long id) throws EntityNotFoundException {
        return userDAO.findById(id).orElseThrow( () -> new EntityNotFoundException("No User found with id :"+id));
    }
    public Iterable<User> findAll() {
        return userDAO.findAll();
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("No User found with username :"+username));
    }
}
