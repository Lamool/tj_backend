package day08;

public class Book {
    // 1. 멤버변수/필드
    private String bookName;
    private String author;

    // 2. 생성자 : 오른쪽 클릭 -> 생성 -> 생성자
    public Book() {}

    public Book(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }

    // 3. 메소드
    // 1. 일반함수
    public void showBookInfo() {
        System.out.println(this.bookName + "," + this.author);      // 매개변수랑 멤버변수랑 구분할 때 this를 사용해라. 여기서는 안 써도 됨.
    }

    // 2. getter ans setter : 오른쪽 클릭 -> 생성
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
