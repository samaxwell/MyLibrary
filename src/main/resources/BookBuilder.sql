DROP TABLE books;
CREATE TABLE books(
	name VARCHAR(100) NOT NULL,
	author_name VARCHAR(50) NOT NULL,
	isbn_number VARCHAR(13) NOT NULL,
	category VARCHAR(30),
	price DECIMAL(5,2),
	publishing_date INT, 
	cover_name VARCHAR(200),
	PRIMARY KEY( isbn_number)
);

INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The White Ship', 'H.P. Lovecraft', 1529798292282, 'Horror', 7.24, 1997, "the_white_ship.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Fahrenheit 451', 'Ray Bradbury', 1529292288112, 'Dystopia', 8.44, 1953, "fahrenheit_451.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Temple', 'H.P. Lovecraft', 1785518717860, 'Horror', 14.13, 1925, "the_temple.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Doom That Came to Sarnath', 'H.P. Lovecraft', 1601391109479, 'Horror', 15.95, 1920, "the_doom_that_came_to_sarnath.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('DeathStalker', 'Simon R. Green', 1521061042287, 'Fantasy', 10.62, 1995, "deathstalker.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('DeathStalker Rebellion', 'Simon R. Green', 1668477065434, 'Fantasy', 3.43, 1996, "deathstalker_rebellion.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Eye of the World', 'Robert Jordan', 1020876853520, 'Fantasy', 17.85, 1990, "the_eye_of_the_world.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Wayfarer Redemption', 'Sara Douglas', 1668860114741, 'Fantasy', 22.95, 1995, "the_wayfarer_redemption.jpg"); 
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Flatland: A Romance of Many Dimensions', 'Edwin Abbot Abbot', 1349097583036, 'Math', 18.57, 1884, "flatland_a_romance_of_many_dimensions.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Old Man and the Sea', 'Ernest Hemingway', 1148655788543, 'Classic', 2.93, 1952, "the_old_man_and_the_sea.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Guns, Germs and Steel', 'Jared Diamond', 1362863472943, 'Anthropology', 15.67, 1997, "guns_germs_and_steel.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Time Machine', 'H. G. Wells', 1448720481359, 'Science Fiction', 18.49, 1895, "the_time_machine.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Island of Dr. Moreau', 'H. G. Wells', 1987365881760, 'Science Fiction', 17.96, 1896, "the_island_of_dr_moreau.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('One for the Morning Glory', 'John Barnes Summer', 1016218485020, 'Fantasy', 3.25, 1996, "one_for_the_morning_glory.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Many Colored Land', 'Julian May', 1611768030281, 'Science Fiction', 18.57, 1981, "the_many_colored_land.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Golden Torc', 'Julian May', 1351678154016, 'Science Fiction', 12.53, 1982, "the_golden_torc.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Nonborn King', 'Julian May', 1146162457632, 'Science Fiction', 13.87, 1982, "the_nonborn_king.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Adversary', 'Julian May', 1466333190240, 'Science Fiction', 24.70, 1984, "the_adversary.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Swing: A Beginners Guide', 'Herbert Schildt', 1832440078784, 'Programming', 1.31, 2006, "swing_a_beginners_guide.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Red Planet', 'Robert Heinlein', 1593701053086, 'Science Fiction', 8.26, 1949, "red_planet.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Glory Road', 'Robert Heinlein', 1588765747277, 'Science Fiction', 12.54, 1963, "glory_road.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Revolt in 2100', 'Robert Heinlein', 1847728454740, 'Science Fiction', 20.37, 1953, "revolt_in_2100.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Methuselahs Children', 'Robert Heinlein', 1914069207718, 'Science Fiction', 18.15, 1958, "methuselahs_children.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Puppet Masters', 'Robert Heinlein', 1768222052732, 'Science Fiction', 16.65, 1951, "the_puppet_masters.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('All You Zombies', 'Robert Heinlein', 1146371920671, 'Science Fiction', 15.34, 1959, "all_you_zombies.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Prelude to Foundation', 'Isaac Asimov', 1899905103067, 'Science Fiction', 8.34, 1988, "prelude_to_foundation.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Foundation and Empire', 'Isaac Asimov', 1531639893494, 'Science Fiction', 2.42, 1952, "foundation_and_empire.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Second Foundation', 'Isaac Asimov', 1432059768840, 'Science Fiction', 19.51, 1953, "second_foundation.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Robots of Dawn', 'Isaac Asimov', 1679540970028, 'Science Fiction', 22.73, 1983, "the_robots_of_dawn.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Pebble in the Sky', 'Isaac Asimov', 1914803955964, 'Science Fiction', 3.84, 1950, "pebble_in_the_sky.jpeg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('I, Robot', 'Isaac Asimov', 1801577893837, 'Science Fiction', 14.90, 1950, "i_robot.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('The Lost World', 'Arthur Conan Doyle', 1067082320259, 'Fantasy', 14.59, 1912, "the_lost_world.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Sherlock Holmes', 'Arthur Conan Doyle', 1651148916688, 'Fantasy', 8.80, 1892, "sherlock_holmes.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Enders Game', 'Orson Scott Card', 1074202277059, 'Science Fiction', 17.41, 1985, "enders_game.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Speaker for the Dead', 'Orson Scott Card', 1875606854250, 'Science Fiction', 13.28, 1986, "speaker_for_the_dead.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Enders Shadow', 'Orson Scott Card', 1900720249336, 'Science Fiction', 20.80, 1999, "enders_shadow.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Shadow of the Hegemon', 'Orson Scott Card', 1489706342323, 'Science Fiction', 14.17, 2000, "shadow_of_the_hegemon.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, publishing_date, cover_name) VALUES('Xenocide', 'Orson Scott Card', 1921716427260, 'Science Fiction', 16.75, 1991, "xenocide.jpg");

