package com.mycompany.simuladorprestamos;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraService {
    public BigDecimal calcularCuota(prestamo p) {
        double tasaMensual = (p.getTasaAnual() / 100) / 12;
        double factor = Math.pow(1 + tasaMensual, p.getMeses());
            
        BigDecimal numerador = p.getMonto().multiply(BigDecimal.valueOf(tasaMensual * factor));
        BigDecimal denominador = BigDecimal.valueOf(factor - 1);
        
        return numerador.divide(denominador, 2, RoundingMode.HALF_UP);
    }
}