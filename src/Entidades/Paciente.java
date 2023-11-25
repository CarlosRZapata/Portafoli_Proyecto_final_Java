package Entidades;

import java.io.Serializable;
import java.util.Date;
public class Paciente implements Serializable {

    String IDPaciente;
    public String getIDPaciente() {
        return IDPaciente;
    }

    public void setIDPaciente(String IDPaciente) {
        this.IDPaciente = IDPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public Date getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        FechaNac = fechaNac;
    }

    String nombre;
    String apPaterno;
    String apMaterno;
    Date FechaNac;
}
