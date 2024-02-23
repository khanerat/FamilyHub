package fr.programme.familyhub;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskList {
    private ArrayList<Task> tasks; // Liste des tâches
    private HashMap<String, ArrayList<Task>> assignedTasks; // Tâches attribuées à chaque personne

    // Constructeur pour initialiser la liste des tâches et les tâches attribuées
    public TaskList() {
        this.tasks = new ArrayList<>();
        this.assignedTasks = new HashMap<>();
    }

    // Méthode pour ajouter une nouvelle tâche à la liste
    public void addTask(String taskName) {
        tasks.add(new Task(taskName));
    }

    // Méthode pour marquer une tâche spécifique comme terminée
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
        } else {
            System.out.println("Invalid task index");
        }
    }

    // Méthode pour attribuer une tâche à une personne spécifique
    public void assignTaskToPerson(String person, int taskIndex) {
        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            Task task = tasks.get(taskIndex);
            ArrayList<Task> personTasks = assignedTasks.getOrDefault(person, new ArrayList<>());
            personTasks.add(task);
            assignedTasks.put(person, personTasks);
            System.out.println("Task assigned to " + person);
        } else {
            System.out.println("Invalid task index");
        }
    }

    // Méthode pour afficher les tâches avec leur état 
    public void displayTasks() {
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println((i + 1) + ". " + task.getName() + " - Completed: " + task.isCompleted());
        }
    }

    // Méthode pour afficher les tâches attribuées à une personne
    public void displayAssignedTasks() {
        System.out.println("Assigned Tasks:");
        for (String person : assignedTasks.keySet()) {
            System.out.println(person + ":");
            ArrayList<Task> personTasks = assignedTasks.get(person);
            for (Task task : personTasks) {
                System.out.println("- " + task.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Exemple de code de test
        TaskList taskList = new TaskList();
        
        // Ajout des tâches à la liste
        taskList.addTask("Faire les courses");
        taskList.addTask("Nettoyer la maison");

        // Affichage de toutes les tâches
        taskList.displayTasks();
    }
}
