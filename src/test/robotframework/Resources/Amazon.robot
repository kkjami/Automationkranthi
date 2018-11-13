
*** Settings ***
Resource  PO/searchPage.robot
Resource  PO/LandingPage.robot

*** Keywords ***
search for kranthi
    LandingPage.Load
    Search



#robot -v BROWSER:chrome robot/localitie.tests/ -t "User can search" -i tag
#[Arguments]