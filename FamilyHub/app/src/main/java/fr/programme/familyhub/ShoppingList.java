package fr.programme.familyhub;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


@SuppressWarnings("unused")
public class ShoppingList {
    public static void main(String[] args) {
        // scanner pour saisie utilisateur
        Scanner scanner = new Scanner(System.in);

        // déclaration d'accès à la base de données
        DatabaseAccess databaseAccess = null;
        try {
            // accès à la base de données
            databaseAccess = (DatabaseAccess) DatabaseAccess.getShoppingList();
        } catch (Exception e) {
            // affichage une erreur en cas d'échec
            e.printStackTrace();
        }

        // ouvre la base de données
        databaseAccess.open();

        // boucle pour ajouter des éléments à la liste 
        while (true) {
            System.out.print("Entrez un élément de la liste de courses (ou 'fin' pour terminer) : ");
            String item = scanner.nextLine();

            if (item.equalsIgnoreCase("fin")) {
                // sort de la boucle si entre 'fin'
                break;
            } else {
                // ajoute l'élément à la base de données
                databaseAccess.addShoppingListItem(item);
            }
        }

        // récupérer la liste depuis la base de données
        List<String> shoppingList = DatabaseAccess.getShoppingList();

        // afficher la liste 
        System.out.println("Voici votre liste de courses :");
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.println((i + 1) + ". " + shoppingList.get(i));
        }

        // ferme la base de données
        databaseAccess.close();
    }
}