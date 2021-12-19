package com.library;

import com.library.servicios.BookServices;
import com.library.servicios.AuthorServices;
import com.library.servicios.EditorialServices;
import com.library.servicios.BorrowServices;
import com.library.servicios.CustomerServices;
import com.library.entidades.Author;
import com.library.entidades.Book;
import com.library.entidades.Customer;
import com.library.entidades.Borrow;
import com.library.entidades.Editorial;
import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author maxco
 */
public class LibreryApp {

    /**
     *
     */
    private Scanner sc;

    /**
     *
     */
    private EditorialServices editorialService;

    /**
     *
     */
    private AuthorServices authorService;

    /**
     *
     */
    private BookServices bookService;

    /**
     *
     */
    private CustomerServices customerService;

    /**
     *
     */
    private BorrowServices borrowService;

    /**
     *
     */
    private BufferedReader br;

    /**
     *
     */
    public LibreryApp() {
        this.sc = new Scanner(System.in).useDelimiter("\n").useLocale(Locale.US);
        this.editorialService = new EditorialServices();
        this.authorService = new AuthorServices();
        this.bookService = new BookServices();
        this.borrowService = new BorrowServices();
        this.customerService = new CustomerServices();
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        LibreryApp principal = new LibreryApp();
        String opcion;
        do {
            opcion = principal.menu();
            switch (opcion) {
                case "A":
                    principal.add();
                    break;
                case "B":
                    principal.modify();
                    break;
                case "C":
                    principal.delete();
                    break;
                case "D":
                    principal.search();
                    break;
                case "E":
                    principal.lists();
                    break;
                case "F":
                    principal.borrowBook();
                    break;
                case "G":
                    principal.returnBook();
                    break;
                case "H":
                    principal.dismiss();
                    break;
                case "I":
                    System.out.println("Nos vemos");
                    break;
                default:
                    System.err.println("Option not available");
                    break;
            }
        } while (!opcion.equalsIgnoreCase("I"));

    }

    /**
     *
     * @return
     * @throws AWTException
     */
    private String menu() throws AWTException {
        System.out.println("---------------------------------------");
        System.out.println(
                "A.Submenu to register"
                + "\nB.Submenu to modify "
                + "\nC.Submenu to delete "
                + "\nD.Submenu to search individual"
                + "\nE.Submenu to lists"
                + "\nF.Borrow"
                + "\nG.Return"
                + "\nH.Borrow book"
                + "\nI.Return book"
                + "\nJ.Exit");
        System.out.println("Choose option");
        String opcion = sc.next();
        screenClean();
        return opcion.toUpperCase();
    }

    /**
     *
     * @throws Exception
     */
    private void lists() throws Exception {
        List<Object> objects = null;
        System.out.println("Chose the list to search: "
                + "\nA.Authors"
                + "\nB.Books"
                + "\nC.Customers"
                + "\nD.Editorials"
                + "\nE.Book´s list by author"
                + "\nF.Book´s list by editorial");
        String op = sc.next().toUpperCase();
        switch (op) {
            case "A":
                objects = (List<Object>) (Author) authorService.searchList();
                break;
            case "B":
                objects = (List<Object>) (Book) bookService.searchList();
                break;
            case "C":
                objects = (List<Object>) (Customer) customerService.searchList();
                break;
            case "D":
                objects = (List<Object>) (Editorial) editorialService.searchList();
                break;
            case "E":
                System.out.print("Name del autor: ");
                objects = (List<Object>) (Customer) bookService.searchAuthorList(authorService.searchName(sc.next()));
                break;
            case "F":
                System.out.print("Name de la editorial");
                objects = (List<Object>) (Editorial) bookService.searchEditorialList(editorialService.search(sc.next()));
                break;
            default:
                System.out.println("Option not available");
                break;

        }
        if (objects != null) {
            for (Object object : objects) {
                System.out.println(object);
            }
        }
    }

    /**
     *
     * @throws Exception
     */
    private void search() throws Exception {
        Object object = null;
        System.out.println("Choose a option to search: "
                + "\nA.Author by ID"
                + "\nE.Author by name"
                + "\nB.Book by ISBN"
                + "\nG.Book by title"
                + "\nC.Customer by ID"
                + "\nD.Editorial by ID"
                + "\nF.Editorial by name");
        String op = sc.next().toUpperCase();
        switch (op) {
            case "A":
                System.out.print("Author ID:");
                object = (Author) authorService.searchId(sc.nextInt());
                break;
            case "B":
                System.out.print("Author name: ");
                object = (Author) authorService.searchName(sc.next());
                break;
            case "C":
                System.out.print("Book ISBN:");
                object = (Book) bookService.searchIsbn(sc.nextLong());
                break;
            case "D":
                System.out.print("Book title");
                object = (Book) bookService.searchTitle(sc.next());
                break;
            case "E":
                System.out.print("Customer ID:");
                object = (Customer) customerService.findCustomer(sc.nextInt());
                break;
            case "F":
                System.out.print("Editorial ID:");
                object = (Editorial) editorialService.searchId(sc.nextInt());
                break;
            case "G":
                System.out.print("Editorial name: ");
                object = (Editorial) editorialService.search(sc.next());
                break;
            default:
                System.out.println("Option not available");
                break;

        }
        if (object != null) {
            System.out.println(object);

        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void borrowBook() throws Exception {
        try {
            System.out.print("Borrow date: ");
            System.out.println("Format date: DD/MM/YYYY");
            Date borrowDate = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
            Date returnDate = (Date) borrowDate.clone();
            borrowDate.setDate(borrowDate.getDate() + 15);
            System.out.println("ID book: ");
            Book book = bookService.searchIsbn(sc.nextLong());
            System.out.println("ID cliente: ");
            Customer customer = customerService.findCustomer(sc.nextInt());
            System.out.println(borrowService.bookingBorrow(new Borrow(0, borrowDate, returnDate, book, customer)));
            book.setBorrowedCopy(book.getBorrowedCopy() + 1);
            book.setRemainingCopy(book.getRemainingCopy() - 1);
            bookService.alter(book);
        } catch (Exception e) {
            System.err.println("Catch the erro: "+ e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void dismiss() throws Exception {
        try {
            System.out.println("Choose the option to active or disable: "
                    + "\nA.Author"
                    + "\nB.Editorial"
                    + "\nC.Book");
            System.out.print("Opción: ");
            String op = sc.next().toUpperCase();

            switch (op) {
                case "A":
                    enableAuthor();
                    break;
                case "B":
                    enableEditorial();
                    break;
                case "C":
                    enableBook();
                    break;
                default:
                    System.out.println("Option not available");
                    break;
            }

        } catch (Exception e) {
            throw e;
        }
    }

    /**
     *
     * @throws Exception
     */
    private void add() throws Exception {
        System.out.println("Choose the option to add"
                + "\nA.Author"
                + "\nB.Book"
                + "\nC.Customer"
                + "\nD.Editorial");
        String op = sc.next().toUpperCase();
        switch (op) {
            case "A":
                addAuthor();
                break;
            case "B":
                addBook();
                break;
            case "C":
                addCustomer();
                break;
            case "D":
                addEditorial();
                break;
            default:
                System.err.println("Option not available");
                break;
        }
    }

    /**
     *
     * @throws Exception
     */
    private void delete() throws Exception {
        System.out.println("Choose the option to delete"
                + "\nA.Author"
                + "\nB.Book"
                + "\nC.Customer"
                + "\nD.Editorial");
        String op = sc.next().toUpperCase();
        switch (op) {
            case "A":
                deleteAuthor();
                break;
            case "B":
                deleteBook();
                break;
            case "C":
                deleteCustomer();
                break;
            case "D":
                deleteEditorial();
                break;
            default:
                System.err.println("Option not available");
                break;
        }
    }

    /**
     *
     * @throws Exception
     */
    private void modify() throws Exception {
        System.out.println("Choose the option to modify"
                + "\nA.Author"
                + "\nB.Book"
                + "\nC.Customer"
                + "\nD.Editorial");
        String op = sc.next().toUpperCase();
        switch (op) {
            case "A":
                modifyAuthor();
                break;
            case "B":
                modifyBook();
                break;
            case "C":
                modifyCustomer();
                break;
            case "D":
                modifyEditorial();
                break;
            default:
                System.out.println("Option not available");
                break;
        }

    }

    /**
     *
     * @throws Exception
     */
    private void enableEditorial() throws Exception {
        try {
            System.out.println("Editorial's name: ");
            Editorial e = editorialService.search(sc.next());
            e.setEnable(!e.isEnable());
            System.out.println(editorialService.altaBajaEditorial(e));
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void enableBook() throws Exception {
        try {
            System.out.println("Write id´s book: ");
            Book li = bookService.searchIsbn(sc.nextLong());
            li.setRegister(!li.isRegister());
            bookService.alter(li);
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void enableAuthor() throws Exception {
        try {
            System.out.println("Write id´s book: ");
            Author author = authorService.searchId(sc.nextInt());
            author.setEnable(!author.isEnable());
            System.out.println(authorService.editAuthor(author));
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void returnBook() throws Exception {
        try {
            System.out.println("Choose id of the borrow ");
            Borrow borrow = borrowService.deleteBorrow(borrowService.search(sc.nextInt()));
            Book book = borrow.getBook();
            System.out.println("The devolution was successful");
            System.out.println(borrow);
            book.setBorrowedCopy(book.getBorrowedCopy() - 1);
            book.setRemainingCopy(book.getRemainingCopy() + 1);
            System.out.println(bookService.alter(book));
        } catch (Exception e) {
            throw e;
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws AWTException
     */
    public void screenClean() throws AWTException {
        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30); 
        pressbot.keyPress(17); 
        pressbot.keyPress(76);
        pressbot.keyRelease(17); 


    }

    /**
     *
     * @throws Exception
     */
    private void addAuthor() throws Exception {
        try {
            System.out.print("Name: ");
            System.out.println(authorService.addAuthor(new Author(sc.next(), true)));
        } catch (Exception e) {
            throw e;
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void modifyBook() throws Exception {
        try {
            System.out.print("ISBN: ");
            Book book = bookService.searchIsbn(sc.nextLong());
            System.out.println("Elegi lo que desea modificar"
                    + "\nA.ISBN"
                    + "\nB.Title"
                    + "\nC.Year"
                    + "\nD.Number  of copies"
                    + "\nE.Number of borrow copies"
                    + "\nF.Remaining copies"
                    + "\nG.Author"
                    + "\nH.Editorial"
                    + "\nI.Active or desactive");
            System.out.print("Opcion");
            String op = sc.next();
            switch (op) {
                case "A":
                    System.out.print("ISBN: ");
                    book.setIsbn(sc.nextLong());
                    break;
                case "B":
                    System.out.print("Title: ");
                    book.setTitle(sc.next());
                case "C":
                    System.out.print("Year: ");
                    book.setYear(sc.nextInt());
                    break;
                case "D":
                    System.out.print("Copies: ");
                    book.setCopy(sc.nextInt());
                case "E":
                    System.out.print("Borrow copies: ");
                    book.setBorrowedCopy(sc.nextInt());
                    break;
                case "F":
                    System.out.print("Ejemplares Restantes: ");
                    book.setRemainingCopy(sc.nextInt());
                    break;
                case "G":
                    System.out.print("Author ID: ");
                    Author a = authorService.searchId(sc.nextInt());
                    book.setAuthor(a);
                case "H":
                    System.out.print("Editorial ID: ");
                    Editorial e = editorialService.searchId(sc.nextInt());
                    book.setEditorial(e);
                    break;
                case "I":
                    book.setRegister(!book.isRegister());
                    break;
                default:
                    System.out.println("La opción es incorrecta");
                    break;
            }
            System.out.println(bookService.alter(book));

        } catch (Exception e) {
            throw e;
        }
        System.out.println("The modification was successful");
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void addEditorial() throws Exception {
        try {
            System.out.print("Editorial ID: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            String name = sc.next();
            editorialService.addEditorial(new Editorial(id, name, true));
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("The registration was successful");
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void modifyAuthor() throws Exception {
        try {
            System.out.print("ID autor");
            Author at = authorService.searchId(sc.nextInt());
            System.out.print("Name");
            at.setName(sc.next());
            System.out.println(authorService.editAuthor(at));
            br.readLine();
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("The modification was successful");
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void modifyEditorial() throws Exception {
        try {
            System.out.print("ID editorial: ");
            Editorial ed = editorialService.searchId(sc.nextInt());
            System.out.print("Name: ");
            ed.setName(sc.next());
            System.out.println(editorialService.editEditorial(ed));
        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void addBook() throws Exception {
        try {
            System.out.print("ISBN: ");
            Long isbn = sc.nextLong();
            System.out.print("Title: ");
            String titulo = sc.next();
            System.out.print("Year: ");
            int anio = sc.nextInt();
            System.out.print("Number of copies: ");
            int ejemplar = sc.nextInt();
            System.out.print("Author ID: ");
            Author a = authorService.searchId(sc.nextInt());
            System.out.print("Editorial ID: ");
            Editorial e = editorialService.searchId(sc.nextInt());
            Book book = new Book(isbn, titulo, anio, ejemplar, true, a, e);
            System.out.println(bookService.addBook(book));

        } catch (Exception e) {
            System.out.println("Catch a error: " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void deleteBook() throws Exception {
        try {
            System.out.print("ISBN libro: ");
            System.out.println(bookService.remove(bookService.searchIsbn(sc.nextLong())));
            System.out.println("The elimination was successful");

        } catch (Exception e) {
            System.out.println("Catch a error: " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void deleteEditorial() throws Exception {
        try {
            System.out.print("Name de editorial: ");
            System.out.println(editorialService.remove(editorialService.search(sc.next())));
            System.out.println("The elimination was successful");

        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void addCustomer() throws Exception {
        try {
            System.out.print("Document id: ");
            Long dni = (long) (sc.nextLong());
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Lastname: ");
            String lastname = sc.next();
            System.out.print("number: ");
            String phoneNumber = sc.next();
            System.out.println(customerService.addCliente(new Customer(dni, name, lastname, phoneNumber)));

        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void deleteAuthor() throws Exception {
        try {
            System.out.println("ID de autor");
            System.out.println(authorService.remove(authorService.searchId(sc.nextInt())));

        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void deleteCustomer() throws Exception {
        try {
            System.out.println("ID de Customer");
            System.out.println(customerService.remove(customerService.findCustomer(sc.nextInt())));

        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }

    /**
     *
     * @throws Exception
     */
    private void modifyCustomer() throws Exception {
        try {
            System.out.println("ID de Customer");
            System.out.println(customerService.modify(customerService.findCustomer(sc.nextInt())));

        } catch (Exception e) {
            System.out.println("Catch a error " + e);
        }
        System.out.println("Press any keyboard key.");
        br.readLine();
    }
}
