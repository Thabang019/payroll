package za.ac.cput.factory;

import za.ac.cput.domain.Contact;
import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

public class EmployeeFactory {

    public static Employee createEmployee(long employeeNumber, String firstName, String lastName, String email, String mobile, String workNumber){
        if(Helper.isNullorEmpty(employeeNumber))
            return null;

        if(Helper.isNullorEmpty(firstName) || Helper.isNullorEmpty(firstName))
            return null;

        Contact contact = ContactFactory.createContact(email, mobile, workNumber);
        if(contact == null)
            return null;

        return new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setContact(contact)
                .build();
    }
}
