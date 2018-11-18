-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 2017-12-03 08:32:57
-- 服务器版本： 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- 表的结构 `course`
--


CREATE TABLE `course` (
  `CourseID` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Time` time NOT NULL,
  `type` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`CourseID`, `Name`, `Time`, `type`) VALUES
(41, '数学', '08:30:00', '考试'),
(42, '马克思', '11:40:00', '考试'),
(43, '数电', '11:30:00', '考试');

-- --------------------------------------------------------

--
-- 表的结构 `students`
--


CREATE TABLE `students` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `classname` varchar(10) NOT NULL,
  `studentno` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `students`
--

INSERT INTO `students` (`id`, `name`, `classname`, `studentno`) VALUES
(23, '郑文龙', '2班', '201635010245'),
(24, '萧浩邦', '2班', '201635010231'),
(25, '钟志荣', '2班', '201635010248'),
(26, '林宏森', '2班', '201635010218'),
(27, '颜纯胜', '2班', '201635010235'),
(28, '赵志洋', '2班', '201635010243');

-- --------------------------------------------------------

--
-- 表的结构 `subject`
--


CREATE TABLE `subject` (
  `SubjectID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `CourseName` varchar(20) NOT NULL,
  `Subjectfinal` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `subject`
--

INSERT INTO `subject` (`SubjectID`, `StudentID`, `CourseName`, `Subjectfinal`) VALUES
(16, 23, '英语', '80'),
(17, 23, 'Java', '90'),
(18, 23, '马克思', '60'),
(19, 23, '数电', '75'),
(20, 27, '数学', '60'),
(21, 27, '英语', '99'),
(22, 27, '体育', '99'),
(23, 27, 'Java', '99'),
(24, 27, '马克思', '99'),
(25, 27, '数电', '60'),
(26, 24, '数学', '60'),
(28, 24, '体育', '70'),
(29, 24, 'Java', '80'),
(30, 24, '马克思', '77'),
(31, 24, '数电', '63'),
(32, 25, '数学', '59'),
(33, 25, '英语', '59'),
(34, 25, '体育', '59'),
(36, 25, 'Java', '59'),
(37, 25, '马克思', '59'),
(38, 25, '数电', '59'),
(39, 26, '数学', '59'),
(40, 26, '英语', '59'),
(42, 26, '体育', '59'),
(43, 26, 'Java', '59'),
(45, 26, '马克思', '59'),
(46, 26, '数电', '59'),
(48, 28, '英语', '60'),
(49, 28, '体育', '60'),
(50, 28, 'Java', '60'),
(53, 28, '马克思', '60'),
(54, 28, '数电', '60'),
(55, 23, '数学', '68');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`CourseID`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `subject`
--
ALTER TABLE `subject`
  ADD PRIMARY KEY (`SubjectID`),
  ADD UNIQUE KEY `StudentID` (`StudentID`,`CourseName`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `course`
--
ALTER TABLE `course`
  MODIFY `CourseID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- 使用表AUTO_INCREMENT `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- 使用表AUTO_INCREMENT `subject`
--
ALTER TABLE `subject`
  MODIFY `SubjectID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- 限制导出的表
--

--
-- 限制表 `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `subject2student` FOREIGN KEY (`StudentID`) REFERENCES `students` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
