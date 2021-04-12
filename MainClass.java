package DAY4;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Book coreJava =new Book();
		coreJava.setBookName("Core Java Adv Book");
		Book jdbcJava = new Book();
		Book springJava = new Book();
		
		Library lib1=new Library(coreJava);
		lib1.doReading("OOPS");
		
		
		Book book  = lib1.getJavaBook();
		String bookName=book.getBookName();
		book.setBookName(bookName.toUpperCase());
		lib1.doReading("Exception Handling");
		
		
		
		lib1.setJavaBook(jdbcJava);
		lib1.doReading("Oracle-JDBC");
		
		
	}

}
