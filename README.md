# Political Data Project

This project hold the automation scripts for Political data APIs which includes create record, get all the records and get record by ID.

# How to execute Tests?

- You should have maven installed on your machine
- Download project
- Open command prompt/terminal and go inside PoliticalData folder
- Run command: mvn clean test
- Once completed, reports will be created inside Reports folder based on system date and time
- Go to newly created folder inside Reports folder -> expand cucumber-html-reports folder
- Open overview-features.html file in browser
- If you have added any new data into TestData.xlsx then Run JSONUtility.java class (src/main/java/com/framework): This will generate JSON files from TestData.xlsx sheet present in src/main/resources/data folder