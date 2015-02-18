package Lesson_4;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Scanner;

public class Lesson4 {

    @BeforeClass
    public void SomeBeforeClass() {
        String test_text = "8.0";
        File file = new File("..\\Selenium-bionic4\\Myfile.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                out.print(test_text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void SomeTest4() {
        File file1 = new File("..\\Selenium-bionic4\\Myfile.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s1;
        s1 = sc.nextLine();
        boolean s0 = s1.matches("^\\d+(\\.\\d+)");
        Assert.assertEquals(s0, true);
		sc.close();
    }

    @AfterClass
    public void SomeAfterClass(){
        new File("..\\Selenium-bionic4\\Myfile.txt").delete();
    }
}



