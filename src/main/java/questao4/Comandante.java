/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao5;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author RODOLFO ROCHA
 */
@Entity
public class Comandante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codComandante;
    
    private String nome;
    
    @Enumerated(EnumType.STRING)
    private Paises pais;
    
    //RELACIONAMENTO
    @OneToMany(cascade={CascadeType.ALL})
    private List<Navio> navios;

    //METODOS
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Paises getPais() {
        return pais;
    }

    public void setPais(Paises pais) {
        this.pais = pais;
    }

    public List<Navio> getNavios() {
        return navios;
    }

    public void setNavios(List<Navio> navios) {
        this.navios = navios;
    }
    
    public Long getCodComandante() {
        return codComandante;
    }

    public void setCodComandante(Long codComandante) {
        this.codComandante = codComandante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codComandante != null ? codComandante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codComandante fields are not set
        if (!(object instanceof Comandante)) {
            return false;
        }
        Comandante other = (Comandante) object;
        if ((this.codComandante == null && other.codComandante != null) || (this.codComandante != null && !this.codComandante.equals(other.codComandante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "questao5.Comandante[ id=" + codComandante + " ]";
    }
    
}
