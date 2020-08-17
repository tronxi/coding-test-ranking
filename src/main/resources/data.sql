insert into top_word (id, word) values (1, 'Luminoso');
insert into top_word (id, word) values (2, 'Nuevo');
insert into top_word (id, word) values (3, 'Céntrico');
insert into top_word (id, word) values (4, 'Reformado');
insert into top_word (id, word) values (5, 'Ático');

insert into picture (id, url, quality) values (1, 'http://www.idealista.com/pictures/1', 'SD');
insert into picture (id, url, quality) values (2, 'http://www.idealista.com/pictures/2', 'HD');
insert into picture (id, url, quality) values (3, 'http://www.idealista.com/pictures/3', 'SD');
insert into picture (id, url, quality) values (4, 'http://www.idealista.com/pictures/4', 'HD');
insert into picture (id, url, quality) values (5, 'http://www.idealista.com/pictures/5', 'SD');
insert into picture (id, url, quality) values (6, 'http://www.idealista.com/pictures/6', 'SD');
insert into picture (id, url, quality) values (7, 'http://www.idealista.com/pictures/7', 'SD');
insert into picture (id, url, quality) values (8, 'http://www.idealista.com/pictures/8', 'HD');
insert into picture (id, url, quality) values (9, 'http://www.idealista.com/pictures/9', 'HD');
insert into picture (id, url, quality) values (10, 'http://www.idealista.com/pictures/10', 'HD');


insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (1, 'CHALET', 'Este piso es una ganga, compra, compra, COMPRA!!!!!', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (2, 'FLAT', 'Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (3, 'CHALET', '', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (4, 'FLAT', 'Ático céntrico muy luminoso y recién reformado, parece nuevo', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (5, 'FLAT', 'Pisazo,', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (6, 'GARAGE', '', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (7, 'GARAGE', 'Garaje en el centro de Albacete', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (8, 'CHALET', 'Maravilloso chalet situado en lAs afueras de un pequeño pueblo rural. El entorno es espectacular, las vistas magníficas. ¡Cómprelo ahora!', 300, null, 0, null);
insert into ad (id, typology, description, house_size, garden_size, score, irrelevant_since) values (9, 'FLAT', 'Nuevo ático céntrico recién reformado. No deje pasar la oportunidad y adquiera este ático de lujo', 300, null, 0, null);

insert into ad_pictures (ad_entity_id, pictures_id) values ('2', '4');
insert into ad_pictures (ad_entity_id, pictures_id) values ('3', '2');
insert into ad_pictures (ad_entity_id, pictures_id) values ('4', '5');
insert into ad_pictures (ad_entity_id, pictures_id) values ('5', '3');
insert into ad_pictures (ad_entity_id, pictures_id) values ('5', '8');
insert into ad_pictures (ad_entity_id, pictures_id) values ('6', '6');
insert into ad_pictures (ad_entity_id, pictures_id) values ('8', '1');
insert into ad_pictures (ad_entity_id, pictures_id) values ('8', '7');
insert into ad_pictures (ad_entity_id, pictures_id) values ('9', '9');
insert into ad_pictures (ad_entity_id, pictures_id) values ('9', '10');





