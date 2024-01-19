package edu.miu.assignment.entity.dto.request;

import edu.miu.assignment.entity.dto.response.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    String name;
    List<PostDto> posts;
}