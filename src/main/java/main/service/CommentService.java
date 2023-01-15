package main.service;

import main.dto.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> getChildComments(Long id);

    void addComment(CommentDto commentDto);

    void deleteComment(Long id);
}
