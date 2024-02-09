package com.example;

public class Task {
	    private String title;
	    private String description;
	    private Priority priority;
	    private Status status;
	    private String dueDate;

	    public Task(String title, String description, Priority priority, Status status, String dueDate) {
	        this.title = title;
	        this.description = description;
	        this.priority = priority;
	        this.status = status;
	        this.dueDate = dueDate;
	    } 
	    
	    public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public Priority getPriority() {
			return priority;
		}

		public Status getStatus() {
			return status;
		}

		public String getDueDate() {
			return dueDate;
		}

		public void setPriority(Priority priority) {
			this.priority = priority;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public void setDueDate(String dueDate) {
			this.dueDate = dueDate;
		}

	@Override
		public String toString() {
	    return  String.format("| %-20s | %-22s | %-10s | %-12s | %-13s |", 
	            title, description, priority, status, dueDate);
		}
	}

	enum Priority {
	    HIGH, MEDIUM, LOW
	}

	enum Status {
	    TODO, IN_PROGRESS, DONE
	}

