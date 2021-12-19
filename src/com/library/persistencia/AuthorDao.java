/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.persistencia;

import com.library.entidades.Author;
import com.library.servicios.BookServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class AuthorDao extends Dao {

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author delete(Author author) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(author);
            em.getTransaction().commit();
            return author;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return  null;
    }

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author create(Author author) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(author);
            em.getTransaction().commit();
            return author;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null; 
    }

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author modify(Author author) throws Exception {
        try {
            em.getTransaction().begin();
            em.merge(author);
            em.getTransaction().commit();
            return author;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Author search(String name) throws Exception {
        try {
            return (Author) em.createQuery("SELECT a FROM Author a WHERE a.name = "
                    + ":name").setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Author> searchList() throws Exception {
        try {
            return em.createQuery("SELECT a FROM Author a").getResultList();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Author searchIdDao(Integer id) throws Exception {
        try {
            return em.find(Author.class,id);
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return  null;
    }
}
