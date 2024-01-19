package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.Comment;
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

@Service
public class UserServiceImpl implements UserService {
@Autowired
    ListMapper listMapper;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserResponseDto> findAll()
    {
        return (List<UserResponseDto>) listMapper.mapList(userRepo.findAll(), new UserResponseDto());
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
    public UserResponseDto getUserFromId(long id) {
        return userRepo.findById(Math.toIntExact(id))
                .map(user -> modelMapper.map(user, UserResponseDto.class))
                .orElse(null);
    }


    @Override
public void addNewUser(UserRequestDto userRequestDto)
    {
        User user = modelMapper.map(userRequestDto, User.class);

        // Map comments for each post
        for (Post post : user.getPosts()) {
            if (post.getComments() != null) {
                for (Comment comment : post.getComments()) {
                    // Map CommentDto to Comment
                    Comment mappedComment = modelMapper.map(comment, Comment.class);
                    // Set the mapped comment back to the post
                    comment = mappedComment;
                }
            }
        }

        // Save the User entity
        userRepo.save(user);

    }

}
