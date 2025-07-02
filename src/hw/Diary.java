package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.time.LocalDateTime;

public class Diary {

    public static void main(String[] args) throws IOException {

        DiaryManager diaryManager = new DiaryManager();
        diaryManager.run();


    }
}
