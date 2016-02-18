import java.util.HashMap;
import java.util.ArrayList;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public/");
    String layout = "templates/layout.vtl";
    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/cds", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String cdName = request.queryParams("cdName");
      if(cdName != null) {
        Cd myCd = new Cd(cdName);
      }
      model.put("cds", Cd.all());
      model.put("template", "templates/cds.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/artists", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String artistName = request.queryParams("artistName");
      Artist myArtist;
      if(artistName != null) {
        myArtist = new Artist(artistName);
      }

      model.put("artists", Artist.all());
      model.put("template", "templates/artists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/addCd", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/addCd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/addArtist", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/addArtist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/cds/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Cd cd = Cd.find(Integer.parseInt(request.params(":id")));
      model.put("cd", cd);
      model.put("template", "templates/cd.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/artists/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      System.out.println(request.params(":id"));
      String cdName = request.queryParams("assignCd");
      System.out.println(cdName);
      if(cdName != null) {
        Cd assigned = new Cd(cdName);
        artist.addCd(assigned);
        System.out.println(artist.viewCds().size());
        ArrayList<String> artistCds = new ArrayList<String>();
        for(Integer i = 1; i <= 2; i++) {
          Cd tempCd = (Cd)artist.viewCds().get(i);
          System.out.println("tempcd title?" + tempCd.getTitle());
          artistCds.add(tempCd.getTitle());
        }
        model.put("artistCds", artistCds);
      }

      else {
        System.out.println("broken");
      }
      model.put("artist", artist);
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/home/artists/:id/assign", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Artist artist = Artist.find(Integer.parseInt(request.params(":id")));
      model.put("artist", artist);

      model.put("template", "templates/assign.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
