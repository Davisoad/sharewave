package br.com.sharewave.sharewave.entities.model;

import br.com.sharewave.sharewave.dtos.FollowerDTO;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "followers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    public Follower(FollowerDTO data) {
        this.follower_id = data.follower_id();
        this.followed_user_id = data.followed_user_id();
    }
}
