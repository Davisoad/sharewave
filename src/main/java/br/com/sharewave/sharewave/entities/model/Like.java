package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.LikeDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "idPost")
    private Long idPost;
    @Column(name = "idUser")
    private Long idUser;
    @ManyToOne
    @JoinColumn(name = "idPost", insertable = false, updatable = false)
    private Post post;
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    public Like(LikeDTO data) {
        this.idPost = data.idPost();
        this.idUser = data.idUser();
    }
}