package debit.manager.service;

import debit.manager.domain.User;
import debit.manager.domain.dto.UserDto;
import debit.manager.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User createUser(UserDto dto) {
        User u = new User(dto);
        return userRepo.save(u);
    }
}
