package edu.eam.ingesoft.logica.credito;

public class EvaluacionCredito {

    private String nombreSolicitante;
    private double ingresosMensuales;
    private int numeroCreditosActivos;
    private int puntajeCredito;
    private double valorCreditoSolicitado;
    private boolean tieneCodeudor;

    // Constructor
    public EvaluacionCredito(String nombreSolicitante, double ingresosMensuales,
                             int numeroCreditosActivos, int puntajeCredito,
                             double valorCreditoSolicitado, boolean tieneCodeudor) {
        this.nombreSolicitante = nombreSolicitante;
        this.ingresosMensuales = ingresosMensuales;
        this.numeroCreditosActivos = numeroCreditosActivos;
        this.puntajeCredito = puntajeCredito;
        this.valorCreditoSolicitado = valorCreditoSolicitado;
        this.tieneCodeudor = tieneCodeudor;
    }

    // Calcular tasa mensual (simplificado)
    public double calcularTasaMensual(double tasaNominalAnual) {
        double tasa = tasaNominalAnual / 12;
        return tasa;
    }

    // Calcular cuota mensual (simplificado con if/else)
    public double calcularCuotaMensual(double tasaNominalAnual, int plazoMeses) {
        double tasaMensual = calcularTasaMensual(tasaNominalAnual);

        if (tasaMensual == 0) {
            return valorCreditoSolicitado / plazoMeses;
        } else {
            // Cálculo muy básico (sin fórmula completa)
            double interes = valorCreditoSolicitado * (tasaMensual / 100);
            double cuota = (valorCreditoSolicitado + interes) / plazoMeses;
            return cuota;
        }
    }

    // Evaluar aprobación con if/else básicos
    public boolean evaluarAprobacion(double tasaNominalAnual, int plazoMeses) {
        double cuota = calcularCuotaMensual(tasaNominalAnual, plazoMeses);

        if (puntajeCredito < 500) {
            return false; // perfil bajo
        } else {
            if (puntajeCredito >= 500 && puntajeCredito <= 700) {
                if (tieneCodeudor) {
                    if (cuota <= ingresosMensuales * 0.25) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                if (puntajeCredito > 700) {
                    if (numeroCreditosActivos < 2) {
                        if (cuota <= ingresosMensuales * 0.30) {
                            return true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    // Getters y setters
    public String getNombreSolicitante() {
        return nombreSolicitante;
    }

    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }

    public double getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public int getNumeroCreditosActivos() {
        return numeroCreditosActivos;
    }

    public void setNumeroCreditosActivos(int numeroCreditosActivos) {
        this.numeroCreditosActivos = numeroCreditosActivos;
    }

    public int getPuntajeCredito() {
        return puntajeCredito;
    }

    public void setPuntajeCredito(int puntajeCredito) {
        this.puntajeCredito = puntajeCredito;
    }

    public double getValorCreditoSolicitado() {
        return valorCreditoSolicitado;
    }

    public void setValorCreditoSolicitado(double valorCreditoSolicitado) {
        this.valorCreditoSolicitado = valorCreditoSolicitado;
    }

    public boolean isTieneCodeudor() {
        return tieneCodeudor;
    }

    public void setTieneCodeudor(boolean tieneCodeudor) {
        this.tieneCodeudor = tieneCodeudor;
    }
}