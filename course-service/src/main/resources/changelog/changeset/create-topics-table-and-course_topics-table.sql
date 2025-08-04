-- changeset andrei:create-topics-table

alter table groups
alter column name type varchar(25);

alter table groups
alter column name set not null;

alter table group_courses
alter column group_id set not null;

create table if not exists topics(
    id uuid primary key,
    name varchar(45) not null
);

create table if not exists course_topics(
    course_id uuid not null,
    topic_id uuid not null,
    primary key (course_id, topic_id),
    foreign key (course_id) references courses(id) on delete cascade,
    foreign key (topic_id) references topics(id) on delete cascade
);

create unique index if not exists uq_course_topics on course_topics(course_id, topic_id);
create unique index if not exists uq_topics_name on topics(name)


