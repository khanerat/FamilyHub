package android.database.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@SuppressWarnings("unused")
public class SQLiteDatabase {

    private static final String DATABASE_PATH = "/data/data/com.example.myapp/databases/";
    private static final String DATABASE_NAME = "familyhub.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TAG = "SQLiteDatabase";
	private static Object OPEN_READWRITE;

    private static SQLiteDatabase database;
    private final Context context;

    public SQLiteDatabase(Context context) {
        this.context = context;
    }

    public void open() throws SQLException {
        String path = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
    }

    private static SQLiteDatabase database;

    // Méthode pour ouvrir une base de données SQLite
    private static SQLiteDatabase openDatabase(String path, Object object, Object oPEN_READWRITE2) {
        // Vous pouvez implémenter la logique d'ouverture de la base de données ici
        // Par exemple :
        try {
			if (database == null || !database.isOpen()) {
			    try {
					try {
						try {
							database = new SQLiteDatabase();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // Créer une nouvelle instance de SQLiteDatabase si elle n'existe pas déjà
			    // Implémenter la logique pour ouvrir la base de données à partir du chemin spécifié
			    // Remplacer cette ligne par votre logique d'ouverture de la base de données
			    System.out.println("Base de données ouverte avec succès.");
			} else {
			    System.out.println("La base de données est déjà ouverte.");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return database;
    }

	public void close() {
        if (database != null && database.isOpen()) {
            database.close();
        }
    }

    public boolean isOpen() {
        return database != null && database.isOpen();
    }

    public long insert(String table, ContentValues values) {
        return database.insert(table, null, values);
    }

    public Cursor rawQuery(String sql, String[] selectionArgs) {
        return database.rawQuery(sql, selectionArgs);
    }

    public void execSQL(String sql) {
        database.execSQL(sql);
    }

    // Méthode pour copier la base de données depuis le dossier assets vers le dossier de l'application
    public void copyDatabase() throws IOException {
        InputStream myInput = context.getAssets().open(DATABASE_NAME);
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }
}

