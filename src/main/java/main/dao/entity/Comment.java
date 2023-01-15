package main.dao.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    // Из-за хибера не могу сделать через Comment, только через id
    private Long parentId;
}
