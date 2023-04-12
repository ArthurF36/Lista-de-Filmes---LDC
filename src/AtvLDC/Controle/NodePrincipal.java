// Classe NodePrincipal
package AtvLDC.Controle;

public class NodePrincipal {
    private Categoria info;
    private NodePrincipal ante;
    private NodePrincipal prox;

    public NodePrincipal(Categoria categ) {
        this.info = categ;
    }

    public Categoria getInfo() {
        return this.info;
    }

    public NodePrincipal getAnte() {
        return this.ante;
    }

    public NodePrincipal getProx() {
        return this.prox;
    }

    public void setInfo(Categoria nvCatg) {
        this.info = nvCatg;
    }

    public void setAnte(NodePrincipal nvAnte) {
        this.ante = nvAnte;
    }

    public void setProx(NodePrincipal nvProx) {
        this.prox = nvProx;
    }
}