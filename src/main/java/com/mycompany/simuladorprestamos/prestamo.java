package com.mycompany.simuladorprestamos;

import java.math.BigDecimal;

public class prestamo {
    private BigDecimal monto;
    private double tasaAnual;
    private int meses;

    public prestamo(BigDecimal monto, double tasaAnual, int meses) {
        this.monto = monto;
        this.tasaAnual = tasaAnual;
        this.meses = meses;
    }

    // Getters
    public BigDecimal getMonto() { return monto; }
    public double getTasaAnual() { return tasaAnual; }
    public int getMeses() { return meses; }
}