/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author RODOLFO ROCHA
 */
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * @author RODOLFO ROCHA
 */
public class DaoJPA implements IDao{

    private EntityManagerFactory emf;
    private EntityManager em;
    
    //construtores
    public DaoJPA (String persistenceUnitName){
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.em = emf.createEntityManager();
    }
    
    
    @Override
    public boolean save(Object o) {
      try{
            getEm().getTransaction().begin();
            getEm().persist(o);
            getEm().getTransaction().commit();
        return true;
      } catch (Exception e) {
            e.printStackTrace();
            getEm().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public Object find(Class classe, Object objetct) {
        return getEm().find(classe, objetct);
    }
    
    @Override
    public boolean update(Object o) {
       try{
            getEm().getTransaction().begin();
            getEm().merge(o);
            getEm().getTransaction().commit();
           return true;
       }catch (Exception e) {
            e.printStackTrace();
            getEm().getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(Object o) {
       try{
            getEm().getTransaction().begin();
            getEm().remove(o);
            getEm().getTransaction().commit();
           return true;
       }catch (Exception e) {
            e.printStackTrace();
            getEm().getTransaction().rollback(); // Em caso de falha ele volta para o estagio anterior do banco
            return false;
        }
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
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
  
    
}
