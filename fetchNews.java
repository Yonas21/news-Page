/**
 * Created by Yon MomBoy on 5/26/2018.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class fetchNews {

    public static void getNews() throws FileNotFoundException {
        //instantiate the environment variables
        System.setProperty("webdriver.chrome.driver","F:\\in\\jetbrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //set the intial page that we navigate to
        webDriver.get("https://addisfortune.net/articles/");

        String source = webDriver.getPageSource();

//        //BufferedWriter bufferedWriter = new BufferedWriter(source,);
//        System.out.println("Page Title: "+webDriver.getTitle());
//        System.out.println("page source: "+webDriver.getPageSource().toString().length());
//        System.out.println("Current URL: "+webDriver.getCurrentUrl());

        // write into files
        File news = new File("F:\\3rd Second Semister\\Software II\\web Automation\\index.html");

        //read the file and store it
        Scanner scanner = new Scanner(news);
        StringBuilder stringBuilder = new StringBuilder();

        //input the file every time they has gotten
        while (scanner.hasNext()){
            String string = scanner.nextLine();
            stringBuilder.append(string);
        }
        stringBuilder.append(source);

        //write the file
        PrintWriter printWriter = new PrintWriter(news);

        printWriter.print(stringBuilder.toString());
        printWriter.close();

        //read and write to the text file
        File textFile = new File("F:\\3rd Second Semister\\Software II\\web Automation\\pages.txt");
        PrintWriter printWriter1 = new PrintWriter(textFile);


        List<WebElement> elementList = webDriver.findElements(By.tagName("a")); //to find every links for the articles

        for (int i = 0;i<elementList.size();i++){
            System.out.println(i); //test if it works
            String text =  elementList.get(i).getAttribute("href");

            if(elementList !=null && elementList.indexOf("https://addisfortune.net/articles/")!=-1){
                printWriter1.print(text);
                System.out.println(text);
            }

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        webDriver.close(); //close the chrome web driver
        printWriter1.close(); //close the file writer
    }

    public static void updateNews() throws FileNotFoundException {
        //here again system setup
        System.setProperty("webdriver.chrome.driver","F:\\in\\jetbrains\\chromedriver_win32\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        //files where we write into and display
        File text = new File("F:\\3rd Second Semister\\Software II\\web Automation\\pages.txt");
        File html = new File("F:\\3rd Second Semister\\Software II\\web Automation\\index.html");


        //update the written file
        PrintWriter printWriter = new PrintWriter(html);
        Scanner scanner = new Scanner(text);
        while (scanner.hasNext()){
            String string = scanner.nextLine();//get string from input devices
            webDriver.navigate().to(string); //because we get the link from the text file

            //get page source from the article
            String source = webDriver.getPageSource();
            //finally write file into newss page
            File displayPage = new File("F:\\3rd Second Semister\\Software II\\web Automation\\index.html");
            PrintWriter printWriter1 = new PrintWriter(displayPage);
            printWriter1.print(source); //write the page source into html file
            printWriter1.close();

            //final write to the file or update
            printWriter.print("<a href = \"" +webDriver.getTitle() + ".html\" > " + webDriver.getTitle() + "</a><br>"); //write the article link as full links/href

        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the opened ones
        webDriver.close();
        printWriter.close();
    }

}
