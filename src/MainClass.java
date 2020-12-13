import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.ac.uos.i2p.assignment.*;

public class MainClass {
    public static ContactTracingImpl loadData() {
        //creates a new HashMap and assigns it student names and unique IDs
        HashMap<String, String> studentList = new HashMap<String, String>();
        studentList.put("Clint Eastwood", "S101");
        studentList.put("Jamie Foxx", "S102");
        studentList.put("Olivia Wilde", "S103");
        //creates a new HashMap and assigns it student IDs and their respective email addresses
        HashMap<String, String> emailList = new HashMap<String, String>();
        emailList.put("S101", "abc@uos.ac.uk");
        emailList.put("S102", "xyz@uos.ac.uk");
        emailList.put("S103", "klm@uos.ac.uk");
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

        //creates an instance of the class, so we can call the methods
        ContactTracingImpl contactTracingInstance = new ContactTracingImpl();

        contactTracingInstance.loadStudentList(studentList);
        contactTracingInstance.loadEmailList(emailList);
        contactTracingInstance.loadCourseList(courseList);
        contactTracingInstance.loadStudentCourseList(studentCourseList);

        List<String> returnCourseList = new ArrayList<String>();
        List<String> returnMatchingStudentList = new ArrayList<String>();
        List<String> returnEmailList = new ArrayList<String>();

        returnCourseList = contactTracingInstance.findMatchingCourses("S101");
        //System.out.println(returnCourseList);

        returnMatchingStudentList = contactTracingInstance.findMatchingStudents(returnCourseList);
        //System.out.println(returnMatchingStudentList);

        returnEmailList = contactTracingInstance.contactTracing("S103");
        System.out.println(returnEmailList);

        return contactTracingInstance;
    }

    public static void main(String[] args){
        //calls the loadData method when the program is run
        loadData();
    }
}

