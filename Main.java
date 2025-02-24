import gui.GUI;
import transfer.Question;

public class Main {
    public static void main(String[] args) {
        Question statementOne = new Question("Welcome to my USH Project, where you decide if events-- by which created the atomic bomb-- had happened. Press the button to continue");
        System.out.println(statementOne.getUserPressedButton());  

        Question questionOne = new Question("August 2nd, 1939: Albert Einstein HAD written to FDR about the Nazi’s nuclear program, Uranverein, and the letter had reached FDR", 11);
        getAnswer(questionOne, Plausibility.ONE_TRUE, Plausibility.ONE_FALSE);

        Question questionTwo = new Question("April 12, 1945: President FDR dies, and president Truman takes his place. Shortly after being inaugurated, he was informed about the Manhattan project and he AGREED to allow the program to continue running", 11);
        getAnswer(questionTwo, Plausibility.TWO_TRUE, Plausibility.TWO_FALSE);

        Question questionThree = new Question("July, 1945: Oppenihimmer, along with some of his peers, realize the minimal, but non-zero possibility that the nuclear bomb could light the atmosphere on fire-- virtually ending the world-- and AGREEING to proceed with the Trinity test.", 11);
        getAnswer(questionThree, Plausibility.THREE_TRUE, Plausibility.THREE_FALSE);

        Question questionFour = new Question("July 26 to early August, 1945: Truman had warned Japan to completely surrender, and-- due to their lack of cooperation he was left with a decision. He DECIDED to bomb Nagasaki and Hiroshima, to end the war (we will ignore the third plausible bombing for simplicity)", 11);
        getAnswer(questionFour, Plausibility.FOUR_TRUE, Plausibility.FOUR_FALSE);        

        new Question("");
    }
    private static void getAnswer(Question question, Plausibility oneTrue, Plausibility oneFalse) {
        if (question.getUserPressedButton()) {
            new Question(oneTrue.txt);
            if(oneTrue.ending) {
                GUI.ending = true;
            }
            return;
        }
        new Question(oneFalse.txt);
        if(oneFalse.ending) {
            GUI.ending = true;
        }
    }
}
