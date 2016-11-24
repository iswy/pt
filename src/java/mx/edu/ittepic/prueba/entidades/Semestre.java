/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.ittepic.prueba.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pi
 */
@Entity
@Table( name = "semestre" )
@XmlRootElement
@NamedQueries(
{
    @NamedQuery( name = "Semestre.findAll" , query = "SELECT s FROM Semestre s" )
    , @NamedQuery( name = "Semestre.findByIdsemestre" , query = "SELECT s FROM Semestre s WHERE s.idsemestre = :idsemestre" )
    , @NamedQuery( name = "Semestre.findByNomSemestre" , query = "SELECT s FROM Semestre s WHERE s.nomSemestre = :nomSemestre" )
} )
public class Semestre implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Basic( optional = false )
    @Column( name = "idsemestre" )
    private Integer idsemestre;
    @Column( name = "nom_semestre" )
    private Integer nomSemestre;
    /*@OneToMany( mappedBy = "idsemestre" )
    private List<Alumno> alumnoList;
     */

    public Semestre()
    {
    }

    public Semestre( Integer idsemestre )
    {
        this.idsemestre = idsemestre;
    }

    public Integer getIdsemestre()
    {
        return idsemestre;
    }

    public void setIdsemestre( Integer idsemestre )
    {
        this.idsemestre = idsemestre;
    }

    public Integer getNomSemestre()
    {
        return nomSemestre;
    }

    public void setNomSemestre( Integer nomSemestre )
    {
        this.nomSemestre = nomSemestre;
    }

    /*
    @XmlTransient
    public List<Alumno> getAlumnoList()
    {
        return alumnoList;
    }

    public void setAlumnoList( List<Alumno> alumnoList )
    {
        this.alumnoList = alumnoList;
    }
    */
    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += ( idsemestre != null ? idsemestre.hashCode() : 0 );
        return hash;
    }

    @Override
    public boolean equals( Object object )
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if ( !( object instanceof Semestre ) )
        {
            return false;
        }
        Semestre other = ( Semestre ) object;
        if ( ( this.idsemestre == null && other.idsemestre != null ) || ( this.idsemestre != null && !this.idsemestre.equals( other.idsemestre ) ) )
            return false;
        return true;
    }

    @Override
    public String toString()
    {
        return "mx.edu.ittepic.prueba.entidades.Semestre[ idsemestre=" + idsemestre + " ]";
    }

}
