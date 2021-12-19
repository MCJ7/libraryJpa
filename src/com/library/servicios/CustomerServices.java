/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.servicios;

import com.library.entidades.Customer;
import com.library.persistencia.CustomerDao;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maxco
 */
public class CustomerServices {

    /**
     *
     */
    private CustomerDao dao;

    /**
     *
     */
    public CustomerServices() {
        dao = new CustomerDao();
    }

    /**
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public Customer addCliente(Customer customer) throws Exception {
        try {

            if (customer.getLastname() == null && customer.getLastname().trim().isEmpty()) {
                throw new Exception("Error en el apellido");
            }
            if (customer.getName() == null && customer.getName().trim().isEmpty()) {
                throw new Exception("Error en el nombre");
            }
            if (customer.getNumberPhone() == null && customer.getNumberPhone().trim().isEmpty()) {
                throw new Exception("Error en el telefono");
            }
            if ((String.valueOf(customer.getDocumentNumber())).length() != 8) {
                throw new Exception("Error en el dni");
            }
            return dao.add(customer);

        } catch (Exception e) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;

    }

    /**
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public Customer remove(Customer customer) throws Exception {
        try {
            if (customer.getLastname() == null && customer.getLastname().trim().isEmpty()) {
                throw new Exception("Error en el apellido");
            }
            if (customer.getName() == null && customer.getName().trim().isEmpty()) {
                throw new Exception("Error en el nombre");
            }
            if (customer.getNumberPhone() == null && customer.getNumberPhone().trim().isEmpty()) {
                throw new Exception("Error en el telefono");
            }
            if (customer.getDocumentNumber() == null && customer.getDocumentNumber() > 8) {
                throw new Exception("Error en el dni");
            }
            return dao.removeDao(customer);
        } catch (Exception e) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     * @throws Exception
     */
    public Customer findCustomer(Integer id) throws Exception {
        try {
            if (id == null || id < 0) {
                throw new Exception("Error en el id");
            }
            return dao.find(id);
        } catch (Exception e) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @param customer
     * @return
     * @throws Exception
     */
    public Customer modify(Customer customer) throws Exception {
        try {
            if (customer.getLastname() == null && customer.getLastname().trim().isEmpty()) {
                throw new Exception("Error en el apellido");
            }
            if (customer.getName() == null && customer.getName().trim().isEmpty()) {
                throw new Exception("Error en el nombre");
            }
            if (customer.getNumberPhone() == null && customer.getNumberPhone().trim().isEmpty()) {
                throw new Exception("Error en el telefono");
            }
            if (customer.getDocumentNumber() == null && customer.getDocumentNumber() > 8) {
                throw new Exception("Error en el dni");
            }
            return dao.modify(customer);
        } catch (Exception e) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    /**
     *
     * @return
     */
    public List<Customer> searchList() {
        try {
            return dao.lists();
        } catch (Exception e) {
            Logger.getLogger(CustomerServices.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

}
