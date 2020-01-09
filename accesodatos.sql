-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-01-2020 a las 16:52:57
-- Versión del servidor: 8.0.18
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `accesodatos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE `categories` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(150) DEFAULT NULL,
  `remarks` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`category_id`, `category_name`, `remarks`) VALUES
(1, 'Comedy', 'Movies with humour'),
(2, 'Romantic', 'Love stories'),
(3, 'Epic', 'Story acient movies'),
(4, 'Horror', NULL),
(5, 'Science Fiction', NULL),
(6, 'Thriller', NULL),
(7, 'Action', NULL),
(8, 'Romantic Comedy', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `members`
--

CREATE TABLE `members` (
  `membership_number` int(11) NOT NULL,
  `full_names` varchar(350) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `physical_address` varchar(255) DEFAULT NULL,
  `postal_address` varchar(255) DEFAULT NULL,
  `contact_number` varchar(75) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `members`
--

INSERT INTO `members` (`membership_number`, `full_names`, `gender`, `date_of_birth`, `physical_address`, `postal_address`, `contact_number`, `email`) VALUES
(1, 'Janet Jones', 'Female', '1980-07-21', 'First Street Plot No 4', 'Private Bag', '0759 253 542', 'janetjones@yagoo.cm'),
(2, 'Janet Smith Jones', 'Female', '1980-06-23', 'Melrose 123', NULL, NULL, 'jj@fstreet.com'),
(3, 'Robert Phil', 'Male', '1989-07-12', '3rd Street 34', NULL, '12345', 'rm@tstreet.com'),
(4, 'Gloria Williams', 'Female', '1984-02-14', '2nd Street 23', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movierentals`
--

CREATE TABLE `movierentals` (
  `reference_number` int(11) NOT NULL,
  `transaction_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `membership_number` int(11) DEFAULT NULL,
  `movie_id` int(11) DEFAULT NULL,
  `movie_returned` bit(1) DEFAULT b'0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movierentals`
--

INSERT INTO `movierentals` (`reference_number`, `transaction_date`, `return_date`, `membership_number`, `movie_id`, `movie_returned`) VALUES
(11, '2012-06-20', NULL, 1, 1, b'0'),
(12, '2012-06-22', '2012-06-25', 1, 2, b'0'),
(13, '2012-06-22', '2012-06-25', 3, 2, b'0'),
(14, '2012-06-21', '2012-06-24', 2, 2, b'0'),
(15, '2012-06-23', NULL, 3, 3, b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `movies`
--

CREATE TABLE `movies` (
  `movie_id` int(11) NOT NULL,
  `title` varchar(300) DEFAULT NULL,
  `director` varchar(150) DEFAULT NULL,
  `year_released` year(4) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `movies`
--

INSERT INTO `movies` (`movie_id`, `title`, `director`, `year_released`, `category_id`) VALUES
(1, 'Pirates of the Caribean 4', ' Rob Marshall', 2011, 1),
(2, 'Forgetting Sarah Marshal', 'Nicholas Stoller', 2008, 2),
(3, 'X-Men', NULL, 2008, NULL),
(4, 'Code Name Black', 'Edgar Jimz', 2010, NULL),
(5, 'Daddy\'s Little Girls', NULL, 2007, 8),
(6, 'Angels and Demons', NULL, 2007, 6),
(7, 'Davinci Code', NULL, 2007, 6),
(9, 'Honey mooners', 'John Schultz', 2005, 8),
(16, '67% Guilty', NULL, 2012, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `payments`
--

CREATE TABLE `payments` (
  `payment_id` int(11) NOT NULL,
  `membership_number` int(11) DEFAULT NULL,
  `payment_date` date DEFAULT NULL,
  `description` varchar(75) DEFAULT NULL,
  `amount_paid` float DEFAULT NULL,
  `external_reference_number` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `payments`
--

INSERT INTO `payments` (`payment_id`, `membership_number`, `payment_date`, `description`, `amount_paid`, `external_reference_number`) VALUES
(1, 1, '2012-07-23', 'Movie rental payment', 2500, 11),
(2, 1, '2012-07-25', 'Movie rental payment', 2000, 12),
(3, 3, '2012-07-30', 'Movie rental payment', 6000, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indices de la tabla `members`
--
ALTER TABLE `members`
  ADD PRIMARY KEY (`membership_number`);

--
-- Indices de la tabla `movierentals`
--
ALTER TABLE `movierentals`
  ADD PRIMARY KEY (`reference_number`),
  ADD KEY `fk_MovieRentals_Members1` (`membership_number`),
  ADD KEY `fk_MovieRentals_Movies1` (`movie_id`);

--
-- Indices de la tabla `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`movie_id`),
  ADD KEY `fk_Movies_Categories1` (`category_id`),
  ADD KEY `title_index` (`title`),
  ADD KEY `qw` (`title`);

--
-- Indices de la tabla `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`payment_id`),
  ADD KEY `fk_Payments_Members1` (`membership_number`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categories`
--
ALTER TABLE `categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `members`
--
ALTER TABLE `members`
  MODIFY `membership_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `movierentals`
--
ALTER TABLE `movierentals`
  MODIFY `reference_number` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `movies`
--
ALTER TABLE `movies`
  MODIFY `movie_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT de la tabla `payments`
--
ALTER TABLE `payments`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `movierentals`
--
ALTER TABLE `movierentals`
  ADD CONSTRAINT `fk_MovieRentals_Members1` FOREIGN KEY (`membership_number`) REFERENCES `members` (`membership_number`),
  ADD CONSTRAINT `fk_MovieRentals_Movies1` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`);

--
-- Filtros para la tabla `movies`
--
ALTER TABLE `movies`
  ADD CONSTRAINT `fk_Movies_Categories1` FOREIGN KEY (`category_id`) REFERENCES `categories` (`category_id`);

--
-- Filtros para la tabla `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_Payments_Members1` FOREIGN KEY (`membership_number`) REFERENCES `members` (`membership_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
