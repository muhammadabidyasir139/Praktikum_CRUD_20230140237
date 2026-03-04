package com.deploy.praktikum1.service.Impl;

import com.deploy.praktikum1.mapper.UserMapper;
import com.deploy.praktikum1.model.dto.UserAddRequest;
import com.deploy.praktikum1.model.dto.UserDto;
import com.deploy.praktikum1.model.entity.User;
import com.deploy.praktikum1.repository.UserRepository;
import com.deploy.praktikum1.service.UserService;
import com.deploy.praktikum1.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationUtil validationUtil;

    @Override
    public UserDto AddUser(UserAddRequest request) {
        validationUtil.validate(request);

        User saveUser = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .age(request.getAge())
                .build();

                userRepository.save(saveUser);

        UserDto userDto = UserMapper.MAPPER.toUserDtoData(saveUser);

        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        return List.of();
    }

    @Override
    public UserDto getUserById(String id) {
        return null;
    }

    @Override
    public UserDto UpdateUser(String idi, UserAddRequest request) {
        return null;
    }

    @Override
    public void DeleteUser(String id) {

    }
}
