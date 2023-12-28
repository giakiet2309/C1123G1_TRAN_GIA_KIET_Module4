package com.validatecreateform.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AccountDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AccountDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        if (!accountDto.getFirstName().matches("^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$")){
            errors.rejectValue("firstName", null, "Tên gồm chữ cái có độ dài từ 5 tới 45 ký tự");
        }
        if (!accountDto.getLastName().matches("^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$")){
            errors.rejectValue("lastName", null, "Tên gồm chữ cái có độ dài từ 5 tới 45 ký tự");
        }
        if (!accountDto.getPhoneNumber().matches("^[0-9]{10,15}$")){
            errors.rejectValue("phoneNumber", null, "SDT gồm 10 đến 15 chữ số");
        }
        if (accountDto.getAge() < 18){
            errors.rejectValue("age", null, "Để đăng ký tài khoản phải trên 18 tuổi");
        }
        if (!accountDto.getEmail().matches("^.+@.+\\..+$")){
            errors.rejectValue("email", null, "Email không đúng quy tắc");
        }
    }
}
