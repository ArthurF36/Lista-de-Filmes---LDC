// Classe NodeSecundaria
package AtvLDC.Controle;
public class NodeSecundaria {
    private Filme info;
    private NodeSecundaria ante;
    private NodeSecundaria prox;

    public NodeSecundaria(Filme filme) {
        this.info = filme;
    }

    public Filme getInfo() {
        return this.info;
    }

    public NodeSecundaria getAnte() {
        return this.ante;
    }

    public NodeSecundaria getProx() {
        return this.prox;
    }

    public void setInfo(Filme nvFilm) {
        this.info = nvFilm;
    }

    public void setAnte(NodeSecundaria nvAnte) {
        this.ante = nvAnte;
    }

    public void setProx(NodeSecundaria nvProx) {
        this.prox = nvProx;
    }
}