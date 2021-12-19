
package com.library.servicios;

import com.library.entidades.Author;
import com.library.persistencia.AuthorDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class AuthorServices {

    /**
     *
     */
    private AuthorDao dao;

    /**
     *
     */
    public AuthorServices() {
        dao = new AuthorDao();
    }

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author addAuthor(Author author) throws Exception {
        try {
            if (author.getName() == null || author.getName().trim().isEmpty()) {
                throw new Exception("El nombre es null");
            }
            dao.create(author);
            return author;
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author editAuthor(Author author) throws Exception {
        try {
            if (author.getName() == null || author.getName().trim().isEmpty()) {
                throw new Exception("El autor es null");
            }
            dao.modify(author);
            return author;
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Author searchName(String name) throws Exception {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("El nombre es null");
            }
            return dao.search(name);
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Author searchId(Integer id) throws Exception {
        try {
            if (id == null || id < 0) {
                throw new Exception("El id es null");
            }
            return dao.searchIdDao(id);
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
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
            return dao.searchList();

        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param author
     * @return
     * @throws Exception
     */
    public Author remove(Author author) throws Exception {
        try {
            return dao.delete(author);
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param author
     * @return
     */
    public Author altaBajaAutor(Author author) {
        try {
            return dao.modify(author);
        } catch (Exception e) {
            Logger.getLogger(AuthorServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
