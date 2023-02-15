-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2023 a las 12:59:22
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `jdocxdef`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `abonos`
--

CREATE TABLE `abonos` (
  `id` int(11) NOT NULL,
  `importe` double NOT NULL,
  `esJoven` tinyint(1) NOT NULL DEFAULT 0,
  `esAdulto` tinyint(1) NOT NULL DEFAULT 0,
  `esJubilado` tinyint(1) NOT NULL DEFAULT 0,
  `asiento` int(11) NOT NULL,
  `fechaInscripcion` date NOT NULL DEFAULT current_timestamp(),
  `idSocio` int(11) NOT NULL,
  `idZona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `abonos`
--

INSERT INTO `abonos` (`id`, `importe`, `esJoven`, `esAdulto`, `esJubilado`, `asiento`, `fechaInscripcion`, `idSocio`, `idZona`) VALUES
(2, 150, 1, 0, 0, 6, '2023-02-14', 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestores`
--

CREATE TABLE `gestores` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `esAdmin` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `gestores`
--

INSERT INTO `gestores` (`id`, `usuario`, `correo`, `contrasena`, `esAdmin`) VALUES
(1, 'Diego', 'di.piedra@aulanz.net', '202cb962ac59075b964b07152d234b70', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socios`
--

CREATE TABLE `socios` (
  `id` int(11) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `primerApellido` varchar(30) NOT NULL,
  `segundoApellido` varchar(30) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `fechaNacimiento` varchar(20) NOT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `socios`
--

INSERT INTO `socios` (`id`, `dni`, `nombre`, `primerApellido`, `segundoApellido`, `correo`, `contrasena`, `fechaNacimiento`, `telefono`, `idUsuario`) VALUES
(1, '55557009A', 'Diego', 'Piedra', 'Alvarez', 'di.piedra@aulanz.net', 'dcf94bec37276ef64dc0f79f006e500e', '2001-09-22', '', 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuariosweb`
--

CREATE TABLE `usuariosweb` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `nombreUsuario` varchar(100) NOT NULL,
  `contrasena` varchar(100) NOT NULL,
  `fotoPerfil` blob NOT NULL,
  `otp` int(50) NOT NULL,
  `verification_status` varchar(50) NOT NULL,
  `fechaRegistro` varchar(20) NOT NULL DEFAULT current_timestamp(),
  `esSocio` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuariosweb`
--

INSERT INTO `usuariosweb` (`id`, `nombre`, `correo`, `nombreUsuario`, `contrasena`, `fotoPerfil`, `otp`, `verification_status`, `fechaRegistro`, `esSocio`) VALUES
(4, 'Oier Rojo Nuñez', 'oi.rojo@aulanz.net', 'Oierloco', '827ccb0eea8a706c4c34a16891f84e7b', 0x64657363617267612e6a7067, 2534, '1', '2023-02-10 11:33:30', 0),
(5, 'Sabi', 'xa.gonzalez@aulanz.net', 'sabier', '16b2d4da09bdf7b04ea3d25b41a049b3', 0x7375752e6a666966, 2154, '1', '2023-02-10 11:34:07', 0),
(7, 'Iker Cao', 'ik.cao@aulanz.net', 'iker', 'e637d52df1ebdfc8eef062c325ee3cb2', 0x7472616e73706172656e742e706e67, 8151, '1', '2023-02-10 12:16:09', 0),
(8, 'Diego', 'di.piedra@aulanz.net', 'diego.piedra', 'ed370839510b9e7499f6225da3ceb899', 0x6d656e755f69636f6e2e6a7067, 4063, '', '2023-02-10 12:39:29', 1),
(9, 'Ignacio', 'ig.herrera@aulanz.net', 'JoKer', 'ef9d7d42eefc2a6ab5506ef5391d77d0', 0x6a6f6b65722d6a6f617175696e2d70686f656e69782d6865726f652d76696c6c616e6f2d313536373433303438302e6a7067, 7336, '1', '2023-02-10 13:18:59', 0),
(11, 'jgontzall37', 'jgontzall37@gmail.com', 'jgontzall37', '2b9e1c5f522b2565b34cdb5ee3776284', 0x64657363617267612e6a666966, 7418, '1', '2023-02-13 08:42:39', 0),
(14, 'Jokin Gonzalez', 'jo.gonzalez@aulanz.net', 'jokin', '65e56c75bd222a6f9fab9ab8c178e513', 0x64657363617267612e6a666966, 6527, '1', '2023-02-14 09:16:31', 0),
(15, 'Adel', 'ad.khlebnikova@aulanz.net', 'Adelinsky', '995bf053c4694e1e353cfd42b94e4447', 0x32306661376236302d343862392d343364372d626166312d6131363331656330653362622e6a7067, 1883, '1', '2023-02-14 09:23:05', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zona`
--

CREATE TABLE `zona` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `zona`
--

INSERT INTO `zona` (`id`, `nombre`) VALUES
(1, 'Norte'),
(2, 'Sur'),
(3, 'Este'),
(4, 'Oeste');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `abonos`
--
ALTER TABLE `abonos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idSocio` (`idSocio`),
  ADD KEY `idZona` (`idZona`);

--
-- Indices de la tabla `gestores`
--
ALTER TABLE `gestores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `socios`
--
ALTER TABLE `socios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuariosweb`
--
ALTER TABLE `usuariosweb`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `zona`
--
ALTER TABLE `zona`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `abonos`
--
ALTER TABLE `abonos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `gestores`
--
ALTER TABLE `gestores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `socios`
--
ALTER TABLE `socios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `usuariosweb`
--
ALTER TABLE `usuariosweb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `zona`
--
ALTER TABLE `zona`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `abonos`
--
ALTER TABLE `abonos`
  ADD CONSTRAINT `abonos_ibfk_1` FOREIGN KEY (`idSocio`) REFERENCES `socios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `abonos_ibfk_2` FOREIGN KEY (`idZona`) REFERENCES `zona` (`id`);

--
-- Filtros para la tabla `socios`
--
ALTER TABLE `socios`
  ADD CONSTRAINT `socios_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `usuariosweb` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
