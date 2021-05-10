insert into categories (name) values ('Food');
insert into categories (name) values ('Drinks');
insert into company (name) values ('Nestle');
insert into company (name) values ('Heinz');
insert into product (name, stock, company_id, version) values ('Tomato Ketchup', 100, 2, 1000);
insert into product (name, stock, company_id, version) values ('Nescafe', 100, 1, 2000);
insert into product_categories (product_id, categories_id) values (1, 1);
insert into product_categories (product_id, categories_id) values (2, 2);