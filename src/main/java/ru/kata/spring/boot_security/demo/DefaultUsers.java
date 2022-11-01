package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DefaultUsers {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DefaultUsers(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
        Role roleAdmin = new Role();
        roleAdmin.setId(1);
        roleAdmin.setRole("ROLE_ADMIN");
        this.roleService.saveRole(roleAdmin);
        Role roleUser = new Role();
        roleUser.setId(2);
        roleUser.setRole("ROLE_USER");
        this.roleService.saveRole(roleUser);

        User userAdmin = new User();
        userAdmin.setId(1);
        userAdmin.setFirstName("Skornyakov");
        userAdmin.setLastName("Nikita");
        userAdmin.setAge(23);
        userAdmin.setUsername("nikita@mail.ru");
        userAdmin.setPassword("123");
        userAdmin.setRoles(new ArrayList<>(Stream.of(roleAdmin).collect(Collectors.toList())));
        this.userService.saveUser(userAdmin);

        User user = new User();
        user.setId(2);
        user.setFirstName("User");
        user.setLastName("User");
        user.setAge(44);
        user.setUsername("user@mail.ru");
        user.setPassword("user");
        user.setRoles(new ArrayList<>(Stream.of(roleUser).collect(Collectors.toList())));
        this.userService.saveUser(user);
    }
}
