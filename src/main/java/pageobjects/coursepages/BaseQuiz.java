package pageobjects.coursepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobjects.BaseMain;
import pageobjects.CourseGalleryPage;

import java.util.List;

import static java.lang.Math.round;

public class BaseQuiz extends BaseMain {
    CourseGalleryPage courseGalleryPage = new CourseGalleryPage(driver);
    By questionN = By.xpath("//div[@class='quiz-process-question-block-title']/span");

    By qstAmount = By.xpath("//div[@class='quiz-process-questions-button ']");
    By answeredQstAmount = By.xpath("//div[@class='quiz-process-questions-button answered']");
    By nextBtn = By.xpath("//div[@class='quiz-process-navigations-block-button-next ']");
    By questionName = By.xpath("//div[@class='quiz-process-question-block-task']");
    By processProgressData = By.id("quiz-process-progress-data");

    public BaseQuiz(WebDriver dr) {
        super(dr);
    }

    public String getQuestionNumber() {
        return driver.findElement(questionN).getText();
    }

    public void checkThatWeGetQuestionNumberOne(){
        assertIfElementsAreEqual(getQuestionNumber(), "1");
    }

    public void checkThatWeGetQuestionNumberTwo(){
        assertIfElementsAreEqual(getQuestionNumber(), "2");
    }

    public int getAnsweredQuestionsAmount(){
        List<WebElement> list = driver.findElements(answeredQstAmount);
        System.out.println("answered questions "+list.size());
        return list.size();
    }

    public void questionNameIsDisplayed() {
        driver.findElement(questionName).isDisplayed();
    }

    public WebElement getAnswerForTheFirstQuestion(int answerId) {
        return driver.findElement(
                        By.xpath("//div[@class='quiz-process-question-block-answers-block-item ' and @data-answer-id='" + answerId + "']"));
    }

    public WebElement getAnswerForTheAnotherQuestions(int answerId) {
        return driver.findElement(
                By.xpath("//div[@class='quiz-process-question-block-answers-block-item' and @data-answer-id='" + answerId + "']"));
    }

    public void clickToTheFirstQuestionAnswer() {
        getAnswerForTheFirstQuestion(0).click();
    }

    public void clickToTheAnotherQuestionsAnswer() {
        getAnswerForTheAnotherQuestions(1).click();
    }

    public double getProgressBarValue() {
        String pattern = "%";
        String value = driver.findElement(processProgressData).getText();
        double intValue = Integer.parseInt(value.replaceAll(pattern,""));
        System.out.println("Actual value is "+intValue);
        return intValue;
    }

    public double getExpectedProgressBarValue(double totalQNum){
        return round(getAnsweredQuestionsAmount()/totalQNum)*100;
    }

//    public void verifyTheProgressBarValueForTheFirstCourse(){
//        double totalQNum = courseGalleryPage.getNumOfQuestionsInCourse("Development", "SQL 101 (Basics)");
//        double expectedValue = getExpectedProgressBarValue(totalQNum);
//        checkThatProgressBarValueIsAsExpected(expectedValue);
//    }

    public void verifyTheProgressBarValueForACourse(String expertiseName, String courseName){
        switchToWindowFromBaseMain(0);
        double totalQNum = courseGalleryPage.getNumOfQuestionsInCourse(expertiseName, courseName);
        System.out.println("Total Num " +totalQNum);
        switchToWindowFromBaseMain(1);
        double expectedValue = getExpectedProgressBarValue(totalQNum);
        checkThatProgressBarValueIsAsExpected(expectedValue);
        System.out.println("Expected value is " +expectedValue);
    }

//    public void verifyTheProgressBarValueForTheSecondCourse(){
//        double totalQNum = courseGalleryPage.getNumOfQuestionsInCourse("Development", "SQL 101 test");
//        double expectedValue = getExpectedProgressBarValue(totalQNum);
//        checkThatProgressBarValueIsAsExpected(expectedValue);
//    }

    public void checkThatProgressBarValueIsAsExpected(double expectedValue){
        assertIfElementsAreEqual(getProgressBarValue(), expectedValue);
    }

    public void clickNextBtn() {
        driver.findElement(nextBtn).click();
    }

}
