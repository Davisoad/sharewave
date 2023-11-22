package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String commentContent;
    private LocalDate commentDate;
    private Long idPost;
    private Long idUser;
    @ManyToOne
    @JoinColumn(name = "idPost", insertable = false, updatable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    public Comment(CommentDTO data) {
        this.commentContent = data.commentContent();
        this.commentDate = data.commentDate();
        this.idPost = data.idPost();
        this.idUser = data.idUser();
    }
}
