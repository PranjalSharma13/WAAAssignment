package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.dto.response.CommentResponseDto;
import edu.miu.assignment.entity.dto.response.UserResponseDto;
import edu.miu.assignment.helper.ListMapper;
import edu.miu.assignment.repo.CommentRepo;
import edu.miu.assignment.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepo commentRepo;
    @Autowired
    ListMapper listMapper;
    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<CommentResponseDto> findAll() {
        return (List<CommentResponseDto>)listMapper.mapList(commentRepo.findAll(), new CommentResponseDto());
    }
}
