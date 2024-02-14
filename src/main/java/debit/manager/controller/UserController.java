package debit.manager.controller;

import debit.manager.domain.User;
import debit.manager.domain.dto.UserDto;
import debit.manager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity createUser(UserDto dto, UriComponentsBuilder uriBuilder) {
        User u = userService.createUser(dto);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(u.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
