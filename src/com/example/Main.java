package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
	
	    public static void main(String[] args) {
	        TaskManager taskManager = new TaskManager();
	        Scanner scanner = new Scanner(System.in);
	        
	        String title, description, dueDate;
	       
	        // Example tasks
	        Task task1 = new Task("Implement feature", "Add search functionality", Priority.HIGH , Status.TODO, "2024-01-30");
	        Task task2 = new Task("Review code", "Check for code quality  ", Priority.MEDIUM, Status.IN_PROGRESS, "2024-02-05");

	        taskManager.addTask(task1);
	        taskManager.addTask(task2);

	        // Main loop
	        while (true) {
	            System.out.println("1. Add Task");
	            System.out.println("2. Display Tasks");
	            System.out.println("3. Search Tasks");
	            System.out.println("4. Update Task Status");
	            System.out.println("5. Update Task Due Date");
	            System.out.println("6. Update Task Priority");
	            System.out.println("7. Remove Task.");
	            System.out.println("8. Exit.");
	            
	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
                     		System.out.println("Enter Task Title : ");
	                		title = scanner.nextLine();
	                		System.out.println("Enter Task Description : ");
	                		description = scanner.nextLine();
	                		System.out.print("Enter Task priority (HIGH, MEDIUM, LOW): ");
	                        Priority newPriority = Priority.valueOf(scanner.nextLine());
	                		System.out.print("Enter Task status (TODO, IN_PROGRESS, DONE): ");
	                        Status newStatus = Status.valueOf(scanner.nextLine());
	                		System.out.println("Enter Task DueDate : ");
	                		dueDate = scanner.nextLine();
	                		
                		Task task = new Task(title, description, newPriority, newStatus, dueDate);	
	                		 taskManager.addTask(task);
                		
	                    break;
	                case 2:
	                    taskManager.displayTasks();
	                    break;
	                    
	                case 3:
	                    System.out.print("Enter Title for searching Task  : ");
	                    String keyword = scanner.nextLine();
	                    try {
	                        List<Task> searchResults = taskManager.searchTasks(keyword);
	                        System.out.println("Search Results:");
	                        System.out.println("+----------------------+---------------------------+------------+--------------+----------------+");
	 	     	           System.out.println("| Name                 | Description               | Priority   | Status       | Due Date       |");
	 	     	           System.out.println("+----------------------+---------------------------+------------+--------------+----------------+");

	                        searchResults.forEach(System.out::println);
	                        
	                        System.out.println("+----------------------+----------------------------+------------+--------------+---------------+");
		                    
	                    } catch (TaskNotFoundException e) {
	                        System.out.println(e.getMessage());
	                    }
	     	          
	                    break;
	                    
	                case 4:
	                    // Update Task Status
	                    System.out.print("Enter task title to update status: ");
	                    String titleToUpdate = scanner.nextLine();
	                    Task taskToUpdateStatus = findTaskByTitle(taskManager, titleToUpdate);
	                    if (taskToUpdateStatus != null) {
	                        System.out.print("Enter new status (TODO, IN_PROGRESS, DONE): ");
	                        Status newstatus = Status.valueOf(scanner.nextLine().toUpperCase());
	                        try {
								taskManager.updateTaskStatus(taskToUpdateStatus, newstatus);
							} catch (TaskNotFoundException e) {
								// TODO Auto-generated catch block
								 System.out.println(e.getMessage());
							}
	                        System.out.println("Task status updated successfully.");
	                        taskManager.displayTasks();
	                        
	                    } else {
	                        System.out.println("Task not found.");
	                    }
	                    break;
	                    

	                case 5:
	                    // Update Task Due Date
	                    System.out.print("Enter task title to update due date: ");
	                    String titleToUpdateDueDate = scanner.nextLine();
	                    Task taskToUpdateDueDate = findTaskByTitle(taskManager, titleToUpdateDueDate);
	                    if (taskToUpdateDueDate != null) {
	                        System.out.print("Enter new due date (YYYY-MM-DD): ");
	                        String newDueDate = scanner.nextLine();
	                        try {
								taskManager.updateTaskDueDate(taskToUpdateDueDate, newDueDate);
							} catch (TaskNotFoundException e) {
								// TODO Auto-generated catch block
								 System.out.println(e.getMessage());
							}
	                        System.out.println("Task due date updated successfully.");
	                        taskManager.displayTasks();
	                    } else {
	                        System.out.println("Task not found.");
	                    }
	                    break;

	                case 6:
	                    // Update Task Priority
	                    System.out.print("Enter task title to update priority: ");
	                    String titleToUpdatePriority = scanner.nextLine();
	                    Task taskToUpdatePriority = findTaskByTitle(taskManager, titleToUpdatePriority);
	                    if (taskToUpdatePriority != null) {
	                        System.out.print("Enter new priority (HIGH, MEDIUM, LOW): ");
	                        Priority newpriority = Priority.valueOf(scanner.nextLine().toUpperCase());
	                        try {
								taskManager.updateTaskPriority(taskToUpdatePriority, newpriority);
							} catch (TaskNotFoundException e) {
								// TODO Auto-generated catch block
								 System.out.println(e.getMessage());
							}
	                        System.out.println("Task priority updated successfully.");
	                        taskManager.displayTasks();
	                    } else {
	                        System.out.println("Task not found.");
	                    }
	                    break;
	                    
	                case 7:
	                	// Removing a task
	                	System.out.print("Enter Title for remove Task  : ");
	                    title = scanner.nextLine();
					try {
						taskManager.removeTask(title);
					} catch (TaskNotFoundException e) {
						// TODO Auto-generated catch block
						System.out.println(e.getMessage());
					}
	                    break;

	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }
	        }
	    }
	    
	    private static Task findTaskByTitle(TaskManager taskManager, String title) {
	        for (Task task : taskManager.getTasks()) {
	            if (task.getTitle().equalsIgnoreCase(title)) {
	                return task;
	            }
	        }
	        return null;
	   }
}

