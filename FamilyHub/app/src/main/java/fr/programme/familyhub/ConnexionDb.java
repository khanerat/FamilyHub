package fr.programme.familyhub;

public class ConnexionDb {

    private static ConnexionDb instance;

    private String username;

    private ConnexionDb() {
        System.out.println("Connexion créée");
        this.username = "username";
    }

    public static ConnexionDb getInstance() {
        if(instance == null) {
            instance = new ConnexionDb();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }
}
