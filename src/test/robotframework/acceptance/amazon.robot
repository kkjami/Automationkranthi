*** Settings ***
Documentation  hello suite
Resource  ../Resources/Amazon.robot
Resource  ../Resources/Common.robot
Suite Setup  Insert Testing Data
Test Setup  Common.Begin Web Test
Test Teardown  Common.End Web Test
Suite Teardown  Cleanup Tesing Data

*** Variables ***
${BROWSER} =  chrome
${URL} =  http://google.com/
${SearchTerm} =  kranthi
@{multi_variable_set} =  one  two  three

*** Test Cases ***
User can search
    [Documentation]  hey this is test
 #   Open Browser  http://google.com/  chrome
    wait Until Page Contains  Google Search
    Log  entering name
    Input Text  name=q  kranthi
    Log  Clicking on search button
    Click Button  xpath=//input[@value="Google Search"]
    #Sleep  5s
  #  Close Browser


User can search1
    [Documentation]  hey this is test2
    Amazon.search for kranthi


User can search in gerkin
    [Documentation]  Using gerkin
    When Amazon.search for kranthi
    ${my_new_variable} =  Set Variable  something else
    Log  ${my_new_variable}

List variable
    [Tags]  hello
    @{multi_variable_set_2} =  set variable  one1  two2  three3
    @{multi_variable_set_3} =  create list  one11  two21  three31
    Log  @{multi_variable_set}[0]
    Log  @{multi_variable_set}[1]
    Log  @{multi_variable_set_2}[0]
    Log  @{multi_variable_set_2}[1]
