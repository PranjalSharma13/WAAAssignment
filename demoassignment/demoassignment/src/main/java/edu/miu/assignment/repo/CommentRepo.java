package edu.miu.assignment.repo;

import edu.miu.assignment.entity.Comment;
import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
    List<Post> findAllByPost(Post post);
}
