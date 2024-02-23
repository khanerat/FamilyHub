package fr.programme.familyhub;

import javax.naming.Context;

import com.google.android.filament.View;

public class MainActivity <View, TextView> {

    //methode parent
    private final String Users ="id";//changer ce qui est surligné

    @Override//definir une method qui hérite du parent
    protected void onCreate(bundle savedInstanceState) {
        setContentView(R.layout.activity_main);

        final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();

        Users = db.getId("kot");

        TextView textView_Users = (TextView) textView_Users.findViewById();
        textView_Users.setText(Users);
    }

    private Context getApplicationContext(){

    }

    private void setcontentView(int activityMain) {

    }


   // ConnexionDb connexion = ConnexionDb.getInstance();

   // ConnexionDb connexion2 = ConnexionDb.getInstance();

    //System.out.println();// à vérifier

//appel du bouton
    public void sendCreated(View view) {

        //champs de texte
        String connexion = ((EditText) findViewById(R.id.connexion)).getText().toString();

        //acces base de données
        final DatabaseAccess db = DatabaseAccess.getInstance(getApplicationContext());
        db.open();

        //on verifie l'identifiant
        boolean connecte = db.connecteUsers(connexion);

        if(!connecte){
            db.addUsers(connexion);
            String Id = db.getId(connexion);
            Toast.makeText(this, "Bienvenue" + connexion + " Nathan", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"connexion déjà établie pour " + connexion, Toast.LENGTh_SHORT).show();

            db.close();
        }
    }
}
