package main.service.mapper;

import main.dao.entity.Post;
import main.dto.PostDto;

public interface PostMapper {

    PostDto toDto(Post post);
}
