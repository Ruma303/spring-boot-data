-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
-- ---------------------------------------------------------


-- CREATE DATABASE "university" ----------------------------
CREATE DATABASE IF NOT EXISTS `university` CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
USE `university`;
-- ---------------------------------------------------------


-- CREATE TABLE "courses" --------------------------------------
CREATE TABLE `courses`( 
	`id_course` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`course_name` VarChar( 100 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `id_course` ),
	CONSTRAINT `course_name` UNIQUE( `course_name` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 10;
-- -------------------------------------------------------------


-- CREATE TABLE "exams" ----------------------------------------
CREATE TABLE `exams`( 
	`id_exam` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`id_student` Int( 0 ) NOT NULL,
	`id_subject` Int( 0 ) NOT NULL,
	`exam_date` Date NOT NULL,
	`grade` Decimal( 3, 1 ) NULL DEFAULT NULL,
	PRIMARY KEY ( `id_exam` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 41;
-- -------------------------------------------------------------


-- CREATE TABLE "student_details" ------------------------------
CREATE TABLE `student_details`( 
	`id_student` Int( 0 ) NOT NULL,
	`address` VarChar( 200 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`phone` VarChar( 20 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	PRIMARY KEY ( `id_student` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB;
-- -------------------------------------------------------------


-- CREATE TABLE "students" -------------------------------------
CREATE TABLE `students`( 
	`id_student` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`first_name` VarChar( 500 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`last_name` VarChar( 500 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`email` VarChar( 200 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`password` VarChar( 200 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`age` Int( 0 ) NULL DEFAULT NULL,
	`id_course` Int( 0 ) NULL DEFAULT NULL,
	`birthdate` Date NULL DEFAULT NULL,
	PRIMARY KEY ( `id_student` ),
	CONSTRAINT `email` UNIQUE( `email` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 22;
-- -------------------------------------------------------------


-- CREATE TABLE "subjects" -------------------------------------
CREATE TABLE `subjects`( 
	`id_subject` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`subject_name` VarChar( 100 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`id_teacher` Int( 0 ) NOT NULL,
	PRIMARY KEY ( `id_subject` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 11;
-- -------------------------------------------------------------


-- CREATE TABLE "teachers" -------------------------------------
CREATE TABLE `teachers`( 
	`id_teacher` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`first_name` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`last_name` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	PRIMARY KEY ( `id_teacher` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 6;
-- -------------------------------------------------------------


-- Dump data of "courses" ----------------------------------
BEGIN;

INSERT INTO `courses`(`id_course`,`course_name`) VALUES 
( '5', 'Architettura' ),
( '2', 'Economia' ),
( '3', 'Giurisprudenza' ),
( '10', 'Ingegneria Elettronica' ),
( '1', 'Ingegneria Informatica' ),
( '7', 'Lettere' ),
( '4', 'Medicina' ),
( '8', 'Psicologia' ),
( '6', 'Scienze Politiche' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "exams" ------------------------------------
BEGIN;

INSERT INTO `exams`(`id_exam`,`id_student`,`id_subject`,`exam_date`,`grade`) VALUES 
( '1', '1', '1', '2023-06-15', '28.0' ),
( '2', '1', '6', '2023-07-10', '30.0' ),
( '3', '2', '1', '2023-06-16', '27.5' ),
( '4', '2', '4', '2023-07-11', '26.0' ),
( '5', '3', '2', '2023-06-17', '25.0' ),
( '6', '3', '7', '2023-07-12', '24.5' ),
( '7', '4', '3', '2023-06-18', '22.0' ),
( '8', '4', '5', '2023-07-13', '23.0' ),
( '9', '5', '4', '2023-06-19', '29.0' ),
( '10', '5', '10', '2023-07-14', '30.0' ),
( '11', '6', '6', '2023-06-20', '27.0' ),
( '12', '6', '8', '2023-07-15', '26.5' ),
( '13', '7', '1', '2023-06-21', '28.5' ),
( '14', '7', '9', '2023-07-16', '25.0' ),
( '15', '8', '2', '2023-06-22', '24.0' ),
( '16', '8', '3', '2023-07-17', '23.5' ),
( '17', '9', '4', '2023-06-23', '26.0' ),
( '18', '9', '5', '2023-07-18', '27.0' ),
( '19', '10', '6', '2023-06-24', '29.5' ),
( '20', '10', '7', '2023-07-19', '28.0' ),
( '21', '11', '8', '2023-06-25', '27.0' ),
( '22', '11', '9', '2023-07-20', '26.0' ),
( '23', '12', '10', '2023-06-26', '28.5' ),
( '24', '12', '1', '2023-07-21', '30.0' ),
( '25', '13', '2', '2023-06-27', '25.0' ),
( '26', '13', '3', '2023-07-22', '24.5' ),
( '27', '14', '4', '2023-06-28', '22.0' ),
( '28', '14', '5', '2023-07-23', '23.0' ),
( '29', '15', '6', '2023-06-29', '29.0' ),
( '30', '15', '7', '2023-07-24', '30.0' ),
( '31', '16', '8', '2023-06-30', '27.0' ),
( '32', '16', '9', '2023-07-25', '26.5' ),
( '33', '17', '10', '2023-07-01', '28.0' ),
( '34', '17', '1', '2023-07-26', '27.5' ),
( '35', '18', '2', '2023-07-02', '26.0' ),
( '36', '18', '3', '2023-07-27', '25.5' ),
( '37', '19', '4', '2023-07-03', '24.0' ),
( '38', '19', '5', '2023-07-28', '23.5' ),
( '39', '20', '6', '2023-07-04', '29.0' ),
( '40', '20', '7', '2023-07-29', '28.5' ),
( '41', '1', '2', '2024-01-22', '28.5' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "student_details" --------------------------
BEGIN;

INSERT INTO `student_details`(`id_student`,`address`,`phone`) VALUES 
( '1', 'Via Roma 1, Milano', '02-1234567' ),
( '2', 'Via Verdi 5, Torino', '011-7654321' ),
( '3', 'Piazza Dante 3, Firenze', '055-2345678' ),
( '4', 'Corso Italia 10, Napoli', '081-3456789' ),
( '5', 'Via Milano 7, Bologna', '051-4567890' ),
( '6', 'Viale Europa 2, Genova', '010-5678901' ),
( '7', 'Via Garibaldi 8, Palermo', '091-6789012' ),
( '8', 'Piazza Garibaldi 12, Bari', '080-7890123' ),
( '9', 'Via Libertà 3, Verona', '045-8901234' ),
( '10', 'Corso Vittorio Emanuele 4, Padova', '049-9012345' ),
( '11', 'Via Dante 6, Trieste', '040-0123456' ),
( '12', 'Viale Roma 15, Reggio Emilia', '0522-123456' ),
( '13', 'Via XX Settembre 11, Catania', '095-234567' ),
( '14', 'Piazza Mazzini 9, Livorno', '0586-345678' ),
( '15', 'Via Garibaldi 20, Brescia', '030-456789' ),
( '16', 'Corso Umberto 7, Perugia', '075-567890' ),
( '17', 'Via Libertà 4, Salerno', '081-678901' ),
( '18', 'Piazza Dante 2, Pescara', '085-789012' ),
( '19', 'Via Roma 3, Monza', '039-890123' ),
( '20', 'Viale Italia 5, Taranto', '099-901234' ),
( '21', 'Via Roma 42, Milano', '+390212345678' ),
( '22', 'Via Roma 43, Milano', '+390212345678' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "students" ---------------------------------
BEGIN;
INSERT INTO `students`(`id_student`,`first_name`,`last_name`,`email`,`password`,`age`,`id_course`,`birthdate`) VALUES
( '1', 'Alessandro', 'Rossi', 'alessandro.rossi@example.com', 'password123', '21', '1', '2002-01-15' ),
( '2', 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', 'password123', '22', '1', '2001-02-20' ),
( '3', 'Marco', 'Verdi', 'marco.verdi@example.com', 'password123', '20', '2', '2003-03-10' ),
( '4', 'Lorenzo', 'Neri', 'lorenzo.neri@example.com', 'password123', '23', '3', '2000-04-25' ),
( '5', 'Francesca', 'Russo', 'francesca.russo@example.com', 'password123', '19', '4', '2004-05-30' ),
( '6', 'Chiara', 'Ferrari', 'chiara.ferrari@example.com', 'password123', '21', '5', '2002-06-15' ),
( '7', 'Simone', 'Gallo', 'simone.gallo@example.com', 'password123', '22', '6', '2001-07-05' ),
( '8', 'Elena', 'Romano', 'elena.romano@example.com', 'password123', '20', '7', '2003-08-10' ),
( '9', 'Andrea', 'Costa', 'andrea.costa@example.com', 'password123', '24', '8', '1999-09-20' ),
( '10', 'Martina', 'De Luca', 'martina.deluca@example.com', 'password123', '22', '1', '2001-10-15' ),
( '11', 'Davide', 'Greco', 'davide.greco@example.com', 'password123', '21', '2', '2002-11-25' ),
( '12', 'Sara', 'Conti', 'sara.conti@example.com', 'password123', '23', '3', '2000-12-05' ),
( '13', 'Federico', 'Marini', 'federico.marini@example.com', 'password123', '20', '4', '2003-01-10' ),
( '14', 'Laura', 'Giordano', 'laura.giordano@example.com', 'password123', '22', '5', '2001-02-15' ),
( '15', 'Gabriele', 'Barbieri', 'gabriele.barbieri@example.com', 'password123', '21', '6', '2002-03-20' ),
( '16', 'Valentina', 'Rinaldi', 'valentina.rinaldi@example.com', 'password123', '20', '7', '2003-04-25' ),
( '17', 'Matteo', 'Esposito', 'matteo.esposito@example.com', 'password123', '23', '8', '2000-05-30' ),
( '18', 'Ilaria', 'Romani', 'ilaria.romani@example.com', 'password123', '21', '1', '2002-06-15' ),
( '19', 'Riccardo', 'Leone', 'riccardo.leone@example.com', 'password123', '22', '2', '2001-07-05' ),
( '20', 'Sofia', 'Moretti', 'sofia.moretti@example.com', 'password123', '20', '3', '2003-08-10' ),
( '21', 'Mario', 'Rossi', 'mario.rossi@example.com', 'password123', '22', '1', '2001-04-10' ),
( '22', 'Piero', 'Verdi', 'piero.verdi@example.com', 'password123', '22', '1', '2001-04-10' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "subjects" ---------------------------------
BEGIN;

INSERT INTO `subjects`(`id_subject`,`subject_name`,`id_teacher`) VALUES 
( '1', 'Matematica', '1' ),
( '2', 'Fisica', '2' ),
( '3', 'Chimica', '3' ),
( '4', 'Letteratura', '4' ),
( '5', 'Storia', '5' ),
( '6', 'Informatica', '1' ),
( '7', 'Economia', '2' ),
( '8', 'Biologia', '3' ),
( '9', 'Filosofia', '4' ),
( '10', 'Arte', '5' ),
( '11', 'Analisi Matematica I', '1' );
COMMIT;
-- ---------------------------------------------------------


-- Dump data of "teachers" ---------------------------------
BEGIN;

INSERT INTO `teachers`(`id_teacher`,`first_name`,`last_name`) VALUES 
( '1', 'Luca', 'Bianchi' ),
( '2', 'Marco', 'Verdi' ),
( '3', 'Anna', 'Rossi' ),
( '4', 'Sara', 'Neri' ),
( '5', 'Giulia', 'Gialli' ),
( '6', 'Giovanni', 'Verdi' );
COMMIT;
-- ---------------------------------------------------------


-- CREATE INDEX "fk_exam_student" ------------------------------
CREATE INDEX `fk_exam_student` USING BTREE ON `exams`( `id_student` );
-- -------------------------------------------------------------


-- CREATE INDEX "fk_exam_subject" ------------------------------
CREATE INDEX `fk_exam_subject` USING BTREE ON `exams`( `id_subject` );
-- -------------------------------------------------------------


-- CREATE INDEX "fk_student_course" ----------------------------
CREATE INDEX `fk_student_course` USING BTREE ON `students`( `id_course` );
-- -------------------------------------------------------------


-- CREATE INDEX "fk_subject_teacher" ---------------------------
CREATE INDEX `fk_subject_teacher` USING BTREE ON `subjects`( `id_teacher` );
-- -------------------------------------------------------------


-- CREATE LINK "fk_exam_student" -------------------------------
ALTER TABLE `exams`
	ADD CONSTRAINT `fk_exam_student` FOREIGN KEY ( `id_student` )
	REFERENCES `students`( `id_student` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------


-- CREATE LINK "fk_exam_subject" -------------------------------
ALTER TABLE `exams`
	ADD CONSTRAINT `fk_exam_subject` FOREIGN KEY ( `id_subject` )
	REFERENCES `subjects`( `id_subject` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------


-- CREATE LINK "fk_student_course" -----------------------------
ALTER TABLE `students`
	ADD CONSTRAINT `fk_student_course` FOREIGN KEY ( `id_course` )
	REFERENCES `courses`( `id_course` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------


-- CREATE LINK "fk_student_details" ----------------------------
ALTER TABLE `student_details`
	ADD CONSTRAINT `fk_student_details` FOREIGN KEY ( `id_student` )
	REFERENCES `students`( `id_student` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------


-- CREATE LINK "fk_subject_teacher" ----------------------------
ALTER TABLE `subjects`
	ADD CONSTRAINT `fk_subject_teacher` FOREIGN KEY ( `id_teacher` )
	REFERENCES `teachers`( `id_teacher` )
	ON DELETE Cascade
	ON UPDATE Cascade;
-- -------------------------------------------------------------


/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
-- ---------------------------------------------------------


