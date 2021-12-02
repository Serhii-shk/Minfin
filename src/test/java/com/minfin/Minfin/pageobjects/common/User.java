package com.minfin.Minfin.pageobjects.common;

import com.minfin.Minfin.enums.*;
import com.minfin.Minfin.pageobjects.BasePO;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Builder
@Data
@Slf4j
public class User {

    private int requiredAmount;
    private String surname;
    private String firstName;
    private String middleName;
    private String phone;
    @Builder.Default
    private String confirmCode = "123456";
    private String email;
    private PurposeOfUse purposeOfUse;
    private Employment employment;
    private City city;
    private Streets street;
    private City cityRegistration;
    private Streets streetRegistration;
    private String dayOfBirthday;
    private String monthOfBirthday;
    private String yearOfBirthday;
    private String inn;
    private String term;
    private String monthlyOutcome;
    private String monthlyIncome;
    private String passportSeries;
    private String passportNumber;
    private String passportIssued;
    private String passportDate;
    private String houseNumber;
    private String flatNumber;
    private String buildNumber;
    private String postCode;
    private String houseNumberRegistration;
    private String flatNumberRegistration;
    private String buildNumberRegistration;
    private String postCodeRegistration;
    private String contactName;
    private String companyName;
    private String startYearCurrentJob;
    private StartMonthCurrentJob startMonthCurrentJob;
    private String companyPhone;
    private String contactPhone;
    private Industry industry;
    private Position position;
    private MaritalStatus maritalStatus;
    private ChildrenCount childrenCount;
    private EducationDegree educationDegree;
    private ContactType contactType;
    private LivingType livingType;
    private String loanPayments;
    private String passportType;

    public static UserBuilder builder() {
        return new CustomUserBuilder();
    }

    private static class CustomUserBuilder extends UserBuilder {

        @Override
        public User build() {
            User user = super.build();
            log.info(user.toString());
            return user;
        }
    }

    public static class UserBuilder {

        public UserBuilder randomTerm(int min, int max) {
            this.term = String.valueOf(BasePO.randomInt(min, max));
            return this;
        }

        public UserBuilder randomMonthlyIncome(int min, int max) {
            this.monthlyIncome = String.valueOf(BasePO.randomInt(min, max));
            return this;
        }

        public UserBuilder randomMonthlyOutcome(int min, int max) {
            this.monthlyOutcome = String.valueOf(BasePO.randomInt(min, max));
            return this;
        }

    }
}
