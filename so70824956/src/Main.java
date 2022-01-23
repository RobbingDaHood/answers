import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] questions = new String[100];
        String[] answers = new String[100];
        String yourAnimal = new String();
        String yourQuestion = new String();
        boolean isDone = false;
        boolean wantToPlay = true;
        int answer1 = 0;
        int pos = 0, oldPos = 0;
        // change the questioning to include a human being and an insect
        questions[0] = "Does the animal you are thinking of have legs?";
        questions[1] = "Does it have a tail?";
        questions[2] = "Is it a fish?";
        questions[3] = "Is it a dog?";
        questions[4] = "Is it small?";
        questions[9] = "Is it a human?";
        questions[10] = "Is it an insect?";
        //I added human and insect to the questions
        answers[2] = "fish";
        answers[3] = "dog";
        answers[7] = "human";
        answers[8] = "insect";
        while (wantToPlay) {
            isDone = false;
            while (!isDone) {
                //This code only executes if it is the first iteration asking if the animal has legs
                if (questions[pos] != null) {
                    answer1 = JOptionPane.showConfirmDialog(null, questions[pos]);

                    if (answer1 == JOptionPane.YES_OPTION) {
                        if (answers[pos] != null) {
                            JOptionPane.showMessageDialog(null, "Yay! I win!");
                            isDone = true;
                            pos = 0;
                        } else {
                            pos = pos * 2 + 1;
                        }
                    } else {
                        pos = pos * 2 + 2;
                    }
                }

                if (questions[pos] == null) {
                    yourAnimal = JOptionPane.showInputDialog(null, "I give up.\nWhat was your animal?");
                    yourQuestion = JOptionPane.showInputDialog(null, "Type a question for which the answer is Yes for " + answers[oldPos] + "\nbut No for " + yourAnimal + ".");
                    JOptionPane.showMessageDialog(null, "pos = " + pos);
                    questions[pos * 2 + 2] = questions[pos];
                    questions[pos] = yourQuestion;
                    questions[pos * 2 + 1] = "Is it a " + yourAnimal + "?";
                    answers[pos * 2 + 2] = answers[pos];
                    answers[pos * 2 + 1] = yourAnimal;
                    answers[pos] = null;
                    isDone = true;
                    pos = 0;
                }
            }
            answer1 = JOptionPane.showConfirmDialog(null, "Do you want to play again?");
            wantToPlay = (answer1 == JOptionPane.YES_OPTION);
        }
    }
}