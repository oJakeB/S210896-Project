package uk.ac.uos.i2p.assignment;
import uk.ac.uos.i2p.assignment.ContactTracingImpl;

import java.awt.desktop.QuitEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class TaskTwo {
    static Scanner takeInput = new Scanner(System.in);
    static ContactTracingImpl contactTracing = new ContactTracingImpl();
    public static String studentName;
    public static String studentNumber;
    public static String covidResult;
    public static String positiveResultFile;
    public static String contactTracedFile;

    public static void setStudentName(){
        System.out.println("Please Input Student Name:");
        studentName = takeInput.nextLine();
    }

    public static void setStudentNumber(){
        System.out.println("Please Input Student Number:");
        studentNumber = takeInput.nextLine();
    }

    public static void setCovidResult(){
        System.out.println("Please Input COVID Result:");
        covidResult = takeInput.nextLine();
    }

    public static void compareCovidResult(){
        if(covidResult.toLowerCase().equals("positive")){
            System.out.println("Please Input Name For Positive Result File");
            positiveResultFile = takeInput.nextLine();
            writeResultFile(positiveResultFile);
        }
        else{
            System.out.println("Covid Result Is Negative");
        }
    }

    public static void writeResultFile(String filename){
        File outputFile = new File("./covid outputs/" + filename + ".txt");
        //outputFile.getParentFile().mkdirs();
        FileWriter writingObject;
        try{
            outputFile.createNewFile();
            writingObject = new FileWriter(outputFile.getAbsolutePath());
            writingObject.write(studentName + "\n" + studentNumber + "\n\n");
            writingObject.close();
        } catch (IOException e) {
            System.out.println("An Exception Has Been Caught:");
            System.exit(1);
        }
    }
}
