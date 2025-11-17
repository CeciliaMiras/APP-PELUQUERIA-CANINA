
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import com.mycompany.peluqueriacanina.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladora {
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        //Creamos el dueño y asignamos sus valores
        Duenio duenio=new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        //Creamos la mascota y asignamos sus valore
        Mascota masco=new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUn_duenio(duenio);
        controlPersis.guardar(duenio,masco);
    }

    

    public List<Mascota> traerMascota() {
    return controlPersis.traerMascotas();
    }

    public void borrarMasocta(int num_cliente) {
        try {
            controlPersis.borrarMascota(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMasocta(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);
        //modifico mascota
        controlPersis.modificarMasocta(masco);
        //seteo nuevo valores del dueño
        Duenio duenio=this.buscarDuenio(masco.getUn_duenio().getId_duenio());
        duenio.setCelDuenio(celDuenio);
        duenio.setNombre(nombreDuenio);
        //llamar al modificar dueño 
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
       controlPersis.modificarDuenio(duenio);
    }
}
