@Navigation
Feature: Navigation bar
  To see the subpages
  Without loggin in
  I can click the navigation bar links


  Background: I am on the Free Range Tester web Without loggin in.
    Given I navigate to www.freerangetesters.com

   Scenario Outline: I can access the sub pages through the navigation bar

    When I go to a <section> using the navigation bar
    Examples:
      | section   |
      | Academia  |
      | Cursos    |
      | Mentorías |
      | Talleres  |
      | Blog      |
      | Recursos  |

     @Courses
 Scenario: Courses are presented correctly to potential customers

  When I go to Cursos using the navigation bar
  And select Fundamentos del Testing

   @Plans @Courses
  Scenario: Users can Select Deporte when go Recursos

    When I go to Recursos using the navigation bar
    Then select Automation Sandbox and validate dropdown