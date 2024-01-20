package edu.miu.assignment.controller;

import edu.miu.assignment.entity.dto.request.CommentRequestDto;
import edu.miu.assignment.entity.dto.request.UserRequestDto;
import edu.miu.assignment.service.CommentService;
import edu.miu.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users/")
public class CommentController {
    @Autowired
    CommentService commentService;
//    5-	Make it possible to add a comment that will be associated with its post.
@PostMapping("{userId}/posts/{postId}")
public void addComment(  @PathVariable long userId,
                         @PathVariable long postId,
                         @RequestBody CommentRequestDto commentRequestDto){
    commentService.addNewComment(userId,postId,commentRequestDto);
}

}
