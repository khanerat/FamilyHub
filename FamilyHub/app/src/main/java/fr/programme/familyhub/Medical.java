package fr.programme.familyhub;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Medical {
    // stocke les rendez-vous médicaux
    private Map<String, String> appointments;

    public Medical() {
        appointments = new HashMap<>(); // Initialisation de la Map
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) { // Boucle tant que l'utilisateur ne choisit pas de quitter
            System.out.println("\n=== Gestion des rendez-vous médicaux ===");
            System.out.println("1. Prendre un rendez-vous");
            System.out.println("2. Afficher les rendez-vous");
            System.out.println("3. Quitter");
            System.out.print("Entrez votre choix : ");
            
            if (scanner.hasNextInt()) { // Vérification de l'entrée utilisateur
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume la nouvelle ligne
                
                switch (choice) {
                    case 1:
                        scheduleAppointment(scanner); // Prendre rendez-vous
                        break;
                    case 2:
                        displayAppointments(); // Afficher rendez-vous
                        break;
                    case 3:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez réessayer.");
                }
            } else {
                System.out.println("Veuillez entrer un nombre.");
                scanner.nextLine(); // Consume l'entrée incorrecte
            }
        }
        scanner.close();
    }

    private void scheduleAppointment(Scanner scanner) {
        System.out.print("Entrez le nom du patient : ");
        String patientName = scanner.nextLine();
        System.out.print("Entrez la date du rendez-vous : ");
        String appointmentDate = scanner.nextLine();

        appointments.put(appointmentDate, patientName); // Ajoute rendez-vous 
        System.out.println("Rendez-vous ajouté avec succès !");
    }

    private void displayAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Aucun rendez-vous trouvé.");
        } else {
            System.out.println("=== Liste des rendez-vous ===");
            for (Map.Entry<String, String> entry : appointments.entrySet()) {
                System.out.println("Date : " + entry.getKey() + ", Patient : " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Medical app = new Medical();
        app.displayMenu();
    }
}