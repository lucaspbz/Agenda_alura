package br.com.alura.agenda.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import br.com.alura.agenda.model.Telefone;

@Dao
public interface TelefoneDao {
    @Query("SELECT * FROM Telefone" +
            " WHERE alunoId = :alunoId LIMIT 1")
    Telefone buscarPrimeiroTelefoneDoAluno(int alunoId);

    @Insert()
    void salva(Telefone... telefones);

    @Query("SELECT * FROM Telefone" +
            " WHERE alunoId = :alunoId")
    List<Telefone> buscaTodosTelefonesDoAluno(int alunoId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void atualiza(Telefone... telefones);
}
