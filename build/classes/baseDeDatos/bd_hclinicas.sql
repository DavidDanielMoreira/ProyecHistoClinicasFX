-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-08-2024 a las 01:08:27
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_hclinicas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `h_clinicas`
--

CREATE TABLE `h_clinicas` (
  `idHisto` int(11) UNSIGNED NOT NULL,
  `fecAltaHisto` date DEFAULT NULL,
  `historiaClinica` varchar(8) COLLATE utf8_spanish_ci NOT NULL,
  `idPaci` int(11) UNSIGNED NOT NULL,
  `idMedi` int(11) UNSIGNED NOT NULL,
  `tratHisto` text COLLATE utf8_spanish_ci,
  `fecUlt` date NOT NULL,
  `estadoHisto` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `h_clinicas`
--

INSERT INTO `h_clinicas` (`idHisto`, `fecAltaHisto`, `historiaClinica`, `idPaci`, `idMedi`, `tratHisto`, `fecUlt`, `estadoHisto`) VALUES
(1, '2024-08-18', '25724439', 1, 1, 'Padece diabetes tipo 1. gggggg.\nModifacion 19/08/2024.', '2024-08-19', 1),
(2, '2024-08-19', '20111000', 2, 1, 'Historia Clinica n° 2. dffjg ffkggg ffkggkhh fgffff.', '2024-08-20', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicos`
--

CREATE TABLE `medicos` (
  `idMedi` int(11) UNSIGNED NOT NULL,
  `apellidoMedi` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombresMedi` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilioMedi` varchar(90) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dniMedi` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nroMatriculaMedi` varchar(18) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoMedi` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `especialidadMedi` varchar(16) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `medicos`
--

INSERT INTO `medicos` (`idMedi`, `apellidoMedi`, `nombresMedi`, `domicilioMedi`, `dniMedi`, `nroMatriculaMedi`, `telefonoMedi`, `especialidadMedi`) VALUES
(1, 'Roldan', 'Jorge', 'Almafuerte 198', '12777000', '456/0ABB', '01115456789', 'CLINICO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `idPaci` int(11) UNSIGNED NOT NULL,
  `fecAltaPaci` date DEFAULT NULL,
  `apellidoPaci` varchar(50) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombresPaci` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `domicilioPaci` varchar(90) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dniPaci` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `telefonoPaci` varchar(30) COLLATE utf8_spanish_ci DEFAULT NULL,
  `correoPaci` varchar(90) COLLATE utf8_spanish_ci DEFAULT NULL,
  `sexoPaci` varchar(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estadoPaci` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`idPaci`, `fecAltaPaci`, `apellidoPaci`, `nombresPaci`, `domicilioPaci`, `dniPaci`, `telefonoPaci`, `correoPaci`, `sexoPaci`, `estadoPaci`) VALUES
(1, '2024-08-14', 'Moreira', 'David', 'Salta 528', '25724439', '3400658999', 'david77@gmail.com', 'M', 1),
(2, '2024-08-19', 'Lopez', 'Hugo', 'Salta 456', '20111000', '0115896989', '-', 'M', 1),
(3, '2024-08-19', 'Salas', 'Alberto', 'Formosa 123', '10588111', '3418999', 'salas@hotmail.com', 'M', 1),
(4, '2024-08-20', 'Moreno', 'Luis', '-', '27888111', '-', '-', 'M', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `h_clinicas`
--
ALTER TABLE `h_clinicas`
  ADD PRIMARY KEY (`idHisto`),
  ADD KEY `idPaci` (`idPaci`),
  ADD KEY `idMedi` (`idMedi`);

--
-- Indices de la tabla `medicos`
--
ALTER TABLE `medicos`
  ADD PRIMARY KEY (`idMedi`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`idPaci`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `h_clinicas`
--
ALTER TABLE `h_clinicas`
  MODIFY `idHisto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `medicos`
--
ALTER TABLE `medicos`
  MODIFY `idMedi` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `idPaci` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `h_clinicas`
--
ALTER TABLE `h_clinicas`
  ADD CONSTRAINT `h_clinicas_ibfk_1` FOREIGN KEY (`idPaci`) REFERENCES `pacientes` (`idPaci`),
  ADD CONSTRAINT `h_clinicas_ibfk_2` FOREIGN KEY (`idMedi`) REFERENCES `medicos` (`idMedi`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
