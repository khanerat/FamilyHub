package fr.programme.familyhub;


import java.util.Calendar;
import java.util.Scanner;

public class CalendarApp {

    public static void main(String[] args) {

        // Scanner pour la saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        // Demander à l'utilisateur d'entrer l'année
        System.out.print("Entrez l'année (2024) : ");
        int year = scanner.nextInt();

        // Demander à l'utilisateur d'entrer le mois (1 pour janvier, 12 pour décembre)
        System.out.print("Entrez le mois (1 pour janvier, 12 pour décembre) : ");
        int month = scanner.nextInt() - 1; // -1 car les mois dans Calendar commencent à 0

        // Obtenir une instance du calendrier
        Calendar calendar = Calendar.getInstance();

        // Définir l'année et le mois dans le calendrier
        calendar.set(year, month, 1);

        // Obtenir le jour de la semaine où commence le mois
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Obtenir le nombre de jours dans le mois
        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Afficher l'en-tête du calendrier
        System.out.println("\n Dim Lun Mar Mer Jeu Ven Sam");

        // Variable pour suivre le jour du mois
        int dayOfMonth = 1;

        // Boucle pour afficher les espaces avant le 1er jour du mois
        for (int i = 1; i < firstDayOfWeek; i++) {
            System.out.print("    "); // 4 espaces pour chaque jour de la semaine
        }

        // Boucle pour afficher les jours du mois
        for (int i = 0; i < numDays; i++) {
            // Afficher le jour du mois formaté avec 4 caractères (espaces compris)
            System.out.printf("%4d", dayOfMonth);

            // Passage à la ligne après le samedi (jour 7 de la semaine)
            if ((i + firstDayOfWeek) % 7 == 0 || i == numDays - 1) {
                System.out.println();
            } else {
                System.out.print(" "); // Espace entre les jours
            }

            // Incrémenter le jour du mois
            dayOfMonth++;
        }
    }
}

//import java.util.Calendar;
//import java.util.Scanner;

//public class InteractiveCalendar {
//   public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur d'entrer l'année
//        System.out.print("Entrez l'année (par exemple 2024) : ");
//        int year = scanner.nextInt();

        // Demande à l'utilisateur d'entrer le mois
//        System.out.print("Entrez le mois (1 pour janvier, 12 pour décembre) : ");
//        int month = scanner.nextInt() - 1; // Les mois dans Calendar sont 0-indexés

        // Création d'une instance de calendrier
//        Calendar calendar = Calendar.getInstance();

        // Définition de la date dans le calendrier
//        calendar.set(year, month, 1);

        // Obtention du premier jour de la semaine
//        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        // Obtention du nombre de jours dans le mois
//        int numDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Affichage de l'en-tête du calendrier
//        System.out.println("\n   Dim   Lun   Mar   Mer   Jeu   Ven   Sam");

        // Saut au jour de la semaine du premier jour du mois
//        for (int i = Calendar.SUNDAY; i < firstDayOfWeek; i++) {
//            System.out.print("      ");
//        }

        // Affichage des jours du mois
//        for (int day = 1; day <= numDays; day++) {
//            System.out.printf("%6d", day);
//            if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
//                System.out.println();
//            }
//            calendar.add(Calendar.DAY_OF_MONTH, 1);
//        }

//        scanner.close();
//    }
//}
