create table recipe
(
    id              int auto_increment
        primary key,
    name            varchar(255)  null,
    ingredients     text          null,
    energy_cost     int default 0 null,
    description     text          null,
    vegan           tinyint(1)    null,
    nutrition_score int           null,
    constraint recipe_id_uindex
        unique (id)
);

