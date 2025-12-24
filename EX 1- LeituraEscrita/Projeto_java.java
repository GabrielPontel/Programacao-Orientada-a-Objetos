/*
    Gabriel Pontel de Mori - 2025

Exercicio básico em java para apresender leitura e escrita.

*/


package com.mycompany.projeto_java;

import java.util.Scanner;

public class Projeto_java {

    public static void main(String[] args) {
        int x ;
        Scanner ler = new Scanner(System.in);
        x = ler.nextInt();
        if(x>50)
            System.out.println("Grande");
        else if(x<100)
            System.out.println("Medio");
        else
            System.out.println("Vidaos");
    }
}
