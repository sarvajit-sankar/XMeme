package com.xmeme.starter.exceptions;

public class MemeNotFoundException extends RuntimeException {
    public MemeNotFoundException(String id) {
        super("Meme not found with id: " + id);
    }
}