package main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class PostDto {

    private Long id;
    private String title;
    private String text;
}
