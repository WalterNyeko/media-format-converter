package com.exceptions;

public class UnsupportedFileFormatException extends RuntimeException{
    public UnsupportedFileFormatException(String message) {
        super(message);
    }
}
