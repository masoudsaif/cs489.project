package com.cs489.taskmanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs489.taskmanagement.model.*;
import com.cs489.taskmanagement.repositories.*;

import java.util.Date;

@Service
public class DataService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SubTaskRepository subTaskRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private DependencyRepository dependencyRepository;

    public void insertData() {
        // Create a user
        User user = new User("John Doe", "john.doe@example.com", "Developer");
        user = userRepository.save(user);

        // Create a project
        Project project = new Project("Project A", "Description of Project A", new Date(), new Date());
        project = projectRepository.save(project);

        // Create a task and associate it with the project
        Task task = new Task("Task 1", "Description of Task 1", "High", "To do");
        task.setProject(project);
        task = taskRepository.save(task);

        // Create a subtask and associate it with the task
        SubTask subtask = new SubTask("Subtask 1", "Description of Subtask 1", "Medium", "To do", task);
        subtask = subTaskRepository.save(subtask);

        // Create an assignment and associate it with the user and the task
        Assignment assignment = new Assignment(user, task, new Date(), new Date());
        assignment = assignmentRepository.save(assignment);

        // Create a comment and associate it with the user and the task
        Comment comment = new Comment(user, task, "This is a comment", new Date());
        comment = commentRepository.save(comment);

        // Create a dependency between two tasks
        Task task2 = new Task("Task 2", "Description of Task 2", "Medium", "To do");
        task2.setProject(project);
        task2 = taskRepository.save(task2);

        Dependency dependency = new Dependency(task, task2, "finish-to-start");
        dependency = dependencyRepository.save(dependency);

        System.out.println("Data insertion complete.");
    }
}
