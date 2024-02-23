package fr.programme.familyhub;

import android.content.Context;

import android.database.sqlite.SQLiteDatabase;



    public class DatabaseOpenHelper extends SQLiteAssetHelper {

        private static final String DATABASE_NAME = "familyhub.db";

        public DatabaseOpenHelper(Context context){
            super();
        }

        @SuppressWarnings("rawtypes")
		public SQLiteDatabase getWritableDatabase() {
                return null;
        }

		public static String getDatabaseName() {
			return DATABASE_NAME;
		}

}
