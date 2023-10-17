package br.com.sharewave.sharewave.entities.model;

import jakarta.persistence.*;

@Entity
@Table(name = "followers")
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "follower_id")
    private Long follower_id;
    @Column(name = "followed_user_id")
    private Long followed_user_id;
    @ManyToOne
    @JoinColumn(name = "follower_id", insertable = false, updatable = false)
    private User follower;
    @ManyToOne
    @JoinColumn(name = "followed_user_id", insertable = false, updatable = false)
    private User followedUser;

    public Follower() {
    }

    public Follower(Long follower_id, Long followed_user_id, User follower, User followedUser) {
        this.follower_id = follower_id;
        this.followed_user_id = followed_user_id;
        this.follower = follower;
        this.followedUser = followedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollower_id() {
        return follower_id;
    }

    public void setFollower_id(Long follower_id) {
        this.follower_id = follower_id;
    }

    public Long getFollowed_user_id() {
        return followed_user_id;
    }

    public void setFollowed_user_id(Long followed_user_id) {
        this.followed_user_id = followed_user_id;
    }

    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }

    public User getFollowedUser() {
        return followedUser;
    }

    public void setFollowedUser(User followedUser) {
        this.followedUser = followedUser;
    }
}
