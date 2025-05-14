# Chatty Project QA
 Automated test project for social network Chatty 

«Chatty» is a social networking web application that allows users to connect, 
share content, and manage personal profiles. The platform supports both regular
users and administrators with role-specific functionalities.
The first stage involved analyzing the technical requirements. During this phase, several inconsistencies were identified and corrected to ensure alignment with the intended functionality and project goals.

Objective of the project:

The goal of automated testing in the Chatty project is to increase test coverage, improve efficiency, and ensure fast and reliable validation of core functionalities. Automated tests are designed to:
- Verify the correctness of user registration, login, and session management
- Validate content creation, editing, and deletion workflows
- Ensure proper enforcement of role-based permissions (User vs Admin)
- Support regression testing to prevent the reappearance of known issues
- Enable continuous integration and fast feedback during development

The implementation of API testing is provided in the [Chatty-Project-QA-API repository](https://github.com/Ziabko/Chatty-Project-QA-API).

✅ Testing Activities

📋 Requirements Analysis
- Analyzed the technical documentation ("Chatty" specification)
- Identified and corrected inconsistencies in the requirements
🧪 Manual Testing on Qase Platform
- Designed and documented test cases
- Created and maintained bug reports
- Performed structured manual testing

🔌 API Testing
Tested REST API endpoints using Swagger and Postman
Validated authentication, user roles, and content operations

🤖  Test Automation (Java)
Automated UI testing using Selenium (or another framework if applicable)
Automated API testing using REST Assured and JUnit
Developed and maintained reusable test scripts for regression testing

