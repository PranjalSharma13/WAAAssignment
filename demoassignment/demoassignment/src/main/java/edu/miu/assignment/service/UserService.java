package edu.miu.assignment.service;

import edu.miu.assignment.entity.dto.request.UserRequestDto;
import edu.miu.assignment.entity.dto.response.PostDto;
import edu.miu.assignment.entity.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    public List<UserResponseDto> findAll(boolean havingMoreThan1Pos , int numberOfPosts, String title);

    public List<PostDto> getPostFromUserId(long userId);
    public UserResponseDto getUserFromId(long userId);
    void addNewUser(UserRequestDto user);
    public void deleteUser(long userId);

}
