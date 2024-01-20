package edu.miu.assignment.controller;

import edu.miu.assignment.entity.dto.request.UserRequestDto;
import edu.miu.assignment.entity.dto.response.PostDto;
import edu.miu.assignment.entity.dto.response.UserResponseDto;
import edu.miu.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public List<UserResponseDto> findAll(@RequestParam(required = false, defaultValue = "false") boolean havingMoreThan1Pos,
                                         @RequestParam(required = false, defaultValue = "0") int numberOfPosts,
                                         @RequestParam(required = false, defaultValue = "") String title)
    {
        return userService.findAll(havingMoreThan1Pos,numberOfPosts,title);
    }
    @PostMapping
    public void createUser(@RequestBody UserRequestDto userDto){
        userService.addNewUser(userDto);
    }
    @GetMapping ("/{id}")
    public UserResponseDto getUserFromId(@PathVariable long id){
        return userService.getUserFromId(id);
    }

    @GetMapping ("/{id}/posts")
    public List<PostDto> getPostFromUserId(@PathVariable long id){
        return userService.getPostFromUserId(id);
    }

    @DeleteMapping ("/{id}")
    public void deleteUser(@PathVariable long id)
    {
        userService.deleteUser(id);
    }
}
