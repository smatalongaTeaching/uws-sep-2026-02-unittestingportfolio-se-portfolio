# USW_SEP_UnitTesting_PortfolioExercise

Group Coursework – Test-Driven Development Portfolio.
1.Dean Cain (B01787107) - [https://github.com/b01787017/B01787107-DeanCain-Unit2_PortfolioExcercise.git](https://github.com/b01787017/B01787107-DeanCain-Unit2_PortfolioExcercise.git)
2.James Lough (B01794144) -
3.Danny Cox (B01838418) -

This was completed as pair courseowkr with both contributors working on seperate feature branches, each stage was committed independently, code reviews were conducted via Pull Requests. Pull Requests were accepted or rejected based on review outcomes. Closed Pull Requests in the repository deomonstrate review activity.

This project implements a small money library developed using a strict Test-Driven Development (TDD) approach.

The library supports:
-Representation of monetary values in: USD & CHF
-Currency conversion via a Bank exchange-rate manager
-Addition of same and different currencies
-Composite expressions (Sum of Sums)
-Multiplication of expressions
-Mixed operations (plus + times chaining)
-Edge cases such as: Zero amounts & Equal exchange rates

The implementation evolves incrementally through red–Green–Refactor cycles across staged development. For each stage a failing test was written first, the failure was checked, the minimal imnplemtation was added to make the test pass, the code was cleaned, duplications removed and structure improved before moving onto the next stage.

All source and test files are located inside the moneyExample package. The project was developed using Visual Studio Code and JUnit 5.

Build_and_Run
1.Prerequisites
-Java JDK (Version compatible with JUnit 5 — typically Java 11+)
-Visual Studio Code (or any Java-compatible IDE)
-JUnit 5 extension enabled

2.Running Tests
Since the project does not use Maven or Gradle, tests are run directly through the IDE.
a.Open the project folder.
b.Ensure the Java and JUnit extensions are installed.
c.Navigate to any test class.
d.Use “Run All Tests” or run individual test methods.

All tests should pass before submission.
