package DAY4;

public class Book {
	private String bookName;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public void readTheBook(String topic) {
		System.out.println(" run "+topic+" programs of "+bookName );
	}
	
	
	
	public void updateBook() {
		
	}
}
