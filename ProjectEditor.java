package task24;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
/**
 * 
 * @author Mamela Jikwana
 *
 */
public class ProjectEditor {
	/**
	 * for user input
	 * @param scanner
	 */
	public void editProject(Scanner scanner) 
	{
		int option;
		while (true)	
		{	
			//display menu to user
			System.out.println("\nWould you like to:"
					+ "\n1. Change the due date of the project."
					+ "\n2. Change the total amount of the fee paid to date."
					+ "\n3. Update a contractor’s contact details."
					+ "\n4. Finalise project"
					+ "\n0. Quit");
			option = scanner.nextInt(); 

			switch(option)
			{
			//if the user selects option 1 to update the due date, read the file
			//add to list projectData
			case 1:
				int number = 0;

				try{
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile .readLine()) != null)
					{
						projectData.add(string);
					}
					textFile.close();

					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to edit: ");
					number = scanner.nextInt();
					number = number-1;

					scanner.nextLine();
					System.out.println("Please enter new due date");
					String newDueDate = scanner.nextLine();

					String temp = projectData.get(number);
					temp = temp.toString();						

					//split the list
					//set the new date to the correct index which is 7
					List<String> splitString = Arrays.asList(temp.split(","));
					splitString.set(7,newDueDate);

					//replace [] with an empty string
					String project = splitString.toString();
					project = project.replace("[","");
					project = project.replace("]","");

					//add the project and project number to the list
					projectData.set(number,project);

					//open file writer and overwrite existing information with the information in projectData, then close the writer
					FileWriter writers = new FileWriter("projects.txt");
					FileWriter writerLine = new FileWriter("projects.txt",true);
					for(int i = 0; i<projectData.size();i++) 
					{
						if (i > 0) 
						{
							writerLine.write(projectData.get(i)+"\n");
						}  
						else
						{
							writers.write(projectData.get(i)+"\n");
						}
					}
					//if no errors occurred while writing to the file,display relevant message
					System.out.println("Due date has been updated");
					writers.close();
					writerLine.close();
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}

				// if the use would like to pay money into the account, they should select option 2
			case 2:
				//initialize variables
				double projectFees;
				double feesPaidToDate;
				double invoice;
				double madePayment;

				try{
					//read the file
					//add to list projectData
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();
					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to edit: ");
					number = scanner.nextInt();
					number = number-1;

					String temp = projectData.get(number);
					temp = temp.toString();

					//split the list
					//get the required information to calculate the outstanding amount
					//cast the information in index 5 and 6 from a string to a double by using Double.parseDouble()
					//subtract the the project fees from fees paid date to determine the amount of money that's still outstanding
					//add the payment made by the client to fees from fees paid date
					List<String> splitString = Arrays.asList(temp.split(","));

					projectFees = Double.parseDouble(splitString.get(5));
					feesPaidToDate = Double.parseDouble(splitString.get(6));
					invoice = projectFees - feesPaidToDate;
					System.out.printf("Outstanding fees R%.2f",invoice);
					System.out.println("\nPlease enter the amount of money the client is paying ");
					madePayment= scanner.nextDouble();
					feesPaidToDate += madePayment;

					//cast fees from fees paid date to a string
					String feesPaidToDateString = String.valueOf(feesPaidToDate);

					//update the value in index 6,by setting index 6 with the new fees from fees paid date
					splitString.set(6,feesPaidToDateString);
					String project = splitString.toString();
					project = project.replace("[","");
					project = project.replace("]","");

					//update the list and write updated list to text file
					projectData.set(number,project);
					FileWriter writers = new FileWriter("projects.txt");
					FileWriter writerLine = new FileWriter("projects.txt",true);
					for(int i = 0; i < projectData.size();i++) 
					{
						if (i > 0) 
						{
							writerLine.write(projectData.get(i)+"\n");
						} 
						else 
						{
							writers.write(projectData.get(i)+"\n");
						}
					}
					//if no errors occurred while writing to the file,display relevant message
					System.out.println("Fees paid to date has been updated");
					writers.close();
					writerLine.close();
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}

				//if user selects option 3 to update contract details
			case 3:
				try{
					//read the file
					//add to list projectData
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();

					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to edit: ");
					number = scanner.nextInt();
					number = number-1;

					String temp = projectData.get(number);
					temp = temp.toString();

					//split the list
					//ask the user to enter the contractor's contact details
					List<String> splitString = Arrays.asList(temp.split(","));

					System.out.println("Please enter the contractor's new name");
					String newName = scanner.nextLine();
					scanner.nextLine();
					System.out.println("Please enter the contractor's new surname");
					String newSurname = scanner.nextLine();

					System.out.println("Please enter the contractor's new telephone number");
					String newTelephoneNumber = scanner.nextLine();

					System.out.println("Please enter the contractor's new email address");
					String newEmailAddress = scanner.nextLine();

					System.out.println("Please enter the contractor's new physical address");
					String newPhysicalAddress = scanner.nextLine();

					//update the contractors details by setting information on each of the indexes where the previous information was stored
					splitString.set(18,newName);
					splitString.set(19,newSurname);
					splitString.set(20,newTelephoneNumber);
					splitString.set(21,newEmailAddress);
					splitString.set(22,newPhysicalAddress);

					String project = splitString.toString();
					project = project.replace("[","");
					project = project.replace("]","");

					//update the list and write updated list to text file
					projectData.set(number,project);
					FileWriter writers = new FileWriter("projects.txt");
					FileWriter writerLine = new FileWriter("projects.txt",true);
					for(int i = 0; i < projectData.size();i++) 
					{
						if (i > 0) {
							writerLine.write(projectData.get(i)+"\n");
						} 
						else 
						{
							writers.write(projectData.get(i)+"\n");
						}
					}
					//if no errors occurred while writing to the file,display relevant message
					System.out.println("Contractor contact details has been updated");
					writers.close();
					writerLine.close();
					break;
				}
				//use the try catch exception handler, should any errors occur the message written below will be displayed
				catch (Exception e)
				{
					System.out.println("Invalid input");
				}

				//if the user selects option to finalise the project
			case 4:
				//initialize variables
				String invoiceInformation = null;
				String projectCompletedInformation = null;
				try{
					//read the file
					//add to list projectData
					BufferedReader textFile = new BufferedReader(new FileReader("projects.txt"));
					String string;
					ArrayList<String> projectData = new ArrayList<String>();
					while((string = textFile.readLine()) != null)
					{
						projectData.add(string);
					}                   
					textFile.close();

					//the user should enter the project number of the project they would like to edit
					System.out.println("Please enter project number of the project you would like to finalise: ");
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
					projectFees = Double.parseDouble(splitString.get(5));
					feesPaidToDate = Double.parseDouble(splitString.get(6));					
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

					//determine the outstanding amount of money
					invoice = projectFees - feesPaidToDate;

					String projectFeesString = String.valueOf(projectFees);
					String feesPaidToDateString = String.valueOf(feesPaidToDate);
					String invoiceString = String.valueOf(invoice);
					String projectNumberString = String.valueOf(projectNumber);

					//if there is outstanding money an invoice will be generated for the client, 
					//if not a completion certificate with the date of completion will be generated
					if ((Double.compare(projectFees,feesPaidToDate)) > 0)
					{
						//when generating an invoice the clients contact details, project fees, 
						//fees paid to date and outstanding amount should be displayed
						invoiceInformation = "===== Poised Structural Engineers Invoice =====\n";
						invoiceInformation += "Invoice addressed to:";
						invoiceInformation += "\nName:" + clientName;
						invoiceInformation += "\nSurname:" + clientSurname;
						invoiceInformation += "\nTelephone Number:" + clientTelephoneNumber;
						invoiceInformation += "\nEmail Address:" + clientEmailAddress;
						invoiceInformation += "\nPhysical Address:" + clientPhysicalAddress;
						invoiceInformation += "\nProject fees R" + projectFeesString;
						invoiceInformation += "\nFees paid to date R" + feesPaidToDateString;
						invoiceInformation += "\nOutstanding fees R" + invoiceString;
						System.out.println(invoiceInformation + "\n");
						String project = invoiceInformation.toString();
						project = project.replace("[","");
						project = project.replace("]","");

						//the invoice should be written to a text file ClientInvoice.txt
						//write and close writter
						FileWriter writeClientInvoice = new FileWriter("ClientInvoice.txt",true);						
						writeClientInvoice.write("\n" + invoiceInformation);
						System.out.println("Client invoice has been written");
						writeClientInvoice.close();
					}
					else
					{
						//if the project has been complete, a completion certificate with the date of completion will be generated
						// ask the user when the project was completed
						//if there is no outstanding money generate the completion certificate, add project,contractor, architect 
						//and client details on the completion certificate
						System.out.println("When was the project completed? Enter date in dd/MM/yyy format");
						String completionDate = scanner.next(); 
						projectCompletedInformation = "===== LIST OF COMPLETED PROJECTS =====";
						projectCompletedInformation += "\nProject Mumber:" + projectNumberString;
						projectCompletedInformation += "\nProject Name:" + projectName;
						projectCompletedInformation += "\nBuilding Type:" + buildingType;
						projectCompletedInformation += "\nProject Physical Address:" + projectPhysicalAddress;
						projectCompletedInformation += "\nProject Erf Mumber:" + erfNumber;
						projectCompletedInformation += "\nProject fees R" + projectFeesString;
						projectCompletedInformation += "\nFees paid to date R" + feesPaidToDateString;
						projectCompletedInformation += "\nProject Due Date:" + dueDate;
						projectCompletedInformation += "\nProject Due Date:" + completionDate;
						projectCompletedInformation += "\nArchitect Name:" + architectName;
						projectCompletedInformation += "\nArchitect Surname:" + architectSurname;
						projectCompletedInformation += "\nArchitect Telephone Number:" + architectTelephoneNumber;
						projectCompletedInformation += "\nArchitect Email Address:" + architectEmailAddress;
						projectCompletedInformation += "\nArchitect Physical Address:" + architectPhysicalAddress;							
						projectCompletedInformation += "\nClient Name:" + clientName;
						projectCompletedInformation += "\nClient Surname:" + clientSurname;
						projectCompletedInformation += "\nClient Telephone Number:" + clientTelephoneNumber;
						projectCompletedInformation += "\nClient Email Address:" + clientEmailAddress;
						projectCompletedInformation += "\nClient Physical Address:" + clientPhysicalAddress;
						projectCompletedInformation += "\nContractor Name:" + contractorName;
						projectCompletedInformation += "\nContractor Surname:" + contractorSurname;
						projectCompletedInformation += "\nContractor Telephone Number:" + contractorTelephoneNumber;
						projectCompletedInformation += "\nContractor Email Address:" + contractorEmailAddress;
						projectCompletedInformation += "\nContractor Physical Address:" + contractorPhysicalAddress;

						//add to list
						System.out.println(projectCompletedInformation + "\n");
						String project = projectCompletedInformation.toString();
						project = project.replace("[","");
						project = project.replace("]","");

						//write list to completedProjects.txt 
						FileWriter writeClientInvoice = new FileWriter("completedProjects.txt",true);						
						writeClientInvoice.write("\n" + projectCompletedInformation);
						System.out.println("Completed project has been written");
						writeClientInvoice.close();
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
				System.out.println("Please make a valid selection");
			}
		}
	}
}