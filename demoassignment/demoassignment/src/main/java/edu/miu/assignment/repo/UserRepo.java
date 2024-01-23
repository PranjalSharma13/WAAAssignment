package edu.miu.assignment.repo;

import edu.miu.assignment.entity.User;
import edu.miu.assignment.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > :postCount")
    List<User> findUsersWithMoreThanNPosts( @Param("postCount") int postCount);

    @Query("SELECT  u FROM User u JOIN Post p ON u.id = p.id WHERE p.title= :title")
    List<User> findAllByPostsTitle(@Param("title") String title);
    User findByEmail(String email);


}
