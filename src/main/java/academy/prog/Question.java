package academy.prog;

public class Question {
    public String question;
    public String answer;

    public Question(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }


    public String getAnswer() {
        return answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
