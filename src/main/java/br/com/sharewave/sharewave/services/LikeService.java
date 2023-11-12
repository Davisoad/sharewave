package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.LikeDTO;
import br.com.sharewave.sharewave.entities.model.Like;
import br.com.sharewave.sharewave.repositories.LikeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;

    public LikeService(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    public Iterable<Like> getAllLike() {
        return likeRepository.findAll();
    }

    public Optional<Like> findLikeById(Long id) {
        return likeRepository.findById(id);
    }

    public void saveLike(Like like) {
        likeRepository.save(like);
    }

    public void createLike(LikeDTO data) {
        saveLike(new Like(data));
    }

    public void updateLike(Long id, LikeDTO data) {
        Like like = likeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Like not found! "));

        like.setIdPost(data.idPost());
        like.setIdUser(data.idUser());

        saveLike(like);
    }

    public void deleteLike(Long id) {
        likeRepository.deleteById(id);
    }
}
