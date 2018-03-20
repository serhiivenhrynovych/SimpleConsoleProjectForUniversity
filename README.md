# SimpleConsoleProjectForUniversity
Simple java project with the console interface for university, which consist of
departments and lectors. The lectors could work in more than one department. A lector could
have one of degree (assistant,associate professor,professor).

All data is stored in relational database.

The app implemented such commands:
1.Who is head of department {department_name}
Answer: Head of {department_name} department is {head_of_department_name}
2.Show {department_name} statistic.
Answer: assistans - {assistams_count}.
associate professors - {associate_professors_count}
professors -{professors_count}
3. Show the average salary for department {department_name}.
Answer: The average salary of {department_name} is {average_salary}
4. Show count of employee for {department_name}.
Answer: {employee_count}
5. Global search by {template}.
Example: Global search by van
Answer: Ivan​ Petrenko, Petro Ivan​ov

Used technologies:

-Java

-Spring Boot

-JDBC

-H2database
