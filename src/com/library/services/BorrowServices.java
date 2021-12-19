/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.services;

import com.library.entities.Borrow;
import com.library.daos.BorrowDao;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class BorrowServices {

    /**
     *
     */
    private BorrowDao dao;

    /**
     *
     */
    public BorrowServices() {
        dao = new BorrowDao();
    }

    /**
     *
     * @param borrow
     * @return
     * @throws Exception
     */
    public Borrow bookingBorrow(Borrow borrow) throws Exception {
        try {
            if (borrow.getCustomer() == null) {
                throw new Exception("No es posible el cliente");
            }
            if (borrow.getReturnDate() == null) {
                throw new Exception("No es posible la fecha de devolución");
            }
            if (borrow.getBorrowDate() == null) {
                throw new Exception("No es posible la fecha de prestamo");
            }
            if (borrow.getBook() == null) {
                throw new Exception("No es posible el libro");
            }
            return dao.add(borrow);
        } catch (Exception e) {
            Logger.getLogger(BorrowServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param borrow
     * @return
     * @throws Exception
     */
    public Borrow deleteBorrow(Borrow borrow) throws Exception {
        try{
        if (borrow.getCustomer() == null) {
            throw new Exception("No es posible el cliente");
        }
        if (borrow.getReturnDate() == null) {
            throw new Exception("No es posible la fecha de devolución");
        }
        if (borrow.getBorrowDate() == null) {
            throw new Exception("No es posible la fecha de prestamo");
        }
        if (borrow.getBook() == null) {
            throw new Exception("No es posible el libro");
        }
        return dao.delete(borrow);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Borrow search(Integer id) throws Exception {

        try {
            if (id == null || id < 0) {
                throw new Exception("No es posible el cliente");
            }
            return dao.search(id);
        } catch (Exception e) {
            Logger.getLogger(BorrowServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param borrow
     * @return
     * @throws Exception
     */
    public Borrow verify(Borrow borrow) throws Exception {
        try {
            if (borrow.getCustomer() == null) {
                throw new Exception("Do not available the customer");
            }
            if (borrow.getReturnDate() == null) {
                throw new Exception("Do not available the return date");
            }
            if (borrow.getBorrowDate() == null) {
                throw new Exception("Do not available the borrow date");
            }
            if (borrow.getBook() == null) {
                throw new Exception("No es posible el libro");
            }
            return dao.add(borrow);
        } catch (Exception e) {
            Logger.getLogger(BorrowServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }
}
