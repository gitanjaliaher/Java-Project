package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {

		  private List<Task> tasks;

		    public TaskManager() {
		        this.tasks = new ArrayList<>();
		    }

		    public void addTask(Task task) {
		        tasks.add(task);
		    }

		    public void displayTasks() {
		       // tasks.forEach(System.out::println);
		    	   if (tasks.isEmpty()) {
		               System.out.println("No tasks found.");
		               return;
		           }
		           
		           // Print table header
		           System.out.println("+----------------------+--------------------------+------------+--------------+---------------+");
		           System.out.println("| Name                 | Description              | Priority   | Status       | Due Date      |");
		           System.out.println("+----------------------+--------------------------+------------+--------------+---------------+");

		           // Print tasks
		           tasks.forEach(System.out::println);

		           // Print table footer
		           System.out.println("+----------------------+--------------------------+------------+--------------+---------------+");
		       

		    }

		    public List<Task> searchTasks(String keyword) throws TaskNotFoundException {
		        List<Task> result = tasks.stream()
		                .filter(task -> task.getTitle().contains(keyword) || 
		                                task.getDescription().contains(keyword) || 
		                                task.getTitle().equalsIgnoreCase(keyword))
		                .collect(Collectors.toList());

		        if (result.isEmpty()) {
		            throw new TaskNotFoundException("No tasks found for keyword '" + keyword + "'.");
		        }

		        return result;
		    }
		    
		    public void updateTaskStatus(Task task, Status newStatus) throws TaskNotFoundException {
		        boolean taskFound = tasks.stream().anyMatch(t -> t.equals(task));
		        if (!taskFound) {
		            throw new TaskNotFoundException("Task not found.");
		        }
		        task.setStatus(newStatus);
		    }


		    public void updateTaskDueDate(Task task, String newDueDate) throws TaskNotFoundException {
		        boolean taskFound = tasks.stream().anyMatch(t -> t.equals(task));
		        if (!taskFound) {
		            throw new TaskNotFoundException("Task not found.");
		        }
		        task.setDueDate(newDueDate);
		    }

		    public void updateTaskPriority(Task task, Priority newPriority) throws TaskNotFoundException {
		        boolean taskFound = tasks.stream().anyMatch(t -> t.equals(task));
		        if (!taskFound) {
		            throw new TaskNotFoundException("Task not found.");
		        }
		        task.setPriority(newPriority);
		    }
		    
		    public void removeTask(String title) throws TaskNotFoundException {
		        boolean removed = tasks.removeIf(task -> task.getTitle().equalsIgnoreCase(title));
		        if (!removed) {
		            throw new TaskNotFoundException("Task '" + title + "' not found.");
		        }
		        else {
		        	System.out.println("Task removed successfully!...");
		        }
		    }

			public List<Task> getTasks() {
				// TODO Auto-generated method stub
				return tasks;
			}

		}

