package com.wbz.wbzapi.dto;

import com.wbz.wbzapi.entity.Role;
import com.wbz.wbzapi.entity.User;
import com.wbz.wbzapi.mapper.Impl.UserMapperImpl;
import com.wbz.wbzapi.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserDTOTest {

    @Autowired
    private UserMapper userMapper;

    private User user;

    @BeforeEach
    void setUpUser() {
        user = new User();
        user.setId(12345L);
        user.setEmail("@gmail.ru");
        user.setUsername("john");
        Role userRole1 = new Role();
        userRole1.setName("USER");
        Role userRole2 = new Role();
        userRole2.setName("ADMIN");
        userRole2.setUsers(new ArrayList<>(Collections.singletonList(user)));
        user.setRoles(new ArrayList<>(Arrays.asList(userRole1, userRole2)));
    }

    //TODO не полный из-за отстутствия ролемаппера(сдлетаь его), а также статуса в юзер ДТО

    @Test
    @DisplayName("Получение DTO из User")
    public void userToUserDTO() {
        UserDTO userDTO = userMapper.toUserDTO(user);
        assertAll("Проверка id,username,email",
                () -> assertEquals(user.getId(),userDTO.getId()),
                () -> assertEquals(user.getUsername(), userDTO.getUsername()),
                () -> assertEquals(user.getEmail(), userDTO.getEmail())
        );
    }
}
