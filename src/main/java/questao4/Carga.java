
package questao5;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author RODOLFO ROCHA
 */
@Entity
public class Carga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codCarga;
    
    //ENUNS DE PAISES
    @Enumerated(EnumType.STRING)
    private Paises origem;
    @Enumerated(EnumType.STRING)
    private Paises destino;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private double valor;
    
    //RELACIONAMENTOS
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Produto> produtos;
    
    @OneToOne(mappedBy = "carga")
    private Navio navio;
    
    
    //METODOS

    public Navio getNavio() {
        return navio;
    }

    public void setNavio(Navio navio) {
        this.navio = navio;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
    
    public Paises getOrigem() {
        return origem;
    }

    public void setOrigem(Paises origem) {
        this.origem = origem;
    }

    public Paises getDestino() {
        return destino;
    }

    public void setDestino(Paises destino) {
        this.destino = destino;
    }

    public Long getCodCarga() {
        return codCarga;
    }

    public void setCodCarga(Long codCarga) {
        this.codCarga = codCarga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarga != null ? codCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the codCarga fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.codCarga == null && other.codCarga != null) || (this.codCarga != null && !this.codCarga.equals(other.codCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "questao5.Carga[ id=" + codCarga + " ]";
    }
    
}
