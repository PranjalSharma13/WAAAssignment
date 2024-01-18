package edu.miu.assignment.service;

import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.dto.response.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findPostById(long id);
    void addPost(PostDto post);
}