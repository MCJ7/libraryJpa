/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.persistencia;

import com.library.entidades.Borrow;
import com.library.servicios.BookServices;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class BorrowDao extends Dao {

    /**
     *
     * @param borrow
     * @return
     */
    public Borrow add(Borrow borrow) {
        try {
            em.getTransaction().begin();
            em.persist(borrow);
            em.getTransaction().commit();
            return borrow;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param loan
     * @return
     */
    public Borrow modify(Borrow loan) {
        try {
            em.getTransaction().begin();
            em.merge(loan);
            em.getTransaction().commit();
            return loan;
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
    public Borrow search(Integer id) {
        try {
            return em.find(Borrow.class, id);
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param borrow
     * @return
     */
    public Borrow delete(Borrow borrow) {
        try {
            em.getTransaction().begin();
            em.remove(borrow);
            em.getTransaction().commit();
            return borrow;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
