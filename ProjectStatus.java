package task24;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * 
 * @author Mamela Jikwana
 *
 */
public class ProjectStatus {
	/**
	 * for user input
	 * @param scanner 
	 */
	public void projectPosition(Scanner scanner) 
	{
		int option;
		while (true)	
		{
			//display menu to user
			System.out.println("\nWould you like to:"
					+ "\n1. View ongoing projects"
					+ "\n2. View overdue projects"
					+ "\n3. Search for a project"
					+ "\n0. Quit");
			option = scanner.nextInt(); 

			switch(option)
			{
			//if user wishes to view ongoing projects
			case 1:
				//initialize variables
				int number = 0;
				String ongoingProjectInformation = null;

				try{
					//read text file to view ongoing projects
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();
					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to check the status for: ");
					number = scanner.nextInt();

					number = number-1;

					String temp = projectData.get(number);
					temp = temp.toString();

					List<String> splitString = Arrays.asList(temp.split(", "));

					//get all the information read and stored to a list by using get(index), eg get(4) will give us the erf number
					int projectNumber = Integer.parseInt(splitString.get(0));
					String projectName = splitString.get(1);
					String buildingType = splitString.get(2);
					String projectPhysicalAddress = splitString.get(3);
					String erfNumber = splitString.get(4);
					double projectFees = Double.parseDouble(splitString.get(5));
					double feesPaidToDate = Double.parseDouble(splitString.get(6));					
					String dueDate = splitString.get(7);
					String architectName = splitString.get(8);
					String architectSurname = splitString.get(9);
					String architectTelephoneNumber = splitString.get(10);
					String architectEmailAddress = splitString.get(11);
					String architectPhysicalAddress = splitString.get(12); 
					String clientName = splitString.get(13);
					String clientSurname = splitString.get(14);
					String clientTelephoneNumber = splitString.get(15);
					String clientEmailAddress = splitString.get(16);
					String clientPhysicalAddress = splitString.get(17); 
					String contractorName = splitString.get(18);
					String contractorSurname = splitString.get(19);
					String contractorTelephoneNumber = splitString.get(20);
					String contractorEmailAddress = splitString.get(21);
					String contractorPhysicalAddress = splitString.get(22);									

					//cast back to string 
					String projectFeesString = String.valueOf(projectFees);
					String feesPaidToDateString = String.valueOf(feesPaidToDate);
					String dueDateString = String.valueOf(dueDate);
					String projectNumberString = String.valueOf(projectNumber);

					//ask user if the project is ongoing or not
					System.out.println("Is the project ongoing or has it been completed? Answer Y/N if it's still ongoing");
					String response = scanner.next();
					if (response.equalsIgnoreCase("y"))
					{
						//if the user answered yes output to a text file "ongoingProjects.txt"
						ongoingProjectInformation = "===== LIST OF ONGOING PROJECTS =====";
						ongoingProjectInformation += "\nProject Mumber:" + projectNumberString;
						ongoingProjectInformation += "\nProject Name:" + projectName;
						ongoingProjectInformation += "\nBuilding Type:" + buildingType;
						ongoingProjectInformation += "\nProject Physical Address:" + projectPhysicalAddress;
						ongoingProjectInformation += "\nProject Erf Mumber:" + erfNumber;
						ongoingProjectInformation += "\nProject fees R" + projectFeesString;
						ongoingProjectInformation += "\nFees paid to date R" + feesPaidToDateString;
						ongoingProjectInformation += "\nProject Due Date:" + dueDateString;
						ongoingProjectInformation += "\nArchitect Name:" + architectName;
						ongoingProjectInformation += "\nArchitect Surname:" + architectSurname;
						ongoingProjectInformation += "\nArchitect Telephone Number:" + architectTelephoneNumber;
						ongoingProjectInformation += "\nArchitect Email Address:" + architectEmailAddress;
						ongoingProjectInformation += "\nArchitect Physical Address:" + architectPhysicalAddress;							
						ongoingProjectInformation += "\nClient Name:" + clientName;
						ongoingProjectInformation += "\nClient Surname:" + clientSurname;
						ongoingProjectInformation += "\nClient Telephone Number:" + clientTelephoneNumber;
						ongoingProjectInformation += "\nClient Email Address:" + clientEmailAddress;
						ongoingProjectInformation += "\nClient Physical Address:" + clientPhysicalAddress;
						ongoingProjectInformation += "\nContractor Name:" + contractorName;
						ongoingProjectInformation += "\nContractor Surname:" + contractorSurname;
						ongoingProjectInformation += "\nContractor Telephone Number:" + contractorTelephoneNumber;
						ongoingProjectInformation += "\nContractor Email Address:" + contractorEmailAddress;
						ongoingProjectInformation += "\nContractor Physical Address:" + contractorPhysicalAddress;

						System.out.println(ongoingProjectInformation + "\n");
						String project = ongoingProjectInformation.toString();
						project = project.replace("[","");
						project = project.replace("]","");

						//write and close writter
						FileWriter writeClientInvoice = new FileWriter("ongoingProjects.txt",true);						
						writeClientInvoice.write("\n" + ongoingProjectInformation);
						System.out.println("Ongoing project has been written");
						writeClientInvoice.close();
					}
					else
					{
						System.out.println("The project had been finalized");
					}
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}
				//if the user wants to view overdue projects	
			case 2:
				//initialize variable
				String projectOverDueInformation = null;
				try{
					//read text file to view ongoing projects
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();

					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to check the status for: ");
					number = scanner.nextInt();

					number = number-1;

					String temp = projectData.get(number);
					temp = temp.toString();

					List<String> splitString = Arrays.asList(temp.split(", "));

					//get all the information read and stored to a list by using get(index), eg get(4) will give us the erf number
					int projectNumber = Integer.parseInt(splitString.get(0));
					String projectName = splitString.get(1);
					String buildingType = splitString.get(2);
					String projectPhysicalAddress = splitString.get(3);
					String erfNumber = splitString.get(4);
					double projectFees = Double.parseDouble(splitString.get(5));
					double feesPaidToDate = Double.parseDouble(splitString.get(6));					
					String dueDate = splitString.get(7);
					String architectName = splitString.get(8);
					String architectSurname = splitString.get(9);
					String architectTelephoneNumber = splitString.get(10);
					String architectEmailAddress = splitString.get(11);
					String architectPhysicalAddress = splitString.get(12); 
					String clientName = splitString.get(13);
					String clientSurname = splitString.get(14);
					String clientTelephoneNumber = splitString.get(15);
					String clientEmailAddress = splitString.get(16);
					String clientPhysicalAddress = splitString.get(17); 
					String contractorName = splitString.get(18);
					String contractorSurname = splitString.get(19);
					String contractorTelephoneNumber = splitString.get(20);
					String contractorEmailAddress = splitString.get(21);
					String contractorPhysicalAddress = splitString.get(22);									

					//make sure the due date is correctly formated
					//get current date
					Date currentDate = new Date();
					DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
					Date deadline = format.parse(dueDate);

					//cast back to string 
					String projectFeesString = String.valueOf(projectFees);
					String feesPaidToDateString = String.valueOf(feesPaidToDate);
					String dueDateString = String.valueOf(dueDate);
					String projectNumberString = String.valueOf(projectNumber);

					//compare the project due date to todays date. If the due date if before todays date then the project is overdue.
					//if overdue write to overdueProjects.txt
					if (deadline.compareTo(currentDate) < 0){
						projectOverDueInformation = "===== LIST OF OVERDUE PROJECTS =====";
						projectOverDueInformation += "\nProject Mumber:" + projectNumberString;
						projectOverDueInformation += "\nProject Name:" + projectName;
						projectOverDueInformation += "\nBuilding Type:" + buildingType;
						projectOverDueInformation += "\nProject Physical Address:" + projectPhysicalAddress;
						projectOverDueInformation += "\nProject Erf Mumber:" + erfNumber;
						projectOverDueInformation += "\nProject fees R" + projectFeesString;
						projectOverDueInformation += "\nFees paid to date R" + feesPaidToDateString;
						projectOverDueInformation += "\nProject Due Date:" + dueDateString;
						projectOverDueInformation += "\nArchitect Name:" + architectName;
						projectOverDueInformation += "\nArchitect Surname:" + architectSurname;
						projectOverDueInformation += "\nArchitect Telephone Number:" + architectTelephoneNumber;
						projectOverDueInformation += "\nArchitect Email Address:" + architectEmailAddress;
						projectOverDueInformation += "\nArchitect Physical Address:" + architectPhysicalAddress;							
						projectOverDueInformation += "\nClient Name:" + clientName;
						projectOverDueInformation += "\nClient Surname:" + clientSurname;
						projectOverDueInformation += "\nClient Telephone Number:" + clientTelephoneNumber;
						projectOverDueInformation += "\nClient Email Address:" + clientEmailAddress;
						projectOverDueInformation += "\nClient Physical Address:" + clientPhysicalAddress;
						projectOverDueInformation += "\nContractor Name:" + contractorName;
						projectOverDueInformation += "\nContractor Surname:" + contractorSurname;
						projectOverDueInformation += "\nContractor Telephone Number:" + contractorTelephoneNumber;
						projectOverDueInformation += "\nContractor Email Address:" + contractorEmailAddress;
						projectOverDueInformation += "\nContractor Physical Address:" + contractorPhysicalAddress;

						System.out.println(projectOverDueInformation + "\n");
						String project = projectOverDueInformation.toString();
						project = project.replace("[","");
						project = project.replace("]","");
					}
					//if the project is not overdue then it is still ongoing or finalized
					else
					{
						System.out.println("Project is still ongoing or completed");
					}
					//write and close writer
					FileWriter writeClientInvoice = new FileWriter("overdueProjects.txt",true);						
					writeClientInvoice.write("\n" + projectOverDueInformation);
					System.out.println("Overdue project has been written");
					writeClientInvoice.close();
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}

			case 3:
				//initialize variables
				String projectSearch = null;
				int num = 0;
				try{
					//read text file to view ongoing projects
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();

					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to search: ");
					number = scanner.nextInt();

					num = number-1;

					String temp = projectData.get(num);
					temp = temp.toString();

					List<String> splitString = Arrays.asList(temp.split(", "));

					//get all the information read and stored to a list by using get(index), eg get(4) will give us the erf number
					int projectNumber = Integer.parseInt(splitString.get(0));
					String projectName = splitString.get(1);
					String buildingType = splitString.get(2);
					String projectPhysicalAddress = splitString.get(3);
					String erfNumber = splitString.get(4);
					double projectFees = Double.parseDouble(splitString.get(5));
					double feesPaidToDate = Double.parseDouble(splitString.get(6));					
					String dueDate = splitString.get(7);
					String architectName = splitString.get(8);
					String architectSurname = splitString.get(9);
					String architectTelephoneNumber = splitString.get(10);
					String architectEmailAddress = splitString.get(11);
					String architectPhysicalAddress = splitString.get(12); 
					String clientName = splitString.get(13);
					String clientSurname = splitString.get(14);
					String clientTelephoneNumber = splitString.get(15);
					String clientEmailAddress = splitString.get(16);
					String clientPhysicalAddress = splitString.get(17); 
					String contractorName = splitString.get(18);
					String contractorSurname = splitString.get(19);
					String contractorTelephoneNumber = splitString.get(20);
					String contractorEmailAddress = splitString.get(21);
					String contractorPhysicalAddress = splitString.get(22);									

					String projectFeesString = String.valueOf(projectFees);
					String feesPaidToDateString = String.valueOf(feesPaidToDate);
					String dueDateString = String.valueOf(dueDate);
					String projectNumberString = String.valueOf(projectNumber);

					//if the entered number equals the project number on the text file print the  
					if (projectNumber == number)
					{
						projectSearch = "===== YOU ARE VIEWING PROJECT NUMBER:"  + projectNumber + " DETAILS =====";
						projectSearch += "\nProject Mumber:" + projectNumberString;
						projectSearch += "\nProject Name:" + projectName;
						projectSearch += "\nBuilding Type:" + buildingType;
						projectSearch += "\nProject Physical Address:" + projectPhysicalAddress;
						projectSearch += "\nProject Erf Mumber:" + erfNumber;
						projectSearch += "\nProject fees R" + projectFeesString;
						projectSearch += "\nFees paid to date R" + feesPaidToDateString;
						projectSearch += "\nProject Due Date:" + dueDateString;
						projectSearch += "\nArchitect Name:" + architectName;
						projectSearch += "\nArchitect Surname:" + architectSurname;
						projectSearch += "\nArchitect Telephone Number:" + architectTelephoneNumber;
						projectSearch += "\nArchitect Email Address:" + architectEmailAddress;
						projectSearch += "\nArchitect Physical Address:" + architectPhysicalAddress;							
						projectSearch += "\nClient Name:" + clientName;
						projectSearch += "\nClient Surname:" + clientSurname;
						projectSearch += "\nClient Telephone Number:" + clientTelephoneNumber;
						projectSearch += "\nClient Email Address:" + clientEmailAddress;
						projectSearch += "\nClient Physical Address:" + clientPhysicalAddress;
						projectSearch += "\nContractor Name:" + contractorName;
						projectSearch += "\nContractor Surname:" + contractorSurname;
						projectSearch += "\nContractor Telephone Number:" + contractorTelephoneNumber;
						projectSearch += "\nContractor Email Address:" + contractorEmailAddress;
						projectSearch += "\nContractor Physical Address:" + contractorPhysicalAddress;

						String project = projectSearch.toString();
						project = project.replace("[","");
						project = project.replace("]","");
						System.out.println(project + "\n");
					}
					//if project does not exist, display relevant information
					else
					{
						System.out.println("Project does not exist");
					}
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}
				//if user wishes to exit
			case 0:
				break;
			default:
				System.out.println("Please make valid selection");
			}
		}
	}
}