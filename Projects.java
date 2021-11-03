package task24;

/**
 * This class is to create, access and modify Project objects. It links to the PoisedStructuralEngineers class.
 * @author Mamela Jikwana
 *
 */
public class Projects{

	// Project object attributes
	int projectNumber;
	String projectName;
	String buildingType;
	String projectPhysicalAddress;
	String erfNumber;
	double projectFees;
	double feesPaidToDate;
	double invoice;
	String dueDate;

	//person class created separated. it is linked to the projects class
	person client;
	person architect;
	person contractor;
	/**
	 * Projects constructor
	 * @param projectNumber the Projects project number
	 * @param projectName the project name
	 * @param builingType the building type
	 * @param projectPhysicalAddress project the physical address
	 * @param erfNumber the project erf number
	 * @param projectFees the project fees
	 * @param feesPaidToDate the total fees paid to date for the project
	 * @param dueDate the project due date
	 * @param client the client details from the person class
	 * @param contractor the contractor details from the person class
	 * @param architect the architect details from the person class
	 */
	public Projects (int projectNumber, String projectName, String builingType, String projectPhysicalAddress, String erfNumber,
			double projectFees, double feesPaidToDate, String dueDate,person client, person contractor, person architect) 
	{	
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.buildingType = builingType;
		this.projectPhysicalAddress =projectPhysicalAddress;
		this.erfNumber = erfNumber;
		this.projectFees = projectFees;
		this.feesPaidToDate = feesPaidToDate;
		this.dueDate = dueDate;
		this.client = client;
		this.architect = architect;
		this.contractor = contractor;
	}
	/**
	 * 
	 * @param newProjectNumber sets the project number 
	 */
	public void setProjectNumber(int newProjectNumber) {projectNumber = newProjectNumber;}
	/**
	 * 
	 * @param newProjectName sets the project name
	 */
	public void setProjectName(String newProjectName) {projectName = newProjectName;}
	/**
	 * 
	 * @param newBuilingType sets the building type 
	 */
	public void setTelephoneNumber(String newBuilingType) {buildingType = newBuilingType;}
	/**
	 * 
	 * @param newProjectPhysicalAddress sets the project's physical address
	 */
	public void setProjectPhysicalAddress(String newProjectPhysicalAddress) {projectPhysicalAddress = newProjectPhysicalAddress;}
	/**
	 * 
	 * @param newErfNumber sets erf number
	 */
	public void setErfNumber(String newErfNumber) {erfNumber = newErfNumber;}
	/**
	 * 
	 * @param newProjectFees sets project fees 
	 */
	public void setProjectFees(double newProjectFees) {projectFees = newProjectFees;}
	/**
	 * 
	 * @param newFeesPaidToDate sets fees paid to date
	 */
	public void setFeesPaidToDate(double newFeesPaidToDate) {feesPaidToDate = newFeesPaidToDate;}
	/**
	 * 
	 * @param newDueDate sets due date
	 */
	public void setDueDate(String newDueDate) {dueDate = newDueDate;}
	/**
	 * get the Projects project number
	 * @return the project number
	 */
	public int getProjectNumber() {return projectNumber;}
	/**
	 * get the Projects project name
	 * @return the project name
	 */
	public String getProjectName() {return projectName;}
	/**
	 * get the Projects building type
	 * @return the building type
	 */
	public String getBuildingType() {return buildingType;}
	/**
	 * get the Projects physical address
	 * @return the physical address
	 */
	public String getProjectPhysicalAddress() {return projectPhysicalAddress;}
	/**
	 * get the Projects erf number
	 * @return the erf number
	 */
	public String getErfNumber() {return erfNumber;}
	/**
	 * get the Projects project fees
	 * @return the project fees
	 */
	public double getProjectFees() {return projectFees;}
	/**
	 * get the Projects fees paid to date
	 * @return the fees paid to date
	 */
	public double getFeesPaidToDate() {return feesPaidToDate;}
	/**
	 * get the Projects due date
	 * @return the due date
	 */
	public String getDueDate() {return dueDate;}
	/**
	 * get the person client
	 * @return the client
	 */
	public person getClient() {return client;}
	/**
	 * get the person architect
	 * @return the architect
	 */
	public person getArchitect() {return architect;}
	/**
	 * get the person contractor
	 * @return the contractor
	 */
	public person getcontractor() {return contractor;}

	//Method to obtain a string detailing all person details in an easy to read format
	public String toString() {
		String output = "Project number: " + this.projectNumber;
		output += "\nProject Name: " + this.projectName;
		output += "\nBuiling Type: " + this.buildingType;
		output += "\nProject Physical Address: " + this.projectPhysicalAddress;
		output += "\nErf Number: " + this.erfNumber;
		output += "\nProject Fees: " + this.projectFees;
		output += "\nFees Paid To Date: " + this.feesPaidToDate;
		output += "\nDue Date: " + this.dueDate;
		output += "\nClient Contact Details: " + this.client;
		output += "\nArchitect Contact Details: " + this.architect;
		output += "\nContractor Contact Details: " + this.contractor;

		return output;
	}
}