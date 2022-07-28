package electro.by.gecko.vitrine.service;

import electro.by.gecko.vitrine.entity.User;
import electro.by.gecko.vitrine.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDAO.findByUsername(username);
        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return optionalUser.get();
    }
}
