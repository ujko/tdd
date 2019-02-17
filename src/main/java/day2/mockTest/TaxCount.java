package day2.mockTest;

public class TaxCount {
    EmployeeDao employeeDao;// = new EmployeDaoImp();
    public TaxCount() {}

    TaxCount(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public double getTax(int empId) {
        Employee e = employeeDao.getEmployee(empId);
        if(e == null) {
            throw new IllegalArgumentException("Błędny argument");
        }
        double salary = e.getSalary();
        return salary * 0.19;
    }
    public String getUpperCaseName(int id) {
        Employee e = employeeDao.getEmployee(id);
        if(e == null) {
            throw new IllegalArgumentException("Błędny argument");
        }
        return e.getName().toUpperCase();
    }
}
