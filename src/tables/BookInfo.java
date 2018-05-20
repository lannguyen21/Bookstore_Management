package tables;

public class BookInfo {
	private int No;
	private int bookID;
	private String name;
	private String author;
	private String type;
	private String publisher;
	
	BookInfo(){
	}

	public BookInfo(int no, int bookID, String name, String author, String type, String publisher) {
		super();
		No = no;
		this.bookID = bookID;
		this.name = name;
		this.author = author;
		this.type = type;
		this.publisher = publisher;
	}

	public int getNo() {
		return No;
	}

	public void setNo(int no) {
		No = no;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	
}
