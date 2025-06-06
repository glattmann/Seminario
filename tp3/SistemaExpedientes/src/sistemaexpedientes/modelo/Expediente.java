package sistemaexpedientes.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author GL
 */
/**
 * Representa un expediente en el sistema. Guarda toda la info básica,
 * como el número, fecha, estado, contribuyente, etc.
 */
public class Expediente {

    // Atributos principales
    private int idExpediente;
    private int numero;
    private String letra;
    private int anio;
    private Date fechaHora;
    private String estado;
    private TipoTramite tipoTramite;
    private Rubro rubro;
    private Contribuyente contribuyente;
    private String observaciones;

    // Otras listas que puede tener el expediente
    private List<ActuacionSectorial> actuaciones; // lo que hace cada sector
    private List<Movimiento> movimientos; // para el seguimiento del trámite
    private List<Boolean> requisitos; // checkboxes del checklist


    // Constructor completo
    public Expediente(int idExpediente, int numero, String letra, int anio,
                      Date fechaHora, String estado, TipoTramite tipoTramite,
                      Rubro rubro, Contribuyente contribuyente, String observaciones) {
        this.idExpediente = idExpediente;
        this.numero = numero;
        this.letra = letra;
        this.anio = anio;
        this.fechaHora = fechaHora;
        this.estado = estado;
        this.tipoTramite = tipoTramite;
        this.rubro = rubro;
        this.contribuyente = contribuyente;
        this.observaciones = observaciones;
        this.actuaciones = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }

    // Constructor por defecto
    public Expediente() {
        this.actuaciones = new ArrayList<>();
        this.movimientos = new ArrayList<>();
    }

    // Getters y setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    public void setContribuyente(Contribuyente contribuyente) {
        this.contribuyente = contribuyente;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
        this.rubro = rubro;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    // Devuelve la identificación del expediente (número-letra-año)
    public String getNomenclatura() {
        return numero + "-" + letra + "-" + anio;
    }
    // Cambia el estado del expediente
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
    // Marca el expediente como cerrado, pero solo si está todo completo
    public void cerrar() {
        if (esCircuitoCompleto()) {
            this.estado = "Cerrado";
        } else {
            throw new IllegalStateException("El circuito del expediente no está completo.");
        }
    }
    // Agrega una observación al expediente (no borra las anteriores)
    public void registrarObservacion(String obs) {
        this.observaciones = (this.observaciones == null ? "" : this.observaciones + "\n") + obs;
    }

    public boolean esChecklistCompleto() {
        return true;
    }
    // Devuelve true si todas las actuaciones fueron aprobadas
    public boolean actuacionesCompletadas() {
        return actuaciones.stream().allMatch(ActuacionSectorial::esAprobada);
    }

    public boolean inspeccionAprobada() {
        return true;
    }

    public boolean visadoFirmado() {
        return true;
    }

    public boolean pagoRegistrado() {
        return true;
    }
    // Chequea si se completó todo lo necesario para cerrarlo
    public boolean esCircuitoCompleto() {
        return esChecklistCompleto()
                && actuacionesCompletadas()
                && inspeccionAprobada()
                && visadoFirmado()
                && pagoRegistrado();
    }
    // Para guardar o cargar los checks del checklist
    public List<Boolean> getRequisitos() {
    return requisitos;
    }

    public void setRequisitos(List<Boolean> requisitos) {
        this.requisitos = requisitos;
    }


    // Métodos para manejar asociaciones
    public void agregarActuacion(ActuacionSectorial actuacion) {
        this.actuaciones.add(actuacion);
    }

    public void agregarMovimiento(Movimiento movimiento) {
        this.movimientos.add(movimiento);
    }

    public List<ActuacionSectorial> getActuaciones() {
        return actuaciones;
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    @Override
    public String toString() {
        return "Expediente " + getNomenclatura() + " | " +
           (contribuyente != null ? contribuyente.getNombreCompleto() : "Sin contribuyente");
    }

}