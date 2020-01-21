package br.com.alura.agenda.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Telefone {
    @PrimaryKey(autoGenerate = true)
    int id;
    private String numero;
    private TipoTelefone tipo;
    @ForeignKey(entity = Aluno.class,
    parentColumns = "id",
    childColumns = "alunoId",
    onUpdate = ForeignKey.CASCADE,
    onDelete = ForeignKey.CASCADE)
    int alunoId;

    public Telefone(String numero, TipoTelefone tipo, int alunoId) {

        this.numero = numero;
        this.tipo = tipo;
        this.alunoId = alunoId;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelefone tipo) {
        this.tipo = tipo;
    }
}
