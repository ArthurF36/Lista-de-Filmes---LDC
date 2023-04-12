// Classe ListaFilmes
package AtvLDC.Modelo;

import AtvLDC.Controle.Categoria;
import AtvLDC.Controle.Filme;
import AtvLDC.Controle.NodeSecundaria;
import java.util.Scanner;

public class ListaFilmes {
    Scanner in = new Scanner(System.in);
    Scanner input = new Scanner(System.in);
    private NodeSecundaria primeiro;
    private NodeSecundaria ultimo;
    private int qtd;

    public void inserir(Filme film, Categoria categ) {
        NodeSecundaria nvFilm = new NodeSecundaria(film);
        ListaCategorias listCateg = new ListaCategorias();
        NodeSecundaria aux, anterior;
        Filme infoAux;
        int compara;
        if (this.isEmpty() == true) {
            this.primeiro = nvFilm;
            this.ultimo = nvFilm;
            this.primeiro.setAnte(this.ultimo);
            this.ultimo.setProx(this.primeiro);
        }
        else if (this.primeiro.getInfo().compareTo(film) > 0) {
            this.primeiro.setAnte(nvFilm);
            nvFilm.setProx(this.primeiro);
            this.primeiro = nvFilm;
            this.primeiro.setAnte(this.ultimo);
        }
        else if (this.ultimo.getInfo().compareTo(film) < 0) {
            this.ultimo.setProx(nvFilm);
            nvFilm.setAnte(this.ultimo);
            this.ultimo = nvFilm;
            this.ultimo.setProx(this.primeiro);
        }
        else {
            aux = this.primeiro;
            do {
                anterior = aux.getAnte();
                infoAux = aux.getInfo();
                compara = infoAux.compareTo(film);
                if (compara == 0) {
                    System.out.println("Filme já cadastrado. Inseção não efetuada.");
                    return;
                }
                else if (compara > 0) {
                    anterior.setProx(nvFilm);
                    nvFilm.setAnte(anterior);
                    nvFilm.setProx(aux);
                    aux.setAnte(nvFilm);
                    break;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
        this.qtd++;
        dadosFilm(nvFilm, film);
        listCateg.inserir(categ, film);
        System.out.println("Filme inserido.");
    }

    public void dadosFilm(NodeSecundaria nvFilme, Filme film) {
        String genero, clas;
        int ano;
        System.out.print("Informe o gênero do filme: ");
        genero = input.nextLine();
        film.setGenero(genero);
        System.out.print("Informe a sua classificação: ");
        clas = input.nextLine();
        film.setClassificacao(clas);
        System.out.print("Informe o ano de lançamento: ");
        ano = in.nextInt();
        film.setAno(ano);
        nvFilme.setInfo(film);
    }

    public void categoriaInserir(Filme film) {
        NodeSecundaria nvFilm = new NodeSecundaria(film);
        NodeSecundaria aux, anterior;
        Filme infoPrimer, infoUltim, infoAux;
        int compara;
        infoPrimer = this.primeiro.getInfo();
        infoUltim = this.ultimo.getInfo();
        if (this.isEmpty() == true) {
            this.primeiro = nvFilm;
            this.ultimo = nvFilm;
        }
        else if (infoPrimer.compareTo(film) > 0) {
            this.primeiro.setAnte(nvFilm);
            nvFilm.setProx(this.primeiro);
            this.primeiro = nvFilm;
            this.primeiro.setAnte(this.ultimo);
        }
        else if (infoUltim.compareTo(film) < 0) {
            this.ultimo.setProx(nvFilm);
            nvFilm.setAnte(this.ultimo);
            this.ultimo = nvFilm;
            this.ultimo.setProx(this.primeiro);
        }
        else {
            aux = this.primeiro;
            do {
                anterior = aux.getAnte();
                infoAux = aux.getInfo();
                compara = infoAux.compareTo(film);
                if (compara > 0) {
                    anterior.setProx(nvFilm);
                    nvFilm.setAnte(anterior);
                    nvFilm.setProx(aux);
                    aux.setAnte(nvFilm);
                    break;
                }
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
        this.qtd--;
    }

    public void removeFilme(Filme film) {
        NodeSecundaria aux, anterior, posterior;
        Filme infoPrimer, infoUltim;
        infoPrimer = this.primeiro.getInfo();
        infoUltim = this.ultimo.getInfo();
        if (this.isEmpty() == true) {
            System.out.println("Lista de filmes vazia.");
            return;
        }
        else if (infoPrimer.compareTo(film) == 0) {
            if (this.qtd == 1) {
                this.primeiro = null;
                this.ultimo = null;
            }
            else {
                this.primeiro = this.primeiro.getProx();
                this.ultimo.setProx(this.primeiro);
            }
        }
        else if (infoUltim.compareTo(film) == 0) {
            anterior = this.ultimo.getAnte();
            posterior = this.primeiro;
            anterior.setProx(posterior);
            posterior.setAnte(anterior);
        }
        else {
            aux = this.buscaFilme(film);
            if (aux == null) {
                System.out.println("Filme informado não se encontra na lista.");
                return;
            }
            else {
                anterior = aux.getAnte();
                posterior = aux.getProx();
                anterior.setProx(posterior);
                posterior.setAnte(anterior);
            }
        }
        this.qtd--;
    }

    public void exibeFilme( Filme film) {
        NodeSecundaria aux;
        if (this.isEmpty() == true) {
            System.out.println("Lista de filmes vazia.");
        }
        else {
            aux = this.buscaFilme(film);
            if (aux == null) {
                System.out.println("Filme não cadastrado.");
            }
            else {
                System.out.println(aux.getInfo());
            }
        }
    }

    public void editaFilme(Filme film) {
        NodeSecundaria aux;
        char opcao;
        String genero, clas;
        int ano;
        Filme editFilm;
        if (this.isEmpty() == true) {
            System.out.println("Lista de filmes vazia.");
        }
        else {
            aux = this.buscaFilme(film);
            if (aux == null) {
                System.out.println("Filme não cadastrado.");
            }
            else {
                editFilm = aux.getInfo();
                menuEditar();
                do {
                    System.out.println();
                    System.out.println("Menu de edições.");
                    System.out.println("Digite 4 para ver o menu novamente.");
                    System.out.print("Informe a sua opção desejada: ");
                    opcao = in.next().charAt(0);
                    if (opcao == '1') {
                        System.out.print("Informe gênero para a alteração: ");
                        genero = input.nextLine();
                        editFilm.setGenero(genero);
                    }
                    else if (opcao == '2') {
                        System.out.print("Informe a classificação para a alteração: ");
                        clas = input.nextLine();
                        editFilm.setClassificacao(clas);
                    }
                    else if (opcao == '3') {
                        System.out.print("Informe o ano para a alteração: ");
                        ano = in.nextInt();
                        editFilm.setAno(ano);
                    }
                    else if (opcao == '4') {
                        menuEditar();
                    }
                    else if (opcao == '0') {
                        System.out.println("Voltando para o menu principal.");
                    }
                    else {
                        System.out.println("Opção inválida.");
                    }
                } while (opcao != '0');
            }
        }
    }

    public void exibeListaFilme() {
        NodeSecundaria aux;
        int qtdFilm = 0;
        if (this.isEmpty() == true) {
            System.out.println("Lista de filmes vazia.");
        }
        else {
            aux = this.primeiro;
            do {
                System.out.println((qtdFilm + 1) + "° filme:");
                System.out.println(aux.getInfo());
                if (qtdFilm != this.qtd - 1) {
                    System.out.println();
                }
                qtdFilm++;
                aux = aux.getProx();
            } while (aux != this.primeiro);
        }
    }

    public NodeSecundaria buscaFilme(Filme film) {
        NodeSecundaria aux;
        Filme infoAux;
        int compara;
        aux = this.primeiro;
        do {
            infoAux = aux.getInfo();
            compara = infoAux.compareTo(film);
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

    private void menuEditar() {
        System.out.println("Opções para edição:");
        System.out.println("1 - Editar gênero.");
        System.out.println("2 - Editar classificação.");
        System.out.println("3 - Editar ano.");
        System.out.println("0 - Sair do menu de edições.");
    }

    private boolean isEmpty() {
        if (this.primeiro == null && this.ultimo == null && this.qtd == 0) {
            return true;
        }
        return false;
    }
}