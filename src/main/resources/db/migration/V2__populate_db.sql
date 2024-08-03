INSERT INTO client (name) VALUES
('Vanessa'),
('Peter'),
('Merlin'),
('Mark'),
('Jane'),
('Adel'),
('Eve'),
('Max'),
('Grace'),
('Hank');

INSERT INTO planet (id, name) VALUES
('MRK', 'Mercury'),
('VNR', 'Venera'),
('JUP', 'Jupiter'),
('MRS', 'Mars'),
('STR', 'Saturn');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
('2023-02-06 10:00:01', 1, 'MRS', 'VNR'),
('2024-09-26 16:36:00', 2, 'STR', 'MRK'),
('2021-11-17 22:30:05', 3, 'STR', 'VNR'),
('2023-12-07 09:13:31', 4, 'JUP', 'MRS'),
('2009-05-18 04:38:27', 5, 'MRS', 'MRK'),
('2008-06-14 22:17:45', 6, 'JUP', 'VNR'),
('1999-07-08 12:11:21', 7, 'MRK', 'MRS'),
('1995-01-05 05:36:11', 8, 'VNR', 'MRK'),
('1998-12-06 09:15:05', 9, 'MRK', 'STR'),
('1982-06-08 07:01:03', 10, 'VNR', 'JUP');