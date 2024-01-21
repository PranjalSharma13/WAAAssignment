package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.Logger;
import edu.miu.assignment.repo.LoggerRepo;
import edu.miu.assignment.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepo loggerRepo;
    @Override
    public List<Logger> findAll(){
      return  loggerRepo.findAll();
    }
    @Override
    public  void save(Logger logger)
    {
        loggerRepo.save(logger);
    }
}
