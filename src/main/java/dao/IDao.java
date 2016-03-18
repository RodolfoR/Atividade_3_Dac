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
public interface IDao {
    public boolean save(Object o);
    
    public Object find(Class classe, Object o);
    
    public boolean update(Object o);
    
    public boolean delete(Object o);
}