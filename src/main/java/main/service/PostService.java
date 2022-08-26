package main.service;

import main.dto.PostDto;

public interface PostService {

    PostDto save(PostDto postDto);

    PostDto getById(Long id);

    void delete(Long id);

    PostDto update(Long id, PostDto postDto);

}
