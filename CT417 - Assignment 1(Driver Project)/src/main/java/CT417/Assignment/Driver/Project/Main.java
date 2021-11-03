package CT417.Assignment.Driver.Project;

import java.util.ArrayList;
import java.util.List;


//importing from the Gradle Project from part(a) of the assignment, through jitpack
import CT417.Assignment.*;
import CT417.Assignment.Module;

import org.joda.time.DateTime;

public class Main
{
	public static void main(String[] args) {
		System.out.println("Student Registration System\n");
		
		// creating mock data with students, modules and courses
		String[] names = new String[]{"John", "Anne", "Bob", "Sean", "Michael", "Bill"};
		int[] ages = new int[] {22,24,22,21,18,19};
		DateTime[] DOBs = new DateTime[] {new DateTime("1999-09-22"), new DateTime("1997-04-03"),new DateTime("1999-03-26"),new DateTime("2000-02-17"),new DateTime("2003-05-19"),new DateTime("2002-08-01")};
		
		List<Student> studentList = new ArrayList<Student>();
		String[] moduleNames = new String[] {"Software Eng", "Maths", "Engineering", "Programming", "Calculus"};
		String[] modules = new String[] {"CT417", "MA140", "EG150", "CT123", "MM450"};
		List<Module> moduleList = new ArrayList<Module>();
		for(int i =0; i<modules.length;i++) {
			moduleList.add(new Module(moduleNames[i], modules[i]));
		}
		Programme eng = new Programme("ENG", "Engineering", new DateTime("2021-09-06"), new DateTime("2025-05-12"), List.of(moduleList.get(1), moduleList.get(2), moduleList.get(3), moduleList.get(4)));
		Programme bct = new Programme("BCT", "Computer Science", new DateTime("2021-09-06"), new DateTime("2025-05-12"), List.of(moduleList.get(0), moduleList.get(1), moduleList.get(3)));
		Programme[] studentProgrammes = new Programme[] {bct,eng,eng,bct,eng,bct};
		
		for(int i =0;i<names.length;i++) {
			studentList.add(new Student(names[i], ages[i], studentProgrammes[i],DOBs[i]));
		}
		
		
		for(int i =0; i <names.length;i++) {
			if(studentList.get(i).getProgramme() == bct) 
				studentList.get(i).setModules(bct.getModules());
			else
				studentList.get(i).setModules(eng.getModules());	
		}
		
		// printing out the details of students: their name, age, dob, programme, modules, etc.
		for(Student s: studentList) {
			s.PrintStudentInfo();
		}
	}
}
