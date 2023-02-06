insert into products (sku, name, description) values ('cBKhdYE37I64','BOLACHA DO LIDL','MELHOR PEQUENO ALMOCO DE SEMPRE E LANCHE E JANTAR E ALMOÇO E TUDO');
insert into products (sku, name, description) values ('vpOkPKUOUH02','BOLACHA DE OUTRAS MARCAS','Pior que as do Lidl');
insert into products (sku, name, description) values ('Nhv6LRuZpj11','MAÇAS','Maças de grande qualidade');
insert into products (sku, name, description) values ('K5Jl6BIdeH16','UVAS','Melhores uvas alguma vez ja colhidas');
insert into products (sku, name, description) values ('n4w6ZoP9W770','MELAO','Melões bem grandes cheios de agua');
insert into products (sku, name, description) values ('nNH8cCVN6H80','MELANCIA','Pior que melão');
insert into products (sku, name, description) values ('ebFewAMdaw90','CUECAS','Roupa interior muito confortavel');
insert into products (sku, name, description) values ('MiZuT7VWJT46','VASSOURA','Varre tudo');
insert into products (sku, name, description) values ('iSh0kUzHCn73','LEITE','Leite das melhores vacas de Rabo de Peixe, Açores');
insert into products (sku, name, description) values ('xYiBwtl4nC27','AVEIA','Comida de passaro para pessoas');

insert into user (id, username,email, password) values (1,'Álvaro','alvaro@gmail.com', '$2a$10$RbZraQc74IXL1Yt6uRsj8OW.q48yIZBM1K5sXoIZFuUwGWcl9PBgm');
insert into user (id, username,email, password) values (2,'Tiago','tiago@gmail.com', '$2a$10$RbZraQc74IXL1Yt6uRsj8OW.q48yIZBM1K5sXoIZFuUwGWcl9PBgm');
insert into user (id, username,email, password) values (3,'Mariana','mariana@gmail.com', '$2a$10$RbZraQc74IXL1Yt6uRsj8OW.q48yIZBM1K5sXoIZFuUwGWcl9PBgm');

insert into roles(id,authority) values (1,'COSTUMER')
insert into roles(id,authority) values (2,'MODERATOR')

insert into user_roles(user_id,role_id) values(1,1)
insert into user_roles(user_id,role_id) values(2,2)
insert into user_roles(user_id,role_id) values(3,2)



insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2010 13:45', 'DD/MM/YYYY HH24:MI'), 4, 'ebFewAMdaw90', 'PENDING', 'GOSTEI', 1, 'fwefwefweqfwqefwqefwqefwqefwqef', 2,0,0,0);
insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2011 13:45', 'DD/MM/YYYY HH24:MI'), 3, 'ebFewAMdaw90', 'PENDING', 'GOSTEI', 2, 'wqef qewf wqefwqefwqefwefweq', 3,0,0,0);

insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2012 13:45', 'DD/MM/YYYY HH24:MI'), 5, 'cBKhdYE37I64', 'PENDING', 'OMG MELHORES BOLACGHAS DE SEMPRE!!!11!!', 3, 'OMGfwefwefweqfwqefwqefwqefwqefwqef!', 1,0,0,0);
insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2013 13:45', 'DD/MM/YYYY HH24:MI'), 5, 'cBKhdYE37I64', 'PENDING', 'Mesmo as MELHORES bolachas de sempre ', 4, 'wqef qewf wqefwqefwqefwefweq', 3,0,0,0);

insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2014 13:45', 'DD/MM/YYYY HH24:MI'), 0, 'vpOkPKUOUH02', 'PENDING', 'PIORES BOLACGHAS DE SEMPRE!!!11!!', 5, 'OMGfwefwefweqfwqefwqefwqefwqefwqef!', 2,0,0,0);
insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2015 13:45', 'DD/MM/YYYY HH24:MI'), 0, 'vpOkPKUOUH02', 'PENDING', 'Mesmo HORRIVEIS PIORES bolachas de sempre ', 6, 'wqef qewf wqefwqefwqefwefweq', 2,0,0,0);
insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2016 13:45', 'DD/MM/YYYY HH24:MI'), 2.5, 'cBKhdYE37I64', 'APPROVED', 'MELHORES bolachas de sempre ', 7, 'wqef qewf wqefwqefwqefwefweq', 1,0,0,0);
insert into reviews (creation_date_time, rating, product_sku, status, text, id, fun_fact, user_id, total_votes, up_votes, down_votes) values (TO_DATE('01/12/2020 13:45', 'DD/MM/YYYY HH24:MI'), 4.5, 'cBKhdYE37I64', 'APPROVED', 'MELHORES bolachas', 8, 'wqef qewf wqefwqefwqefwefweq', 2,3,3,0);

insert into vote (reviews_id, user_id, vote,ID) values (8,1,true,1);
insert into vote (reviews_id, user_id, vote,ID) values (8,2,true,2);
insert into vote (reviews_id, user_id, vote,ID) values (8,3,true,3);

