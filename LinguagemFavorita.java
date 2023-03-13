package br.com.dio.collection.set.exerciciospropostos;

/*Crie uma classe LinguagemFavorita que possua os atributos
nome, anoDeCriacao e ide. Em seguida, crie um conjunto com
3 linguagens e faça um programa que ordene esse conjunto
por: 1.- Ordem de Inserção;
2.- Ordem Natural (nome);
3.- IDE, Ano de criação e nome;
4.- Nome, ano de criacao e IDE;
Ao final, exiba as linguagens no console, um abaixo da outra.
* */



import java.util.*;


public class LinguagemFavorita {
    public static void main(String[] args) {

        Set<Linguagens> minhasLinguagens = new LinkedHashSet<>(){{
            add(new Linguagens("Java", 1991, "Intellj"));
            add(new Linguagens("Phyton", 1994, "Jupyter"));
            add(new Linguagens("JavaScript", 1995, "Eclipse"));

        }};

        System.out.println("\n---Imprimir por Ordem de Inserção---\n");
        for (Linguagens lingua:minhasLinguagens)
        {System.out.println(lingua.getNome() + " - " + lingua.getAno() + " - " + lingua.getIDE());};

        System.out.println("\n---Imprimir por Ordem Natural---\n");
        Set<Linguagens> minhasLinguagens1= new TreeSet<>(new ComparetorNome());
        minhasLinguagens1.addAll(minhasLinguagens);
        for (Linguagens lingua:minhasLinguagens1)
        {System.out.println(lingua.getNome() + " - " + lingua.getAno() + " - " + lingua.getIDE());}

        System.out.println("\n---Imprimir por ordem IDE, Ano de criação e nome---\n");
        Set<Linguagens> minhasLinguagens2 = new TreeSet<>(new ComparatorIDEanoNome());
        minhasLinguagens2.addAll(minhasLinguagens);
        for (Linguagens lingua:minhasLinguagens2)
        {System.out.println(lingua.getNome() + " - " + lingua.getAno() + " - " + lingua.getIDE());}

        System.out.println("\n---Imprimir por ordem Nome, ano de criacao e IDE---\n");
        Set<Linguagens> minhaLinguagens3 = new TreeSet<>(new ComparatorNomeanoIDE());
        minhaLinguagens3.addAll(minhasLinguagens);
        for (Linguagens lingua:minhaLinguagens3)
        {System.out.println(lingua.getNome() + " - " + lingua.getAno() + " - " + lingua.getIDE());}

    }
}
class Linguagens {
    private String nome;

    private Integer ano;

    private String IDE;

    public Linguagens(String nome, Integer ano, String IDE) {
        this.nome = nome;
        this.ano = ano;
        this.IDE = IDE;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public String getIDE() {
        return IDE;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", IDE='" + IDE + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linguagens lingua = (Linguagens) o;
        return nome.equals(lingua.nome) && ano.equals(lingua.ano) && IDE.equals(lingua.IDE);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, ano, IDE);
    }
}

class ComparetorNome implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {
        return String.CASE_INSENSITIVE_ORDER.compare(l1.getNome(), l2.getNome());
    }
}

class ComparatorIDEanoNome implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {
        int IDE = l1.getIDE().compareTo(l2.getIDE());
        if(IDE != 0) return IDE;

        int ano = l1.getAno().compareTo(l2.getAno());
        if (ano != 0) return ano;

        return String.CASE_INSENSITIVE_ORDER.compare(l1.getNome(), l2.getNome());
    }
}
class ComparatorNomeanoIDE implements Comparator<Linguagens>{

    @Override
    public int compare(Linguagens l1, Linguagens l2) {

        int nome = l1.getNome().compareTo(l2.getNome());
        if (nome != 0) return nome;

        int ano = l1.getAno().compareTo(l2.getAno());
        if (ano != 0) return ano;

        return String.CASE_INSENSITIVE_ORDER.compare(l1.getIDE(), l2.getIDE());

    }
}