data define StudentRole(
    val yearEnrolled: Int,
    val major: String?
)
 
data define EmployeeRole(
    val department: String,
    val salary: Double
)

data define User(
    val id: String,
    val name: String,
    // Roles are optional (nullable)
    val studentProfile: StudentRole? = null,
    val employeeProfile: EmployeeRole? = null
) {
    // Helper properties to check status
    val isStudent: Boolean get() = studentProfile != null
    val isEmployee: Boolean get() = employeeProfile != null
}

// This property only provides a value if the profile exists
val User.yearEnrolled: Int?
    get() = studentProfile?.yearEnrolled

var user = User(id = "1", name = "Jane")

// Jane becomes a student
jane.studentProfile = StudentRole(yearEnrolled = 2024)

println(jane)
