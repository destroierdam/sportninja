package com.damian.boytchev.sport.ninja.SportNinja.service.abstraction;

import com.damian.boytchev.sport.ninja.SportNinja.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    User create(User user);
    User read(User user);
    User update(User user);
    Boolean delete(User user);
    User getUserById(UUID userId);
    Boolean deleteUserById(UUID uuid);
    List<User> findAllUsers(Pageable pageable);
}
