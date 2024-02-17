package org.listadupla;

public class Main {
    public static void main(String[] args) {
        ListaDuplaEncadeada<String> minhaListaEncadeada = new ListaDuplaEncadeada<>();

        minhaListaEncadeada.add("c1");
        minhaListaEncadeada.add("c2");
        minhaListaEncadeada.add("c3");
        minhaListaEncadeada.add("c4");
        minhaListaEncadeada.add("c5");

        System.out.println(minhaListaEncadeada);

        minhaListaEncadeada.remove(2);

        System.out.println(minhaListaEncadeada);

    }
}