package org.juanrobledo.authappspring.controllers.dto;

public record AuthResponse(String username, String password, String token) {
}
