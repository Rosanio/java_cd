import org.junit.*;
import static org.junit.Assert.*;

public class testCd {

  @Test
  public void newCd_instantiatesCorrectly() {
    Cd newCd = new Cd("The Black Album");
    assertEquals(true, newCd instanceof Cd);
  }

  @Test
  public void getTitle_returnsTitle() {
    Cd newCd = new Cd("OK, Computer");
    assertEquals("OK, Computer", newCd.getTitle());
  }

  @Test
  public void all_returnsCdArrayList() {
    Cd newCd1 = new Cd("The Black Album");
    Cd newCd2 = new Cd("OK, Computer");
    assertEquals(true, Cd.all().contains(newCd1));
    assertEquals(true, Cd.all().contains(newCd2));
  }

  @Test
  public void sort_returnsSortedArrayList() {
    Cd newCd1 = new Cd("The Black Album");
    Cd newCd2 = new Cd("OK, Computer");
    assertEquals("The Black Album", Cd.all().get(1));
  }
}
