package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.ExceptionClass;
import edu.miu.assignment.repo.ExceptionRepo;
import edu.miu.assignment.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ExceptionServiceImpl implements ExceptionService {


    @Autowired
    ExceptionRepo exceptionRepo;
    @Override
    public void save(ExceptionClass exceptionClass) {
       exceptionRepo.save(exceptionClass);
    }
}
