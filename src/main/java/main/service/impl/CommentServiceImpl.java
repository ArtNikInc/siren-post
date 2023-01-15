package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.dao.repository.CommentRepository;
import main.dto.CommentDto;
import main.service.CommentService;
import main.service.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper mapper;

    @Override
    public List<CommentDto> getChildComments(Long id) {
        return commentRepository.findByParentId(id).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void addComment(CommentDto commentDto) {
        commentRepository.save(mapper.fromDto(commentDto));
    }

    @Override
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
