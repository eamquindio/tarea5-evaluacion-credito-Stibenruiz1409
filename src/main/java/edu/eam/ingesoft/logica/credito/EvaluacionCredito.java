package edu.eam.ingesoft.logica.credito;

public class EvaluacionCredito {

    private String nombreSolicitante;
    private double ingresosMensuales;
    private int numeroCreditosActivos;
    private int puntajeCredito;
    private double valorCreditoSolicitado;
    private boolean tieneCodedor;
    
    public EvaluacionCredito(String nombreSolicitante, double ingresosMensuales, 
                            int numeroCreditosActivos, int puntajeCredito, 
                            double valorCreditoSolicitado, boolean tieneCodedor) {
        this.nombreSolicitante = nombreSolicitante;
        this.ingresosMensuales = ingresosMensuales;
        this.numeroCreditosActivos = numeroCreditosActivos;
        this.puntajeCredito = puntajeCredito;
        this.valorCreditoSolicitado = valorCreditoSolicitado;
        this.tieneCodedor = tieneCodedor;
    }
    
    public double calcularTasaMensual(double tasaNominalAnual) {
        return (tasaNominalAnual / 100.0) / 12.0;
    }
     
    public double calcularCuotaMensual(double tasaNominalAnual, int plazoMeses) {
        double im = calcularTasaMensual(tasaNominalAnual); 
        if (im == 0) {
            return valorCreditoSolicitado / plazoMeses; 
        }
        double factor = Math.pow(1 + im, plazoMeses);
        double cuota = valorCreditoSolicitado * (im * factor) / (factor - 1);
        return Math.round(cuota * 100.0) / 100.0; 
    }
    
    
    public boolean evaluarAprobacion(double tasaNominalAnual, int plazoMeses) {
        double cuota = calcularCuotaMensual(tasaNominalAnual, plazoMeses);

        
        if (puntajeCredito < 500) {
            return false;
        }
        
        if (puntajeCredito >= 500 && puntajeCredito <= 700) {
            return tieneCodedor && cuota <= ingresosMensuales * 0.25;
        }
        
        if (puntajeCredito > 700 && numeroCreditosActivos < 2) {
            return cuota <= ingresosMensuales * 0.30;
        }

        return false;
    }
    
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
    public boolean isTieneCodedor() { return tieneCodedor; }
    public void setTieneCodedor(boolean tieneCodedor) { this.tieneCodedor = tieneCodedor; }
}