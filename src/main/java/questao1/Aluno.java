
package Questao_1;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author RODOLFO ROCHA
 */
@Entity
@Table(name = "Aluno")
public class Aluno extends Pessoa implements Serializable {
    //ATRIBUTOS DA CLASSE
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Aluno")
    private Long id;
    
    @Column(name="Matricula")
    private String matricula;
    
    @Column(name="Turma")
    private String turma;
    
    @Temporal(TemporalType.DATE)
    @Column(name="Data de Ingresso")
    private Date dataDeIngresso;
    
    //METODOS GETTERS E SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Date getDataDeIngresso() {
        return dataDeIngresso;
    }

    public void setDataDeIngresso(Date dataDeIngresso) {
        this.dataDeIngresso = dataDeIngresso;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao_1.Aluno[ id=" + id + " ]";
    }
    
}
