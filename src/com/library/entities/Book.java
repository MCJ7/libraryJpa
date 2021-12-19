/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author maxco
 */
@Entity(name = "Book")
public class Book {

    /**
     *
     */
    @Id
    private Long isbn;

    /**
     *
     */
    @Column(unique = true)
    private String title;

    /**
     *
     */
    private Integer year;

    /**
     *
     */
    private Integer copy;

    /**
     *
     */
    private Integer borrowedCopy;

    /**
     *
     */
    private Integer remainingCopy;

    /**
     *
     */
    private boolean register;

    /**
     *
     */
    @OneToOne
    private Author author;

    /**
     *
     */
    @OneToOne
    private Editorial editorial;

    /**
     *
     * @param isbn
     * @param title
     * @param year
     * @param copy
     * @param register
     * @param author
     * @param editorial
     */
    public Book(Long isbn, String title, Integer year, Integer copy, 
             boolean register, Author author, Editorial editorial) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.copy = copy;
        this.borrowedCopy = 0;
        this.remainingCopy = 0;
        this.register = register;
        this.author = author;
        this.editorial = editorial;
    }

    /**
     *
     */
    public Book() {
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public Integer getYear() {
        return year;
    }

    /**
     *
     * @param year
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *
     * @return
     */
    public Integer getCopy() {
        return copy;
    }

    /**
     *
     * @param copy
     */
    public void setCopy(Integer copy) {
        this.copy = copy;
    }

    /**
     *
     * @return
     */
    public Integer getBorrowedCopy() {
        return borrowedCopy;
    }

    /**
     *
     * @param borrowedCopy
     */
    public void setBorrowedCopy(Integer borrowedCopy) {
        this.borrowedCopy = borrowedCopy;
    }

    /**
     *
     * @return
     */
    public Integer getRemainingCopy() {
        return remainingCopy;
    }

    /**
     *
     * @param remainingCopy
     */
    public void setRemainingCopy(Integer remainingCopy) {
        this.remainingCopy = remainingCopy;
    }

    /**
     *
     * @return
     */
    public boolean isRegister() {
        return register;
    }

    /**
     *
     * @param register
     */
    public void setRegister(boolean register) {
        this.register = register;
    }

    /**
     *
     * @return
     */
    public Author getAuthor() {
        return author;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     *
     * @return
     */
    public Editorial getEditorial() {
        return editorial;
    }

    /**
     *
     * @param editorial
     */
    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    /**
     *
     * @return
     */
    public Long getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (isbn != null ? isbn.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the isbn fields are not set
//        if (!(object instanceof Libro)) {
//            return false;
//        }
//        Libro other = (Libro) object;
//        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
//            return false;
//        }
//        return true;
//    }

    /**
     *
     * @return
     */

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Isbn: ").append(isbn);
        sb.append("\nTitle: ").append(title);
        sb.append("\nYear: ").append(year);
        sb.append("\nCopies: ").append(copy);
        sb.append("\nBorrowed Copies: ").append(borrowedCopy);
        sb.append("\nRemaining Copies: ").append(remainingCopy);
        sb.append("\nRegister: ").append(register);
        sb.append("\nAuthor: ").append(author);
        sb.append("\nEditorial: ").append(editorial);
        sb.append(" ");
        return sb.toString();
    }
}
