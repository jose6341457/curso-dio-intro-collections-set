package br.com.dio.collection.set.exerciciospropostos;

/*
Crie um conjunto contendo as cores do arco-íris e: 1.-Exiba todas as cores uma abaixo da outra;
        2.-A quantidade de cores que o arco-íris tem; 3.-Exiba as cores em ordem alfabética;
        4.-Exiba as cores na ordem inversa da que foi informada; 5.-Exiba todas as cores que começam
        com a letra ”v”; 6.-Remova todas as cores que não começam com a letra “v”; 7.-Limpe o conjunto;
        8.-Confira se o conjunto está vazio
        */


import org.w3c.dom.ls.LSOutput;

import java.nio.charset.Charset;
import java.util.*;
import java.util.concurrent.Callable;

public class CoresArcoIris {

    public static void main(String[] args) {


        Set<String> asCores = new HashSet<>();
        asCores.add("amarelo");
        asCores.add("azul");
        asCores.add("azul escuro");
        asCores.add("laranja");
        asCores.add("vermelho");
        asCores.add("verde");
        asCores.add("violeta");

        System.out.println("\n---Exiba todas as cores uma abaixo da outra---\n");
        Iterator iterator = asCores.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("A quantidade de cores que o arco-íris tem são: " + asCores.size());

        System.out.println("\n---Exiba as cores em ordem alfabética---\n");
        Set<String> asCores1 = new TreeSet<>(asCores);
        Iterator iterator1 = asCores1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        System.out.println("\n---Exiba as cores na ordem inversa da que foi informada---\n");
        //Primeirameramente criar um (TreeSet<String>) para acesar ao metodo descendingSet();
        TreeSet<String> asCores2 = new TreeSet<>(asCores1);
        TreeSet<String> asCoresReverse = (TreeSet<String>) asCores2.descendingSet();
        Iterator iterator2 = asCoresReverse.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }


        System.out.println("\n---Exiba todas as cores que começam com a letra ”v”---\n");
// è necessârio fazer uma variavál String para tirar o elemento do conjunto e depois, aplicar charAt para saber a primeira letra do elemento
// quando usamos char é preciso colocar as aspas simples ''
        Iterator<String> iterator3 = asCoresReverse.iterator();
        while (iterator3.hasNext()) {
            String cores = iterator3.next();
            char primeiraLetra = cores.charAt(0);
            char segundaLetra = 'v';
            if (primeiraLetra == segundaLetra) {
                System.out.println(cores);
            }
        }
        System.out.println("\n---Remova todas as cores que não começam com a letra “v”:---\n");
        System.out.println("O conjunto das cores que não começam com a letra “v” é: ");
        Set<String> asCoresSemV = new TreeSet<>(asCoresReverse);
        Iterator<String> stringIterator = asCoresReverse.descendingIterator();
        while (stringIterator.hasNext()){
                String coresSemV = stringIterator.next();
                char p = coresSemV.charAt(0);
                char s = 'a';
                char t = 'l';
                if (p==s || p==t) {
                   // System.out.println(coresSemV);
                    asCoresSemV.remove(coresSemV);
                }
            }
        Iterator<String> iterator4 = asCoresSemV.iterator();
            while (iterator4.hasNext()){
                System.out.println(iterator4.next());
            }
        System.out.println("\n---Limpe o conjunto");
            asCoresSemV.clear();
        System.out.println("Este é o conjunto: " + asCoresSemV);

        System.out.println("\n---Confira se o conjunto está vazio: " + asCoresSemV.isEmpty());




    }

}
