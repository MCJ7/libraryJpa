/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author maxco
 */
@Entity(name = "Customer")
public class Customer {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    /**
     *
     */
    @Column(unique = true)
    private Long documentNumber;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String lastname;

    /**
     *
     */
    private String numberPhone;

    /**
     *
     */
    public Customer() {
    }

    /**
     *
     * @param documentNumber
     * @param name
     * @param lastname
     * @param numberPhone
     */
    public Customer( Long documentNumber, String name, String lastname, String numberPhone) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Long getDocumentNumber() {
        return documentNumber;
    }

    /**
     *
     * @param documentNumber
     */
    public void setDocumentNumber(Long documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     */
    public String getNumberPhone() {
        return numberPhone;
    }

    /**
     *
     * @param numberPhone
     */
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id);
        sb.append("\nDocument : ").append(documentNumber);
        sb.append("\nNombre: ").append(name);
        sb.append("\nApellido: ").append(lastname);
        sb.append("\nTelefono: ").append(numberPhone);
        sb.append("");
        return sb.toString();
    }
}
