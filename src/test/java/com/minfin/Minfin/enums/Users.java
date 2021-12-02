package com.minfin.Minfin.enums;

public enum Users {
    USER_1("тест", "тест", "тест", "666666666", "123456",
            "12", "04", "1963", "2311232110", "test@test.test"),
    LARGE_WIZARD("тест", "тест", "тест", "666666661", "123456",
            "12", "04", "1963", "2311232110", "test@test.test"),
    USER_7("тест", "тест", "тест", "666666667", "123456",
            "12", "04", "1963", "2311232110", "test@test.test"),
    USER_3_DELETE_ALWAYS("тест", "тест", "тест", "666666662", "123456",
            "12", "04", "1963", "2311232110", "test@test.test");

    private final String firstName;
    private final String surname;
    private final String phone;
    private final String confirmCode;
    private final String middleName;
    private final String dayOfBirth;
    private final String monthOfBirth;
    private final String yearOfBirth;
    private final String inn;
    private final String email;

    Users(String firstName, String surname, String middleName, String phone, String confirmCode,
          String dayOfBirth, String monthOfBirth, String yearOfBirth, String inn, String email) {
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.phone = phone;
        this.confirmCode = confirmCode;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.inn = inn;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return middleName + " " + firstName + " " + surname;
    }

    public String getSurname() {
        return surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPhone() {
        return phone;
    }

    public String getFullPhoneNumber() {
        return "+380" + phone;
    }

    public String getEmail() {
        return email;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getInn() {
        return inn;
    }
}
