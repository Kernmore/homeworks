package academy.prog;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    private List<Question> list = new ArrayList<>();
    private int count = 0;

    public Questions(){
        list.add(new Question("Do you have pets?"));
        list.add(new Question("Do you like pizza??"));
        list.add(new Question("Do you smoke cigarettes?"));
        list.add(new Question("Did you do your homework??"));
    }

    public List<Question> getList() {
        return list;
    }

    public String getQuestion(){
        Question temp = list.get(count);
        count++;
        return temp.getQuestion();
    }

    public void setCountToZero(){
        count = 0;
    }
}
