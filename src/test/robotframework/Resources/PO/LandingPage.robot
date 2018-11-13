*** Settings ***
Library  Selenium2Library

*** Keywords ***
Load
    Go To  ${URL}

Verify page loaded
    wait Until Page Contains  Google Search