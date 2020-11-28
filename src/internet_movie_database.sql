CREATE DATABASE IF NOT EXISTS internet_movie_database;

-- -------------------- Tablak --------------------

CREATE TABLE actor (
  actor_id int(6) NOT NULL,
  actor_first_name varchar(100) NOT NULL,
  actor_last_name varchar(100) NOT NULL,
  actor_birth_date date DEFAULT NULL
);

CREATE TABLE director (
  director_id int(6) NOT NULL,
  director_first_name varchar(100) NOT NULL,
  director_last_name varchar(100) NOT NULL,
  director_birth_date date DEFAULT NULL
);

CREATE TABLE movie (
  movie_id int(6) NOT NULL,
  movie_title varchar(100) NOT NULL,
  movie_genre varchar(50) DEFAULT NULL,
  movie_length int(3) DEFAULT NULL
);

CREATE TABLE movie_acting (
  actor_id int(6) NOT NULL,
  leading_role tinyint(1) NOT NULL,
  movie_id int(6) NOT NULL
);

CREATE TABLE movie_directing (
  director_id int(6) NOT NULL,
  movie_id int(6) NOT NULL
);

CREATE TABLE movie_producing (
  studio_id int(6) NOT NULL,
  movie_id int(6) NOT NULL
);

CREATE TABLE series (
  series_id int(6) NOT NULL,
  series_title varchar(100) NOT NULL,
  series_genre varchar(50) DEFAULT NULL,
  series_seasons int(3) DEFAULT NULL
);

CREATE TABLE series_acting (
  actor_id int(6) NOT NULL,
  leading_role tinyint(1) DEFAULT NULL,
  series_id int(6) NOT NULL
);

CREATE TABLE series_directing (
  director_id int(6) NOT NULL,
  series_id int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE series_producing (
  studio_id int(6) NOT NULL,
  series_id int(6) NOT NULL
);

CREATE TABLE studio (
  studio_id int(6) NOT NULL,
  studio_name varchar(100) NOT NULL,
  studio_country varchar(100) DEFAULT NULL,
  studio_owner varchar(100) DEFAULT NULL,
  studio_founded int(4) DEFAULT NULL
);

-- -------------------- Kulcsok --------------------

ALTER TABLE actor
  ADD PRIMARY KEY (actor_id);

ALTER TABLE director
  ADD PRIMARY KEY (director_id);

ALTER TABLE movie
  ADD PRIMARY KEY (movie_id);

ALTER TABLE movie_acting
  ADD PRIMARY KEY (actor_id,movie_id),
  ADD KEY movie_acting_movie_id (movie_id);

ALTER TABLE movie_directing
  ADD PRIMARY KEY (director_id,movie_id),
  ADD KEY movie_directing_movie_id (movie_id);

ALTER TABLE movie_producing
  ADD PRIMARY KEY (studio_id,movie_id),
  ADD KEY movie_producing_movie_id (movie_id);

ALTER TABLE series
  ADD PRIMARY KEY (series_id);

ALTER TABLE series_acting
  ADD PRIMARY KEY (actor_id,series_id),
  ADD KEY series_acting_series_id (series_id);

ALTER TABLE series_directing
  ADD PRIMARY KEY (director_id,series_id),
  ADD KEY series_directing_series_id (series_id);

ALTER TABLE series_producing
  ADD PRIMARY KEY (studio_id,series_id),
  ADD KEY series_producing_series_id (series_id);

ALTER TABLE studio
  ADD PRIMARY KEY (studio_id);

-- -------------------- Auto increment --------------------


ALTER TABLE actor
  MODIFY actor_id int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

ALTER TABLE director
  MODIFY director_id int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

ALTER TABLE movie
  MODIFY movie_id int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

ALTER TABLE series
  MODIFY series_id int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;

ALTER TABLE studio
  MODIFY studio_id int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT;


-- -------------------- Idegen kulcsok --------------------

ALTER TABLE movie_acting
  ADD CONSTRAINT movie_acting_actor_id FOREIGN KEY (actor_id) REFERENCES actor (actor_id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT movie_acting_movie_id FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE movie_directing
  ADD CONSTRAINT movie_directing_director_id FOREIGN KEY (director_id) REFERENCES director (director_id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT movie_directing_movie_id FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE movie_producing
  ADD CONSTRAINT movie_producing_movie_id FOREIGN KEY (movie_id) REFERENCES movie (movie_id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT movie_producing_studio_id FOREIGN KEY (studio_id) REFERENCES studio (studio_id) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE series_acting
  ADD CONSTRAINT series_acting_actor_id FOREIGN KEY (actor_id) REFERENCES actor (actor_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT series_acting_series_id FOREIGN KEY (series_id) REFERENCES series (series_id) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE series_directing
  ADD CONSTRAINT series_directing_director_id FOREIGN KEY (director_id) REFERENCES director (director_id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT series_directing_series_id FOREIGN KEY (series_id) REFERENCES series (series_id) ON DELETE NO ACTION ON UPDATE CASCADE;

ALTER TABLE series_producing
  ADD CONSTRAINT series_producing_series_id FOREIGN KEY (series_id) REFERENCES series (series_id) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT series_producing_studio_id FOREIGN KEY (studio_id) REFERENCES studio (studio_id) ON DELETE NO ACTION ON UPDATE CASCADE;


-- -------------------- Tablak feltoltese --------------------

INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Nicole', 'Kidman', '1967-06-20');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Leonardo', 'Dicaprio', '1974-11-11');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Natalie', 'Portman', '1981-06-09');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Robbin', 'Williams', '1951-07-21');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Paul', 'Bettany', '1971-05-27');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Ryan', 'Reynolds', '1976-10-23');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Mila', 'Kunis', '1983-08-14');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Jennifer', 'Lawrence', '1990-08-15');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Josh', 'Hutcherson', '1992-10-12');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Liam', 'Hemsworth', '1990-01-13');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Jared', 'Leto', '1971-12-26');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Jennifer', 'Connelly', '1970-12-12');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Ellen', 'Burstyn', '1932-12-07');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Clint', 'Eastwood', '1930-05-31');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Colin', 'Firth', '1960-09-10');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Kate', 'Winslet', '1975-10-05');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Daniel', 'Radcliffe', '1989-10-05');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Emma', 'Watson', '1990-04-15');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Rupert', 'Grint', '1988-08-24');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Anne', 'Hathaway', '1982-11-12');
INSERT INTO actor(actor_id, actor_first_name, actor_last_name, actor_birth_date) VALUES(NULL, 'Meryl ', 'Streep', '1949-06-22');


INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Lars', 'von Trier', '1956-04-30');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Darren', 'Aronofsky', '1969-02-12');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'James', 'Cameron', '1954-08-16');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Martin', 'Scorsese', '1942-11-17');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Quentin', 'Tarantino', '1963-03-27');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Gary', 'Ross', '1956-11-03');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Chris', 'Columbus', '1958-09-10');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Robert', 'Mulligan', '1925-08-23');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Baz', 'Luhrman', '1962-09-17');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Tony', 'Scott', '1944-06-21');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Mike', 'Cahill', '1979-07-05');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Peter', 'Weir', '1944-08-21');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Clint', 'Eastwood', '1930-05-31');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Tim', 'Miller', '1964-10-10');
INSERT INTO director (director_id, director_first_name, director_last_name, director_birth_date) VALUES (NULL, 'Vincent', 'Ward', '1956-02-16');


INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Dogville', 'Drama', '178');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Black Swan', 'Drama', '108');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Wrestler', 'Drama', '111');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Requiem for a Dream', 'Drama', '100');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Before I Go to Sleep', 'Drama', '92');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Upside', 'Drama', '125');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'To Kill a Mockingbird', 'Drama', '124');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Great Gatsby', 'Drama', '145');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Django Unchained', 'Western', '165');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Wolf of Wall Street', 'Drama', '179');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Once Upon a Time... in Hollywood', 'Crime', '159');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Hunger Games', 'Sci-fi', '143');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Harry Potter and the Philosopher''s Stone', 'Fantasy', '159');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Deja Vu', 'Action', '126');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Lucy', 'Thriller', '90');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Another Earth', 'Drama', '92');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'I Origins', 'Drama', '113');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Truman Show', 'Comedy', '103');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Pulp Fiction', 'Crime', '150');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Gran Torino', 'Drama', '116');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Deadpool', 'Action', '106');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'What Dreams May come', 'Drama', '113');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Coco', 'Animation', '109');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Titanic', 'Romance', '194');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'Bird Box', 'Horror', '124');
INSERT INTO movie (movie_id, movie_title, movie_genre, movie_length) VALUES (NULL, 'The Devil Wears Prada', 'Comedy', '109');


INSERT INTO series (series_id, series_title, series_genre, series_seasons) VALUES (NULL, 'American Horror Story', 'Horror', '10');


-- -------------------- Kapcsolattablak feltoltese --------------------

INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('1', '1', '1');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('1', '1', '5');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('5', '0', '1');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('3', '1', '2');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('2', '1', '8');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('2', '1', '10');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('2', '1', '11');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('2', '1', '24');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('8', '1', '12');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('9', '0', '12');
INSERT INTO movie_acting(actor_id, leading_role, movie_id) VALUES ('10', '0', '12');


INSERT INTO movie_directing (director_id, movie_id) VALUES ('1', '1');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('2', '2');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('2', '3');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('2', '4');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('8', '7');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('9', '8');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('5', '9');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('4', '10');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('5', '11');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('6', '12');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('7', '13');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('10', '14');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('11', '16');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('11', '17');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('12', '18');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('5', '19');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('13', '20');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('14', '21');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('15', '22');
INSERT INTO movie_directing (director_id, movie_id) VALUES ('3', '24');


-- -------------------- Jogok --------------------

GRANT SELECT, INSERT, UPDATE, DELETE ON internet_movie_database.* TO `user`@`%`;
