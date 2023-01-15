package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Builder
@AllArgsConstructor
@Getter
public class CommentDto {

    @Nullable
    @Setter
    private Long id;

    private String text;

    private Long postId;

    @Nullable
    private Long parentId;
}
