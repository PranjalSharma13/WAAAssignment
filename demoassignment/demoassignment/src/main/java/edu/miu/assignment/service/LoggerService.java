package edu.miu.assignment.service;

import edu.miu.assignment.entity.Logger;

import java.util.List;

public interface LoggerService {
    public List<Logger> findAll() ;
    public void save(Logger logger);
}
