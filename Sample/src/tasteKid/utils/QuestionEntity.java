package tasteKid.utils;

public class QuestionEntity {
  public static final String FIELD_QUESTION = "QUESTION";
  public static final String FIELD_ANSWER = "ANSWER";
  public static final String FIELD_MCQ1 = "MCQ1";
  public static final String FIELD_MCQ2 = "MCQ2";
  public static final String FIELD_MCQ3 = "MCQ3";
  public static final String FIELD_MCQ4 = "MCQ4";


  public QuestionEntity(String question, String answer, String mcq1, String mcq2, String mcq3,
      String mcq4) {
    super();
    this.question = question;
    this.answer = answer;
    this.mcq1 = mcq1;
    this.mcq2 = mcq2;
    this.mcq3 = mcq3;
    this.mcq4 = mcq4;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }

  public String getMcq1() {
    return mcq1;
  }

  public String getMcq2() {
    return mcq2;
  }

  public String getMcq3() {
    return mcq3;
  }

  public String getMcq4() {
    return mcq4;
  }

  String question;
  String answer;
  String mcq1;
  String mcq2;
  String mcq3;
  String mcq4;

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(question).append(":").append(answer).append(":").append(mcq1).append(":")
        .append(mcq2).append(":").append(mcq3).append(":").append(mcq4);
    return buffer.toString();
  }
}
