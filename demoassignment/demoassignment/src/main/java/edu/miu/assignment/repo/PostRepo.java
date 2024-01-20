package edu.miu.assignment.repo;

import edu.miu.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo  extends JpaRepository <Post, Long>{
//    public List<Post> findAll();
//    public Post findPostById(long id);
//    public void addPost(Post post);
}
