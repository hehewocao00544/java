package cn.hehewocao.pojo;

public class Book {

	private String bookname;
	private String writer;
	private String id;
	private String press;
	private String date;
	private float price;
	private String type;
	private int number;

	public Book() {

	}

	public Book(String bookname, String writer, String id, String press, String date, float price, String type,
			int number) {

		this.bookname = bookname;
		this.writer = writer;
		this.id = id;
		this.press = press;
		this.date = date;
		this.price = price;
		this.type = type;
		this.number = number;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
