package br.com.alura.agenda.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import br.com.alura.agenda.database.conversor.ConversorCalendar;
import br.com.alura.agenda.database.dao.RoomAlunoDao;
import br.com.alura.agenda.model.Aluno;

import static br.com.alura.agenda.database.AgendaMigrations.MIGRATIONS;

@Database(entities = {Aluno.class}, version = 4, exportSchema = false)
@TypeConverters({ConversorCalendar.class})
public abstract class AgendaDatabase extends RoomDatabase {

    private static final String NOME_BANCO_DE_DADOS = "agenda.db";


    public static AgendaDatabase getInstance(Context context) {
        return Room
                .databaseBuilder(context, AgendaDatabase.class, NOME_BANCO_DE_DADOS)
                .allowMainThreadQueries()
                .addMigrations(MIGRATIONS)
                .build();
    }

    public abstract RoomAlunoDao getRoomAlunoDAO();
}
