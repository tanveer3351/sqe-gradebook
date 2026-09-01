class GradeBook {

    public int sumScores(Student student) {
        int sum = 0;

        for (int score : student.getScores()) {
            sum += score;
        }

        return sum;
    }

    public double avgScores(Student student) {
        
        return (double) sumScores(student) / student.getScores().size();
    }
}
