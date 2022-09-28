create table ingredient
(
    id    int auto_increment
        primary key,
    name  varchar(255) null,
    price int          null,
    constraint ingredient_id_uindex
        unique (id)
);

