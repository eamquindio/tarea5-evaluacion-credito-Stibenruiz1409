package edu.eam.ingesoft.logica.credito;

/**
 * Clase que representa una evaluación de crédito para la entidad financiera FinAurora.
 * Permite calcular cuotas mensuales y evaluar la aprobación de créditos según reglas de negocio.
 */
public class EvaluacionCredito {
    

    private String nombreSolicitante;
    private double ingresosMensuales;
    private int numeroCreditosActivos;
    private int puntajeCredito;
    private double valorCreditoSolicitado;
    private boolean tieneCodedor;
    
    /**
     * Constructor de la clase EvaluacionCredito.
     * 
     * @param nombreSolicitante Nombre completo del solicitante del crédito
     * @param ingresosMensuales Ingresos mensuales del solicitante en pesos
     * @param numeroCreditosActivos Cantidad de créditos activos que tiene el solicitante
     * @param puntajeCredito Puntaje crediticio del solicitante (0-1000)
     * @param valorCreditoSolicitado Monto del crédito solicitado en pesos
     * @param tieneCodedor Indica si el solicitante cuenta con un codeudor
     */
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
    
    /**
     * Calcula la tasa de interés mensual a partir de la tasa nominal anual.
     * 
     * @param tasaNominalAnual Tasa nominal anual en porcentaje
     * @return Tasa mensual en porcentaje
     */
    public double calcularTasaMensual(double tasaNominalAnual) {
        return 1;
    }
    
    /**
     * Calcula la cuota mensual del crédito usando la fórmula de amortización francesa.
     * Formula: Cuota = M * (im * (1+im)^n) / ((1+im)^n - 1)
     * 
     * @param tasaNominalAnual Tasa nominal anual en porcentaje
     * @param plazoMeses Plazo del crédito en meses
     * @return Valor de la cuota mensual en pesos
     */
    public double calcularCuotaMensual(double tasaNominalAnual, int plazoMeses) {
        return 0;
    }
    
    /**
     * Evalúa si el crédito debe ser aprobado según las reglas de negocio:
     * - Perfil bajo (puntaje < 500): Rechazo automático
     * - Perfil medio (500 ≤ puntaje ≤ 700): Requiere codeudor y cuota ≤ 25% de ingresos
     * - Perfil alto (puntaje > 700 y < 2 créditos): Cuota ≤ 30% de ingresos
     * 
     * @param tasaNominalAnual Tasa nominal anual en porcentaje
     * @param plazoMeses Plazo del crédito en meses
     * @return true si el crédito es aprobado, false si es rechazado
     */
    public boolean evaluarAprobacion(double tasaNominalAnual, int plazoMeses) {

        
        return false;
    }
    
    /**
     * Obtiene el nombre del solicitante.
     * @return Nombre completo del solicitante
     */
    public String getNombreSolicitante() {
        return nombreSolicitante;
    }
    
    /**
     * Establece el nombre del solicitante.
     * @param nombreSolicitante Nombre completo del solicitante
     */
    public void setNombreSolicitante(String nombreSolicitante) {
        this.nombreSolicitante = nombreSolicitante;
    }
    
    /**
     * Obtiene los ingresos mensuales del solicitante.
     * @return Ingresos mensuales en pesos
     */
    
    public double getIngresosMensuales() {
        return ingresosMensuales;
    }
    
    /**
     * Establece los ingresos mensuales del solicitante.
     * @param ingresosMensuales Ingresos mensuales en pesos
     */
    public void setIngresosMensuales(double ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }
    
    /**
     * Obtiene el número de créditos activos del solicitante.
     * @return Cantidad de créditos activos
     */
    public int getNumeroCreditosActivos() {
        return numeroCreditosActivos;
    }
    
    /**
     * Establece el número de créditos activos del solicitante.
     * @param numeroCreditosActivos Cantidad de créditos activos
     */
    public void setNumeroCreditosActivos(int numeroCreditosActivos) {
        this.numeroCreditosActivos = numeroCreditosActivos;
    }
    
    /**
     * Obtiene el puntaje de crédito del solicitante.
     * @return Puntaje crediticio (0-1000)
     */
    public int getPuntajeCredito() {
        return puntajeCredito;
    }
    
    /**
     * Establece el puntaje de crédito del solicitante.
     * @param puntajeCredito Puntaje crediticio (0-1000)
     */
    public void setPuntajeCredito(int puntajeCredito) {
        this.puntajeCredito = puntajeCredito;
    }
    
    /**
     * Obtiene el valor del crédito solicitado.
     * @return Monto del crédito en pesos
     */
    public double getValorCreditoSolicitado() {
        return valorCreditoSolicitado;
    }
    
    /**
     * Establece el valor del crédito solicitado.
     * @param valorCreditoSolicitado Monto del crédito en pesos
     */
    public void setValorCreditoSolicitado(double valorCreditoSolicitado) {
        this.valorCreditoSolicitado = valorCreditoSolicitado;
    }
    
    /**
     * Verifica si el solicitante tiene codeudor.
     * @return true si tiene codeudor, false en caso contrario
     */
    public boolean isTieneCodedor() {
        return tieneCodedor;
    }
    
    /**
     * Establece si el solicitante tiene codeudor.
     * @param tieneCodedor true si tiene codeudor, false en caso contrario
     */
    public void setTieneCodedor(boolean tieneCodedor) {
        this.tieneCodedor = tieneCodedor;
    }
}