
package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;


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
}
