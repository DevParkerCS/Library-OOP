public class Book {
  String title;
  String author;
  String checkedOutBy;
  int numCheckOuts;

  // attributes here

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    checkedOutBy = null;
    numCheckOuts = 0;
  }

  public void checkOut(String userName) {
    if (checkedOutBy == null) {
      this.checkedOutBy = userName;
      numCheckOuts += 1;
    }
  }

  public void checkIn() {
    if (checkedOutBy != null) {
      checkedOutBy = null;
    }
  }

  public boolean isCheckedOut() {
    if (this.checkedOutBy != null) {
      return true;
    }
    return false;
  }
}
