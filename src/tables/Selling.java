package tables;

public class Selling {
	private int sellID;
	public int getSellID() {
		return sellID;
	}
	public void setSellID(int sellID) {
		this.sellID = sellID;
	}
	private int bookID;
	private int price;
	private int quantity;
	private String date;
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
