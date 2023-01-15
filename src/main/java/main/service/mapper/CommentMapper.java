package main.service.mapper;

import main.dao.entity.Comment;
import main.dto.CommentDto;
import org.mapstruct.Mapper;

@Mapper
public interface CommentMapper {

    CommentDto toDto(Comment comment);

    Comment fromDto(CommentDto dto);
}
