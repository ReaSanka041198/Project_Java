-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2020 lúc 07:24 PM
-- Phiên bản máy phục vụ: 10.4.13-MariaDB
-- Phiên bản PHP: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_qlsv`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `usernames` char(16) NOT NULL,
  `passwords` char(32) NOT NULL,
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`usernames`, `passwords`, `name`) VALUES
('admintratos', 'An041198', 'Nguyen Hoang An');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `classes`
--

CREATE TABLE `classes` (
  `class_name` char(10) NOT NULL,
  `description` varchar(50) NOT NULL,
  `amount` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `classes`
--

INSERT INTO `classes` (`class_name`, `description`, `amount`) VALUES
('16DAKH2', 'Khóa 16 thầy X chủ nhiệm', 48),
('16DTHC1', 'Khóa 16 thầy toàn chủ nhiệm', 50),
('16DTHC2', 'Khóa 16 do thầy Bùi mạnh toàn chủ nhiệm', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `facultys`
--

CREATE TABLE `facultys` (
  `faculty_id` char(5) NOT NULL,
  `faculty_name` char(30) NOT NULL,
  `phone` char(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mark`
--

CREATE TABLE `mark` (
  `subject_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `mark1` float NOT NULL,
  `mark2` float NOT NULL,
  `mark3` float NOT NULL,
  `medium_mark` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `mark`
--

INSERT INTO `mark` (`subject_id`, `student_id`, `mark1`, `mark2`, `mark3`, `medium_mark`) VALUES
(6, 1611061291, 7, 6, 7, 7),
(1, 1611061092, 7, 3, 4, 7),
(4, 1611061092, 7, 7, 8, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `semesters`
--

CREATE TABLE `semesters` (
  `class_id` char(4) NOT NULL,
  `subject_id` char(10) NOT NULL,
  `semester` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `students`
--

CREATE TABLE `students` (
  `student_id` int(11) NOT NULL,
  `first_name` varchar(7) NOT NULL,
  `last_name` varchar(7) NOT NULL,
  `birthday` date NOT NULL,
  `gender` char(3) NOT NULL,
  `address` varchar(70) NOT NULL,
  `class_name` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `students`
--

INSERT INTO `students` (`student_id`, `first_name`, `last_name`, `birthday`, `gender`, `address`, `class_name`) VALUES
(1611061092, 'Kieu', 'Cuong', '1998-04-02', 'Nam', 'Kế cạnh nhà Bùi Thế anh có những cái nhà kho nhỏ nhỏ', '16DTHC1'),
(1611061123, 'Tèo', 'Anh', '1998-02-04', 'Nam', 'Khu phố 1, xóm nhà lá cạnh mấy con sông có hàng dừa màu tím', '16DAKH2'),
(1611061291, 'Nguyễn', 'An', '2020-06-24', 'Nam', '32/17 Võ Văn Hát, Long Trường, Quận 9', '16DTHC1'),
(1611061562, 'Lê', 'Lợi', '2020-06-24', 'Nam', 'ấp long hòa xã long thới huyện chợ lách bến tre', '16DTHC1'),
(1611061566, 'Phùng', 'Kiều', '2020-06-24', 'Nam', 'ấp long hòa xã long thới huyện chợ lách bến tre', '16DTHC1'),
(1611061568, 'Văn', 'Minh', '2020-06-08', 'Nam', 'số nhà 123/45 quận 9 thành phố HCM', '16DTHC1'),
(1611061870, 'Lương', 'Anh', '2020-06-08', 'Nữ', 'số nhà 123/45 quận 9 thành phố HCM', '16DTHC1'),
(1611061942, 'Văn', 'Tèo', '2020-06-08', 'Nam', 'số nhà 123/45 quận 9 thành phố HCM', '16DAKH2'),
(1611062472, 'Hoài', 'Nam', '2020-06-10', 'Nam', '32/17, Võ Văn Hát chung nhà với thằng admin', '16DAKH2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `subjects`
--

CREATE TABLE `subjects` (
  `subject_id` int(11) NOT NULL,
  `subject_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `subjects`
--

INSERT INTO `subjects` (`subject_id`, `subject_name`) VALUES
(1, 'Nhập môn CNTT'),
(2, 'Công nghệ phần mềm'),
(3, 'Lý thuyết đồ thị'),
(4, 'Toán cao cấp 1'),
(5, 'Toán cao cấp 2'),
(6, 'Những nguyên lý của chủ nghĩa Mác Lê-nin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`usernames`);

--
-- Chỉ mục cho bảng `classes`
--
ALTER TABLE `classes`
  ADD PRIMARY KEY (`class_name`);

--
-- Chỉ mục cho bảng `facultys`
--
ALTER TABLE `facultys`
  ADD PRIMARY KEY (`faculty_id`);

--
-- Chỉ mục cho bảng `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`student_id`),
  ADD KEY `class_name` (`class_name`);

--
-- Chỉ mục cho bảng `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`subject_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `subjects`
--
ALTER TABLE `subjects`
  MODIFY `subject_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
