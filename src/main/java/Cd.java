import java.util.ArrayList;

public class Cd {
  public static ArrayList<Cd> cds = new ArrayList<Cd>();

  private String mTitle;

  public Cd(String title) {
    mTitle = title;
    cds.add(this);
  }

  public String getTitle() {
    return mTitle;
  }

  public static ArrayList all() {
    return cds;
  }

  // public static ArrayList sort() {
  //   Cd [] cdArray = cds.toArray(new Cd[cds.size()]);
  //   cdArray.sort()
  // }
}
