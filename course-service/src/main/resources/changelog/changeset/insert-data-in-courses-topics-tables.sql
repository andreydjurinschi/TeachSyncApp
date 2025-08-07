-- changeset andrei:insert-data-into-course-topics-tables


insert into courses (id, name, description, teacher_id) values
('11111111-1111-1111-1111-111111111111', 'Java Basics', 'Введение в Java', null),
('22222222-2222-2222-2222-222222222222', 'Spring Boot', 'Фреймворк Spring', null);

insert into topics (id, name) values
('aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'OOP'),
('aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Collections'),
('aaaaaaa3-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'JPA'),
('aaaaaaa4-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'REST');

insert into course_topics (course_id, topic_id) values
('11111111-1111-1111-1111-111111111111', 'aaaaaaa1-aaaa-aaaa-aaaa-aaaaaaaaaaaa'),
('11111111-1111-1111-1111-111111111111', 'aaaaaaa2-aaaa-aaaa-aaaa-aaaaaaaaaaaa');