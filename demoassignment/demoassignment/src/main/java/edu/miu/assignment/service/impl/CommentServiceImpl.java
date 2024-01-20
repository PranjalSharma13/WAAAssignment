package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.Comment;
import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.User;
import edu.miu.assignment.entity.dto.request.CommentRequestDto;
import edu.miu.assignment.entity.dto.response.CommentResponseDto;
import edu.miu.assignment.helper.ListMapper;
import edu.miu.assignment.repo.CommentRepo;
import edu.miu.assignment.repo.PostRepo;
import edu.miu.assignment.repo.UserRepo;
import edu.miu.assignment.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CommentServiceImpl implements CommentService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PostRepo postRepo;

    @Autowired
    ListMapper listMapper;
//    @Override
//    public List<CommentResponseDto> findAll() {
//        List<Comment> allComments = commentRepo.findAll();
//        return listMapper.mapList(allComments, CommentResponseDto.class);
//    }

    @Override
    public void addNewComment(long user_id, long post_id, CommentRequestDto commentDto) {
        Comment comment = new Comment();
        comment.setName(commentDto.getName());

        Optional<Post> optionalPost = postRepo.findById(post_id);
        if (optionalPost.isPresent()) {
            comment.setPost(optionalPost.get());
            commentRepo.save(comment);
        }
        }


//    @Override
//    public List<CommentResponseDto> findCommentsFromPostId(long user_id, long post_id) {
//        return (List<CommentResponseDto>) listMapper.mapList(commentRepo.findAllByPost(postRepo.findPostById(post_id)), new CommentResponseDto());
//    }
//
//    @Override
//    public CommentResponseDto findCommentsFromPostId(long post_id,
//            long comment_id)  {
//
//        User user = userRepo.findById(Math.toIntExact(user_id)).orElse(null);
//        if(user!=null){
//            Post post = user.getPosts().stream().filter(x->x.getId() == post_id).findFirst().orElse(null);
//            if(post!= null){
//                Comment comment = post.getComment().stream().filter(x->x.getId() == comment_id).findFirst().orElse(null);
//                if(comment != null){
//                    return modelMapper.map(comment, CommentResponseDto.class);
//                }
//            }
//        }
//return  null;
//    }
}
