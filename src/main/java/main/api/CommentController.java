package main.api;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import main.dto.CommentDto;
import main.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService service;

    @PostMapping("/")
    public void addCommentToPost(CommentDto dto) {
        dto.setId(null);
        service.addComment(dto);
    }

    @GetMapping("/{id}")
    public List<CommentDto> getChildComments(@NonNull @PathVariable Long id) {
        return service.getChildComments(id);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        service.deleteComment(id);
    }

}
