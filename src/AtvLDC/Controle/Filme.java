// Classe filme
package AtvLDC.Controle;
public class Filme {
    private String titulo;
    private String genero;
    private String classificacao;
    private int ano;

    public Filme (String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getGenero() {
        return this.genero;
    }

    public String getClassificacao() {
        return this.classificacao;
    }

    public int getAno() {
        return this.ano;
    }

    public void setGenero(String nvGen) {
        this.genero = nvGen;
    }

    public void setClassificacao(String nvClas) {
        this.classificacao = nvClas;
    }

    public void setAno(int nvAno) {
        this.ano = nvAno;
    }

    public int compareTo(Filme busFil) {
        int compara;
        compara = this.titulo.compareTo(busFil.titulo);
        return compara;
    }

    public String toString() {
        return "Titulo: " + this.titulo + "\n" + "Gênero: " + this.genero + "\n" + "Classificação: " + classificacao
                + "\n" + "Ano: " + this.ano;
    }
}