package edu.eam.ingesoft.logica.credito;

public class EvaluacionCredito {

    private String nombreSolicitante;
    private double ingresosMensuales;
    private int numeroCreditosActivos;
    private int puntajeCredito;
    private double valorCreditoSolicitado;
    private boolean tieneCodeudor;  // ✅ corregido

    public EvaluacionCredito(String nombreSolicitante, double ingresosMensuales,
                             int numeroCreditosActivos, int puntajeCredito,
                             double valorCreditoSolicitado, boolean tieneCodeudor) {
        this.nombreSolicitante = nombreSolicitante;
        this.ingresosMensuales = ingresosMensuales;
        this.numeroCreditosActivos = numeroCreditosActivos;
        this.puntajeCredito = puntajeCredito;
        this.valorCreditoSolicitado = valorCreditoSolicitado;
        this.tieneCodeudor = tieneCodeudor; // ✅ corregido
    }

    // Calcula tasa mensual a partir de la tasa nominal anual
    public double calcularTasaMensual(double tasaNominalAnual) {
        return (tasaNominalAnual / 100.0) / 12.0;
    }

    // Calcula la cuota mensual según el método francés
    public double calcularCuotaMensual(double tasaNominalAnual, int plazoMeses) {
        double im = calcularTasaMensual(tasaNominalAnual);
        if (im == 0) {
            return valorCreditoSolicitado / plazoMeses;
        }
        double factor = Math.pow(1 + im, plazoMeses);
        double cuota = valorCreditoSolicitado * (im * factor) / (factor - 1);
        return Math.round(cuota * 100.0) / 100.0;
    }

    // Evalúa si el crédito es aprobado o no según reglas de negocio
    public boolean evaluarAprobacion(double tasaNominalAnual, int plazoMeses) {
        double cuota = calcularCuotaMensual(tasaNominalAnual, plazoMeses);

        if (puntajeCredito < 500) {
            return false;
        } else if (puntajeCredito >= 500 && puntajeCredito <= 700) {
            return tieneCodeudor && cuota <= ingresosMensuales * 0.25;
        } else if (puntajeCredito > 700 && numeroCreditosActivos < 2) {
            return cuota <= ingresosMensuales * 0.30;
        } else {
            return false;
        }
    }

    // Getters y Setters
    public String getNombreSolicitante() { return nombreSolicitante; }
    public void setNombreSolicitante(String nombreSolicitante) { this.nombreSolicitante = nombreSolicitante; }

    public double getIngresosMensuales() { return ingresosMensuales; }
    public void setIngresosMensuales(double ingresosMensuales) { this.ingresosMensuales = ingresosMensuales; }

    public int getNumeroCreditosActivos() { return numeroCreditosActivos; }
    public void setNumeroCreditosActivos(int numeroCreditosActivos) { this.numeroCreditosActivos = numeroCreditosActivos; }

    public int getPuntajeCredito() { return puntajeCredito; }
    public void setPuntajeCredito(int puntajeCredito) { this.puntajeCredito = puntajeCredito; }

    public double getValorCreditoSolicitado() { return valorCreditoSolicitado; }
    public void setValorCreditoSolicitado(double valorCreditoSolicitado) { this.valorCreditoSolicitado = valorCreditoSolicitado; }

    public boolean isTieneCodeudor() { return tieneCodeudor; }
    public void setTieneCodeudor(boolean tieneCodeudor) { this.tieneCodeudor = tieneCodeudor; }
}
