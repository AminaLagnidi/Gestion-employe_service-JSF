/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Login;
import java.util.List;

import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author HP
 */
public class LoginService extends AbstractFacade<Login>{
      @Override
    protected Class<Login> getEntityClass() {
        return Login.class;
    }
   public int nbrLogins(String username,String password){
           List<Login> users;
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            users = session.createQuery("FROM Login WHERE username = :username AND password = :password").setParameter("username", username).setParameter("password", password).list();
            session.getTransaction().commit();
            if (users==null){
                return 0;
            }else
            return users.size();
}
}