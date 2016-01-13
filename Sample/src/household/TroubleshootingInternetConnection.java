package household;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


public class TroubleshootingInternetConnection {

  private static final String USER_AGENT =
      "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36";
  private static final String USERNAME = "naresh_metro";
  private static final String PASSWORD = "123456";
  private static final String LOGOUT_URL =
      "http://my.inventum.in:2002/userportal/logout.do?svccat=1";
  private static final String LOGIN_URL = "http://my.inventum.in:2002/userportal/newlogin.do";
  private static final boolean SWITCH_INPUT_STREAM = false;

  public static void main(String[] args) {
    TroubleshootingInternetConnection instance = new TroubleshootingInternetConnection();
    String urlParameters = instance.composeUrlParamters();
    try {
      instance.sendPost(LOGIN_URL, urlParameters);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  String composeUrlParamters() {

    String urlParameters = "username=" + USERNAME + "&password=" + PASSWORD;
    return urlParameters;

  }

  public void sendPost(final String URL, final String URL_PARAMETERS) throws IOException {

    URL obj = new URL(URL);
    java.net.HttpURLConnection con = (java.net.HttpURLConnection) obj.openConnection();

    // add reuqest header
    con.setRequestMethod("POST");
    con.setRequestProperty("User-Agent", USER_AGENT);
    con.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\r\n");
    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded\r\n");
    // String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.writeBytes(URL_PARAMETERS);
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("\nSending 'POST' request to URL : " + URL);
    System.out.println("Post parameters : " + URL_PARAMETERS);
    System.out.println("Response Code : " + responseCode);
    if (SWITCH_INPUT_STREAM) {
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response = new StringBuffer();

      while ((inputLine = in.readLine()) != null) {
        response.append(inputLine);
      }
      in.close();
      // print result
      System.out.println(response.toString());
    }
  }

}
