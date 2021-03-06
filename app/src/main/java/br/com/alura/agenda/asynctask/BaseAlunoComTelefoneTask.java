package br.com.alura.agenda.asynctask;

import android.os.AsyncTask;

import br.com.alura.agenda.model.Telefone;

public abstract class BaseAlunoComTelefoneTask extends AsyncTask<Void, Void, Void> {
    private FinalizadaListener listener;

    protected BaseAlunoComTelefoneTask(FinalizadaListener listener) {
        this.listener = listener;
    }

    void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoFinalizada();
    }

    public interface FinalizadaListener {
        void quandoFinalizada();
    }
}
