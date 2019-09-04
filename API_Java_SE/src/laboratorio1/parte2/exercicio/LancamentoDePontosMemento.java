package laboratorio1.parte2.exercicio;

import java.util.ArrayList;
import java.util.List;

public class LancamentoDePontosMemento {

    private String nomeUsuario;
    private List<Ponto> pontos = new ArrayList<>();

    public LancamentoDePontosMemento(String nomeUsuario, List<Ponto> pontos) {
    	super();
    	this.pontos.addAll(pontos);
        this.nomeUsuario = nomeUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public List<Ponto> getPontos() {
        return this.pontos;
    }

    public void setPontos(List<Ponto> pontos) {
        this.pontos = pontos;
    }

    public void lancarPonto(Ponto ponto) {
        this.pontos.add(ponto);
    }

    public void removerPonto(Ponto ponto) {
        this.pontos.remove(ponto);
    }

    @Override
    public String toString() {
        return "LancamentoDePontos{" +
                "pontos=" + pontos +
                '}';
    }

}