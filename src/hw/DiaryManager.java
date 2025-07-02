package hw;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class DiaryManager {

    private final Path diaryPath = Path.of("malika/diary.txt");
    private final Path logPath = Path.of("malika/diary.log");
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public String RESET = "\u001B[0m";
    public String RED = "\u001B[31m";
    public String BLUE = "\u001B[34m";

    public void run() throws IOException {
        createDirectories();
        String userInput = getUserInput();
        String reversed = reverseString(userInput);
        writeToDiary(reversed);
        readAndPrintDiary();
        logActivity(userInput);
        System.out.println(getLocalDateTime());
        readAndPrintLog();
    }


    private void createDirectories() throws IOException {
        Files.createDirectories(Path.of("malika"));
    }

    private String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    private String reverseString(String text) {
        return new StringBuilder(text).reverse().toString();
    }

    private void writeToDiary(String text) throws IOException {
        BufferedWriter bw = Files.newBufferedWriter(diaryPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        bw.write(text);
        bw.newLine();
        bw.close();
    }

    private void readAndPrintDiary() throws IOException {
        BufferedReader br = Files.newBufferedReader(diaryPath);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    public LocalDateTime getLocalDateTime(){

        return LocalDateTime.now();


    }

    private void logActivity(String text) throws IOException {

        BufferedWriter bwLog  = Files.newBufferedWriter(logPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        String when =  getLocalDateTime() + " " + text;
        bwLog.write(RED +when + RESET);
        bwLog.newLine();
        bwLog.close();

    }

    private void readAndPrintLog() throws IOException {
        BufferedReader brLog = Files.newBufferedReader(logPath);
        String line;
        while ((line = brLog.readLine()) != null) {
            System.out.println(line);
        }
        BufferedWriter readLog  = Files.newBufferedWriter(logPath, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        String whenRead =  "information read at: "+ getLocalDateTime();
        readLog.write(BLUE + whenRead + RESET);
        readLog.newLine();
        System.out.println(BLUE + whenRead + RESET);
        readLog.close();
        brLog.close();
    }
}
