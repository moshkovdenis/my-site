insert into users(id, name, age, email)
values (gen_random_uuid(), 'Denis', 27, 'denis@mail.ru'),
       (gen_random_uuid(), 'Stas', 28, 'stas@mail.ru'),
       (gen_random_uuid(), 'Ivan', 25, 'ivan@mail.ru') on conflict do nothing ;
