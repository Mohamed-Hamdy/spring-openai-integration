-- Add Test Data for Test Database Connection

SELECT * FROM integration;

INSERT INTO integration (name, tech_stack, tech_stack_recommended) 
VALUES ('Test1', 'Java, Spring', 'Start with basics');

INSERT INTO integration (name, tech_stack, tech_stack_recommended)
VALUES ('John Doe', 'Java, Spring Boot, PostgreSQL', 'Start with Java basics, then learn Spring Boot');

INSERT INTO integration (name, tech_stack, tech_stack_recommended)
VALUES ('Jane Smith', 'Python, Django, Docker', 'Focus on Python fundamentals, then Docker and Django');

INSERT INTO integration (name, tech_stack, tech_stack_recommended)
VALUES ('Alice Johnson', 'JavaScript, React, Node.js', 'Master JavaScript first, then React for frontend and Node.js backend');

INSERT INTO integration (name, tech_stack, tech_stack_recommended)
VALUES ('Bob Lee', 'C++, Linux, Embedded Systems', 'Start with C++ basics, then Linux systems programming');

INSERT INTO integration (name, tech_stack, tech_stack_recommended)
VALUES ('Emma Williams', 'Ruby, Rails, PostgreSQL', 'Learn Ruby fundamentals, then Rails framework with PostgreSQL');


SELECT * FROM integration;
