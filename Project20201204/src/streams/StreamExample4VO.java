package streams;

public class StreamExample4VO {
	
	private int employeeId;
	private String firstName;
	private String email;
	private int salary;
	private int departmentId;
	
	public StreamExample4VO(int employeeId, String firstName, String email, int salary) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.email = email;
		this.salary = salary;
		this.departmentId = departmentId;
	}
	public StreamExample4VO() {
		
	}
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getDepartmentId() {
		return departmentId;
		
	}
	public void setDepartmentId (int departmentId) {
		this.departmentId =  departmentId;
	}
	
	public void showEmpInfo() {
		System.out.println("사원번호: " + employeeId + ", firstName: " + firstName + ", email " + email + ", salary: " + salary + ", departmentId:" + departmentId);
	}
    
}
