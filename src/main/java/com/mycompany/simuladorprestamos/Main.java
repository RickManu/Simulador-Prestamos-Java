package com.mycompany.simuladorprestamos;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CalculadoraService calc = new CalculadoraService();

        System.out.println("--- SIMULADOR FINANCIERO COTONEB ---");
        System.out.print("Ingrese el monto del prestamo (Q): ");
        BigDecimal monto = sc.nextBigDecimal();
        
        System.out.print("Ingrese la tasa de interes anual (%): ");
        double tasa = sc.nextDouble();
        
        System.out.print("Ingrese el plazo en meses: ");
        int meses = sc.nextInt();

        prestamo p = new prestamo(monto, tasa, meses);
        BigDecimal cuota = calc.calcularCuota(p);

        System.out.println("\nCUOTA MENSUAL FIJA: Q" + cuota);
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-5s | %-12s | %-12s | %-12s\n", "Mes", "Interes", "Capital", "Saldo");
        System.out.println("-------------------------------------------------------");

        BigDecimal saldo = monto;
        double tasaMensual = (tasa / 100) / 12;

        for (int i = 1; i <= meses; i++) {
            BigDecimal interesMes = saldo.multiply(BigDecimal.valueOf(tasaMensual)).setScale(2, java.math.RoundingMode.HALF_UP);
            BigDecimal capitalMes = cuota.subtract(interesMes);
            saldo = saldo.subtract(capitalMes);

            System.out.printf("%-5d | Q%-11s | Q%-11s | Q%-11s\n", i, interesMes, capitalMes, saldo.abs());
        }
    }
}