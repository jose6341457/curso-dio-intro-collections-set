package br.com.dio.collection.set;
/* Dado as seguintes informações sobre ,imhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
nome, género e tempo de episódio:

Série 1= nome: got, género: fantasia, tempoEpisodio: 60
Série 2= nome: dark, género: drama, tempoEpisodio: 60
Série 3= nome: that '70s show, género: comédia, tempoEpisodio: 25
*/

import java.util.*;

public class ExemploOrdenacaoSet {
    public static void main(String[] args) {
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got" , "fantasia" , 60));
            add(new Serie("dark" , "drama" , 60));
            add(new Serie("that '70s show" , "comédia" , 25));
        }};

        System.out.println("\n---Imprimir ordem aleatória---\n");
        for (Serie serie:minhasSeries)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());};

        System.out.println("\n---Imprimir ordem de Inserçâo---\n");
        Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{
           add(new Serie("got" , "fantasia" , 60));
           add(new Serie("dark" , "drama" , 60));
           add(new Serie("that '70s show" ,"comédia" , 25));
        }};

        for (Serie serie:minhasSeries1)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());}

        System.out.println("\n---Imprimir ordem Natural---\n");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie:minhasSeries2)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());}

        System.out.println("\n---Imprimir ordem Nome/Genero/TempoEpisodio---\n");
        Set<Serie>minhasSerie3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSerie3.addAll(minhasSeries);
        for (Serie serie:minhasSerie3)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());}

        System.out.println("\n---Imprimir ordem Genero---\n");
        Set<Serie>minhasSerie4 = new TreeSet<>(new ComparatorGenero());
        minhasSerie4.addAll(minhasSeries);
        for (Serie serie:minhasSerie4)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());}

        System.out.println("\n---Imprimir ordem Tempo Episodio---\n");
        Set<Serie>minhasSerie5 = new TreeSet<>(new ComparatorTempoEpisodio());
        minhasSerie5.addAll(minhasSeries);
        for (Serie serie:minhasSerie5)
        {System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());}
        System.out.println("Não aceita duplicados");

    }
}
class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio() , serie.getTempoEpisodio());
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());
    }
}
class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
       int nome = s1.getNome().compareTo(s2.getNome());
       if (nome !=0) return nome;

       int genero = s1.getGenero().compareTo(s2.getGenero());
       if (genero != 0) return genero;

       return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie>{


    @Override
    public int compare(Serie s1, Serie s2) {
        return String.CASE_INSENSITIVE_ORDER.compare(s1.getGenero(), s2.getGenero());
    }
}

class ComparatorTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}
