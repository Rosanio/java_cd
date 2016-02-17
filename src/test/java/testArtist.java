import org.junit.*;
import static org.junit.Assert.*;

public class testArtist {

  @Test
  public void artist_instantiatesCorrectly() {
    Artist newArtist = new Artist("Elliott Smith");
    assertEquals(true, newArtist instanceof Artist);
  }

  @Test
  public void addCd_toArrayList_true() {
    Artist newArtist = new Artist("Elliott Smith");
    Cd elliottSmithCd = new Cd("XO");
    newArtist.addCd(elliottSmithCd);
    assertEquals(true, newArtist.viewCds().containsValue(elliottSmithCd));
  }

  @Test
  public void addCd_toArrayListContainedInSpecificArtist_false() {
    Artist newArtist1 = new Artist("Elliott Smith");
    Artist newArtist2 = new Artist("James Blake");
    Cd elliottSmithCd = new Cd("XO");
    Cd jamesBlakeCd = new Cd("Retrograde");
    newArtist1.addCd(elliottSmithCd);
    newArtist2.addCd(jamesBlakeCd);
    assertEquals(false, newArtist1.viewCds().containsValue(jamesBlakeCd));
  }

  @Test
  public void all_returnsArtistArrayList() {
    Artist newArtist1 = new Artist("Elliott Smith");
    Artist newArtist2 = new Artist("James Blake");
    Artist newArtist3 = new Artist("Notwist");
    assertEquals(true, Artist.all().contains(newArtist1));
    assertEquals(true, Artist.all().contains(newArtist2));
    assertEquals(true, Artist.all().contains(newArtist3));
  }
}
