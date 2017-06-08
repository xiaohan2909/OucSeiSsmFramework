-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 主机: localhost
-- 生成日期: 2017 年 06 月 08 日 06:36
-- 服务器版本: 5.5.32
-- PHP 版本: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `sample`
--
CREATE DATABASE IF NOT EXISTS `sample` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `sample`;

-- --------------------------------------------------------

--
-- 表的结构 `log`
--

CREATE TABLE IF NOT EXISTS `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` char(10) DEFAULT NULL,
  `time` char(8) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=37 ;

--
-- 转存表中的数据 `log`
--

INSERT INTO `log` (`id`, `date`, `time`, `description`) VALUES
(1, '2014-09-12', '21:07:02', 'update product by id is 13'),
(2, '2014-09-12', '21:18:31', 'update product by id is 13'),
(3, '2014-09-12', '21:18:47', 'update product by id is 13'),
(4, '2014-09-12', '21:24:11', 'update product by id is 12'),
(5, '2014-09-12', '21:45:23', 'update product by id is 14'),
(6, '2014-09-13', '09:02:28', 'update product by id is 14'),
(7, '2014-09-13', '09:11:57', 'update product by id is 12'),
(8, '2014-09-13', '11:33:21', 'update product by id is 13'),
(9, '2014-09-13', '11:33:32', 'update product by id is 14'),
(10, '2014-09-23', '16:40:52', 'update product by id is 12'),
(11, '2014-09-23', '16:48:18', 'update product by id is 13'),
(12, '2014-09-23', '16:49:28', 'update product by id is 13'),
(13, '2014-09-23', '16:51:15', 'update product by id is 13'),
(14, '2014-09-23', '21:47:59', 'update product by id is 9'),
(15, '2014-10-24', '16:34:16', 'update product by id is 5'),
(16, '2014-10-24', '16:36:42', 'update product by id is 5'),
(17, '2014-10-24', '16:44:27', 'update product by id is 5'),
(18, '2014-10-28', '17:17:35', 'update product by id is 12'),
(19, '2014-10-28', '18:38:33', 'update product by id is 12'),
(20, '2014-10-28', '18:41:26', 'update product by id is 12'),
(21, '2014-10-28', '18:56:37', 'update product by id is 12'),
(22, '2014-10-28', '18:57:06', 'update product by id is 12'),
(23, '2014-10-28', '18:59:22', 'update product by id is 12'),
(24, '2014-10-28', '19:02:32', 'update product by id is 12'),
(25, '2014-10-28', '19:03:06', 'update product by id is 12'),
(26, '2014-10-28', '19:08:46', 'update product by id is 12'),
(27, '2014-10-28', '19:12:16', 'update product by id is 12'),
(28, '2014-10-28', '19:22:56', 'update product by id is 11'),
(29, '2014-10-28', '20:29:40', 'update product by id is 5'),
(30, '2014-10-28', '20:33:35', 'update product by id is 5'),
(31, '2014-10-28', '20:35:02', 'update product by id is 5'),
(32, '2014-10-28', '20:37:04', 'update product by id is 10'),
(33, '2014-10-28', '20:41:07', 'update product by id is 10'),
(34, '2014-10-28', '21:17:19', 'update product by id is 10'),
(35, '2014-10-28', '21:22:15', 'update product by id is 10'),
(36, '2014-10-28', '21:27:26', 'update product by id is 10');

-- --------------------------------------------------------

--
-- 表的结构 `permission`
--

CREATE TABLE IF NOT EXISTS `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- 转存表中的数据 `permission`
--

INSERT INTO `permission` (`id`, `permission_name`) VALUES
(1, 'product.view'),
(2, 'product.create'),
(3, 'product.edit'),
(4, 'product.delete');

-- --------------------------------------------------------

--
-- 表的结构 `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_type_id` bigint(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `code` char(5) NOT NULL,
  `price` int(10) NOT NULL,
  `description` text,
  `picture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=14 ;

--
-- 转存表中的数据 `product`
--

INSERT INTO `product` (`id`, `product_type_id`, `name`, `code`, `price`, `description`, `picture`) VALUES
(1, 1, 'iPhone 3g', 'MP001', 3000, 'iPhone 3g 移动电话', ''),
(2, 1, 'iPhone 3gs', 'MP002', 3500, 'iPhone 3gs 移动电话', ''),
(3, 2, 'iPad 2', 'TC001', 3000, 'iPad 2 平板电脑', ''),
(4, 1, 'iPhone 4', 'MP003', 4000, 'iPhone 4 移动电话', ''),
(5, 1, 'iPhone 4s', 'MP004', 4500, 'iPhone 4s 移动电话', '714_06.png'),
(6, 2, 'iPad 3', 'TC002', 3500, 'iPad 3 平板电脑', ''),
(7, 1, 'iPhone 5', 'MP005', 5000, 'iPhone 5 移动电话', ''),
(8, 2, 'iPad mini', 'TC003', 2000, 'iPad mini 平板电脑', ''),
(9, 2, 'iPad 4', 'TC004', 4000, 'iPad 4 平板电脑', ''),
(10, 1, 'iPhone 5c', 'MP006', 3500, 'iPhone 5c 移动电话', '714_06.png'),
(11, 1, 'iPhone 5s', 'MP007', 5500, 'iPhone 5s 移动电话', '714_03.jpg'),
(12, 2, 'iPad air', 'TC005', 3500, 'iPad air 电脑', '714_03.jpg'),
(13, 2, 'iPad 2', 'TC001', 3000, 'iPad 2 平板电脑', '');

-- --------------------------------------------------------

--
-- 表的结构 `product_type`
--

CREATE TABLE IF NOT EXISTS `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `product_type`
--

INSERT INTO `product_type` (`id`, `name`, `description`) VALUES
(1, 'Mobile Phone', '移动电话'),
(2, 'Tablet Computer', '平板电脑');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 转存表中的数据 `role`
--

INSERT INTO `role` (`id`, `role_name`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- 表的结构 `role_permission`
--

CREATE TABLE IF NOT EXISTS `role_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `role_permission`
--

INSERT INTO `role_permission` (`id`, `role_id`, `permission_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 1, 3),
(4, 1, 4),
(5, 2, 1);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'admin', 'e10adc3949ba59abbe56e057f20f883e'),
(2, 'user1', 'e10adc3949ba59abbe56e057f20f883e'),
(3, 'lixiaohan', 'e10adc3949ba59abbe56e057f20f883e');

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- 转存表中的数据 `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(4, 3, 1),
(5, 2, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
