create table orders
(
    id            int auto_increment
        primary key,
    ingredient_id int                                 null,
    best_before   datetime                            null,
    create_time   timestamp default CURRENT_TIMESTAMP null,
    amount        int                                 null,
    wasted_amount int       default 0                 null,
    used_amount   int       default 0                 null,
    constraint orders_id_uindex
        unique (id)
);

