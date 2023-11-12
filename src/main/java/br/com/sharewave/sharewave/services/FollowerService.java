package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.FollowerDTO;
import br.com.sharewave.sharewave.entities.model.Follower;
import br.com.sharewave.sharewave.repositories.FollowerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FollowerService {

    private final FollowerRepository followerRepository;

    public FollowerService(FollowerRepository followerRepository) {
        this.followerRepository = followerRepository;
    }

    public Iterable<Follower> getAllFollower() {
        return followerRepository.findAll();
    }

    public Optional<Follower> findFollowerById(Long id) {
        return followerRepository.findById(id);
    }

    public void saveFollower(Follower follower) {
        followerRepository.save(follower);
    }

    public void createFollower(FollowerDTO data) {
        saveFollower(new Follower(data));
    }

    public void updateFollower(Long id, FollowerDTO data) {
        Follower follower = followerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Follower not found! "));

        follower.setFollower_id(data.follower_id());
        follower.setFollowed_user_id(data.followed_user_id());

        saveFollower(follower);
    }

    public void deleteFollower(Long id) {
        followerRepository.deleteById(id);
    }
}
