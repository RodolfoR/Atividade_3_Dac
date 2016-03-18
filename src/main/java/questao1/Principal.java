
package Questao_1;

import dao.DaoJPA;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * @author RODOLFO ROCHA
 */
public class Principal {
    DaoJPA dao = new DaoJPA("edu.ifpb.dac_dac-atividade3_jar_1.0-SNAPSHOTPU");
    
    public List<Livro> letraA(){
        try {
            Query query = dao.getEm().createQuery("SELECT l FROM Livro l INNER JOIN l.autor a where a.dataNascimento!='21-11-1982' ");
            
            List<Livro> livrosQuery = query.getResultList(); 
            
            return livrosQuery;
            
        }catch (EntityNotFoundException | NonUniqueResultException notFound  ) {
            notFound.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        
        Autor autor = new Autor();
        Livro livro = new Livro();
        
        List<Livro> livros = null;
        
        livro.setTitulo("Java");
        livro.setISBN("01");        
        livro.setLancamento(null);
        //livros.add(livro);
        
        
        DaoJPA dao = new DaoJPA("Dac_Atividade3UP");
//        if (dao.save(livro)) {
//            JOptionPane.showMessageDialog(null, "add com sucesso");
//        } else {
//            JOptionPane.showConfirmDialog(null, "erro ao salvar");
//        }
        System.out.println("Ate aki funcionou");
//        autor.setNome("Job");
//        autor.setIdade(26);
//        autor.setDataNascimento(null);
//        autor.setInstituicaoVinculada("IFPB");
//        autor.setCpf("0000332266789");
//        autor.setLivros(livros);
//        
//        
//        //DaoJPA dao = new DaoJPA("edu.ifpb.dac_dac-atividade3_jar_1.0-SNAPSHOTPU");
//        if (dao.save(autor)) {
//            JOptionPane.showMessageDialog(null, "add com sucesso");
//        } else {
//            JOptionPane.showConfirmDialog(null, "erro ao salvar");
//        }

    }        
}




//    public Funcionario autenticar(String login, String senha) {
//        Funcionario func = null;
//        try {
//            Query query = getEm().createQuery("SELECT f FROM Funcionario f WHERE f.login=:login and f.senha=:senha");
//            query.setParameter("login", login);
//            query.setParameter("senha", senha);
//
//            //query.getSingleResult()
//            func = (Funcionario) query.getSingleResult();
//
//        } catch (NoResultException e) {
//            e.printStackTrace();
//        }
//        return func;
//    }
//
//    public static void main(String[] args) {
//        Funcionario func = new Funcionario();
//        func.setCodigo("f-2");
//        func.setLogin("func1");
//        func.setSenha("123");
//
//        DaoJPA dao = new DaoJPA("unidadeTeste");
//
//        if (dao.save(func)) {
//            JOptionPane.showMessageDialog(null, "funcionario add com sucesso");
//        } else {
//            JOptionPane.showConfirmDialog(null, "erro ao salvar func");
//        }
//
//        Funcionario func2 = dao.autenticar(func.getLogin(), func.getSenha());
//        if (func2 != null) {
//            JOptionPane.showMessageDialog(null, "funcionario encontrado");
//        } else {
//            JOptionPane.showMessageDialog(null, "funcionario não encontrado");
//        }
//    }