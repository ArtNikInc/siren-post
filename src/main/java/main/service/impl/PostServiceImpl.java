package main.service.impl;

import lombok.RequiredArgsConstructor;
import main.dao.entity.Post;
import main.dao.repository.PostRepository;
import main.dto.PostDto;
import main.exception.EntityNotFoundException;
import main.service.PostService;
import main.service.mapper.PostMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;
    private final PostMapper mapper;

    @Override
    public PostDto save(PostDto postDto) {
        Post post = Post.builder()
                .text(postDto.getText())
                .title(postDto.getTitle())
                .build();
        return mapper.toDto(repository.save(post));
    }

    @Override
    public PostDto getById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Post.class, id)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PostDto update(Long id, PostDto postDto) {
        Post post = Post.builder()
                .id(id)
                .title(postDto.getTitle())
                .text(postDto.getText())
                .build();
        return mapper.toDto(repository.save(post));
    }

}
