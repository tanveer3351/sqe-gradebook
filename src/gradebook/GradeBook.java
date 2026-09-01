class GradeBook {

    public int sumScores(Student student) {
        int sum = 0;

        for (int score : student.getScores()) {
            sum += score;
        }

        return sum;
    }

    public double avgScores(Student student) {
        if (student.getScores().isEmpty()) {
            return 0;
        }

        return (double) sumScores(student) / student.getScores().size();
    }
}
