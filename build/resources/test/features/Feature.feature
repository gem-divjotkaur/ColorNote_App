@SmokeTest
Feature: ColorNote Application Automation

  Scenario: Add 5 text notes in the ColorNote Application
    Given User launches the "ColorNote" Application
    When User allows the "ColorNote" Application to access "photos, media and files"
    And User creates 5 notes in the "ColorNote" Application
    Then User verifies 5 are displayed

  Scenario: Change color of the text notes
    Given User changes the color of each text in the "ColorNote" Application as "RED, ORANGE, YELLOW, GREEN, BLUE"

  Scenario: Print the time of each note
    Given User got the time of each text in the "ColorNote" Application

  Scenario: Change the first day of the week
    Given User tap on the icon to open "Settings"
    When User selects the option "Settings"
    And User scrolls till option "First day of week"
    Then User selects the first day of the week as "MONDAY"

  Scenario: Search for the 3rd text note
    Given User is on the "Home Page"
    When User searches for the 3 text note in the "ColorNote" Application
    Then User verify for "3rd" the text note

  Scenario: Deletion of the text notes
    Given User is navigated to the "Home Page"
    When User deletes the "2nd" text note from the "ColorNote" Application
    And User again deletes the "4th" text note from the "ColorNote" Application
    Then User verifies for the deleted text notes

  Scenario: Archive a text note
    Given User visit "Home Page" again
    When User tap on "1st" note
    And User tap on "Menu" button to choose option "Archive"
    Then User verifies for the archived text note


