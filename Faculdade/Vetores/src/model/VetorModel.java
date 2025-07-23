package model;

import java.util.Arrays;

public class VetorModel {
    private int[] numeros;
    private static final int TAMANHO_PADRAO = 5;

    public VetorModel() {
        this.numeros = new int[TAMANHO_PADRAO];
    }

    public void setNumeros(int[] numeros) {
        this.numeros = numeros;
    }

    public int[] getNumeros() {
        return Arrays.copyOf(numeros, numeros.length);
    }

    public double calcularMedia() {
        return Arrays.stream(numeros).average().orElse(0.0);
    }

    public void ordenarVetor() {
        Arrays.sort(numeros);
    }

    public int[] obterVetorInvertido() {
        int[] invertido = Arrays.copyOf(numeros, numeros.length);
        for (int i = 0; i < invertido.length / 2; i++) {
            int temp = invertido[i];
            invertido[i] = invertido[invertido.length - 1 - i];
            invertido[invertido.length - 1 - i] = temp;
        }
        return invertido;
    }

    public int buscarNumero(int numero) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public int[] calcularSomaParesImpares() {
        int somaPares = 0;
        int somaImpares = 0;
        
        for (int numero : numeros) {
            if (numero % 2 == 0) {
                somaPares += numero;
            } else {
                somaImpares += numero;
            }
        }
        
        return new int[]{somaPares, somaImpares};
    }

    public int[] encontrarMaiorMenor() {
        if (numeros.length == 0) {
            return new int[]{0, 0};
        }
        
        int maior = numeros[0];
        int menor = numeros[0];
        
        for (int numero : numeros) {
            if (numero > maior) maior = numero;
            if (numero < menor) menor = numero;
        }
        
        return new int[]{maior, menor};
    }
}