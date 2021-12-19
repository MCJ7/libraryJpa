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
@Entity(name = "Editorial")
public class Editorial {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    @Column(unique = true)
    private String name;

    /**
     *
     */
    private boolean enable;

    /**
     *
     * @param id
     * @param name
     * @param enable
     */
    public Editorial(Integer id, String name, boolean enable) {
        this.id = id;
        this.name = name;
        this.enable = enable;
    }

    /**
     *
     */
    public Editorial() {
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
    public boolean isEnable() {
        return enable;
    }

    /**
     *
     * @param enable
     */
    public void setEnable(boolean enable) {
        this.enable = enable;
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
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id);
        sb.append("\nName: ").append(name);
        sb.append("\nRegister: ").append(enable);
        sb.append(" ");
        return sb.toString();
    }
}
