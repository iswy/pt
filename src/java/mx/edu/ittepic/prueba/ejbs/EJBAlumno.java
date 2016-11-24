/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.prueba.ejbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.edu.ittepic.prueba.entidades.Alumno;
import mx.edu.ittepic.prueba.entidades.Semestre;
import mx.edu.ittepic.prueba.util.Message;

/**
 *
 * @author pi
 */
@Stateless
public class EJBAlumno
{

    @PersistenceContext
    private EntityManager entity;

    public String newAlumno( String nombre , String apellido , String semestre )
    {

        Message m = new Message();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Semestre semestreid = entity.find( Semestre.class , Integer.parseInt( semestre ) );

        Alumno alumno = new Alumno();
        alumno.setNombre( nombre );
        alumno.setApellido( apellido );
        alumno.setIdsemestre( semestreid );

        entity.persist( entity );
        entity.flush();

        m.setCode( 200 );
        m.setMsg( "Bien" );
        m.setDetail( "Ok" );

        return gson.toJson( m );
    }
}
