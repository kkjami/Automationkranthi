*** Settings ***
Library  Selenium2Library

*** Keywords ***
Search
    Enter search term
    submit search

Enter search term
    Input Text  name=q  ${SearchTerm}

submit search
    Click Button  xpath=//input[@value="Google Search"]