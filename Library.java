package DAY4;

public class Library {
	
	Book javaBook;
	private String topic;
	
	
	public Library(Book javaBook) {
		super();
		this.javaBook = javaBook;
	}
	
	public Book getJavaBook() {
		return javaBook;
	}




	public void setJavaBook(Book javaBook) {
		this.javaBook = javaBook;
	}




	public Library() {
		super();
		// TODO Auto-generated constructor stub
	}




	public void doReading(String topic) {
		javaBook.readTheBook(topic);
	}

}
