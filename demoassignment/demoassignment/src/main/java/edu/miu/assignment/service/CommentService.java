package edu.miu.assignment.service;

import edu.miu.assignment.entity.dto.response.CommentResponseDto;

import java.util.List;

public interface CommentService {
    public List<CommentResponseDto> findAll();
}
