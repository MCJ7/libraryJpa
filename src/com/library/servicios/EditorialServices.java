/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servicios;

import com.library.entidades.Editorial;
import com.library.persistencia.EditorialDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author maxco
 */
public class EditorialServices {

    /**
     *
     */
    private EditorialDao dao;

    /**
     *
     */
    public EditorialServices() {
        this.dao = new EditorialDao();
    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial addEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial.getName() == null || editorial.getName().trim().isEmpty()) {
                throw new Exception("El id es null");
            }
            dao.createDao(editorial);
            return editorial;
        } catch (Exception ex) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, editorial);
        }
        return null;

    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial editEditorial(Editorial editorial) throws Exception {
        try {
            if (editorial.getId() == null) {
                throw new Exception("El id es null");
            }
            if (editorial.getName() == null || editorial.getName().trim().isEmpty()) {
                throw new Exception("El id es null");
            }
            dao.modificar(editorial);
            return editorial;
        } catch (Exception e) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public Editorial search(String name) throws Exception {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("El id es null");
            }
            return dao.buscarPorNombre(name);

        } catch (Exception e) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return
     * @throws Exception
     */
    public List<Editorial> searchList() throws Exception {
        try {
            return dao.search();

        } catch (Exception e) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial remove(Editorial editorial) throws Exception {
        try {
            return dao.drop(editorial);

        } catch (Exception e) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param editorial
     * @return
     * @throws Exception
     */
    public Editorial altaBajaEditorial(Editorial editorial) throws Exception {
        try {
            return dao.modificar(editorial);
        } catch (Exception ex) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, editorial);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Editorial searchId(Integer id) throws Exception {
        try {
            if (id == null || id < 0) {
                throw new Exception("No es posible ese ID");
            }
            return dao.searchId(id);
        } catch (Exception e) {
            Logger.getLogger(EditorialServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
}
