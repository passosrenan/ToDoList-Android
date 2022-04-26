package br.senai.sp.cotia.todolist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.senai.sp.cotia.todolist.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
    public abstract class AppDatabase extends RoomDatabase {

        //atributo para acessar a database
        private static AppDatabase database;

        //atributo para tarefa dao
        public abstract TarefaDao getTarefaDao();

        //metodo para acessar o atributo que acessa a database
        public static AppDatabase getDatabase(Context context) {
            //verifica se ja foi instanciada
            if (database == null) {
                //instancia a database
                database = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todolist").build();
            }
                return database;
        }


}
