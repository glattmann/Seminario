/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaexpedientes.modelo;

/**
 *
 * @author GL
 */
public class Requisito {

    private int idRequisito;
    private String descripcion;
    private boolean obligatorio;

    public Requisito() {
    }

    public Requisito(int idRequisito, String descripcion, boolean obligatorio) {
        this.idRequisito = idRequisito;
        this.descripcion = descripcion;
        this.obligatorio = obligatorio;
    }

    public int getIdRequisito() {
        return idRequisito;
    }

    public void setIdRequisito(int idRequisito) {
        this.idRequisito = idRequisito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isObligatorio() {
        return obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        this.obligatorio = obligatorio;
    }
    // Método que serviría más adelante para verificar si el requisito aplica a cierto tipo de trámite
    public boolean esValidoPara(String tipoTramite) {
        
        return true;
    }
}
