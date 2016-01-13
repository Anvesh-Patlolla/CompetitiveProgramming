package tasteKid;

import java.util.ArrayList;
import java.util.List;

import tasteKid.HttpRequest.HttpRequest;
import tasteKid.HttpRequest.HttpRequest.Pair;
import tasteKid.utils.JsonParser;

public class Driver {
  private static final String LOG_TAG = Driver.class.getSimpleName();
  String DATA =
      "{\"Similar\": {\"Info\": [{\"Name\": \"Red Hot Chili Peppers\", \"Type\": \"music\"}, {\"Name\": \"Pulp Fiction\", \"Type\": \"movie\"}], \"Results\": [{\"Name\": \"John Frusciante\", \"Type\": \"music\"}, {\"Name\": \"Reservoir Dogs\", \"Type\": \"movie\"}, {\"Name\": \"Kill Bill\", \"Type\": \"movie\"}, {\"Name\": \"Foo Fighters\", \"Type\": \"music\"}, {\"Name\": \"Audioslave\", \"Type\": \"music\"}, {\"Name\": \"Jackie Brown\", \"Type\": \"movie\"}, {\"Name\": \"Incubus\", \"Type\": \"music\"}, {\"Name\": \"Death Proof\", \"Type\": \"movie\"}, {\"Name\": \"Sublime\", \"Type\": \"music\"}, {\"Name\": \"Snatch\", \"Type\": \"movie\"}, {\"Name\": \"Full Metal Jacket\", \"Type\": \"movie\"}, {\"Name\": \"Rage Against The Machine\", \"Type\": \"music\"}, {\"Name\": \"Pearl Jam\", \"Type\": \"music\"}, {\"Name\": \"From Dusk Till Dawn\", \"Type\": \"movie\"}, {\"Name\": \"Sin City\", \"Type\": \"movie\"}, {\"Name\": \"Inglourious Basterds\", \"Type\": \"movie\"}, {\"Name\": \"Lenny Kravitz\", \"Type\": \"music\"}, {\"Name\": \"Lock, Stock And Two Smoking Barrels\", \"Type\": \"movie\"}, {\"Name\": \"The Big Lebowski\", \"Type\": \"movie\"}, {\"Name\": \"Goodfellas\", \"Type\": \"movie\"}]}}";

  public static void main(String[] args) {
    String urlParams = "bleach, naruto";
   
    String url = "http://www.tastekid.com/api/similar?q=";
    List<Pair<String, String>> list = new ArrayList<Pair<String,String>>();
    list.add(new Pair<String, String>("format", "JSON"));
    list.add(new Pair<String, String>("f", "musica2239"));
    list.add(new Pair<String, String>("k", "ntc3nzywmwey"));
    String data = HttpRequest.getData(url, null, urlParams);
    JsonParser parser = new JsonParser();
    parser.parseJsonString(data);
  }
}
