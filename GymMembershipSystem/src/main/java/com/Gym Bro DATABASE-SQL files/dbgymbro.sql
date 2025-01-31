-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 30, 2025 at 08:14 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbgymbro`
--

-- --------------------------------------------------------

--
-- Table structure for table `tblpackages`
--

CREATE TABLE `tblpackages` (
  `package_id` int(11) NOT NULL,
  `package_name` varchar(200) NOT NULL,
  `package_access` varchar(100) NOT NULL,
  `package_fee` int(20) NOT NULL,
  `package_training_duration` varchar(100) NOT NULL,
  `package_freebies` varchar(100) NOT NULL,
  `package_instructor` enum('YES','NO') NOT NULL DEFAULT 'NO'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblpackages`
--

INSERT INTO `tblpackages` (`package_id`, `package_name`, `package_access`, `package_fee`, `package_training_duration`, `package_freebies`, `package_instructor`) VALUES
(1, 'Trial', 'Full-day access to all gym facilities, group classes, and amenities.', 0, '3', '1 sample-sized branded protein shake or pre-workout supplement. ', 'NO'),
(2, 'Bronze Membership', 'Full access for 7 consecutive days, including group classes and amenities.', 500, '7', '3 sample-sized branded supplements (choice of protein powder, pre-workout, or vitamins). ', 'NO'),
(3, 'Silver Membership', 'Full access for 30 days, includes group classes, amenities, and one personal training session', 2100, '30', '1 full-sized branded protein powder (2 lbs). \n1 bottle of multivitamins (30-day supply).', 'NO'),
(4, 'Gold Membership', 'Full access for 60 days, includes group classes, amenities, and two personal training session', 4200, '60', '1 full-sized branded protein powder (2 lbs). \n1 pre-workout supplement. \n1 bottle of mult', 'YES'),
(5, 'Diamond Membership', 'Full access for 180 days, includes group classes, amenities, and five personal training session', 12600, '180', '2 full-sized branded protein powders (2 lbs each). \n1 pre-workout supplement. \n1 BCAA (br', 'YES'),
(6, 'Platinum Membership', 'Full access for one year, includes group classes, amenities, and ten personal training session', 25500, '360', '3 full-sized branded protein powders (2 lbs each). \n2 pre-workout supplements. \n1 BCAA po', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `tblpayments`
--

CREATE TABLE `tblpayments` (
  `payment_id` int(11) NOT NULL,
  `payment_amount` int(11) NOT NULL,
  `payment_payment_date` date NOT NULL,
  `payment_mode` varchar(200) NOT NULL,
  `payment_package_id` int(11) NOT NULL,
  `payment_user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tblusers`
--

CREATE TABLE `tblusers` (
  `user_id` int(11) NOT NULL,
  `user_username` varchar(50) NOT NULL,
  `user_password` varchar(50) NOT NULL,
  `user_role` varchar(50) NOT NULL,
  `user_lastname` varchar(50) NOT NULL,
  `user_firstname` varchar(50) NOT NULL,
  `user_middlename` varchar(50) DEFAULT NULL,
  `user_gender` enum('Male','Female') NOT NULL,
  `user_address` varchar(50) NOT NULL,
  `user_contact` varchar(50) NOT NULL,
  `user_registration_date` date NOT NULL DEFAULT current_timestamp(),
  `user_expiration_date` date NOT NULL DEFAULT current_timestamp(),
  `user_status` enum('Single','Married','Separated','Widow') NOT NULL,
  `user_package_id` int(11) NOT NULL,
  `user_archived` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tblusers`
--

INSERT INTO `tblusers` (`user_id`, `user_username`, `user_password`, `user_role`, `user_lastname`, `user_firstname`, `user_middlename`, `user_gender`, `user_address`, `user_contact`, `user_registration_date`, `user_expiration_date`, `user_status`, `user_package_id`, `user_archived`) VALUES
(1, 'joel', 'briza', 'admin', 'Briza', 'Joel', 'Santos', 'Male', 'Malabon City', '09398700114', '2025-01-20', '2026-01-20', 'Single', 1, 0),
(2, 'ivan', 'pogi', 'member', 'Ternida', 'Ivan', 'N', 'Male', 'Bicol', '09999999999', '2025-01-28', '2026-01-28', 'Single', 1, 0),
(3, 'percy', 'percy', 'admin', 'Dalaida', 'Percy', 'Val', 'Male', 'Manila', '09066666666', '2025-01-29', '2026-01-29', 'Married', 1, 0),
(4, 'elijah', 'elijaha', 'member', 'Cabading', 'Eljah Vincent', 'V', 'Male', 'Antipolo City', '09055555555', '2025-01-29', '2026-01-29', 'Married', 2, 0),
(5, 'mjocariza', 'mjocariza', 'member', 'Ocariza', 'Mary Jane', 'Ewan', 'Female', 'Caloocan City', '09055555555', '2025-01-29', '2026-01-29', 'Married', 1, 0),
(6, 'eahizon', 'eahizon', 'member', 'Hizon', 'Elijiah Andre', 'A', 'Male', 'Quezon City', '09077777777', '2025-01-29', '2026-01-29', 'Single', 2, 0),
(7, 'alaranang', 'alaranang', 'member', 'Laranang', 'Aileen', 'W', 'Female', 'Mandaluyong City', '09099999999', '2025-01-29', '2026-01-29', 'Married', 3, 0),
(8, 'jronquillo', 'jronquillo', 'member', 'Ronquillo', 'Jareth', 'V', 'Male', 'Mindoro ', '09383883838', '2025-01-29', '2026-01-29', 'Single', 4, 0),
(10, 'joelpogi', '1ab74a375acc6aec35c2ffcc201bfd6f', 'member', 'Briza', 'Joel', 'Santos', 'Male', 'Niugan, Malabon City', '09398700114', '2025-01-30', '2026-01-30', 'Single', 1, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tblpackages`
--
ALTER TABLE `tblpackages`
  ADD PRIMARY KEY (`package_id`);

--
-- Indexes for table `tblpayments`
--
ALTER TABLE `tblpayments`
  ADD KEY `payment_package_id` (`payment_package_id`),
  ADD KEY `payment_user_id` (`payment_user_id`);

--
-- Indexes for table `tblusers`
--
ALTER TABLE `tblusers`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `user_package_id` (`user_package_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tblusers`
--
ALTER TABLE `tblusers`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tblpayments`
--
ALTER TABLE `tblpayments`
  ADD CONSTRAINT `tblpayments_ibfk_1` FOREIGN KEY (`payment_package_id`) REFERENCES `tblpackages` (`package_id`),
  ADD CONSTRAINT `tblpayments_ibfk_2` FOREIGN KEY (`payment_user_id`) REFERENCES `tblusers` (`user_id`);

--
-- Constraints for table `tblusers`
--
ALTER TABLE `tblusers`
  ADD CONSTRAINT `tblusers_ibfk_1` FOREIGN KEY (`user_package_id`) REFERENCES `tblpackages` (`package_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
