create table if not exists courses(
    id uuid primary key,
    name varchar(255) not null,
    description varchar(510),
    teacher_id uuid
)