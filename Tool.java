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

  public boolean checkInTool() {
      checkedOutBy = null;
      return true;
  }

  public boolean isToolCheckedOut() {
    if (this.checkedOutBy != null) {
      return true;
    }
    return false;
  }
}
