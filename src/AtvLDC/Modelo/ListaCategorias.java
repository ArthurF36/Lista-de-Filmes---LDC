// Classe ListaCategoria
package AtvLDC.Modelo;

import AtvLDC.Controle.Categoria;
import AtvLDC.Controle.Filme;
import AtvLDC.Controle.NodePrincipal;

public class ListaCategorias {
    private NodePrincipal primeiro;
    private int qtd;
    private NodePrincipal ultimo;

    public void inserir(Categoria categ, Filme film) {
        NodePrincipal nvCateg = new NodePrincipal(categ);
        NodePrincipal aux, anterior;
        ListaFilmes listaFilm;
        Categoria infoAux;
        int compara;
        listaFilm = categ.getLista();
        if (this.isEmpty() == true) {
            this.primeiro = nvCateg;
            this.ultimo = nvCateg;
        }
        else if (this.primeiro.getInfo().compareTo(categ) > 0) {
            this.primeiro.setAnte(nvCateg);
            nvCateg.setProx(this.primeiro);
            this.primeiro = nvCateg;
            this.primeiro.setAnte(this.ultimo);
        }
        else if (this.ultimo.getInfo().compareTo(categ) < 0) {
            this.ultimo.setProx(nvCateg);
            nvCateg.setAnte(this.ultimo);
            this.ultimo = nvCateg;
            this.ultimo.setProx(this.primeiro);
        }
        else {
            aux = this.primeiro;
            do {
                anterior = aux.getAnte();
                infoAux = aux.getInfo();
                compara = infoAux.compareTo(categ);
                if (compara == 0) {
                    infoAux.getLista().categoriaInserir(film);
                    return;
                }
                else if (compara > 0) {
                    anterior.setProx(nvCateg);
                    nvCateg.setAnte(anterior);
                    nvCateg.setProx(aux);
                    aux.setAnte(nvCateg);
                    break;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
        this.qtd++;
        listaFilm.categoriaInserir(film);
    }

    public void exibeCategoria(Categoria categ) {
        NodePrincipal aux;
        Categoria infoAux;
        if (this.isEmpty() == true) {
            System.out.println("Lista de filmes vazia.");
        }
        else {
            aux = this.buscaCategoria(categ);
            if (aux == null) {
                System.out.println("Categoria não cadastrada.");
            }
            else {
                infoAux = aux.getInfo();
                infoAux.getLista().exibeListaFilme();
            }
        }
    }

    private NodePrincipal buscaCategoria(Categoria categ) {
        NodePrincipal aux;
        Categoria infoAux;
        int compara;
        aux = this.primeiro;
        do {
            infoAux = aux.getInfo();
            compara = infoAux.compareTo(categ);
            if (compara == 0) {
                return aux;
            }
            else if (compara > 0) {
                return null;
            }
            aux = aux.getProx();
        } while (aux != this.primeiro);
        return null;
    }

    private boolean isEmpty() {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        }
        return false;
    }
}