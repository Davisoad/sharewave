package br.com.sharewave.sharewave.services;

import br.com.sharewave.sharewave.dtos.PostDTO;
import br.com.sharewave.sharewave.entities.model.Post;
import br.com.sharewave.sharewave.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(data.postDate(), inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        PostDTO newPostDTO = new PostDTO(
            data.postContent(),
                formattedDate,
            data.numberLikes(),
            data.numberComments(),
            data.idUser()
        );

        savePost(new Post(newPostDTO));
    }

    public void updatePost(Long id, PostDTO data) {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate localDate = LocalDate.parse(data.postDate(), inputFormatter);
        String formattedDate = localDate.format(outputFormatter);

        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found! "));

        post.setPostContent(data.postContent());
        post.setPostDate(formattedDate);
        post.setNumberLikes(data.numberLikes());
        post.setNumberComments(data.numberComments());
        post.setIdUser(data.idUser());

        savePost(post);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
