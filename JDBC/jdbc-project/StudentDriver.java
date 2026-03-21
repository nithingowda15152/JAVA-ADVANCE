package com.project;

import java.util.Scanner;

public class StudentDriver {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentInterface st=new StudentImplementation();
		
		while(true) {
			System.out.println("Welcome Alll....");
			System.out.println("1.Insert\n2.Update\n3.Delete\n4.DisplayOneStudent\n5.DisplayAll\n6.DeleteAll\n7.Count\n8.SortBasedOnMarks\n9.DisplayHighestMarks\n10.LowestMarks\n11.Exit");
			System.out.println("Choose an option: ");
			int option=sc.nextInt();
			
			switch(option) {

			case 1:
				st.addStudent();
				break;

			case 2:
				st.updateStudent();
				break;

			case 3:
				st.removeStudent();
				break;

			case 4:
				st.displayStudent();
				break;

			case 5:
				st.displayAllStudent();
				break;

			case 6:
				st.removeAllStudent();
				break;

			case 7:
				st.countStudent();
				break;

			case 8:
				st.sortStudent();
				break;

			case 9:
				st.findStudentWithHighestMarks();
				break;

			case 10:
				st.findStudentWithLowestMarks();
				break;

			case 11:
				System.out.println("Thank You");
				System.exit(0);
			}
		}
	}

}
