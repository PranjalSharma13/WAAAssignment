package edu.miu.assignment.controller;

import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.dto.response.PostDto;
import edu.miu.assignment.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll()
    {
        return postService.findAll();
    }
   @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable("id") long id)
    {
        return postService.findPostById(id);
    }
    @PostMapping
    public void addPost(@RequestBody PostDto pdto) {
        postService.addPost(pdto);
    }
}
