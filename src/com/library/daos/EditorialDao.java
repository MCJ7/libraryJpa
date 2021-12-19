/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.daos;

import com.library.entities.Editorial;
import com.library.services.BookServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class EditorialDao extends Dao{

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial createDao(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(editorial);
            em.getTransaction().commit();
            return editorial;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial modificar(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(editorial);
            em.getTransaction().commit();
            return editorial;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial drop(Editorial editorial) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(editorial);
            em.getTransaction().commit();
            return editorial;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public Editorial buscarPorNombre(String name) {
        try {
            return (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.name = ").setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return
     */
    public List<Editorial> search() {
        try {
           return em.createQuery("SELECT e FROM editorial e").getResultList(); 
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public Editorial searchId(Integer id) {
        try {
            return em.find(Editorial.class, id);
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
