
package com.library.services;

import com.library.entities.Author;
import com.library.entities.Book;
import com.library.entities.Editorial;
import com.library.daos.BookDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class BookServices {

    /**
     *
     */
    private BookDao dao;

    /**
     *
     */
    public BookServices() {
        this.dao = new BookDao();
    }

    /**
     *
     * @param book
     * @return
     * @throws Exception
     */
    public Book addBook(Book book) throws Exception {
        try {
            verify(book);
            dao.createBook(book);
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
    public Book editBook(Book book) throws Exception {
        try {
            verify(book);
            if (book.getRemainingCopy() == null || book.getRemainingCopy() < 1) {
                throw new Exception("Number of copies is not available");
            }
            if (book.getBorrowedCopy() == null || book.getBorrowedCopy() < 0
                    || book.getRemainingCopy() < book.getBorrowedCopy()) {
                throw new Exception("Number of copies is not available");
            }
            if (book.getCopy() == null || (book.getRemainingCopy() + book.getBorrowedCopy()) < book.getCopy()) {
                throw new Exception("Number of copies is wrong");
            }
            dao.alterBook(book);
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
    public Book searchTitle(String title) throws Exception {
        try {
            if (title == null || title.trim().isEmpty()) {
                throw new Exception("El id es null");
            }
            return dao.search(title);
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
            if (isbn == null || (String.valueOf(isbn)).length() != 13) {
                throw new Exception("El ISBN no es posible");
            }
            return dao.searchIsbn(isbn);
        } catch (Exception ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param book
     * @return
     * @throws Exception
     */
    public Book remove(Book book) throws Exception {
        try {
            return dao.deleteBook(book);
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

            return dao.searchList();
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param autor
     * @return
     * @throws Exception
     */
    public List<Book> searchAuthorList(Author autor) throws Exception {
        try {

            return dao.searchAuthorList(autor);
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

            return dao.searchEditorialList(editorial);
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
    public Book alter(Book book) throws Exception {
        try {
            return dao.alterBook(book);
        } catch (Exception e) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param book
     * @return
     */
    public Boolean verify(Book book) {

        try {
            if ((String.valueOf(book.getIsbn())).length() != 13) {

                throw new Exception("The ISBN is not available");
            }
            if (book.getYear() == null || book.getYear() < 1) {
                throw new Exception("The year is not available");
            }
            if (book.getCopy() == null) {
                throw new Exception("Number of copies is wrong");
            }
            if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
                throw new Exception("Id is null");
            }
            if (book.getAuthor() == null) {
                throw new Exception("Did not find author");
            }
            if (book.getEditorial() == null) {
                throw new Exception("Did not find editorial");
            }

        } catch (Exception ex) {
            Logger.getLogger(BookServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}