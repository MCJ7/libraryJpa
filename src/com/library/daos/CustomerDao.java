/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.daos;

import com.library.entities.Customer;
import com.library.services.BookServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class CustomerDao extends Dao {

    /**
     *
     * @param customer
     * @return
     */
    public Customer add(Customer customer) {
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
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
    public Customer find(Integer id) {
        try {
            return em.find(Customer.class, id);

        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param customer
     * @return
     */
    public Customer removeDao(Customer customer) {
        try {
            em.getTransaction().begin();
            em.remove(customer);
            em.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param customer
     * @return
     */
    public Customer modify(Customer customer) {
        try {
            em.getTransaction().begin();
            em.merge(customer);
            em.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return
     */
    public List<Customer> lists() {
        try {
             return em.createQuery("SELECT c FROM Customer c").getResultList(); 
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
