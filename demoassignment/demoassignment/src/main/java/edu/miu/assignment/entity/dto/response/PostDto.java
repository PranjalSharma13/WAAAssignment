package edu.miu.assignment.entity.dto.response;

import edu.miu.assignment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PostDto {

    private String title;
    private List<Comment> comment;

}
