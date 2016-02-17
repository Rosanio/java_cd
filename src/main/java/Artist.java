import java.util.ArrayList;
import java.util.HashMap;

public class Artist {
  HashMap<String, Cd> mArtistCds;
  private static ArrayList<Artist> artists = new ArrayList<Artist>();

  private String mName;

  public Artist(String name) {
    mName = name;
    mArtistCds = new HashMap<String, Cd>();
    artists.add(this);
  }

  public void addCd(Cd cd) {
    mArtistCds.put(cd.getTitle(), cd);
  }

  public HashMap viewCds() {
    return mArtistCds;
  }

  public static ArrayList all() {
    return artists;
  }
}
