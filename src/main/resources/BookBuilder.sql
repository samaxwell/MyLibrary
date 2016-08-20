create table books(
	name varchar(100) NOT NULL,
	author_name varchar(50) NOT NULL,
	isbn_number varchar(13) NOT NULL,
	category varchar(30),
	price decimal(5,2),
	PRIMARY KEY( isbn_number)
);

INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The White Ship', 'H.P. Lovecraft', 1529798292282, 'Horror', 7.24);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Temple', 'H.P. Lovecraft', 1785518717860, 'Horror', 14.13);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Doom That Came to Sarnath', 'H.P. Lovecraft', 1601391109479, 'Horror', 15.95);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('DeathStalker', 'Simon R. Green', 1521061042287, 'Fantasy', 10.62);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('DeathStalker Rebellion', 'Simon R. Green', 1668477065434, 'Fantasy', 3.43);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Eye of the World', 'Robert Jordan', 1020876853520, 'Fantasy', 17.85);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Wayfarer Redemption', 'Sara Douglas', 1668860114741, 'Fantasy', 22.95); INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Flatland: A Romance of Many Dimensions', 'Edwin Abbot Abbot', 1349097583036, 'Math', 18.57);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Old Man and the Sea', 'Ernest Hemingway', 1148655788543, 'Classic', 2.93);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Guns, Germs and Steel', 'Jared Diamond', 1362863472943, 'Anthropology', 15.67);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Time Machine', 'H. G. Wells', 1448720481359, 'Science Fiction', 18.49);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Island of Dr. Moreau', 'H. G. Wells', 1987365881760, 'Science Fiction', 17.96);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('One for the Morning Glory', 'John Barnes Summer', 1016218485020, 'Fantasy', 3.25);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Many Colored Land', 'Julian May', 1611768030281, 'Science Fiction', 18.57);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Golden Torc', 'Julian May', 1351678154016, 'Science Fiction', 12.53);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Nonborn King', 'Julian May', 1146162457632, 'Science Fiction', 13.87);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Adversary', 'Julian May', 1466333190240, 'Science Fiction', 24.70);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Swing: A Beginners Guide', 'Herbert Schildt', 1832440078784, 'Programming', 1.31);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Red Planet', 'Robert Heinlein', 1593701053086, 'Science Fiction', 8.26);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Glory Road', 'Robert Heinlein', 1588765747277, 'Science Fiction', 12.54);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Revolt in 2100', 'Robert Heinlein', 1847728454740, 'Science Fiction', 20.37);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Methuselahs Children', 'Robert Heinlein', 1914069207718, 'Science Fiction', 18.15);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Body Snatchers', 'Robert Heinlein', 1768222052732, 'Science Fiction', 16.65);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('All You Zombies', 'Robert Heinlein', 1146371920671, 'Science Fiction', 15.34);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Prelude to Foundation', 'Isaac Asimov', 1899905103067, 'Science Fiction', 8.34);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Foundation and Empire', 'Isaac Asimov', 1531639893494, 'Science Fiction', 2.42);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Second Foundation', 'Isaac Asimov', 1432059768840, 'Science Fiction', 19.51);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Robots of Dawn', 'Isaac Asimov', 1679540970028, 'Science Fiction', 22.73);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Pebble in the Sky', 'Isaac Asimov', 1914803955964, 'Science Fiction', 3.84);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('I, Robot', 'Isaac Asimov', 1801577893837, 'Science Fiction', 14.90);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('The Lost World', 'Arthur Conan Doyle', 1067082320259, 'Fantasy', 14.59);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Sherlock Holmes', 'Arthur Conan Doyle', 1651148916688, 'Fantasy', 8.80);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Enders Game', 'Orson Scott Card', 1074202277059, 'Science Fiction', 17.41);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Speaker for the Dead', 'Orson Scott Card', 1875606854250, 'Science Fiction', 13.28);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Enders Shadow', 'Orson Scott Card', 1900720249336, 'Science Fiction', 20.80);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Shadow of the Hegemon', 'Orson Scott Card', 1489706342323, 'Science Fiction', 14.17);
INSERT INTO books(name, author_name, isbn_number, category, price) VALUES('Xenocide', 'Orson Scott Card', 1921716427260, 'Science Fiction', 16.75);

