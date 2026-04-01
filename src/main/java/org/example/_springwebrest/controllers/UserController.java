package org.example._springwebrest.controllers;

import org.example._springwebrest.models.User;
import org.example._springwebrest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserService userService;

    // GET | POST | PUT | PATCH | DELETE

    @GetMapping
    public List<User> users() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getuser(@PathVariable long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody User user) {

            if(userService.getUserById(id).getId() == user.getId()) {
                return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("ID not found!", HttpStatus.NOT_FOUND);
            }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePatchUser(@PathVariable long id, @RequestBody Map<String, Object> updates) {

        User user = userService.getUserById(id);
        // Modifico le proprietà richieste dal client
        updates.forEach((key, value) -> {
            // Cerco nella classe User una proprietà che ha lo stesso nome della chiave inviata dal client
            Field field = ReflectionUtils.findField(User.class, key);

            if(field != null) {
                // Rendo accessibile il campo per la modifica
                field.setAccessible(true);
                // Modifico il campo richiesto nell'oggetto User con il valore inviato dal client
                ReflectionUtils.setField(field, user, value);
            }
        });

        return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.removeUser(userService.getUserById(id));
        return new ResponseEntity<>("User deleted!", HttpStatus.OK);
    }

}
