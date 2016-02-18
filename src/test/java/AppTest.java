import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

    @Test
    public void rootTest() {
        goTo("http://localhost:4567");
        assertThat(pageSource()).contains("CD Collection");
    }

    @Test
    public void fillFormTest() {
        goTo("http://localhost:4567");
        fill("#cdName").with("XO");
        submit(".btn");
        assertThat(pageSource()).contains("XO");
    }

    @Test
    public void goHome() {
      goTo("http://localhost:4567");
      fill("#cdName").with("XO");
      submit(".btn");
      click("a", withText("Go home"));
      assertThat(pageSource()).contains("CD Collection");
    }

    @Test
    public void showArtists() {
      goTo("http://localhost:4567/home");
      click("a", withText("View Artists"));
      assertThat(pageSource()).contains("Your Artists");
    }

    @Test
    public void addCd() {
      goTo("http://localhost:4567/home");
      click("a", withText("Add Cd"));
      fill("#cdName").with("XO");
      submit(".btn");
      assertThat(pageSource()).contains("XO");
    }
}
