import java.util.ArrayList;
import java.util.HashMap;

public class Artist {
  HashMap<Integer, Cd> mArtistCds;
  private static ArrayList<Artist> artists = new ArrayList<Artist>();

  private String mName;
  private int mId;

  public Artist(String name) {
    mName = name;
    mArtistCds = new HashMap<Integer, Cd>();
    artists.add(this);
    mId = artists.size();
  }

  public String getName() {
    return mName;
  }

  public void addCd(Cd cd) {
    mArtistCds.put(mArtistCds.size(), cd);
  }

  public HashMap viewCds() {
    return mArtistCds;
  }

  public int getId() {
    return mId;
  }

  public static ArrayList all() {
    return artists;
  }

  public static Artist find(int id) {
    try {
      return artists.get(id - 1);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("IndexOutOfBoundsException: " + e.getMessage());
      return null;
    }
  }
}
