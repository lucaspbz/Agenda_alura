package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;

import br.com.alura.agenda.database.dao.AlunoDao;
import br.com.alura.agenda.database.dao.TelefoneDao;
import br.com.alura.agenda.model.Aluno;
import br.com.alura.agenda.model.Telefone;

public class SalvaAlunoTask extends AsyncTask<Void, Void, Void> {
    private final AlunoDao alunoDao;
    private final Aluno aluno;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final TelefoneDao telefoneDAO;
    private final QuandoAlunoSalvoListener listener;

    public SalvaAlunoTask(AlunoDao alunoDao,
                          Aluno aluno,
                          Telefone telefoneFixo,
                          Telefone telefoneCelular,
                          TelefoneDao telefoneDAO, QuandoAlunoSalvoListener listener) {
        this.alunoDao = alunoDao;
        this.aluno = aluno;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefoneDAO = telefoneDAO;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int alunoId = alunoDao.salva(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salva(telefoneFixo, telefoneCelular);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoSalvo();
    }

    private void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setId(alunoId);
        }
    }

    public interface QuandoAlunoSalvoListener {
        void quandoSalvo();
    }
}
