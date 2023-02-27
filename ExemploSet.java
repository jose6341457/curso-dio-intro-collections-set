package br.com.dio.collection.set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {


        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double>notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas.toString());

        System.out.println("Conferir se a nota 5.0 esta no conjunto:");
        System.out.println(notas.contains(5d));

        System.out.println("Exiba a menor nota: ");
        System.out.println(Collections.min(notas));
        System.out.println("Exiba a maior nota: ");
        System.out.println(Collections.max(notas));

        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores ; ");
        System.out.println(soma);

        System.out.println("Exiba a média das notas: ");
        System.out.println(soma/ notas.size());

        System.out.println("Remova a nota zero");
        notas.remove(0d);
        System.out.println(notas);

        System.out.println("Remova as notas menores que 7");
        Iterator<Double> iterator1 = notas.iterator();
        while (iterator1.hasNext()){
            Double next = iterator1.next();
            if(next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Exiba todas as notas na ordem em que foram imformados");
        Set<Double> notas2= new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        System.out.println("Apague todo conjunto: ");
        notas.clear();
        System.out.println("O conjunto notas esta vazío?: ");
        System.out.println(notas.isEmpty());
        System.out.println("O conjunto notas2 esta vazío?: ");
        System.out.println(notas2.isEmpty());
        System.out.println("O conjunto notas3 esta vazío?: ");
        System.out.println(notas3.isEmpty());





    }
}
