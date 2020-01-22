package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import br.com.alura.agenda.database.dao.TelefoneDao;
import br.com.alura.agenda.model.Telefone;

public class BuscaPrimeiroTelefoneTask extends AsyncTask<Void, Void, Telefone> {
    private final TelefoneDao dao;
    private final int alunoId;
    private final TextView campoTelefone;

    public BuscaPrimeiroTelefoneTask(TelefoneDao dao, int alunoId, TextView campoTelefone) {
        this.dao = dao;
        this.alunoId = alunoId;
        this.campoTelefone = campoTelefone;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscarPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        if (primeiroTelefone != null) {
            campoTelefone.setText(primeiroTelefone.getNumero());
        }
    }
}
