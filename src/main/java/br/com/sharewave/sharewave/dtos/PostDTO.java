package br.com.sharewave.sharewave.dtos;


public record PostDTO(String postContent, String postDate, Integer numberLikes, Integer numberComments, Long idUser) {
}
