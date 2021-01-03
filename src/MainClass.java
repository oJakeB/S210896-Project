import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;
import uk.ac.uos.i2p.assignment.*;

public class MainClass {
    public static ContactTracingImpl loadData() {
        //creates a new HashMap and assigns it student names and unique IDs
        HashMap<String, String> studentList = new HashMap<String, String>();
        studentList.put("Clint Eastwood", "S101");
        studentList.put("Jamie Foxx", "S102");
        studentList.put("Olivia Wilde", "S103");
        studentList.put("Brad Pitt", "S104");
        studentList.put("Barack Obama", "S105");
        studentList.put("Kim Kardashian", "S106");
        studentList.put("Taylor Swift", "S107");
        studentList.put("Kanye West", "S108");
        studentList.put("Tom Cruise", "S109");

        //creates a new HashMap and assigns it student IDs and their respective email addresses
        HashMap<String, String> emailList = new HashMap<String, String>();
        emailList.put("S101", "abc@uos.ac.uk");
        emailList.put("S102", "xyz@uos.ac.uk");
        emailList.put("S103", "klm@uos.ac.uk");
        emailList.put("S104", "bdp@uos.ac.uk");
        emailList.put("S105", "bob@uos.ac.uk");
        emailList.put("S106", "kkm@uos.ac.uk");
        emailList.put("S107", "tls@uos.ac.uk");
        emailList.put("S108", "kyw@uos.ac.uk");
        emailList.put("S109", "tmc@uos.ac.uk");

        //creates a new HashMap and assigns it with a course, and a course ID
        HashMap<String, String> courseList = new HashMap<String, String>();
        courseList.put("Software Engineering", "SE01");
        courseList.put("Network Engineering", "NE02");
        courseList.put("Cyber Security", "CS03");
        //creates a new HashMap and assigns it with unique student numbers and their corresponding course ID
        HashMap<String, String> studentCourseList = new HashMap<String, String>();
        studentCourseList.put("S101", "SE01");
        studentCourseList.put("S102", "NE02");
        studentCourseList.put("S103", "SE01");
        studentCourseList.put("S104", "SE01");
        studentCourseList.put("S105", "NE02");
        studentCourseList.put("S106", "SE01");
        studentCourseList.put("S107", "SE01");
        studentCourseList.put("S108", "NE02");
        studentCourseList.put("S109", "SE01");

        //creates an instance of the class (otherwise known as an object), so we can call the methods
        ContactTracingImpl contactTracingInstance = new ContactTracingImpl();

        contactTracingInstance.loadStudentList(studentList);
        contactTracingInstance.loadEmailList(emailList);
        contactTracingInstance.loadCourseList(courseList);
        contactTracingInstance.loadStudentCourseList(studentCourseList);

        return contactTracingInstance;
    }


    public static void main(String[] args){
        //calls the loadData method when the program is run

        ContactTracingImpl ContactTracingObject = loadData();

        TaskTwo taskTwoObject = new TaskTwo();

        taskTwoObject.setStudentName();
        taskTwoObject.setStudentNumber();
        taskTwoObject.setCovidResult();
        taskTwoObject.compareCovidResult();

        if(taskTwoObject.covidResult.toLowerCase().equals("positive")){
            //get relevant information to write ContactTracing file
            List<String> matchingCourseList = ContactTracingObject.findMatchingCourses(taskTwoObject.studentNumber);
            List<String> studentIDList = ContactTracingObject.findMatchingStudents(matchingCourseList);
            List<String> matchingEmails = ContactTracingObject.contactTracing(taskTwoObject.studentNumber);

            //removing already positive student so he doesn't flag up again
            studentIDList.remove(studentIDList.indexOf(taskTwoObject.studentNumber));

            taskTwoObject.writeSelfIsolateFile(studentIDList, matchingEmails);
        }

        //following code runs the J unit testing
        testing testingObject = new testing();
        testingObject.testFindMatchingCourses();
        testingObject.testFindMatchingStudents();
        testingObject.testContactTracing();
    }
}

