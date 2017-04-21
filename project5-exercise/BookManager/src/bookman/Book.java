package bookman;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	private long isbn;
	private int id;
	private String title, author, publisher;
	private double price;
	
	public Book() {
		
	}
	
	public Book(long isbn, String title, double price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Book clone() {
		return new Book(isbn, title, price);
	}

	public void restore(Book book) {
		this.isbn = book.getIsbn();
		this.title = book.getTitle();
		this.price = book.getPrice();
	}
}