package main.api;

import lombok.RequiredArgsConstructor;
import main.dto.PostDto;
import main.service.PostService;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService service;

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping("/")
    public PostDto savePost(@RequestBody PostDto postDto) {
        return service.save(postDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        service.delete(id);
    }

}
