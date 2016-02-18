import java.util.ArrayList;

public class Cd {
  public static ArrayList<Cd> cds = new ArrayList<Cd>();

  private String mTitle;
  private int mId;

  public Cd(String title) {
    mTitle = title;
    cds.add(this);
    mId = cds.size();
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList all() {
    return cds;
  }

  public int getId() {
    return mId;
  }

  public static Cd find(int id) {
    try {
      return cds.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("IndexOutOfBoundsException: " + e.getMessage());
      return null;
    }
  }

  // public static ArrayList sort() {
  //   Cd [] cdArray = cds.toArray(new Cd[cds.size()]);
  //   cdArray.sort()
  // }
}
