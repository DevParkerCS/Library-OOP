public class Tool {
  String checkedOutBy;

  // attributes here

  public Tool() {
    checkedOutBy = null;
  }

  public void checkOutTool(String userName) {
    if (checkedOutBy == null) {
      this.checkedOutBy = userName;
    }
  }

  public void checkInTool() {
    if (checkedOutBy != null) {
      checkedOutBy = null;
    }
  }

  public boolean isToolCheckedOut() {
    if (this.checkedOutBy != null) {
      return true;
    }
    return false;
  }
}
