package com.codegym.furama_case_study_final.dto;

import com.codegym.furama_case_study_final.model.Customer;
import com.codegym.furama_case_study_final.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerDto implements Validator {
    private Long id;
    @Pattern(regexp = "^[K][H][-]\\d{4}", message = "Please enter the correct format for customer code 'KH-XXXX' !")
    private String customerCode;
    private String customerName;
    @Pattern(regexp = "\\d{4}[-]((([0]{1})([1-9]{1}))|(([1]{1})([0-2]{1})))[-]((([0]{1})([1-9]{1}))|(([1-2]{1})([0-9]{1}))|(([3]{1})([0-1]{1})))",
            message = "Please enter the correct format for birthday 'DD/MM/YYYY'")
    private String customerBirthday;
    private int gender;
    @Pattern(regexp = "\\d{9}", message = "Please enter the correct format for id card which is 9-digit string !")
    private String idCard;
    @Pattern(regexp = "\\d{10}", message = "Please enter the correct format for phone number which is 10-digit string !")
    private String phoneNumber;
    @Pattern(regexp = "^[A-z]{1}((\\w)*[.]?(\\w)*|(\\w)*[-]?(\\w)*)@[a-z0-9]+([.][a-z]{2,3}){1,5}",message = "Please enter the correct email format which is (xxx@xxxx.com)!")
    private String customerEmail;
    private String customerAddress;
    private CustomerType customer_type;
    private List<Customer> customerList;

    public CustomerDto() {
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(CustomerType customer_type) {
        this.customer_type = customer_type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        for (Customer customer : customerDto.getCustomerList()) {
            if (customer.getCustomerEmail().equals(customerDto.getCustomerEmail())) {
                errors.rejectValue("customerEmail", "E", "Email is already exists!");
            }
            if (customer.getIdCard().equals(customerDto.getIdCard())){
                errors.rejectValue("idCard", "ID", "ID Card is already exists!");
            }
            if (customer.getPhoneNumber().equals(customerDto.getPhoneNumber())){
                errors.rejectValue("phoneNumber", "Number", "Phone Number is already exists!");
            }
            if (customer.getCustomerCode().equals(customerDto.getCustomerCode())){
                errors.rejectValue("customerCode", "code", "Customer Code is already exists!");
            }
        }
        try{
            if (checkMaxAge(customerDto.customerBirthday)) {
                errors.rejectValue("customerBirthday", "maxAge", "Age must be less than 100!");
            }
            if (checkMinAge(customerDto.customerBirthday)) {
                errors.rejectValue("customerBirthday", "minAge", "Age must be greater than 18!");
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
