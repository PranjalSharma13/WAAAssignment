package edu.miu.assignment.repo;

import edu.miu.assignment.entity.Post;

import java.util.List;

public interface PostRepo {
    public List<Post> findAll();
    public Post findPostById(long id);
    public void addPost(Post post);
}
