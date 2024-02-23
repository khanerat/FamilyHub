package fr.programme.familyhub; 

import java.util.ArrayList ; 



class MessageStore {
    // Attribut pour stocker 
    private ArrayList<Message> messages;

    // Constructeur de classe MessageStore
    public MessageStore() {
        messages = new ArrayList<>(); // Initialise une liste 
    }

    // Méthode pour ajouter un message à la liste
    public void addMessage(Message message) {
        messages.add(message); // Ajoute le message à la liste
    }

    // Méthode pour afficher les messages pour un utilisateur donné
    public void displayMessages(String user) {
        System.out.println("Messages for " + user + ":"); // Affiche un en-tête pour les messages de l'utilisateur spécifié
        for (Message message : messages) { // Parcourt les messages dans la liste
            if (message.getReceiver().equals(user)) { // Vérifie si le destinataire correspond à l'utilisateur spécifié
                System.out.println(message); // Affiche le message
                System.out.println(); // Affiche une ligne vide
            }
        }
    }
}