package com.company;

import java.io.*;

public class ReadAndWrite {

    public static void main(String[] args) {
        try {
            File inputFile = new File("src/input.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String newLine;
            StringBuilder text = new StringBuilder();
            while ((newLine = reader.readLine()) != null) {
                text.append(newLine).append("\n");
            }
            reader.close();
            String paragraph = text.toString().replaceAll("= ", "");
            String[] numbers = paragraph.split("\n");
            int sumOfX = 0;
            int sumOfY = 0;
            for (String number : numbers) {
                int num = Integer.parseInt(number.substring(1));
                if (number.charAt(0) == 'x')  sumOfX += num;
                else if (number.charAt(0) == 'y')  sumOfY += num;
            }

            File outputFile = new File("src/output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
            bufferedWriter.write("x= " + sumOfX + "\ny= " + sumOfY);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
