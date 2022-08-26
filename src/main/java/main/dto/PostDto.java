package main.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class PostDto {

    private Long id;
    private String title;
    private String text;
}
