
package questao5;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author RODOLFO ROCHA
 */
@Entity
public class Navio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codNavio;
    
    private String nome;
    private double capacidade;
    
    @Enumerated(EnumType.STRING)
    private Paises pais;
    
    //RELACIONAMENTO
    @OneToOne(cascade = {CascadeType.ALL})
    private Carga carga;
    
    //METODOS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public Carga getCarga() {
        return carga;
    }

    public void setCarga(Carga carga) {
        this.carga = carga;
    }
    
    public Long getCodNavio() {
        return codNavio;
    }

    public void setCodNavio(Long codNavio) {
        this.codNavio = codNavio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codNavio != null ? codNavio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codNavio fields are not set
        if (!(object instanceof Navio)) {
            return false;
        }
        Navio other = (Navio) object;
        if ((this.codNavio == null && other.codNavio != null) || (this.codNavio != null && !this.codNavio.equals(other.codNavio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "questao5.Navio[ id=" + codNavio + " ]";
    }
    
}
