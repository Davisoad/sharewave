package br.com.sharewave.sharewave.dtos;

import java.time.LocalDate;

public record CommentDTO(String commentContent, LocalDate commentDate, Long idPost, Long idUser) {
}
