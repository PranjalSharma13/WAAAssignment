package edu.miu.assignment.repo;

import edu.miu.assignment.entity.Comment;
import edu.miu.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
}
