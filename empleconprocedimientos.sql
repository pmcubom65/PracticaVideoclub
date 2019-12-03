-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2019 a las 20:10:32
-- Versión del servidor: 5.7.17
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emple`
--

CREATE TABLE `emple` (
  `EMP_NO` int(4) NOT NULL,
  `APELLIDO` varchar(10) COLLATE latin1_spanish_ci DEFAULT NULL,
  `OFICIO` varchar(10) COLLATE latin1_spanish_ci DEFAULT NULL,
  `DIR` int(4) DEFAULT NULL,
  `FECHA_ALT` date DEFAULT NULL,
  `SALARIO` int(7) DEFAULT NULL,
  `COMISION` int(7) DEFAULT NULL,
  `DEPT_NO` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Volcado de datos para la tabla `emple`
--

INSERT INTO `emple` (`EMP_NO`, `APELLIDO`, `OFICIO`, `DIR`, `FECHA_ALT`, `SALARIO`, `COMISION`, `DEPT_NO`) VALUES
(7369, 'SANCHEZ', 'EMPLEADO', 7902, '2005-12-17', 1040, NULL, 20),
(7499, 'ARROYO', 'VENDEDOR', 7698, '2007-02-20', 1500, 390, 30),
(7521, 'SALA', 'VENDEDOR', 7698, '2008-02-22', 1625, 650, 30),
(7566, 'JIMENEZ', 'DIRECTOR', 7839, '2008-04-02', 2900, NULL, 20),
(7654, 'MARTIN', 'VENDEDOR', 7698, '2008-09-29', 1600, 1020, 30),
(7782, 'CEREZO', 'DIRECTOR', 7839, '2005-06-09', 2885, NULL, 10),
(7788, 'GIL', 'ANALISTA', 7566, '2007-09-11', 3000, NULL, 20),
(7839, 'REY', 'PRESIDENTE', NULL, '2007-11-17', 4100, NULL, 10),
(7844, 'TOVAR', 'VENDEDOR', 7698, '2007-09-08', 1350, 0, 30),
(7876, 'ALONSO', 'EMPLEADO', 7788, '2008-09-23', 1430, NULL, 20),
(7900, 'JIMENO', 'EMPLEADO', 7698, '2008-12-03', 1335, NULL, 30),
(7902, 'FERNANDEZ', 'ANALISTA', 7566, '2007-12-03', 3000, NULL, 20),
(7934, 'MUÑOZ', 'EMPLEADO', 7782, '2009-01-23', 1690, NULL, 10),
(9999, 'cubo', 'feo', 6699, '2000-10-10', 1000, 10, 10),
(8888, 'cubo', 'empleado', 7788, '2000-12-12', 1000, 10, 20),
(9991, 'cubo', 'empleado', 7788, '2000-08-08', 1000, 10, 10),
(4442, 'LOPEZ', 'EMPLEADO', 7902, '2003-01-08', 1000, NULL, 20);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `emple`
--
ALTER TABLE `emple`
  ADD PRIMARY KEY (`EMP_NO`),
  ADD KEY `DEPT_NO` (`DEPT_NO`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
