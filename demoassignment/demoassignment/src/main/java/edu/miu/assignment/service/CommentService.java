package edu.miu.assignment.service;

import edu.miu.assignment.entity.dto.request.CommentRequestDto;
import edu.miu.assignment.entity.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
//    public List<CommentResponseDto> findAll();
    void addNewComment(long user_id, long post_id, CommentRequestDto commentDto);

//    public CommentResponseDto findCommentsFromPostId(
//            long user_id,
//            long post_id,
//            long comment_id);
//    public  List<CommentResponseDto> findCommentsFromPostId(long user_id, long post_id);
//
//    void addNewComment(long userId, long postId, CommentRequestDto commentRequestDto);
}
