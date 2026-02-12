There is no application to launch with this projeect, in order to run it though you must have : 

Java JDK 17 installed
junit-platform-console-standalone-1.9.3.jar located in the lib folder of the repo

Using VS Code UI, click on the testing icon in the left hand side bar and then click on the play buttons to run the tests.

Below is an example of how my Sum, Money and Bank classes work together to handle currencies : 

Bank bank = new Bank();
bank.addRate("CHF", "USD", 0.5);

Expression sum = new Sum(Money.dollar(5), Money.franc(10));
Money result = bank.reduce(sum, "USD"); // result : $10.00

Using the Red-Green refactor cycle I wrote 5 failing tests in Stage4IndividualTests.

I then implemented logic within Sum.java and Money.Java to make them pass

I then adjusted the match in my reduce methods as the calculations were incorrect.

Link to individual Repo : https://github.com/smatalongaTeaching/uws-sep-2026-02-unittestingportfolio-se-portfolio/tree/B01794144-James_Lough