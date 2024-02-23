package fr.programme.familyhub;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class DatabaseAccess {

    private DatabaseOpenHelper openHelper;
    private static SQLiteDatabase<?> db;
    private static DatabaseAccess instance;

    // Constructeur privé pour empêcher l'instanciation en dehors de cette classe
    private DatabaseAccess(Context context) {
        this.openHelper = new DatabaseOpenHelper(context);
    }

    // Retourne l'instance de DatabaseAccess en vérifiant si elle est déjà initialisée
    public static DatabaseAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    // Ouvre la connexion à la base de données
    public void open() {
        this.db = openHelper.getWritableDatabase();
    }

    // Ferme la connexion à la base de données
    public void close() {
        if (db != null) {
            DatabaseAccess.db.close();
        }
    }

    // Méthode pour récupérer l'ID d'un utilisateur
    public String getId(String users) {
        if (db != null) {
            String sql = "SELECT BrededParticipants FROM Users WHERE Nom = ?";
            Cursor cursor = db.rawQuery(sql, new String[]{users});
            if (cursor != null && cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("BrededParticipants");
                String result = cursor.getString(columnIndex);
                cursor.close(); // Fermer le curseur après utilisation
                return result;
            }
        }
        return null;
    }

    // Méthode pour récupérer la liste de courses
    public static List<String> getShoppingList() {
        List<String> shoppingList = new ArrayList<>();
        if (db != null) {
            String sql = "SELECT item FROM Shopping_list";
            Cursor cursor = db.rawQuery(sql, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    String item = cursor.getString(cursor.getColumnIndex("item"));
                    shoppingList.add(item);
                }
                cursor.close(); // Fermer le curseur après utilisation
            }
        }
        return shoppingList;
    }

    // Méthode pour ajouter un élément à la liste de courses
    public void addShoppingListItem(String item) {
        try {
            open(); // Ouvre la connexion à la base de données
            String sql = "INSERT INTO Shopping_list (item) VALUES (?)";
            db.execSQL(sql, new Object[]{item});
            System.out.println("Item added to the shopping list: " + item);
        } catch (Exception e) {
            System.err.println("Error adding item to the shopping list: " + e.getMessage());
        } finally {
            close(); // Ferme la connexion à la base de données
        }
    }
}