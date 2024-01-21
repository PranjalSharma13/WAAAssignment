package edu.miu.assignment.repo;

import edu.miu.assignment.entity.ExceptionClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExceptionRepo extends JpaRepository<ExceptionClass,Long> {
}
