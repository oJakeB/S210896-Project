import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uk.ac.uos.i2p.assignment.*;

public class MainClass {
    public static ContactTracingImpl loadData() {
        HashMap<String, String> studentList = new HashMap<String, String>();
        studentList.put("Clint Eastwood", "S101");
        studentList.put("Jamie Foxx", "S102");
        studentList.put("Olivia Wilde", "S103");

        HashMap<String, String> emailList = new HashMap<String, String>();
        emailList.put("S101", "abc.uos.ac.uk");
        emailList.put("S102", "xyz@uos.ac.uk");
        emailList.put("S103", "klm@uos.ac.uk");

        HashMap<String, String> courseList = new HashMap<String, String>();
        courseList.put("Software Engineering", "SE01");
        courseList.put("Network Engineering", "NE02");
        courseList.put("Cyber Security", "CS03");

        HashMap<String, String> studentCourseList = new HashMap<String, String>();
        studentCourseList.put("S101", "SE01");
        studentCourseList.put("S102", "NE02");
        studentCourseList.put("S103", "SE01");

        ContactTracingImpl test = new ContactTracingImpl();

        test.loadStudentList(studentList);
        test.loadEmailList(emailList);
        test.loadCourseList(courseList);
        test.loadStudentCourseList(studentCourseList);

        List<String> returnCourseList = new ArrayList<String>();
        List<String> returnMatchingStudentList = new ArrayList<String>();

        returnCourseList = test.findMatchingCourses("S101");
        System.out.println(returnCourseList);

        returnMatchingStudentList = test.findMatchingStudents(returnCourseList);
        System.out.println(returnMatchingStudentList);

        return test;
    }

    public static void main(String[] args){

        loadData();

    }
}

