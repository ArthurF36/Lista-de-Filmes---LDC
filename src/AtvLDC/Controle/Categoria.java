// Classe Categoria
package AtvLDC.Controle;

import AtvLDC.Modelo.ListaFilmes;

public class Categoria {
    private String descricao;
    private ListaFilmes lista;

    public Categoria (String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public ListaFilmes getLista() {
        return this.lista;
    }

    public void setLista(ListaFilmes nvList) {
        this.lista = nvList;
    }

    public int compareTo(Categoria busCateg) {
        int compara;
        compara = this.descricao.compareTo(busCateg.descricao);
        return compara;
    }

    public String toString() {
        return "Descrição: " + this.descricao;
    }
}