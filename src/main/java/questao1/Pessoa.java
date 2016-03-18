
package Questao_1;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author RODOLFO ROCHA
 */
@MappedSuperclass
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Pessoa implements Serializable {
    //ATRIBUTOS DA CLASSE
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Pessoa")
    private Long id;
    
    @Column(name="Nome")
    private String nome;
    
    @Column(name="CPF")
    private String cpf;
    
    @Column(name="Idade")
    private int idade;
    
    @Column(name="Data de Nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_Endereco")
    @Column(name="Endereço")
    private Endereco endereco;
    
    //METODOS GETTERS E SETTERS

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        if (!(object instanceof Pessoa)) {
            return false;
        }
        Pessoa other = (Pessoa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Questao_1.Pessoa[ id=" + id + " ]";
    }
    
}
