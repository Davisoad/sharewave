package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postContent;
    private String postDate;
    private Integer numberLikes;
    private Integer numberComments;
    private Long idUser;
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;


    public Post(PostDTO data) {
        this.postContent = data.postContent();
        this.postDate = data.postDate();
        this.numberLikes = data.numberLikes();
        this.numberComments = data.numberComments();
        this.idUser = data.idUser();
    }
}
