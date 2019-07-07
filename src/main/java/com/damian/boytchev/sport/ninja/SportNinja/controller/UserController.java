package com.damian.boytchev.sport.ninja.SportNinja.controller;

import com.damian.boytchev.sport.ninja.SportNinja.dto.UserDto;
import com.damian.boytchev.sport.ninja.SportNinja.model.User;
import com.damian.boytchev.sport.ninja.SportNinja.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity<List<UserDto>> getAllUsers(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer count){
        if(page == null){
            page = 0;
        }
        if(count == null){
            count = 30;
        }
        List<User> users = userService.findAllUsers(PageRequest.of(page,count));
        List<UserDto> returned = users.stream().map(User::getUserDto).collect(Collectors.toList());
        return new ResponseEntity<>(returned, HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<UserDto> register(@RequestBody(required = false) UserDto userDto){
        User user = userService.create(new User(userDto));
        return new ResponseEntity<>(user.getUserDto(),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<UserDto> getUserById(@PathVariable UUID userId){
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user.getUserDto(),HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteUser(@PathVariable UUID userId){
        return new ResponseEntity<>(userService.deleteUserById(userId),HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public ResponseEntity<UserDto> updateUser(@PathVariable UUID userId,@RequestBody(required = false) UserDto userDto){
        User user = userService.getUserById(userId);
        user.setUserDto(userDto);
        userService.update(user);

        return new ResponseEntity<>(user.getUserDto(), HttpStatus.OK);
    }
}
