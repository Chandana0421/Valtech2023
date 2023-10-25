package firstWeb;

public class Employee implements Comparable<Employee>{
		
		//Variables
		private int seniority, experience, age;
	    private String name;
	    private int deptId;
	    private int salary, id;

	    public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		@Override
		public String toString() {
			return "Employee [id= " + id + ", name=" + name
					+ ", age=" + age + ", salary=" + salary + ", seniority=" + seniority + ", experience=" + experience + ", deptId=" + deptId + "]";
		}

		@Override
	    public int compareTo(Employee o) {
	        return this.salary - o.salary;
	    }

		public Employee(int seniority, int experience, int age, String name, int salary, int id, int deptId) {
			super();
			this.seniority = seniority;
			this.experience = experience;
			this.age = age;
			this.name = name;
			this.salary = salary;
			this.id = id;
			this.deptId = deptId;
			}

		public Employee(int seniority, int experience, int age, String name, int salary) {
			super();
			this.seniority = seniority;
			this.experience = experience;
			this.age = age;
			this.name = name;
			this.salary = salary;
		}
		
		
		//ignore this const
		public Employee(int i, int j, int k, String string, int l, int m) {
			// TODO Auto-generated constructor stub
		}

		public int getDeptId() {
			return deptId;
		}

		public void setDeptId(int deptId) {
			// TODO Auto-generated method stub
			this.deptId = deptId;
			
		}
		

		public int getSeniority() {
			return seniority;
		}

		public void setSeniority(int seniority) {
			this.seniority = seniority;
		}

		public int getExperience() {
			return experience;
		}

		public void setExperience(int experience) {
			this.experience = experience;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getSalary() {
			return salary;
		}

		public void setSalary(int salary) {
			this.salary = salary;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
//		public static void main(String[] args) {
//			Employee e1 = new Employee(1, 10, 33, 80000, "chanman");
//			Employee e2 = new Employee(5, 6,26, 50000, "kiko");
//			
//		}

	}

