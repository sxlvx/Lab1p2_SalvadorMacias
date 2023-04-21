package com.mycompany.lab1p2_salvadormacias;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Lab1p2_salvadormacias {

    public static Scanner lea = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        boolean salir = true;
        do {
            System.out.println("---Bienvenido al menu---");
            System.out.println();

            System.out.println("Opciones disponibles:\n1.Calculadora de fechas\n2.Numeros palindromos\n3.Salir");
            System.out.println("Ingrese opcion: ");
            int opc = lea.nextInt();
            switch (opc) {
                case 1: {
                    Scanner scanner = new Scanner(System.in);
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    System.out.print("Ingrese una fecha en formato dd/MM/yyyy: ");
                    String fechaString = scanner.nextLine();
                    LocalDate fecha = LocalDate.parse(fechaString, formatter);
                    LocalDate fechaActual = LocalDate.of(2023, 4, 21);
                    System.out.println("La fecha ingresada es: " + fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    System.out.println("La fecha actual es: " + fechaActual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                    long dias = ChronoUnit.DAYS.between(fecha, fechaActual);
                    System.out.println("La diferencia en días entre ambas fechas es: " + Math.abs(dias));
                    long meses = ChronoUnit.MONTHS.between(fecha, fechaActual);
                    System.out.println("La diferencia en meses entre ambas fechas es: " + Math.abs(meses));
                    long anos = ChronoUnit.YEARS.between(fecha, fechaActual);
                    System.out.println("La diferencia en años entre ambas fechas es: " + Math.abs(anos));

                    System.out.println("-----------------------------------------------");

                }//fin case 1
                break;
                case 2: {
                    System.out.print("Ingrese la cantidad de dígitos del número (debe ser impar): ");
                    int num_D = lea.nextInt();
                    if ((num_D % 2 == 0) || (num_D <= 1)) {
                        System.out.println("La cantidad de dígitos debe ser impar y/o tiene que ser mayor a 1.");
                        return;
                    }
                    int[] digitos = new int[num_D];
                    System.out.println("Ingrese los dígitos del número uno por uno:");
                    int rep = 0;
                    while (rep < num_D) {
                        digitos[rep] = lea.nextInt();
                        rep++;
                    }
                    if (Palindromo(digitos, 0, num_D - 1)) {
                        System.out.print("El número ");
                        int i = 0;
                        do {
                            System.out.print(digitos[i]);
                            i++;
                        } while (i < num_D);
                        System.out.println(" es palíndromo.");
                    } else {
                        int j = 0;
                        System.out.print("El número ");
                        do {
                            System.out.print(digitos[j]);
                            j++;
                        } while (j < num_D);
                        System.out.println(" no es palíndromo.");
                    }
                    System.out.println("-----------------------------------------------");

                }//fin case 2
                break;
                case 3: {
                    salir = false;
                    System.out.println("Se abandonara el programa");

                }//fin case 3
                break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    System.out.println("-----------------------------------------------");
            }

        } while (salir != false);
    }//fin menu

    public static boolean Palindromo(int[] digitos, int der, int izq) {
        if (der >= izq) {
            return true;
        } else if (digitos[der] != digitos[izq]) {
            return false;
        } else {
            return Palindromo(digitos, der + 1, izq - 1);
        }
    }
}//fin clase
