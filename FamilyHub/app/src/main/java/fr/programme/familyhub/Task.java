package fr.programme.familyhub;

//Classe représentant une tâche
public class Task {
    private String name;
    private boolean completed;

    // Constructeur pour initialiser une tâche avec un nom
    public Task(String name) {
        this.name = name;
        this.completed = false; // Par défaut, la tâche n'est pas terminée
    }

    // Getter pour obtenir le nom de la tâche
    public String getName() {
        return name;
    }

    // Getter pour vérifier si la tâche est terminée
    public boolean isCompleted() {
        return completed;
    }

    // Setter pour définir si la tâche est terminée ou non
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}