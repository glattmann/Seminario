/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

/**
 * Representa un ítem de control dentro del checklist de requisitos
 * para un expediente del sector Comercio.
 * 
 * Cada instancia de esta clase almacena:
 * - El expediente al que pertenece el checklist.
 * - El requisito asociado.
 * - Si el requisito fue cumplido o no.
 * - Una observación opcional sobre el requisito.
 * 
 * @author GL
 */
public class ChecklistRequisitoComercio {

    private int id;
    private int idExpediente;
    private Expediente expediente;
    private Requisito requisito;
    private boolean cumplido;
    private String observaciones;
    

    
     //Constructor por defecto. 
    public ChecklistRequisitoComercio() {}

    public ChecklistRequisitoComercio(Expediente expediente, Requisito requisito, boolean cumplido, String observaciones) {
        this.expediente = expediente;
        this.requisito = requisito;
        this.cumplido = cumplido;
        this.observaciones = observaciones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getIdExpediente() {
    return idExpediente;
    }

    public void setIdExpediente(int idExpediente) {
        this.idExpediente = idExpediente;
    }


    public Expediente getExpediente() {
        return expediente;
    }

    public void setExpediente(Expediente expediente) {
        this.expediente = expediente;
    }

    public Requisito getRequisito() {
        return requisito;
    }

    public void setRequisito(Requisito requisito) {
        this.requisito = requisito;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
