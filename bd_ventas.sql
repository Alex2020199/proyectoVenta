create database ProyectoVentas;
use ProyectoVentas;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;



CREATE TABLE `Cliente` (
  `id` int(11) UNSIGNED NOT NULL,
  `Dpi` varchar(40) DEFAULT NULL,
  `Nit` varchar(40) DEFAULT NULL,
  `Nombres` varchar(244) NOT NULL,
  `Telefono` varchar(10) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO `Cliente` (`id`, `Dpi`, `Nit`, `Nombres`, `Telefono`, `Direccion`) VALUES
(1, '', 'cf', 'Consumidor Final', '', 'Ciudad'),
(2, '', 'CF', 'Consumidor Final', '', 'Ciudad'),
(3, '', 'C/F', 'Consumidor Final', '', 'Ciudad'),
(4,'333333333333333333333','12345678','Juan Osorio','45678900','zona 1');




CREATE TABLE `Detalle_Ventas` (
  `id` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;






CREATE TABLE `Producto` (
  `id` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Estado` enum('Activo', 'Inactivo') default 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `producto` VALUES (1,'Leche Nido 500 g',125.75,100,'Activo'),
                              (2,'Cafe Incasa',2.5,100,'Activo'),
                              (3,'Huevos 30 unidades.',30.75,20,'Activo'),
                              (4,'Salchichas Fud',0.5,100,'Activo'),
                              (5,'Consome de pollo Malher',3.5,100,'Activo');



CREATE TABLE `Vendedor` (
  `id` int(10) UNSIGNED NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Estado` enum('Activo', 'Inactivo') default 'Activo',
  `User` varchar(100) NOT NULL,
  `Password` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



INSERT INTO `Vendedor` (`id`, `Nombres`, `Telefono`, `Estado`, `User`, `Password`) VALUES
(1, 'Usuario de Prueba', '11111111', 'Activo', 'userPrueba', '12345678');
--
-- Volcado de datos para la tabla `vendedor`
--


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `Ventas` (
  `id` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdVendedor` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` enum('Activo', 'Inactivo') default 'Activo'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE Ventas AUTO_INCREMENT=1;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `Detalle_Ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);


ALTER TABLE `Producto`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `Vendedor`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `Ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ventas_FKIndex1` (`IdVendedor`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`);


ALTER TABLE `Cliente`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `Detalle_Ventas`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `Producto`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT de la tabla `vendedor`
--
ALTER TABLE `Vendedor`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `Ventas`
  MODIFY `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `Detalle_Ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `Ventas` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `Producto` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `Ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`IdVendedor`) REFERENCES `Vendedor` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `Cliente` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
