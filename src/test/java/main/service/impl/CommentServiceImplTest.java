package main.service.impl;

import main.dao.entity.Comment;
import main.dao.entity.Post;
import main.dao.repository.CommentRepository;
import main.dto.CommentDto;
import main.service.CommentService;
import main.service.mapper.CommentMapper;
import main.service.mapper.PostMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class CommentServiceImplTest {

    private static final CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);
    private static final Comment COMMENT = Comment.builder()
            .id(1L)
            .text("text")
            .parentId(null)
            .build();
    private static Comment COMMENT_CHILD = Comment.builder()
            .id(2L)
            .text("text_child")
            .parentId(COMMENT.getId())
            .build();

    @Mock
    private CommentRepository commentRepository;

    private CommentService commentService;

    @Captor
    private ArgumentCaptor<Comment> commentArgumentCaptor;

    @BeforeEach
    void setUp() {
        commentService = new CommentServiceImpl(commentRepository, MAPPER);
    }

    @Test
    void getChildComments() {
        when(commentRepository.findByParentId(COMMENT.getId())).thenReturn(List.of(COMMENT_CHILD));
        List<CommentDto> children = commentService.getChildComments(COMMENT.getId());
        assertEquals(1, children.size());
        assertEquals(COMMENT_CHILD.getId(), children.get(0).getId());
    }

    @Test
    void addComment() {
        when(commentRepository.save(any())).thenReturn(COMMENT);
        commentService.addComment(MAPPER.toDto(COMMENT));
        verify(commentRepository).save(commentArgumentCaptor.capture());
        assertEquals(COMMENT, commentArgumentCaptor.getValue());
    }

    @Test
    void deleteComment() {
        commentService.deleteComment(COMMENT.getId());
        verify(commentRepository).deleteById(COMMENT.getId());
    }
}