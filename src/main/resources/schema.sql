create table if not exists Taco_Order
(
    id
    int
    auto_increment
    primary
    key,
    delivery_Name
    varchar
(
    50
) not null,
    delivery_Street varchar
(
    50
) not null,
    delivery_City varchar
(
    50
) not null,
    delivery_State varchar
(
    50
) not null,
    delivery_Zip varchar
(
    10
) not null,
    cc_number varchar
(
    16
) not null,
    cc_expiration varchar
(
    5
) not null,
    cc_cvv varchar
(
    3
) not null,
    placed_at timestamp not null);

create table if not exists Taco
(
    id
    int
    auto_increment
    primary
    key,
    name
    varchar
(
    50
) not null,
    tacoOrder bigint not null,
    taco_order_key bigint not null,
    created_at timestamp not null
    );
alter table Taco
    add foreign key (tacoOrder) references Taco_Order (id);

-- create table if not exists Ingredient_Ref (
--     ingredient varchar(4) not null,
--     taco bigint not null,
--     taco_key bigint not null
--     );
create table if not exists Ingredient
(
    id varchar
(
    4
) not null primary key,
    name varchar
(
    25
) not null,
    type varchar
(
    10
) not null
    );


-- alter table Ingredient_Ref
--     add foreign key (ingredient) references Ingredient(id);

create table users
(
    id          int auto_increment primary key,
    username    varchar(150),
    password    varchar(10),
    fullname    varchar(150),
    street      varchar(100),
    city        varchar(100),
    state       varchar(100),
    zip         varchar(100),
    phoneNumber varchar(11)
)

-- insert into Ingredient (id, name, type)
-- values ('GRBF', 'Ground Beef', 1);
-- insert into Ingredient (id, name, type)
-- values ('CARN', 'Carnitas', 1);
-- insert into Ingredient (id, name, type)
-- values ('TMTO', 'Diced Tomatoes', 2);
-- insert into Ingredient (id, name, type)
-- values ('LETC', 'Lettuce', 2);
-- insert into Ingredient (id, name, type)
-- values ('CHED', 'Cheddar', 3);
-- insert into Ingredient (id, name, type)
-- values ('JACK', 'Monterrey Jack', 3);
-- insert into Ingredient (id, name, type)
-- values ('SLSA', 'Salsa', 4);
-- insert into Ingredient (id, name, type)
-- values ('SRCR', 'Sour Cream', 4]);