package tasteKid.utils;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

  private static final String LOG_TAG = JsonParser.class.getSimpleName();
  private final ArrayList<QuestionEntity> questionList = new ArrayList<QuestionEntity>();

  private static final String RESULTS_FIELD = "Results";

  private static final String SIMILAR_FIELD = "Similar";
  private static final String TYPE_FIELD = "Type";
  private static final String NAME_FIELD = "Name";

  public ArrayList<QuestionEntity> parseJsonString(String input) {
    try {
      //
      Log.d(LOG_TAG, "------------------------------");
      JSONObject obj = new JSONObject(input);
      JSONObject similar = obj.getJSONObject(SIMILAR_FIELD);
      JSONArray results = similar.getJSONArray(RESULTS_FIELD);
      for (int i = 0; i < results.length(); i++) {
        JSONObject temp = results.getJSONObject(i);

        Log.d(LOG_TAG, temp.getString(TYPE_FIELD));
        Log.d(LOG_TAG, temp.getString(NAME_FIELD));
        Log.d(LOG_TAG, "------------------------------");
      }

    } catch (JSONException e) {
      Log.e(LOG_TAG, e.getMessage());
    }
    return questionList;

  }
}
