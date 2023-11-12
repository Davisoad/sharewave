package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.CommentDTO;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "comments")
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

    public Comment() {
    }

    public Comment(String commentContent, LocalDate commentDate, Long idPost, Long idUser, Post post, User user) {
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.idPost = idPost;
        this.idUser = idUser;
        this.post = post;
        this.user = user;
    }

    public Comment(CommentDTO data) {
        this.commentContent = data.commentContent();
        this.commentDate = data.commentDate();
        this.idPost = data.idPost();
        this.idUser = data.idUser();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public LocalDate getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDate commentDate) {
        this.commentDate = commentDate;
    }

    public Long getIdPost() {
        return idPost;
    }

    public void setIdPost(Long idPost) {
        this.idPost = idPost;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
