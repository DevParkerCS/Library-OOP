public class Library {

  // attributes here
  String name;
  Book[] books;
  Tool[] tools = new Tool[4];
  int numBooks = 0;
  int numTools = 0;
  int capacity;

  public Library(String name, int capacity) {
    this.name = name;
    this.books = new Book[capacity];
  }

  public BookClub createBookClub(int membersAllowed) {
    return new BookClub(membersAllowed);
  }

  public boolean addClubMember(String name, BookClub club) {
    return club.addMember(name);
  }

  public boolean removeClubMember(String name, BookClub club) {
    return club.removeMember(name);
  }

  public boolean addBook(Book book) {
    if (numBooks == books.length) {
      System.out.println("Library is at max capacity");
      return false;
    }
    books[numBooks] = book;
    numBooks += 1;
    return true;
  }

  public void fillTools() {
    for (int i = 0; i < tools.length; i++) {
      tools[i] = new Tool();
    }
  }

  public boolean checkOutTool(String name) {
    for (int i = 0; i < tools.length; i++) {
      if (tools[i].checkedOutBy == null) {
        tools[i].checkOutTool(name);
        System.out.println("Checked Out Tool To " + name);
        return true;
      }
    }
    System.out.println("All tools are currently checked out");
    return false;
  }

  public boolean checkInTool(String name){
    for (int i = 0; i < tools.length; i++){
      if (tools[i].checkedOutBy == name){
        System.out.println(name + " returned their tools");
        return tools[i].checkInTool();
      }
    }
    System.out.println("Imposter!");
    return false;
  }

  public void removeBook(String title) {
    for (int i = 0; i < books.length; i++) {
      if (books[i].title.equals(title)) {
        books[i] = null;
      }
    }
  }

  public Book getBook(String title) {
    for (int i = 0; i < books.length; i++) {
      if (books[i].title.equals(title)) {
        return books[i];
      }
    }
    return null;
  }

  public boolean isAvailable(String title) {
    Book book = getBook(title);
    if (book.equals(null)) {
      System.out.println("IsAvailableFault");
      return false;
    }
    return !book.isCheckedOut();
  }

  public boolean checkOutBook(String title, String userName) {
    if (!isAvailable(title)) {
      return false;
    }

    Book book = getBook(title);
    book.checkOut(userName);
    return true;
  }

  public boolean checkInBook(String title) {
    Book book = getBook(title);
    if (book.equals(null)) {
      return false;
    }
    book.checkIn();
    return true;
  }

  public Book mostPopularBook() {
    Book mostPopular = null;
    int maxCheckOuts = 0;

    for (int i = 0; i < books.length; i++) {
      if (books[i].numCheckOuts > maxCheckOuts) {
        maxCheckOuts = books[i].numCheckOuts;
        mostPopular = books[i];
      }
    }
    return mostPopular;
  }

  public static void main(String[] args) {
    Library BPL = new Library("Bellingham Public Library", 3);
    BPL.fillTools();

    BPL.checkOutTool("Parker");
    BPL.checkOutTool("John");
    BPL.checkInTool("Parker");
    BPL.checkInTool("Parker");
    BPL.checkOutTool("Jacob");
    BPL.checkOutTool("Sam");
    BPL.checkOutTool("Larry");
    BPL.checkOutTool("Parker");

    BookClub bookClub = BPL.createBookClub(3);
    BPL.addClubMember("Parker", bookClub);
    BPL.addClubMember("Johnson", bookClub);
    BPL.addClubMember("Jacob", bookClub);
    BPL.addClubMember("Devin", bookClub);
    BPL.removeClubMember("Jacob", bookClub);
    BPL.addClubMember("Devin", bookClub);

    Book mockingbird = new Book("To Kill a Mockingbird", "Harper Lee");
    Book n84 = new Book("1984", "George Orwell");
    Book gatsby = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    Book b4 = new Book("b4", "b4");

    BPL.addBook(gatsby);
    BPL.addBook(mockingbird);
    BPL.addBook(n84);
    if (BPL.addBook(b4)) {
      System.out.println("Fail: max capacity check");
    }

    BPL.checkOutBook("The Great Gatsby", "vimcent101");
    if (BPL.checkOutBook("The Great Gatsby", "fern92")) {
      System.out.println("Fail: tried to check out a book already checked out");
    }

    if (!BPL.checkInBook("The Great Gatsby")) {
      System.out.println("Fail: checkin");
    }
    if (!BPL.checkOutBook("The Great Gatsby", "greenday707")) {
      System.out.println("Fail: book was checked in but couldn't check it out again afterwards");
    }

    BPL.checkOutBook("To Kill a Mockingbird", "jensenq");
    BPL.checkOutBook("1984", "jensenq");

    Book most_popular = BPL.mostPopularBook();
    if (most_popular != gatsby) {
      System.out.println(
          "Fail: most popular book should be gatsby. check that you're properly returning the Book object, and calculating most popular correctly.");
    }

    // if you run Library and it prints nothing out, you passed all tests
    // in future labs, you will be expected to start writing your own test cases to
    // ensure your program works as intended
  }

}
