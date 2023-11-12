package br.com.sharewave.sharewave.dtos;

import java.time.LocalDate;

public record PostDTO(String postContent, LocalDate postDate, Integer numberLikes, Integer numberComments, Long idUser) {
}
