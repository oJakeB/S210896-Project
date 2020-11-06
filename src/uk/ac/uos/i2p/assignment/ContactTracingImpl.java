package uk.ac.uos.i2p.assignment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ContactTracingImpl implements ContactTracing{
    private Map<String, String> studentList;
    private  Map<String, String> courseList;
    private Map<String, String> emailList;
    private Map<String, String> studentCourseList;
    public void loadStudentList(Map<String, String> studentEntry){
        //comment
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
        List<String> studentList = new ArrayList<String>();

        if(returnValue != null){
            studentList.add(returnValue);
        }
        return studentList;
    }
    public List<String> findMatchingStudents(List<String> matchingCourseList){

        List<String> matchingStudents = new ArrayList<String>();
        List<String> listOfStudentList = new ArrayList<String>(studentCourseList.values());

        for (int counter = 0; counter<matchingCourseList.size(); counter++) {

            if (studentCourseList.containsValue(matchingCourseList)){
                matchingStudents.add(listOfStudentList.get(counter2));

            }
        }
        return matchingStudents;
    }
//    public List<String> contactTracing(String inputStudentNumber){
//
//    }
}
