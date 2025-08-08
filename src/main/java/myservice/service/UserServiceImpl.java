package myservice.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Long id) {
        return new User("Serg", new Address("Khom", "Ukraine" ));
    }
}
