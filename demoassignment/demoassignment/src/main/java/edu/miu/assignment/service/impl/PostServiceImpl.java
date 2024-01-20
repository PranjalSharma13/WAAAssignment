package edu.miu.assignment.service.impl;

import edu.miu.assignment.entity.Post;
import edu.miu.assignment.entity.dto.response.PostDto;
import edu.miu.assignment.helper.ListMapper;
import edu.miu.assignment.repo.PostRepo;
import edu.miu.assignment.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepo postRepo;
    @Autowired
     ModelMapper modelMapper;
    @Autowired
    ListMapper listMapper;
    @Override
    public List<PostDto> findAll() {

        return (List<PostDto>) listMapper.mapList(postRepo.findAll(),new PostDto());
    }


    @Override
    public PostDto findPostById(long id){
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }
    @Override
    public void addPost(PostDto postDto) {
        Post postEntity = modelMapper.map(postDto, Post.class);
        postRepo.save(postEntity);
    }
}
