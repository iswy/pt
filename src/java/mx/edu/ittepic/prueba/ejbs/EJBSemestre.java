/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.prueba.ejbs;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import mx.edu.ittepic.prueba.entidades.Semestre;
import mx.edu.ittepic.prueba.util.Message;

/**
 *
 * @author pi
 */
@Stateless
public class EJBSemestre
{

    @PersistenceContext
    private EntityManager entity;

    public String newSemestre( String nombre )
    {

        Message m = new Message();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        try
        {

            Semestre semestre = new Semestre();
            semestre.setNomSemestre( Integer.parseInt( nombre ) );

            entity.persist( semestre );
            entity.flush();
            m.setCode( 200 );
            m.setMsg( "Bien" );
            m.setDetail( "Ok" );
        }
        catch ( Exception e )
        {

            m.setCode( 200 );
            m.setMsg( e.toString() + "nombre: " + nombre );
            m.setDetail( "Ok" );
        }
        return gson.toJson( m );
    }

    public String getSemestres()
    {
        List<Semestre> semestres;
        Message m = new Message();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Query q = entity.createNamedQuery( "Semestre.findAll" );
        semestres = q.getResultList();

        String msg = gson.toJson( semestres );
        m.setCode( 200 );
        m.setMsg( msg );
        m.setDetail( "Ok" );

        return gson.toJson( m );
    }
}
