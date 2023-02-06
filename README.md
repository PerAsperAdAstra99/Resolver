
## Before triggering the framework, please navigate to the configuration.properties file and provide a test environment.

## PART 1. FRAMEWORK SELECTION

- Cucumber BBD/DDT framework was selected based on the overall experience that confirms following advantages:
- 1.Ability to utilize POM and singleton design pattern.
- 2.Ability to apply end-user perspective by writing test case scenarios in Gherkin language, easily readable by
  non-technical team members and transform into coding logic.
- 3.Ability to utilize cucumber reports and attach screenshots when test fails.
- 4.Ability to use multiple sets of data for tests(Scenario outline).

## PART 2. TEST CASES

## US1: Verify that login function is accessible

### AC1: As a user I should be able to see email, password input boxes and login button

- Steps:
- 1.Given user is on the Home Page
- 2.Then user should be able to see email, password input boxes and login button

### AC2: As a user I should be able to click login button

- Steps:
- 1.Given user is on the Home Page
- 2.Then user should be able to click login button

### AC3: As a user I should be able to input email and password

- Steps:
- 1.Given user is on the Home Page
- 2.When user types "<email>"  into email box
- 3.And user types "<password>" into password box
- 4.Then "<email>" and "<password>" should be present in respective fields
- Examples:
- | email | password |
- | aswyndley2@yellowbook.com | 1234567890 |
- | njanaszewski1@wisc.edu | 007007 |
- | aswyndley2@yellowbook.com | abcdefg |

## US2: Negative testing of login feature

### AC1: As a user I should not be able to log in if the email box empty

- Steps:
- 1.Given user is on the Home Page
- 2.When user types password "1234567890" into password box
- 3.And user clicks login button
- 4.Then warning message for email box should not be blank

### AC2: As a user i should not be able to log in if the password box is empty

- Steps:
- 1.Given user is on the Home Page
- 2.When user types "tpayley0@phoca.cz" into email box
- 3.And user clicks login button
- 4.Then warning message for password box should not be blank

### AC3: Verification of the warning message when attempting to log in without email

- Steps:
- 1.Given user is on the Home Page
- 2.When user types password "1234567890" into password box
- 3.And user clicks login button
- 4.Then warning message for email should contain "Please fill out this field."

### AC4: As a user I should not be able to log in if the email is missing a part before "@"

- Steps:
- 1.Given user is on the Home Page
- 2.When user types "@phoca.cz" into email box
- 3.Then warning message for email should contain "Please enter a part followed by '@'."

### AC5: As a user I should not be able to log in if the email is missing a part before "@"

- Steps:
- 1.Given user is on the Home Page
- 2.When user types "tpayley0@" into email box
- 3.Then warning message for email should contain "Please enter a part following '@'."

### AC6: As a user I should not be able to log in if the email has no "@"

- Steps:
- 1.Given user is on the Home Page
- 2.When user types "tpayley0@" into email box
- 3.Then warning message for email should contain "Please include an '@' in the email address."

## US3: Verify list items and badges in test 2

### AC1: As a user I should be able to see 3 values in listgroup

- Steps:
- 1.Given user is on the Home Page
- 2.Then user sees 3 values in list group

### AC2:As a user I should be able to see item's value

- Steps:
- 1.Given user is on the Home Page
- 2.Then user sees item number 2 's value as "List Item 2"

### AC3: As a user I should be able to see item's badge value

- Steps:
- 1.Given user is on the Home Page
- 2.Then user sees item number 2 's badge value as "6"

## US4:Verify Test 3 dropdown functionality

### AC1: As a user I should be able to see selected option

- Steps:
- 1.Given user is on the Home Page
- 2.Then user sees "Option 1" as default selected option

### AC2: As a user I should be able to see selected option

- Steps:
- 1.Given user is on the Home Page
- 2.When user selects "<option>" from the dropdown
- 3.Then user sees "<expectedOption>" as selected option
- Examples:
- | option | expectedOption |
- | Option 1 | Option 1 |
- | Option 2 | Option 2 |
- | Option 3 | Option 3 |

## US5:Test 4 buttons functionality

### AC1: As a user I should be able to access first button

- Steps:
- 1.Given user is on the Home Page
- 2.Then user is able to access first button

### AC2: As a user I should not be able to access second button

- Steps:
- 1.Given user is on the Home Page
- 2.Then user is not able to access second button

## US6:Test 5 button functionality

### AC1: As a user I should be able to click button, see success message and then not able to access button

- Steps:
- 1.Given user is on the Home Page
- 2.When user waits for the button to be displayed and clicks it
- 3.Then user sees success message displayed
- 4.Then user sees that message content is "You clicked a button!"
- 5.Then user is not able to access button

## US7:Verification if table's values in Test 6

### AC1: As a user I should be able to find value of cell in the table by given coordinates(staring at 0 in the top left corner)

- Steps:
- 1.Given user is on the Home Page
- 2.Then user sees value of the table cell with coordinates 2, 2 as "Ventosanzap"

## PART 3. AUTOMATION FRAMEWORK

### Framework instructions.

BDD/DDT hybrid cucumber framework.

Pre-condition - fork the project;

1) add Framework support -> maven (add POM.XML);
2) Open POM.XML file -> add dependencies-> add to project following dependencies:
   -selenium-java;
   -webdrivermanager (io.github.bonigarcia);
   -cucumber-java;
   -cucumber-junit (version must be same with cucumber-java);
   -reporting-plugin.
3) create project structure:
   a) under package java create package resolver;
   b) under package resolver create packages: pages, runner, step_definition, utilities;
   c) on project level create file configuration.properties (store data that changes running flow of the framework).
4) under package test create resource package.
5) pages package - for page object model design pattern implementation (we store and manage located web elements for
   each page of Application in Test).
6) runner package - contain TestRunner class, which triggers framework, contains plugins
7) step_definition package - contains classes, where we implement java logic to automate Web driver actions. That
   package also contains hooks class where we define pre- and post-conditions for each test procedure.
8) utility package contains:
    - a) browserUtil class - to store reusable static methods, which we can use everywhere in project;
    - b) ConfigurationReader class - help us to open stream in order to read and pass in testing procedures data from
      configuration.properties file;
    - c) driver class - to implement singleton design pattern, which help us get same instance of driver during one
      session as well as to open required browser
9) resource package -> features package, which need to create business layer (we use Cucumber). In feature folder we
   keep feature files, where we describe test scenarios in Gherkin language, then each test scenario we convert in java
   logic in related step_definition class.
10) target package stores reports
    In order access detailed version, navigate to target/cucumber/cucumber-html-reports package and open
    overview-tags.html in the browser













