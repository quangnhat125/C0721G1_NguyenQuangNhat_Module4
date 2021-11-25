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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class EmployeeDto implements Validator {
    private Long id;
    @NotBlank(message = "Employee's name cannot be blank or empty!")
    private String employeeName;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for birthday 'DD/MM/YYYY'")
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
        try{
            if (checkMaxAge(employeeDto.employeeBirthday)) {
                errors.rejectValue("employeeBirthday", "maxAge", "Age must be less than 100!");
            }
            if (checkMinAge(employeeDto.employeeBirthday)) {
                errors.rejectValue("employeeBirthday", "minAge", "Age must be greater than 18!");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    private long getDate(String date) throws ParseException {
        long days = -1;
        if(date ==null ||date == ""){
            return days;
        }
        if(date !=null || date !="") {
            String[] arrayDate = date.split("-");
            int day = Integer.parseInt(arrayDate[2]);
            int month = Integer.parseInt(arrayDate[1]);
            int year = Integer.parseInt(arrayDate[0]);
            DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date currentDate = new Date();
            Date date1;
            Date date2;
            String startDate = "" + day + "-" + month + "-" + year;
            String endDate = simpleDateFormat.format(currentDate);
            date1 = simpleDateFormat.parse(startDate);
            date2 = simpleDateFormat.parse(endDate);
            long getDiff = date2.getTime() - date1.getTime();

            return days = getDiff / (24 * 60 * 60 * 1000);

        }
        return days;
    }
    private boolean checkMaxAge(String date) throws ParseException {
        long days  = getDate(date);
        if(days/365>100||days ==-1){
            return true;
        }
        return false;
    }
    private boolean checkMinAge(String date) throws ParseException {
        long days  = getDate(date);
        if(days/365<18||days ==-1){
            return true;
        }
        return false;

    }
}
