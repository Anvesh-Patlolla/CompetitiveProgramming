package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class CodeCheckerException {


  private static final String EOL = "###############";
  private static String lang = "";

  static String inputFromKeyboard2() {
    StringBuilder source = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    lang = sc.next();
    String s = null;
    ArrayList<String> list = new ArrayList<>();
    while ((s = sc.nextLine()) != EOL /* && count < 2 */) {
      source.append(s);
      // System.out.println("dfghjk -"+s);
    }
    System.out.println(source.toString());
    return source.toString();


  }

  static String getLang(String lang) {

    if (lang.equalsIgnoreCase("java")) {
      return "2";
    }
    if (lang.equalsIgnoreCase("cpp") || lang.equalsIgnoreCase("c++")) {
      return "1";
    }
    return "3";
  }

  public static void main(String[] args) {
    String source = inputFromKeyboard2();
    // JSONObject json = buildJsonObject(getLang(lang), source);
    String url = null;
    url =
        "api.hackerrank.com/checker/submission.json&details?method=post&source=" + source
            + "&lang=" + getLang(lang)
            + "&api_key=hackerrank|65273-456|b246982180d194e285c9e0c299a5e407dda9b204";
    try {
      url = URLEncoder.encode(url, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String retVal = null;
    try {
      retVal = connectionUtil(url);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    JSONObject jsonObject = null;
    try {
      jsonObject = new JSONObject(retVal);
    } catch (JSONException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    String stderr = "";
    try {
      stderr = jsonObject.getString("stderr");
    } catch (JSONException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    //System.out.println(stderr);
    int start = stderr.indexOf("Solution.java:");
    int end = stderr.indexOf(")", start);
    System.out.println(stderr.substring(start+"Solution.java:".length(),end));
  }

  static JSONObject buildJsonObject(String lang, String source) {
    JSONObject jsonString = new JSONObject();
    try {
      jsonString.put("source", source).put("lang", lang)
          .put("api_key", "hackerrank|65273-456|b246982180d194e285c9e0c299a5e407dda9b204");
    } catch (JSONException e) {
      e.printStackTrace();
    }

    System.out.println(jsonString.toString());
    return jsonString;
  }

  static String connectionUtil(String url) throws IOException {
    int timeout = 3000;
    HttpURLConnection c = null;
    URL u = null;
    u = new URL(url);

    c = (HttpURLConnection) u.openConnection();
    try {
      c.setRequestMethod("POST");
    } catch (ProtocolException e) {
      e.printStackTrace();
    }
    c.setRequestProperty("Content-length", "0");
    c.setUseCaches(false);
    c.setAllowUserInteraction(false);
    c.setConnectTimeout(timeout);
    c.setReadTimeout(timeout);
    try {
      c.connect();
    } catch (IOException e) {
      e.printStackTrace();
    }
    int status = -1;
    try {
      status = c.getResponseCode();
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (status == 200 || status == 201) {
      BufferedReader br = new BufferedReader(new InputStreamReader(c.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = br.readLine()) != null) {
        sb.append(line + "\n");
      }
      br.close();
      return sb.toString();
    }

    return "";
  }

}
