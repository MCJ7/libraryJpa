/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.daos;

import com.library.entities.Author;
import com.library.entities.Book;
import com.library.entities.Editorial;
import com.library.services.BookServices;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class BookDao extends Dao {

    /**
     *
     * @param book
     * @return
     * @throws Exception
     */
    public Book createBook(Book book) throws Exception {
        try {
            em.getTransaction().begin();
            em.persist(book);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return book;
    }

    /**
     *
     * @param book
     * @return
     * @throws Exception
     */
    public Book alterBook(Book book) throws Exception {
        try {

            em.getTransaction().begin();
            em.merge(book);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param book
     * @return
     * @throws Exception
     */
    public Book deleteBook(Book book) throws Exception {
        try {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
            return book;
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param title
     * @return
     * @throws Exception
     */
    public Book search(String title) throws Exception {
        try {
            return (Book) em.createQuery("SELECT l FROM Book l WHERE l.title = "
                    + ":title").setParameter("title", title).getSingleResult();
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
    public List<Book> searchList() throws Exception {
        try {
            return em.createQuery("SELECT b FROM Book b").getResultList();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param isbn
     * @return
     * @throws Exception
     */
    public Book searchIsbn(Long isbn) throws Exception {

        try {
            return (Book) em.find(Book.class, isbn);
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
    public List<Book> searchAuthorList(Author author) throws Exception {
        try {
            return em.createQuery("SELECT b FROM Book l WHERE b.author =:author")
                    .setParameter("author", author).getResultList();
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
    public List<Book> searchEditorialList(Editorial editorial) throws Exception {
        try {
            return em.createQuery("SELECT b FROM Book b WHERE b.editorial "
                    + "=:editorial").setParameter("editorial", editorial).getResultList();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
