package main.service;

import main.dto.PostDto;

import java.util.List;

public interface PostService {

    PostDto save(PostDto postDto);

    PostDto getById(Long id);

    List<PostDto> getAll();

    void delete(Long id);

    PostDto update(Long id, PostDto postDto);

}
