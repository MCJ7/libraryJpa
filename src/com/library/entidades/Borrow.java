/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entidades;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author maxco
 */
@Entity(name = "Borrow")
public class Borrow {

    /**
     *
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     *
     */
    @Temporal(TemporalType.DATE)
    private Date borrowDate;

    /**
     *
     */
    @Temporal(TemporalType.DATE)
    private Date returnDate;

    /**
     *
     */
    @OneToOne (cascade = CascadeType.REMOVE)
    Book book;

    /**
     *
     */
    @OneToOne (cascade = CascadeType.REMOVE)
    Customer customer;

    /**
     *
     * @param id
     * @param borrowDate
     * @param returnDate
     * @param book
     * @param customer
     */
    public Borrow(Integer id, Date borrowDate, Date returnDate, Book book, Customer customer) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.book = book;
        this.customer = customer;
    }

    /**
     *
     */
    public Borrow() {
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
    public Date getBorrowDate() {
        return borrowDate;
    }

    /**
     *
     * @param borrowDate
     */
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     *
     * @return
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     *
     * @param returnDate
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     *
     * @return
     */
    public Book getBook() {
        return book;
    }

    /**
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;
    }

    /**
     *
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(id);
        sb.append("\nBorrow date: ").append(borrowDate);
        sb.append("\nReturn date: ").append(returnDate);
        sb.append("\nBook: ").append(book);
        sb.append("\nCustomer: ").append(customer);
        sb.append("");
        return sb.toString();
    }

}
