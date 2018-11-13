*** Settings ***
Library  Selenium2Library

*** Variables ***

#${BROWSER} = chrome

*** Keywords ***
Begin Web Test
    Open Browser  about:blank  ${BROWSER}


End Web Test
    Close Browser

Insert Testing Data
    Log  to do prepare test test data

Cleanup Tesing Data
    Log  Todo cleaning
