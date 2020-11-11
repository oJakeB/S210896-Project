package uk.ac.uos.i2p.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ContactTracingImpl implements ContactTracing{
    private Map<String, String> studentList;
    private  Map<String, String> courseList;
    private Map<String, String> emailList;
    private Map<String, String> studentCourseList;
    public void loadStudentList(Map<String, String> studentEntry){
        studentList = studentEntry;
    }
    public void loadCourseList(Map<String, String> courseEntry){
        courseList = courseEntry;
    }
    public void loadEmailList(Map<String, String> emailEntry){
        emailList = emailEntry;
    }
    public void loadStudentCourseList(Map<String, String> studentCourseEntry){
        studentCourseList = studentCourseEntry;
    }
    public List<String> findMatchingCourses(String inputStudentNumber){
        String returnValue = studentCourseList.get(inputStudentNumber);
        List<String> courseList = new ArrayList<String>();

        if(returnValue != null){
            courseList.add(returnValue);
        }

        return courseList;
    }
    public List<String> findMatchingStudents(List<String> matchingCourseList){

        List<String> matchingStudents = new ArrayList<String>();

        matchingCourseList.forEach((courseID)->{
            studentCourseList.forEach((studentID, secondCourseID)->{
                if(secondCourseID == courseID){
                    matchingStudents.add(studentID);
                }
            });
        });

        return matchingStudents;
    }
    public List<String> contactTracing(String inputStudentNumber) {

        List<String> matchingEmails = new ArrayList<String>();
        List<String> matchingCourseList = findMatchingCourses(inputStudentNumber);
        List<String> studentIDList = findMatchingStudents(matchingCourseList);

        //removing already positive student so he doesn't flag up again
        studentIDList.remove(studentIDList.indexOf(inputStudentNumber));

        System.out.println("Course ID: \n" + matchingCourseList.get(0));
        System.out.println("Contact traced for given course: \n" + studentIDList.get(0));
        System.out.println("Matched this student: \n" + inputStudentNumber);

        emailList.forEach((studentNumber, emailAddress) -> {
            if (studentNumber == studentIDList.get(0)) {
                matchingEmails.add(emailAddress);
            }
        });
        return matchingEmails;

    }
}
