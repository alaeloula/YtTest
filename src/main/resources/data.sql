

--
-- Tabelstructuur voor tabel `SETTINGS`
--

CREATE TABLE settings (
                          `id` bigint(20) UNSIGNED NOT NULL auto_increment,
                          `company_logo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `company_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `owner_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `owner_lastname` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `vat_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `street` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `zip_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `city` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `country` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `owner_email` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `owner_phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `owner_website` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `bank_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `bank_account_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `bic_number` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                          `bank_name2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `bank_account_number2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `bic_number2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                          `created_at` timestamp NULL DEFAULT NULL,
                          `updated_at` timestamp NULL DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `users`
--

CREATE TABLE users (
                       `id` bigint(20) UNSIGNED NOT NULL	auto_increment,
                       `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                       `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                       `email_verified_at` timestamp NULL DEFAULT NULL,
                       `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                       `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                       `created_at` timestamp NULL DEFAULT NULL,
                       `updated_at` timestamp NULL DEFAULT NULL,
                       `compagny_id` bigint(20) UNSIGNED NOT NULL,
                       foreign key (`compagny_id`) references settings (`id`),
                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



--
-- Tabelstructuur voor tabel `cars`
--

CREATE TABLE cars (
                      `id` bigint(20) UNSIGNED NOT NULL auto_increment,
                      `chassisNumber` varchar(17) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `brand` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `model` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `carType` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `transmission` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `firstRegistration` datetime NOT NULL,
                      `mileage` int(11) NOT NULL,
                      `enginePower` int(11) NOT NULL,
                      `cylinder` int(11) NOT NULL,
                      `fuel` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `co2` varchar(5) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `color` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
                      `numberKeys` int(1) NOT NULL,
                      `cerOfConf` tinyint(1) NOT NULL,
                      `inspectionForm` tinyint(1) NOT NULL,
                      `carPass` tinyint(1) NOT NULL,
                      `registerCert` tinyint(1) NOT NULL,
                      `created_at` timestamp NULL DEFAULT NULL,
                      `updated_at` timestamp NULL DEFAULT NULL,
                      `compagny_id` bigint(20) UNSIGNED NOT NULL,
                      foreign key (`compagny_id`) references settings (`id`),
                      PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- --------------------------------------------------------

--
-- Tabelstructuur voor tabel `clients`
--

CREATE TABLE clients (
                         `id` bigint(20) UNSIGNED NOT NULL auto_increment,
                         `isCompany` tinyint(1) NOT NULL,
                         `surname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `firstname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `companyName` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `btwNumber` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `street` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `postalCode` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `city` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `country` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
                         `email` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `phonenumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `mobilenumber` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                         `created_at` timestamp NULL DEFAULT NULL,
                         `updated_at` timestamp NULL DEFAULT NULL,
                         `compagny_id` bigint(20) UNSIGNED NOT NULL,
                         foreign key (`compagny_id`) references settings (`id`),
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- table for link between users and company SI un user peut avoir plusieurs compagnie

CREATE TABLE `invoices` (
                            `id` bigint UNSIGNED NOT NULL auto_increment,
                            `client_id` bigint UNSIGNED NOT NULL,
                            `car_id` bigint UNSIGNED NOT NULL,
                            `date` date NOT NULL,
                            `dueDate` date DEFAULT NULL,
                            `advance` decimal(10,2) NOT NULL,
                            `amount` decimal(8,2) NOT NULL,
                            `paymentMethod` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
                            `paidStatus` tinyint NOT NULL,
                            `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                            `created_at` timestamp NULL DEFAULT NULL,
                            `updated_at` timestamp NULL DEFAULT NULL,
                            `compagny_id` bigint(20) UNSIGNED NOT NULL,
                            foreign key (`client_id`) references clients (`id`),
                            foreign key (`car_id`) references cars (`id`),
                            foreign key (`compagny_id`) references settings (`id`),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;



--
-- Gegevens worden geëxporteerd voor tabel `settings`
--

INSERT INTO `settings` ( `company_logo`, `company_name`, `owner_name`, `owner_lastname`, `vat_number`, `street`, `zip_code`, `city`, `country`, `owner_email`, `owner_phone`, `owner_website`, `bank_name`, `bank_account_number`, `bic_number`, `bank_name2`, `bank_account_number2`, `bic_number2`, `created_at`, `updated_at`) VALUES
                                                                                                                                                                                                                                                                                                                                      ('images/mbo.png', 'MBO', 'Mehdi', 'Latifi', '123.456.789', 'vivastreet 123', '1234', 'Hasselt', 'TEST', 'mbo@test.be', '04949002034', 'www.mbo.be', 'ING', '123443211234', 'BNBTRH', 'KBC', 'BE1234569305', 'BNHJGNG', NULL, '2023-08-14 15:41:53'),
                                                                                                                                                                                                                                                                                                                                      ('images/ybo.png', 'YBO', 'YASSINE', 'Latifi', '111.222.333', 'teststraat 123', '1700', 'Vilvoorde', 'TEST', 'ybo@test.be', '04949002034', 'www.ybo.be', 'ING', '123443211234', 'BNBTRH', 'KBC', 'BE1234569305', 'BNHJGNG', NULL, '2023-08-14 15:41:53');



--
-- Gegevens worden geëxporteerd voor tabel `users`
--

INSERT INTO `users` (`name`, `email`, `email_verified_at`, `password`, `remember_token`, `created_at`, `updated_at`, `compagny_id`) VALUES
                                                                                                                                        ( 'Test1', 'test1@test.be', NULL, 'PSWD_TEST1', NULL, '2023-02-20 20:48:35', '2023-08-13 21:37:13',1),
                                                                                                                                        ( 'Test2', 'test2@test.be', NULL, 'PSWD_TEST2', NULL, '2023-02-20 20:48:35', '2023-08-13 21:37:13',1),
                                                                                                                                        ( 'Test3', 'test3@test.be', NULL, 'PSWD_TEST3', NULL, '2023-02-20 20:48:35', '2023-08-13 21:37:13',2),
                                                                                                                                        ( 'Test4', 'test4@test.be', NULL, 'PSWD_TEST4', NULL, '2023-02-21 21:15:35', '2023-02-21 21:15:35',2);



--
-- Gegevens worden geëxporteerd voor tabel `cars`


INSERT INTO `cars` (`id`, `chassisNumber`, `brand`, `model`, `carType`, `transmission`, `firstRegistration`, `mileage`, `enginePower`, `cylinder`, `fuel`, `co2`, `color`, `numberKeys`, `cerOfConf`, `inspectionForm`, `carPass`, `registerCert`, `created_at`, `updated_at`, `compagny_id`) VALUES
                                                                                                                                                                                                                                                                                                  (1, '123123', 'BMW', '330', 'Personenwagen', '', '2020-05-01 00:00:00', 1000, 200, 3, 'Benzine', '100', 'black', 2, 1, 1, 1, 1, '2023-05-05 22:13:05', '2023-05-05 22:13:05',1),
                                                                                                                                                                                                                                                                                                  (4, '12093456', 'Audi', 'A3', 'coupé', 'Automaat', '1993-02-02 23:00:00', 10000, 1, 2000, 'Benzine', '200', 'Zwart', 2, 1, 1, 1, 1, '2023-05-14 18:08:28', '2023-05-14 18:08:28',1),
                                                                                                                                                                                                                                                                                                  (5, '11112342', 'Peugeot', '406', 'Coupé', '1', '1980-01-31 23:00:00', 11100, 1, 2000, '1', '100', 'wit', 2, 1, 1, 1, 1, '2023-05-14 19:42:28', '2023-05-14 19:42:28',1),
                                                                                                                                                                                                                                                                                                  (6, '111', 'aaa', 'aaa', 'Coupé', 'Automatisch', '2000-01-31 23:00:00', 111, 1, 2000, '1', '100', 'aaa', 2, 1, 1, 1, 1, '2023-05-14 19:46:14', '2023-05-14 19:46:14',1),
                                                                                                                                                                                                                                                                                                  (7, '1111', 'Peugeot', '305', 'Coupé', 'Automatisch', '2011-02-02 23:00:00', 111, 1, 2000, 'Diesel', '100', 'dwds', 2, 1, 1, 1, 1, '2023-05-14 19:49:31', '2023-05-14 19:49:31',1),
                                                                                                                                                                                                                                                                                                  (8, '123123123', 'audi', 'rs3', 'Stadswagen', 'Automatisch', '2023-05-02 22:00:00', 10000, 1, 1000, 'Benzine', '100', 'geel', 2, 1, 1, 1, 1, '2023-05-15 18:23:18', '2023-05-15 18:23:18',1),
                                                                                                                                                                                                                                                                                                  (9, '123123123', 'audi', 'rs3', 'Stadswagen', 'Automatisch', '2023-05-02 22:00:00', 10000, 1, 1000, 'Benzine', '100', 'geel', 2, 1, 1, 1, 1, '2023-05-15 18:23:34', '2023-05-15 18:23:34',1),
                                                                                                                                                                                                                                                                                                  (10, '123123123', 'audi', 'rs3', 'Stadswagen', 'Automatisch', '2023-05-02 22:00:00', 10000, 1, 1000, 'Benzine', '100', 'geel', 2, 1, 1, 1, 1, '2023-05-15 18:23:44', '2023-05-15 18:23:44',1),
                                                                                                                                                                                                                                                                                                  (11, '123123123', 'Lamborghini', 'Urus', 'Coupé', 'Automatisch', '2022-12-31 23:00:00', 10000, 1, 5000, 'Benzine', '100', 'Geel', 3, 1, 1, 1, 1, '2023-05-15 18:25:46', '2023-05-15 18:25:46',1),
                                                                                                                                                                                                                                                                                                  (12, '232323', 'Audi', 'Q5', 'SUV/4x4/Pick-up', 'Automatisch', '2023-05-14 22:00:00', 1, 1, 3000, 'Elektrisch', '40', 'Grijs', 2, 1, 1, 1, 1, '2023-05-15 18:33:32', '2023-05-15 18:33:32',1),
                                                                                                                                                                                                                                                                                                  (13, '434343', 'Citroen', 'Berlibgo', 'Bestelwagen', 'Automatisch', '2023-04-30 22:00:00', 1000, 1, 2000, 'Benzine', '100', 'Groen', 2, 1, 1, 1, 1, '2023-05-15 18:46:05', '2023-05-15 18:46:05',1),
                                                                                                                                                                                                                                                                                                  (14, '9494', 'Mercedes', 'Vito', 'Monovolume', 'Manueel', '2023-05-03 22:00:00', 33333, 1, 2000, 'Elektrisch', '100', 'grijs', 2, 1, 1, 1, 1, '2023-05-15 18:47:56', '2023-05-15 18:47:56',2),
                                                                                                                                                                                                                                                                                                  (15, '234356', 'Mercedes', 'A klasse', 'Monovolume', 'Halfautomaat', '2023-05-01 22:00:00', 1, 1, 2000, 'LPG', '100', 'grijs', 2, 1, 1, 1, 1, '2023-05-15 19:04:50', '2023-05-15 19:04:50',2),
                                                                                                                                                                                                                                                                                                  (16, '1239jdjd320', 'Audi', 'RS3', 'Coupé', 'Automatisch', '2020-01-04 23:00:00', 10000, 1, 3000, 'Benzine', '109', 'Grijs', 2, 1, 1, 1, 1, '2023-05-17 19:13:32', '2023-05-17 19:13:32',2),
                                                                                                                                                                                                                                                                                                  (17, '1239jdjd320', 'Audi', 'RS3', 'Coupé', 'Automatisch', '2020-01-04 23:00:00', 10000, 1, 3000, 'Benzine', '109', 'Grijs', 2, 1, 1, 1, 1, '2023-05-17 19:15:18', '2023-05-17 19:15:18',2),
                                                                                                                                                                                                                                                                                                  (18, 'dmdkxmkwx3', 'Mercedes', 'C200', 'Coupé', 'Automatisch', '2023-07-04 22:00:00', 123000, 1, 2000, 'Benzine', '109', 'Grijs', 2, 1, 1, 1, 1, '2023-07-03 19:01:36', '2023-07-03 19:01:36',2),
                                                                                                                                                                                                                                                                                                  (19, 'dmdkxmkwx3', 'Mercedes', 'C200', 'Coupé', 'Automatisch', '2023-07-04 22:00:00', 123000, 1, 2000, 'Benzine', '109', 'Grijs', 2, 1, 1, 1, 1, '2023-07-03 19:01:38', '2023-07-03 19:01:38',2),
                                                                                                                                                                                                                                                                                                  (20, 'dmdkxmkwx3', 'Mercedes', 'C200', 'Coupé', 'Automatisch', '2023-07-04 22:00:00', 123000, 1, 2000, 'Benzine', '109', 'Grijs', 2, 1, 1, 1, 1, '2023-07-03 19:01:41', '2023-07-03 19:01:41',2),
                                                                                                                                                                                                                                                                                                  (21, '123663ybjwnd', 'Mercedes', 'e300', 'Cabriolet', 'Automatisch', '2023-07-05 22:00:00', 10000, 1, 3000, 'Diesel', '180', 'zwart', 3, 1, 1, 1, 1, '2023-07-11 12:29:06', '2023-07-11 12:29:06',2),
                                                                                                                                                                                                                                                                                                  (22, '123663ybjwnd', 'Mercedes', 'e300', 'Cabriolet', 'Automatisch', '2023-07-05 22:00:00', 10000, 1, 3000, 'Diesel', '180', 'zwart', 3, 1, 1, 1, 1, '2023-07-11 12:29:09', '2023-07-11 12:29:09',2),
                                                                                                                                                                                                                                                                                                  (23, '123663ybjwnd', 'Mercedes', 'e300', 'Cabriolet', 'Automatisch', '2023-07-05 22:00:00', 10000, 1, 3000, 'Diesel', '180', 'zwart', 3, 1, 1, 1, 1, '2023-07-11 12:29:51', '2023-07-11 12:29:51',2),
                                                                                                                                                                                                                                                                                                  (24, 'kdwkjndkjwnd', 'Opel', 'Astra', 'Cabriolet', 'Automatisch', '2023-07-03 22:00:00', 1000, 1, 2000, 'Diesel', '200', 'Zwart', 2, 1, 1, 1, 1, '2023-07-11 12:34:29', '2023-07-11 12:34:29',2),
                                                                                                                                                                                                                                                                                                  (25, '123432434', 'Peugeot', '107', 'Stadswagen', 'Manueel', '2020-02-04 23:00:00', 1000, 1, 1000, 'Benzine', '109', 'geel', 2, 1, 1, 1, 1, '2023-07-13 17:31:50', '2023-07-13 17:31:50',2);




--
-- Gegevens worden geëxporteerd voor tabel `clients`
--

INSERT INTO `clients` (`id`, `isCompany`, `surname`, `firstname`, `companyName`, `btwNumber`, `street`, `postalCode`, `city`, `country`, `email`, `phonenumber`, `mobilenumber`, `created_at`, `updated_at`, `compagny_id`) VALUES
                                                                                                                                                                                                                                (1, 0, 'Latifi', 'Yassine', NULL, NULL, 'Teststraat 1', '1800', 'Vilvoorde', 'Belgium', 'test@test.be', '123455667', NULL, '2023-04-27 19:46:39', '2023-04-27 19:46:39',1),
                                                                                                                                                                                                                                (2, 0, 'Wayne', 'John', NULL, NULL, 'teststreet 5', '1000', 'Brussels', 'Belgium', 'test1@test.be', '1234566686', NULL, '2023-04-27 19:42:54', '2023-04-27 19:42:54',1),
                                                                                                                                                                                                                                (3, 0, 'Chan', 'Arnold', NULL, NULL, 'babastreet 3', '3500', 'Hasselt', 'Belgium', 'Arnold@test.be', '1234950', NULL, '2023-04-27 19:44:06', '2023-04-27 19:44:06',1),
                                                                                                                                                                                                                                (4, 1, 'Latifi', 'Mehdi', 'MBO', '12345', 'teststraat 12', '1000', 'Brussel', 'België', 'test@testa.be', '1234567', NULL, '2023-04-29 18:39:04', '2023-04-29 18:39:04',1),
                                                                                                                                                                                                                                (5, 1, 'White', 'Walter', 'SMALS', '01234556', 'Fonsnylaan 112', '1030', 'Anderlecht', 'België', 'test@test.be', '0407879834', NULL, '2023-04-30 10:39:17', '2023-04-30 10:39:17',1),
                                                                                                                                                                                                                                (6, 0, 'De Pauw', 'Bart', NULL, NULL, 'Wetstraat 12', '1000', 'Brussel', 'België', 'bart.depauw@gmail.com', '011 09 09 09', '0489 88 44 44', '2023-04-30 10:57:42', '2023-04-30 10:57:42',1),
                                                                                                                                                                                                                                (7, 0, 'test23', 'test23', NULL, NULL, 'teststraat 123', '1000', 'Brussel', 'België', 'yes@yes.be', '12345', '54321', '2023-05-02 07:36:36', '2023-05-02 07:36:36',1),
                                                                                                                                                                                                                                (8, 1, 'Beckham', 'David', 'LA Lakers', '23232323', 'Palmstreet 23', '23456', 'Los Angeles', 'United Kingdom', 'la@lakers.be', '12345', '0303030', '2023-05-02 07:38:14', '2023-05-02 07:38:14',2),
                                                                                                                                                                                                                                (9, 1, 'De Wilde', 'Jan', 'Nike', '1111100000', 'Koningstraat 12', '1000', 'Genk', 'België', 'test1234@test.be', '02020202', '045677822', '2023-05-14 16:35:00', '2023-05-14 16:35:00',2),
                                                                                                                                                                                                                                (17, 0, 'Waseige', 'Robert', NULL, NULL, 'Koningstraat 123', '1000', 'Brussels', 'Belgium', 'RW@test.be', '02398948', '046759924', '2023-05-24 14:48:21', '2023-05-24 14:48:21',2),
                                                                                                                                                                                                                                (18, 1, 'Rooney', 'Wayne', 'RORO', '12343', 'Rue Nueve 12', '1111', 'wkmsw', 'belgium', 'rere@yeyey.be', '122345', '12312', '2023-05-31 19:08:49', '2023-05-31 19:08:49',2),
                                                                                                                                                                                                                                (19, 0, 'Putin', 'Yoeri', NULL, NULL, 'Teststraat 123', '1000', 'Brussels', 'Belgium', 'Yp@gmail.com', '02345646', '123409873', '2023-07-26 19:57:25', '2023-07-26 19:57:25',2),
                                                                                                                                                                                                                                (20, 1, 'Brico', 'Jef', 'Brico', '123.0920.12', 'Bricostraat 12', '2000', 'Antwerpen', 'Belgium', 'Brico@brico.be', '023984034', '0909302934', '2023-07-29 10:25:34', '2023-07-29 10:25:34',2);



-- LINK BETWEEN TABLES
-- LINK BETWEEN USERS AND COMPANY


-- LINK BETWEEN CLIENTS AND COMPANY


-- LINK BETWEEN CARS AND COMPANY







