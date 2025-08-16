package med.voll.api.direccion;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.Medico;

@Getter //Genera los getters con la dependencia lombok
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class Direccion {
    private String calle;
    private String numer;
    private String complemento;
    private String barrio;
    private String ciudad;
    private String codigo_postal;
    private String estado;

    public Direccion(DatosDireccion datosDireccion) {
        this.calle = datosDireccion.calle();
        this.numer = datosDireccion.numero();
        this.complemento = datosDireccion.complemento();
        this.barrio = datosDireccion.barrio();
        this.ciudad = datosDireccion.ciudad();
        this.codigo_postal = datosDireccion.codigo_postal();
        this.estado = datosDireccion.estado();
    }
}
