package main.dto;

import lombok.*;
import org.springframework.lang.Nullable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PostDto {

    @Nullable
    private Long id;

    private String title;
    private String text;
}
