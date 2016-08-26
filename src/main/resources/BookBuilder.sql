DROP TABLE books;
CREATE TABLE books(
	name VARCHAR(100) NOT NULL,
	author_name VARCHAR(50) NOT NULL,
	isbn_number VARCHAR(13) NOT NULL,
	category VARCHAR(30),
	price DECIMAL(5,2),
	img_path VARCHAR(200),
	PRIMARY KEY( isbn_number)
);

INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The White Ship', 'H.P. Lovecraft', 1529798292282, 'Horror', 7.24, "the_white_ship.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Temple', 'H.P. Lovecraft', 1785518717860, 'Horror', 14.13, "the_temple.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Doom That Came to Sarnath', 'H.P. Lovecraft', 1601391109479, 'Horror', 15.95, "the_doom_that_came_to_sarnath.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('DeathStalker', 'Simon R. Green', 1521061042287, 'Fantasy', 10.62, "deathstalker.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('DeathStalker Rebellion', 'Simon R. Green', 1668477065434, 'Fantasy', 3.43, "deathstalker_rebellion.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Eye of the World', 'Robert Jordan', 1020876853520, 'Fantasy', 17.85, "the_eye_of_the_world.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Wayfarer Redemption', 'Sara Douglas', 1668860114741, 'Fantasy', 22.95, "the_wayfarer_redemption.jpg"); 
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Flatland: A Romance of Many Dimensions', 'Edwin Abbot Abbot', 1349097583036, 'Math', 18.57, "flatland_a_romance_of_many_dimensions.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Old Man and the Sea', 'Ernest Hemingway', 1148655788543, 'Classic', 2.93, "the_old_man_and_the_sea.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Guns, Germs and Steel', 'Jared Diamond', 1362863472943, 'Anthropology', 15.67, "guns_germs_and_steel.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Time Machine', 'H. G. Wells', 1448720481359, 'Science Fiction', 18.49, "the_time_machine.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Island of Dr. Moreau', 'H. G. Wells', 1987365881760, 'Science Fiction', 17.96, "the_island_of_dr_moreau.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('One for the Morning Glory', 'John Barnes Summer', 1016218485020, 'Fantasy', 3.25, "one_for_the_morning_glory.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Many Colored Land', 'Julian May', 1611768030281, 'Science Fiction', 18.57, "the_many_colored_land.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Golden Torc', 'Julian May', 1351678154016, 'Science Fiction', 12.53, "the_golden_torc.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Nonborn King', 'Julian May', 1146162457632, 'Science Fiction', 13.87, "the_nonborn_king.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Adversary', 'Julian May', 1466333190240, 'Science Fiction', 24.70, "the_adversary.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Swing: A Beginners Guide', 'Herbert Schildt', 1832440078784, 'Programming', 1.31, "swing_a_beginners_guide.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Red Planet', 'Robert Heinlein', 1593701053086, 'Science Fiction', 8.26, "red_planet.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Glory Road', 'Robert Heinlein', 1588765747277, 'Science Fiction', 12.54, "glory_road.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Revolt in 2100', 'Robert Heinlein', 1847728454740, 'Science Fiction', 20.37, "revolt_in_2100.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Methuselahs Children', 'Robert Heinlein', 1914069207718, 'Science Fiction', 18.15, "methuselahs_children.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Puppet Masters', 'Robert Heinlein', 1768222052732, 'Science Fiction', 16.65, "the_puppet_masters.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('All You Zombies', 'Robert Heinlein', 1146371920671, 'Science Fiction', 15.34, "all_you_zombies.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Prelude to Foundation', 'Isaac Asimov', 1899905103067, 'Science Fiction', 8.34, "prelude_to_foundation.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Foundation and Empire', 'Isaac Asimov', 1531639893494, 'Science Fiction', 2.42, "foundation_and_empire.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Second Foundation', 'Isaac Asimov', 1432059768840, 'Science Fiction', 19.51, "second_foundation.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Robots of Dawn', 'Isaac Asimov', 1679540970028, 'Science Fiction', 22.73, "the_robots_of_dawn.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Pebble in the Sky', 'Isaac Asimov', 1914803955964, 'Science Fiction', 3.84, "pebble_in_the_sky.jpeg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('I, Robot', 'Isaac Asimov', 1801577893837, 'Science Fiction', 14.90, "i_robot.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('The Lost World', 'Arthur Conan Doyle', 1067082320259, 'Fantasy', 14.59, "the_lost_world.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Sherlock Holmes', 'Arthur Conan Doyle', 1651148916688, 'Fantasy', 8.80, "sherlock_holmes.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Enders Game', 'Orson Scott Card', 1074202277059, 'Science Fiction', 17.41, "enders_game.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Speaker for the Dead', 'Orson Scott Card', 1875606854250, 'Science Fiction', 13.28, "speaker_for_the_dead.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Enders Shadow', 'Orson Scott Card', 1900720249336, 'Science Fiction', 20.80, "enders_shadow.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Shadow of the Hegemon', 'Orson Scott Card', 1489706342323, 'Science Fiction', 14.17, "shadow_of_the_hegemon.jpg");
INSERT INTO books(name, author_name, isbn_number, category, price, img_path) VALUES('Xenocide', 'Orson Scott Card', 1921716427260, 'Science Fiction', 16.75, "xenocide.jpg");

