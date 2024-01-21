package edu.miu.assignment.service.impl;

import edu.miu.assignment.aop.annotation.ExecutionTime;
import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.User;
import edu.miu.assignment.entity.dto.request.UserRequestDto;
import edu.miu.assignment.entity.dto.response.PostDto;
import edu.miu.assignment.entity.dto.response.UserResponseDto;
import edu.miu.assignment.helper.ListMapper;
import edu.miu.assignment.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import edu.miu.assignment.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
@Autowired
    ListMapper listMapper;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserResponseDto> findAll(boolean havingMoreThan1Pos , int numberOfPosts, String title)
    {
        List<User> users;

        if (havingMoreThan1Pos) {
            users = userRepo.findUsersWithMoreThanNPosts(numberOfPosts);
        } else if(!title.equals("")){
           users=userRepo.findAllByPostsTitle(title);
        }
        else {
            users = userRepo.findAll();
        }
        List<UserResponseDto> userResponseDtos = users.stream()
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .collect(Collectors.toList());
        return userResponseDtos;
    }
    @Override
    public List<PostDto> getPostFromUserId(long userId)
    {
        Optional<User> optionalUser = userRepo.findById(Math.toIntExact(userId));

        List<Post> posts = optionalUser
                .map(User::getPosts)
                .orElseThrow(() -> new EntityNotFoundException("User with ID " + userId + " not found or has no posts"));

// The rest of your code to process the 'posts' list

        return listMapper.mapList(posts, new PostDto());
    }

    @Override
    @ExecutionTime
    public UserResponseDto getUserFromId(long id) {
        return userRepo.findById(Math.toIntExact(id))
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .orElse(null);
    }


    @Override
public void addNewUser(UserRequestDto userRequestDto)
    {
        User a = modelMapper.map(userRequestDto, User.class);
        List<Post> postList = (List<Post>)listMapper.mapList(userRequestDto.getPosts(), new Post());
        a.setPosts(postList);
        userRepo.save(a);

    }
    @Override
    public void deleteUser(long userId)
    {
        userRepo.deleteById(Math.toIntExact(userId));
    }

}
