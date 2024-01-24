package edu.miu.assignment.repo;

import edu.miu.assignment.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepo extends JpaRepository<Logger,Long> {

    interface AuthService {

    }
}
