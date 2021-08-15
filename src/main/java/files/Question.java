package files;

import java.util.HashMap;
import java.util.Map;

public class Question {

    String questBody;
    Map <AnswersId, String> answerVariants = new HashMap();
    String goodAnswer;

    public String getQuestBody() {
        return questBody;
    }

    public void setQuestBody(String questBody) {
        this.questBody = questBody;
    }
    public Map<AnswersId, String> getAnswerVariants() {
        return answerVariants;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }
    public void setAnswerVariants(Map<AnswersId, String> answerVariants) {
        this.answerVariants = answerVariants;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }
    public void setAnswerVariantsElement(AnswersId Aid, String answerVariant) {
        answerVariants.put(Aid, answerVariant);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questBody='" + questBody + '\'' +
                ", answerVariants=" + answerVariants +
                ", goodAnswer='" + goodAnswer + '\'' +
                '}';
    }
}
