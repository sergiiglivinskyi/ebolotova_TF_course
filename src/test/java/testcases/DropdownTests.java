package testcases;

import org.testng.annotations.Test;

public class DropdownTests extends BaseTest{

    @Test(priority = 1, groups = {"high"})
    public void printAllJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobTitleList(),
                signUpPage.expectedJobTitleList());
    }

    @Test(priority = 4, groups = {"medium"})
    public void printDevJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("developer"),
                signUpPage.expectedDevJobTitleList());
    }

    @Test(priority = 3, groups = {"medium"})
    public void printQAJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("test", "QA"),
                signUpPage.expectedQAJobTitleList());
    }

    @Test(priority = 6, groups = {"the lowest"})
    public void printAnalystJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("analyst"),
                signUpPage.expectedAnalystJobTitleList());
    }

    @Test(priority = 5, groups = {"low"})
    public void printBAJobTitleList() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobListWithPreferableTitle("business"),
                signUpPage.expectedBAJobTitleList());
    }
    @Test(priority = 2, groups = {"high"})
    public void printAllJobTitleWithoutSeleniumSelection() {
        homePage.clickSignUpBtn();
        signUpPage.assertActualAndExpectedList(
                signUpPage.getJobTitleListWithoutSeleniumSelect(),
                signUpPage.expectedJobTitleList());

    }

}
