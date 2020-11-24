import java.util.ArrayList;
import java.util.Random;

import org.joda.time.DateTime;

import studentreg.*;

public class StudentRegApp {
	public static void main(String[] args) {
		ArrayList<Module> modules = MockModules();
		ArrayList<Course> courses = MockCourses(modules);
		ArrayList<Student> students = MockStudents(courses);
		
		for(int i = 0; i < students.size(); i++) {
			System.out.println("Student : " + students.get(i).getName());
			System.out.println("ID : " + students.get(i).getId());
			System.out.println("Username : " + students.get(i).getUsername());
			System.out.println("DoB : " + students.get(i).getDateOfBirth());
			System.out.println("Course : " + students.get(i).getCourses().get(0).getName());
			System.out.println("Modules : [ ");
			
			for(int j = 0; j < students.get(i).getCourses().get(0).getModules().size(); j++) {
				System.out.println("\t" + students.get(i).getCourses().get(0).getModules().get(j).getName());
			}
			
			System.out.println("]\n\n\n\n\n");
		}
	}
	
	//Function to quickly generate modules
	private static ArrayList<Module> MockModules() {
		String[] moduleNames = {"MATH", "BIOLOGY", "CHEMISTRY", 
				"PHYSICS", "SOFTWAREENGINEERING", "HISTORY", 
				"GEOGRAPHY", "PROGRAMMING", "SYSTEMS", "WEBDESIGN"};
		
		ArrayList<Module> modules = new ArrayList<Module>();
		
		for(int i = 0; i < moduleNames.length; i++) {
			Module module = new Module();
			String moduleName = moduleNames[i];
			String moduleCode = "" + moduleName.charAt(0) + moduleName.charAt(moduleName.length() - 1) + (new Random().nextInt(1000) + 1000);
			
			module.setName(moduleName);
			module.setCode(moduleCode);
			
			modules.add(module);
		}
		
		return modules;
	}
	
	//function to quickly generate courses
	private static ArrayList<Course> MockCourses(ArrayList<Module> mockModules) {
		Course course = new Course();
		course.setName("Engineering Course");
		course.setStartDate(new DateTime());
		course.setEndDate(new DateTime());
		ArrayList<Module> modules = new ArrayList<Module>();
		
		for(int j = 0; j < mockModules.size(); j++) {
			if(Integer.parseInt(mockModules.get(j).getCode().substring(2)) < 1500) {
				modules.add(mockModules.get(j));
			}
		}
		
		course.setModules(modules);
		
		
		Course course2 = new Course();
		course2.setName("Science Course");
		course2.setStartDate(new DateTime());
		course2.setEndDate(new DateTime());
		ArrayList<Module> modules2 = new ArrayList<Module>();
		
		for(int j = 0; j < mockModules.size(); j++) {
			if(Integer.parseInt(mockModules.get(j).getCode().substring(2)) > 1500) {
				modules2.add(mockModules.get(j));
			}
		}
		
		course2.setModules(modules2);
		
		ArrayList<Course> courses = new ArrayList<Course>();
		courses.add(course);
		courses.add(course2);
		
		return courses;
	}

	
	//function to quickly generate students
	private static ArrayList<Student> MockStudents(ArrayList<Course> mockedCourses) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		String[] studentNames = {"Michael Braum", "Kacy Jackson", "Percy Phillips",
				"John Doe", "Samantha Kayn", "Tim Worthy", 
				"Douglas Sid", "Jesse Bourne"};
		
		for(int i = 0; i < studentNames.length; i++) {
			Student student = new Student();
			Course course = mockedCourses.get(new Random().nextInt(2));
			ArrayList<Course> courses = new ArrayList<Course>();
			courses.add(course);
			
			student.setAge(new Random().nextInt(18) + 40);
			student.setCourses(courses);
			student.setName(studentNames[i]);
			student.setModules(course.getModules());
			student.setDateOfBirth(new DateTime());
			
			students.add(student);
		}
		
		return students;
	}
}



















