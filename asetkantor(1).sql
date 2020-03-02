-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 02, 2020 at 08:14 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `asetkantor`
--

-- --------------------------------------------------------

--
-- Table structure for table `asets`
--

CREATE TABLE `asets` (
  `ID_Barang` int(12) NOT NULL,
  `Nama_Barang` varchar(255) NOT NULL,
  `Jumlah` int(12) NOT NULL,
  `Ruangan` varchar(255) NOT NULL,
  `Tgl_Masuk` date NOT NULL,
  `Tgl_Keluar` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `asets`
--

INSERT INTO `asets` (`ID_Barang`, `Nama_Barang`, `Jumlah`, `Ruangan`, `Tgl_Masuk`, `Tgl_Keluar`) VALUES
(1, 'MejaKayu', 6, 'F2021', '2020-02-20', '2020-02-21'),
(7, 'Laptop GL503VD', 50, 'FTI2021', '2020-02-20', '2020-02-21'),
(9, 'Mouse', 80, 'A302', '2020-02-23', '2020-02-24'),
(10, 'MejaBesi', 100, 'FTI2020', '2020-02-20', '2020-03-01'),
(14, 'Laptop ROG', 5, 'F111', '2020-02-02', '2020-02-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `asets`
--
ALTER TABLE `asets`
  ADD PRIMARY KEY (`ID_Barang`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
