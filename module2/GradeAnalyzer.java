import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {

    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");

        // Step 2: calculate average
        double avg = calculateAverage(scores);

        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }

            if (score < lowest) {
                lowest = score;
            }
        }

        if (scores.isEmpty()) {
            highest = 0;
            lowest = 0;
        }

        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        // Step 3: write and print report
        writeReport(scores, avg, highest, lowest, "report.txt");

        System.out.println("A grades: " + countA);
        System.out.println("B grades: " + countB);
        System.out.println("C grades: " + countC);
        System.out.println("D grades: " + countD);
        System.out.println("F grades: " + countF);
    }
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    int score = Integer.parseInt(line);
                    scores.add(score);
                } catch (NumberFormatException e) {
                    System.out.println("Warning line at the input " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0.0;

        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        // Count grade bands
        for (int score : scores) {
            if (score >= 90) {
                countA++;
            } else if (score >= 80) {
                countB++;
            } else if (score >= 70) {
                countC++;
            } else if (score >= 60) {
                countD++;
            } else {
                countF++;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("===== Grade Report =====\n");
            writer.write(String.format("Number of scores: %d%n", scores.size()));
            writer.write(String.format("Average score:   %.2f%n", avg));
            writer.write(String.format("Highest score:   %d%n", high));
            writer.write(String.format("Lowest score:    %d%n", low));
            writer.write("\n");
            writer.write("Grade Bands:\n");
            writer.write(String.format("A (90-100): %d%n", countA));
            writer.write(String.format("B (80-89):  %d%n", countB));
            writer.write(String.format("C (70-79):  %d%n", countC));
            writer.write(String.format("D (60-69):  %d%n", countD));
            writer.write(String.format("F (below 60): %d%n", countF));

            System.out.println("===== Grade Report =====");
            System.out.println(String.format("Number of scores: %d", scores.size()));
            System.out.println(String.format("Average score:   %.2f", avg));
            System.out.println(String.format("Highest score:   %d", high));
            System.out.println(String.format("Lowest score:    %d", low));
            System.out.println();
            System.out.println("Grade Bands:");
            System.out.println(String.format("A (90-100): %d", countA));
            System.out.println(String.format("B (80-89):  %d", countB));
            System.out.println(String.format("C (70-79):  %d", countC));
            System.out.println(String.format("D (60-69):  %d", countD));
            System.out.println(String.format("F (below 60): %d", countF));

        } catch (IOException e) {
            System.out.println("Error writing report: " + e.getMessage());
        }
    }
}