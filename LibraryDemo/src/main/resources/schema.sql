
DROP TABLE IF EXISTS `library`;
CREATE TABLE `library` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `libraryName` varchar(50) ,
   PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `bookid` int(20) NOT NULL AUTO_INCREMENT,
  `id` int(20) , 
  `title`  varchar(50) ,
  `author` varchar(50) , 
   PRIMARY KEY (`bookid`)
);
