package org.example.services;

import lombok.AllArgsConstructor;
import org.example.dtos.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {
    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserDto registerUser(UserDto userDto) {
        UserDto userDto1 = userService.createUser(userDto);
        return modelMapper.map(userDto1, UserDto.class);
    }
}
