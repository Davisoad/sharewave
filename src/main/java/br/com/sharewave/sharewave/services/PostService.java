package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.PostDTO;
import br.com.sharewave.sharewave.entities.model.Post;
import br.com.sharewave.sharewave.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Iterable<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public void createPost(PostDTO data) {
        savePost(new Post(data));
    }

    public void updatePost(Long id, PostDTO data) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found! "));

        post.setPostContent(data.postContent());
        post.setPostDate(data.postDate());
        post.setNumberLikes(data.numberLikes());
        post.setNumberComments(data.numberComments());
        post.setIdUser(data.idUser());

        savePost(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
