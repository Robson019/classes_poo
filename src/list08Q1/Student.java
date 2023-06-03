package list08Q1;

public class Student extends People {
    private double[] score;

    public Student(String name, String cpf, String birthDate, double[] score) {
        super(name, cpf, birthDate);
        setScore(score);
    }

    public double[] getScore() {
        return score;
    }

    public String showScoreBoard() {
        String board = "["+score[0]+", "+score[1]+", "+score[2]+", "+score[3]+"]";

        return board;
    }

    public void setScore(double[] score) {
        this.score = score;
    }

    public double scoreAVG(double[] score) {
        double sum = 0;

        for (int j = 0; j < 4; j++) {
            sum += score[j];
        }

        return sum/4;
    }
}
