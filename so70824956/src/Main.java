import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] questions = new String[100];
        String[] answers = new String[100];
        String yourAnimal = new String();
        String yourQuestion = new String();
        boolean isDone = false;
        boolean wantToPlay = true;
        int answer1=0;
        int total = 100;
        int pos = 0, oldPos = 0;
        int yesPos = 1, noPos = 2, humanPos =3, insectPos =4;
        // change the questioning to include a human being and an insect
        questions[pos] = "Does the animal you are thinking of have legs?";
        questions[1] = "Is it a dog?";
        questions[2] = "Is it a fish?";
        //I added human and insect to the questions
        questions[3] = "Is it a human?";
        questions[4] = "Is it an insect?";
        answers[1] = "dog";
        answers[2] = "fish";
        //I added human and insect to the questions
        answers[3] = "human";
        answers[4] = "insect";
        while(wantToPlay){
            pos = 0;
            isDone = false;
            while(isDone == false) {
                //This code only executes if it is the first iteration asking if the animal has legs
                if (pos == 0 ) {
                    answer1 = JOptionPane.showConfirmDialog (null, questions[pos]);
                }
                //This section of code asks if the animal you are thinking of is a dog
                else if (pos ==1) {
                    answer1 = JOptionPane.showConfirmDialog(null, questions[pos]);
                    yourAnimal = answers[pos];
                    //this only executes if they answer yes to "Is it a dog?"
                    if(answer1 == JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(null,"Yay! I win!");
                        isDone = true;
                        pos = 0;
                    }
                    //If the animal has legs but is not a dog this changes the position to position 3
                    //to ask if the animal is a human
                    else if (answer1 ==JOptionPane.NO_OPTION) {
                        pos=pos+2;
                        answer1 = JOptionPane.showConfirmDialog(null, questions[pos]);
                        yourAnimal = answers[pos];
                        //if the animal is a human this code executes successfully announcing that
                        //this animal is human
                        if(answer1 == JOptionPane.YES_OPTION)
                        {
                            JOptionPane.showMessageDialog(null,"Yay! I win!");
                            isDone = true;
                            pos = 0;
                        }
                        //This section of code executes if one agrees that the animal has legs but
                        //is not a dog or a human.
                        else if (answer1 ==JOptionPane.NO_OPTION) {
                            pos=pos+1;
                            answer1 = JOptionPane.showConfirmDialog(null, questions[pos]);
                            yourAnimal = answers[pos];
                            if(answer1 == JOptionPane.YES_OPTION)
                            {
                                JOptionPane.showMessageDialog(null,"Yay! I win!");
                                isDone = true;
                                pos = 0;
                            }
                        }
                    }
                }
                else if (pos ==2) {
                    answer1 = JOptionPane.showConfirmDialog(null, questions[pos]);
                    yourAnimal = answers[pos];
                    if(answer1 == JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(null,"Yay! I win!");
                        isDone = true;
                        pos = 0;
                    }
                }
                oldPos = pos;
                //instead of multiplying by 2, I multiplied by 4 since there are 4 inputs
                yesPos = pos *4 + 1;
                noPos =  pos *4 + 2;
                humanPos = pos *4 + 3;
                insectPos = pos *4 + 4;

                if(answer1 == JOptionPane.YES_OPTION) {
                    pos =yesPos;

                }
                else if(answer1 == JOptionPane.NO_OPTION) {
                    pos = noPos;
                }



                if(questions[pos] == null)
                {
                    if(answer1 == JOptionPane.YES_OPTION)
                    {
                        JOptionPane.showMessageDialog(null,"Yay! I win!");
                        isDone = true;
                        pos = 0;
                    }
                    else{
                        pos=yesPos;
                        yourAnimal = JOptionPane.showInputDialog(null,"I give up.\nWhat was your animal?");
                        yourQuestion = JOptionPane.showInputDialog(null,"Type a question for which the answer is Yes for " + answers[oldPos] + "\nbut No for " + yourAnimal + ".");
                        JOptionPane.showMessageDialog(null, "pos = " + pos);
                        questions[yesPos] = questions[oldPos];
                        questions[oldPos] = yourQuestion;
                        questions[noPos] = "Is it a " + yourAnimal + "?";
                        answers[yesPos] = answers[oldPos];
                        answers[noPos] = yourAnimal;
                        isDone = true;
                        pos = 0;
                    }
                }
            }
            answer1 = JOptionPane.showConfirmDialog(null,"Do you want to play again?");
            wantToPlay = (answer1 == JOptionPane.YES_OPTION);
        }
    }
}