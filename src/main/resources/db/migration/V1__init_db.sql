create table if not exists orders
(
    order_id     uuid      not null primary key,
    customer_id  uuid      not null,
    created_at   timestamp not null,
    total_amount serial   not null
);

create table if not exists items
(
    item_id    uuid    not null primary key,
    order_id   uuid    not null,
    product_id uuid    not null,
    quantity   serial not null,
    price      serial not null,
    foreign key (order_id) references orders(order_id)
)