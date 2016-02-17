import java.util.ArrayList;
import java.util.HashMap;

public class Artist {
  private String mName;
  HashMap<String, Cd> mArtistCds;

  public Artist(String name) {
    mName = name;
    mArtistCds = new HashMap<String, Cd>();
  }

  public void addCd(Cd cd) {
    mArtistCds.put(cd.getTitle(), cd);
  }

  public HashMap viewCds() {
    return mArtistCds;
  }

}
