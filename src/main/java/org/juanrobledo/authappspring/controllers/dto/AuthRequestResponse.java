package org.juanrobledo.authappspring.controllers.dto;

public record AuthRequestResponse(String username, String password, String token) {
}
