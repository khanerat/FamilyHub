package fr.programme.familyhub;

import java.util.Scanner;



public class MessagingApp {
    public static void main(String[] args) {
        MessageStore messageStore = new MessageStore(); // Crée une instance de MessageStore pour stocker les messages
        Scanner scanner = new Scanner(System.in); // Initialise pour lire l'entrée utilisateur

        System.out.println("Bienvenue dans la messagerie!"); // Affiche un message de bienvenue

        while (true) { // Boucle infinie pour maintenir l'application en cours d'exécution jusqu'à ce que l'utilisateur choisisse de sortir
            System.out.println("1. Envoie Message"); // Affiche l'option d'envoyer un message
            System.out.println("2. Message Reçu"); // Affiche l'option de consulter les messages reçus
            System.out.println("3. Sortir"); // Affiche l'option pour quitter l'application
            System.out.print("Entre votre choix : "); // Demande à l'utilisateur de saisir son choix
            int choice = scanner.nextInt(); // Lit le choix de l'utilisateur
            scanner.nextLine(); // Consume la nouvelle ligne restante 

            switch (choice) { //  exécute différentes actions en fonction du choix de l'utilisateur
                case 1: //  l'utilisateur choisit d'envoyer un message
                    System.out.print("Entrez le nom d'utilisateur de l'expéditeur: "); // Demande le nom d'utilisateur
                    String sender = scanner.nextLine(); // Lit le nom l'expéditeur
                    System.out.print("Entrez le nom d'utilisateur du destinataire: "); // Demande le nom du destinataire
                    String receiver = scanner.nextLine(); // Lit le nom du destinataire
                    System.out.print("Saisir le contenu du message: "); // Demande le message
                    String content = scanner.nextLine(); // Lit le message
                    Message message = new Message(sender, receiver, content); // Crée un nouvel objet Message
                    messageStore.addMessage(message); // Ajoute le message à la liste
                    System.out.println("message envoyé avec succès!"); // Affiche un message de succès
                    break; 
                case 2: // Cas où l'utilisateur choisit de voir les messages 
                    System.out.print("Entrez le nom d'utilisateur pour afficher les messages: "); // Demande le nom pour afficher les messages
                    String user = scanner.nextLine(); // Lit le nom 
                    messageStore.displayMessages(user); // Affiche les messages reçus
                    break; // Sort de la structure 
                case 3: // Cas où l'utilisateur choisit de quitter l'application
                    System.out.println("Sortie..."); // Affiche sortie
                    scanner.close(); // Ferme le Scanner pour éviter les fuites de ressources
                    System.exit(0); // Termine l'application avec un code de sortie
                default: // Cas par défaut si le choix de l'utilisateur n'est pas valide
                    System.out.println("Choix invalide. Veuillez réessayer."); // Affiche un message d'erreur
            }
        }
    }
}
