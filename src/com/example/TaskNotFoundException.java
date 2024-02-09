package com.example;

class TaskNotFoundException extends Exception {
	
    public TaskNotFoundException(String message) {
        super(message);
    }
}