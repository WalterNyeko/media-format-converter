package com.exceptions;

public class FileAlreadyExistsException extends RuntimeException{
    public FileAlreadyExistsException(String message) {
        super(message);
    }
}
