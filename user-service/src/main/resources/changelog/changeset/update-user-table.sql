insert into users(id, email, full_name, hashed_password, user_role, username)
values ('8c1957f6-3674-40da-a18f-cdccd21a32ef',
        'djurinschi.andreiai@gmail.com', 'Andrei Djurinschi',
        '$2a$12$tKJWggVSL.8bRuUwFbHUzeyYLAA9mz6/Vbxqpyx/nxtackLrkcP9S',
        0,
        'ainaioioiai'
        )
on conflict (id) do nothing