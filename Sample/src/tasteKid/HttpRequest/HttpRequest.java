package tasteKid.HttpRequest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import tasteKid.utils.Log;

public class HttpRequest {

  private static final String LOG_TAG = HttpRequest.class.getSimpleName();
  private static final String USER_AGENT = "Mozilla/5.0";

  public static void postData(final String url, List<String> nameValueList) {
    /*
     * try { HttpClient httpClient = new DefaultHttpClient(); HttpPost httpPost = new
     * HttpPost(url);// "http://10.0.0.8:7777/HttpPostServlet/servlet/httpPostServlet"
     * List<NameValuePair> list = nameValueList; httpPost.setEntity(new UrlEncodedFormEntity(list));
     * HttpResponse response = httpClient.execute(httpPost); Log.d(LOG_TAG, "response :" +
     * response); } catch (Exception e) { Log.e(LOG_TAG, e.getMessage()); System.out.println(e); }
     */

  }

  public static String getData(final String url) {
    return getData(url, null, null);
  }

  public static String getData(final String url, List<Pair<String, String>> list,
      String tasteKidParams) {
    String data = "";
    HttpURLConnection httpUrlConnection = null;
    String urlParams = encodeTasteKidParams(url, tasteKidParams);
    urlParams = generateUrlWithParams(urlParams, list);
    try {
      httpUrlConnection = (HttpURLConnection) new URL(urlParams).openConnection();
      httpUrlConnection.setRequestMethod("GET");
      httpUrlConnection.setRequestProperty("User-Agent", USER_AGENT);
      InputStream in = new BufferedInputStream(httpUrlConnection.getInputStream());

      data = readStream(in);

    } catch (MalformedURLException exception) {
      Log.e(LOG_TAG, "MalformedURLException: " + exception.getMessage());
    } catch (IOException exception) {
      Log.e(LOG_TAG, "IOException:" + exception.getMessage());
    } finally {
      if (null != httpUrlConnection)
        httpUrlConnection.disconnect();
    }
    Log.d(LOG_TAG, "data : getData: " + data);
    return data;
  }

  public static String encodeTasteKidParams(String url, String tasteKidParams) {
    if (tasteKidParams == null) {
      return url;
    }

    String retVal = null;
    try {
      retVal = URLEncoder.encode(tasteKidParams, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      Log.d(LOG_TAG, "UnsupportedEncodingException :" + e.getMessage());
    }
    return url + retVal;
  }

  // Generates GET URL.
  private static String generateUrlWithParams(String url, List<Pair<String, String>> list) {
    if (list == null) {
      return url;
    }
    StringBuilder retVal = new StringBuilder(url);
    retVal.append("&");
    for (Pair<String, String> pair : list) {
      retVal.append(pair.first);
      retVal.append("=");
      retVal.append(pair.second);
      retVal.append("&");
    }
    return retVal.toString();
  }

  private static String readStream(InputStream in) {
    BufferedReader reader = null;
    StringBuffer data = new StringBuffer("");
    try {
      reader = new BufferedReader(new InputStreamReader(in));
      String line = "";
      while ((line = reader.readLine()) != null) {
        data.append(line);
      }
    } catch (IOException e) {
      Log.e(LOG_TAG, "IOException");
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return data.toString();
  }

  public static class Pair<U, V> {
    public U first;
    public V second;

    public Pair(U u, V v) {
      first = u;
      second = v;
    }
  }
}
