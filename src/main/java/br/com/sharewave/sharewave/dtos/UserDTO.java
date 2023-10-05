package br.com.sharewave.sharewave.dtos;

import java.time.LocalDate;

public record UserDTO(String name, String password, String address, String phone, String email, LocalDate date) {
}
