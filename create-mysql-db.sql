DROP DATABASE IF EXISTS `task_list`;
CREATE DATABASE `task_list` DEFAULT CHARSET utf8 COLLATE utf8_bin; -- 大文字小文字を区別する
GRANT ALL PRIVILEGES ON `task_list`.* TO task_list@localhost IDENTIFIED BY 'password';