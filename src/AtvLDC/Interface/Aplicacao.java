// Aplicação java
package AtvLDC.Interface;

import AtvLDC.Controle.Categoria;
import AtvLDC.Controle.Filme;
import AtvLDC.Modelo.ListaCategorias;
import AtvLDC.Modelo.ListaFilmes;
import java.util.Scanner;

public class Aplicacao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        char opcao;
        String titulo, descr;
        int retorno;
        Filme film;
        Categoria categ;
        ListaFilmes listFilm = new ListaFilmes();
        ListaCategorias listCateg = new ListaCategorias();
        menuFilme();
        do {
            System.out.println();
            System.out.println("Menu de aplicação da lista.");
            System.out.println("Digite 7 para vizualizar o menu de opções.");
            System.out.print("Informe aqui a sua opção desejada: ");
            opcao = in.next().charAt(0);
            if (opcao == '1') {
                System.out.print("Informe a descrição de sua categoria: ");
                descr = input.nextLine();
                System.out.print("Informe o título do filme: ");
                titulo = input.nextLine();
                categ = new Categoria(descr);
                film = new Filme(titulo);
                listFilm.inserir(film, categ);
            }
            else if (opcao == '2') {
                System.out.print("Informe o titulo do filme que deseja remover: ");
                titulo = input.nextLine();
                film = new Filme(titulo);
                listFilm.removeFilme(film);
            }
            else if (opcao == '3') {
                System.out.print("Informe o titulo do filme que deseja exibir: ");
                titulo = input.nextLine();
                film = new Filme(titulo);
                listFilm.exibeFilme(film);
            }
            else if (opcao == '4') {
                System.out.print("Informe o titulo do livro que deseja editar: ");
                titulo = input.nextLine();
                film = new Filme(titulo);
                listFilm.editaFilme(film);
            }
            else if (opcao == '5') {
                listFilm.exibeListaFilme();
            }
            else if (opcao == '6') {
                System.out.print("Informe a descrição da categoria desejada: ");
                descr = input.nextLine();
                categ = new Categoria(descr);
                listCateg.exibeCategoria(categ);
            }
            else if (opcao == '7') {
                menuFilme();
            }
            else if (opcao == '0') {
                System.out.println("Fim do programa.");
            }
            else {
                System.out.println("Opção inválida.");
            }
        } while (opcao != '0');
    }

    private static void menuFilme() {
        System.out.println("Menu de opções para a lista de filmes:");
        System.out.println("1 - Cadastrar um novo filme na lista.");
        System.out.println("2 - Remover um filme da lista.");
        System.out.println("3 - Exibir os dados de um único filme.");
        System.out.println("4 - Editar os dados de um filme.");
        System.out.println("5 - Exibir os dados de todos os filmes cadastrados.");
        System.out.println("6 - Exibir os dados de todos os filmes de uma categoria.");
        System.out.println("0 - Sair do programa.");
    }
}