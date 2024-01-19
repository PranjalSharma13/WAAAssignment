package edu.miu.assignment.repo;

import edu.miu.assignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
