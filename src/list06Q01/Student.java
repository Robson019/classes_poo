package list06Q01;

public class Student {
    private String name;
    private String registration;
    private String address;
    private double[] scores;

    public Student(String name, String registration, String address, double[] scores) {
        setName(name);
        setRegistration(registration);
        setAddress(address);
        setScores(scores);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    public double average(double[] scores) {
        double sum = 0;
        for (int j = 0; j < scores.length; j++) {
            sum += scores[j];
        }
        return sum / scores.length;
    }
}
