-- changeset andrei:create-groups-and-group_courses-table

create table if not exists groups(
    id uuid primary key,
    name varchar(25),
    created_at date
);

create table if not exists group_courses (
    course_id uuid not null,
    group_id uuid null,
    primary key (course_id, group_id),
    foreign key (course_id) references courses(id) on delete cascade,
    foreign key (group_id) references groups(id) on delete cascade
);

create unique index if not exists uq_group_courses on group_courses(course_id, group_id);
create unique index if not exists uq_groups_name on groups(name)