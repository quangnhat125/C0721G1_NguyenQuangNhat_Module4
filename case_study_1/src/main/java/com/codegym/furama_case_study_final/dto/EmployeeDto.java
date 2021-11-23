package com.codegym.furama_case_study_final.dto;

import com.codegym.furama_case_study_final.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.ConstraintViolation;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.util.List;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank(message = "Employee's name cannot be blank or empty!")
    private String employeeName;
    private String employeeBirthday;
    @Pattern(regexp = "\\d{9}", message = "Please enter the correct format for id card which is 9-digit string !")
    private String idCard;
    @Min(value = 1, message = "Salary must be greater than 1!")
    private double salary;
    @Pattern(regexp = "\\d{10}", message = "Please enter the correct format for phone number which is 10-digit string !")
    private String phoneNumber;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}",message = "Please enter the correct email format which is (xxx@xxxx.com)!")
    private String email;
    private String address;
    private Position position;
    private Education education;
    private Division division;
    private List<Contract> contractList;
    private List<Employee> employeeList;

    public EmployeeDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        for (Employee employee : employeeDto.getEmployeeList()) {
            if (employee.getEmail().equals(employeeDto.getEmail())) {
                errors.rejectValue("email", "E", "Email is already exists!");
            }
            if (employee.getIdCard().equals(employeeDto.getIdCard())) {
                errors.rejectValue("idCard", "ID", "ID Card is already exists!");
            }
            if (employee.getPhoneNumber().equals(employeeDto.getPhoneNumber())) {
                errors.rejectValue("phoneNumber", "Number", "Phone Number is already exists!");
            }
        }
    }
}
