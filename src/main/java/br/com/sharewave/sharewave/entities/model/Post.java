package br.com.sharewave.sharewave.entities.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String postContent;
    private LocalDate postDate;
    private Integer numberLikes;
    private Integer numberComments;
    private Long idUser;
    @ManyToOne
    @JoinColumn(name = "idUser", insertable = false, updatable = false)
    private User user;

    public Post() {
    }

    public Post(String postContent, LocalDate postDate, Integer numberLikes, Integer numberComments, Long idUser, User user) {
        this.postContent = postContent;
        this.postDate = postDate;
        this.numberLikes = numberLikes;
        this.numberComments = numberComments;
        this.idUser = idUser;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public Integer getNumberLikes() {
        return numberLikes;
    }

    public void setNumberLikes(Integer numberLikes) {
        this.numberLikes = numberLikes;
    }

    public Integer getNumberComments() {
        return numberComments;
    }

    public void setNumberComments(Integer numberComments) {
        this.numberComments = numberComments;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
