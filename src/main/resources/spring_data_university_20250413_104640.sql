-- Valentina Studio --
-- MySQL dump --
-- ---------------------------------------------------------


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
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
AUTO_INCREMENT = 11;
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
AUTO_INCREMENT = 42;
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
AUTO_INCREMENT = 23;
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
AUTO_INCREMENT = 12;
-- -------------------------------------------------------------


-- CREATE TABLE "teachers" -------------------------------------
CREATE TABLE `teachers`( 
	`id_teacher` Int( 0 ) AUTO_INCREMENT NOT NULL,
	`first_name` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`last_name` VarChar( 50 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
	`email` VarChar( 255 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	`password` VarChar( 128 ) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
	PRIMARY KEY ( `id_teacher` ) )
CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
ENGINE = InnoDB
AUTO_INCREMENT = 7;
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
( '1', 'Alessandro', 'Rossi', 'alessandro.rossi@example.com', '0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e', '21', '1', '2004-04-13' ),
( '2', 'Giulia', 'Bianchi', 'giulia.bianchi@example.com', '6cf615d5bcaac778352a8f1f3360d23f02f34ec182e259897fd6ce485d7870d4', '22', '1', '2003-04-13' ),
( '3', 'Marco', 'Verdi', 'marco.verdi@example.com', '5906ac361a137e2d286465cd6588ebb5ac3f5ae955001100bc41577c3d751764', '20', '2', '2005-04-13' ),
( '4', 'Lorenzo', 'Neri', 'lorenzo.neri@example.com', 'b97873a40f73abedd8d685a7cd5e5f85e4a9cfb83eac26886640a0813850122b', '23', '3', '2002-04-13' ),
( '5', 'Francesca', 'Russo', 'francesca.russo@example.com', '8b2c86ea9cf2ea4eb517fd1e06b74f399e7fec0fef92e3b482a6cf2e2b092023', '19', '4', '2006-04-13' ),
( '6', 'Chiara', 'Ferrari', 'chiara.ferrari@example.com', '598a1a400c1dfdf36974e69d7e1bc98593f2e15015eed8e9b7e47a83b31693d5', '21', '5', '2004-04-13' ),
( '7', 'Simone', 'Gallo', 'simone.gallo@example.com', '5860836e8f13fc9837539a597d4086bfc0299e54ad92148d54538b5c3feefb7c', '22', '6', '2003-04-13' ),
( '8', 'Elena', 'Romano', 'elena.romano@example.com', '57f3ebab63f156fd8f776ba645a55d96360a15eeffc8b0e4afe4c05fa88219aa', '20', '7', '2005-04-13' ),
( '9', 'Andrea', 'Costa', 'andrea.costa@example.com', '9323dd6786ebcbf3ac87357cc78ba1abfda6cf5e55cd01097b90d4a286cac90e', '24', '8', '2001-04-13' ),
( '10', 'Martina', 'De Luca', 'martina.de luca@example.com', 'aa4a9ea03fcac15b5fc63c949ac34e7b0fd17906716ac3b8e58c599cdc5a52f0', '22', '1', '2003-04-13' ),
( '11', 'Davide', 'Greco', 'davide.greco@example.com', '53d453b0c08b6b38ae91515dc88d25fbecdd1d6001f022419629df844f8ba433', '21', '2', '2004-04-13' ),
( '12', 'Sara', 'Conti', 'sara.conti@example.com', 'b3d17ebbe4f2b75d27b6309cfaae1487b667301a73951e7d523a039cd2dfe110', '23', '3', '2002-04-13' ),
( '13', 'Federico', 'Marini', 'federico.marini@example.com', '48caafb68583936afd0d78a7bfd7046d2492fad94f3c485915f74bb60128620d', '20', '4', '2005-04-13' ),
( '14', 'Laura', 'Giordano', 'laura.giordano@example.com', 'c6863e1db9b396ed31a36988639513a1c73a065fab83681f4b77adb648fac3d6', '22', '5', '2003-04-13' ),
( '15', 'Gabriele', 'Barbieri', 'gabriele.barbieri@example.com', 'c63c2d34ebe84032ad47b87af194fedd17dacf8222b2ea7f4ebfee3dd6db2dfb', '21', '6', '2004-04-13' ),
( '16', 'Valentina', 'Rinaldi', 'valentina.rinaldi@example.com', '17a3379984b560dc311bb921b7a46b28aa5cb495667382f887a44a7fdbca7a7a', '20', '7', '2005-04-13' ),
( '17', 'Matteo', 'Esposito', 'matteo.esposito@example.com', '69bfb918de05145fba9dcee9688dfb23f6115845885e48fa39945eebb99d8527', '23', '8', '2002-04-13' ),
( '18', 'Ilaria', 'Romani', 'ilaria.romani@example.com', 'd2042d75a67922194c045da2600e1c92ff6d87e8fb6e0208606665f2d1dfa892', '21', '1', '2004-04-13' ),
( '19', 'Riccardo', 'Leone', 'riccardo.leone@example.com', '5790ac3d0b8ae8afc72c2c6fb97654f2b73651c328de0a3b74854ade562dd17a', '22', '2', '2003-04-13' ),
( '20', 'Sofia', 'Moretti', 'sofia.moretti@example.com', '7535d8f2d8c35d958995610f971287288ab5e8c82a3c4fdc2b6fb5d757a5b9f8', '20', '3', '2005-04-13' ),
( '21', 'Mario', 'Rossi', 'mario.rossi@example.com', '91a9ef3563010ea1af916083f9fb03a117d4d0d2a697f82368da1f737629f717', '22', '1', '2003-04-13' ),
( '22', 'Piero', 'Verdi', 'piero.verdi@example.com', 'd23c1038532dc71d0a60a7fb3d330d7606b7520e9e5ee0ddcdb27ee1bd5bc0cd', '22', '1', '2003-04-13' );
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

INSERT INTO `teachers`(`id_teacher`,`first_name`,`last_name`,`email`,`password`) VALUES 
( '1', 'Luca', 'Bianchi', 'luca.bianchi@example.com', '0b14d501a594442a01c6859541bcb3e8164d183d32937b851835442f69d5c94e' ),
( '2', 'Marco', 'Verdi', 'marco.verdi@example.com', '6cf615d5bcaac778352a8f1f3360d23f02f34ec182e259897fd6ce485d7870d4' ),
( '3', 'Anna', 'Rossi', 'anna.rossi@example.com', '5906ac361a137e2d286465cd6588ebb5ac3f5ae955001100bc41577c3d751764' ),
( '4', 'Sara', 'Neri', 'sara.neri@example.com', 'b97873a40f73abedd8d685a7cd5e5f85e4a9cfb83eac26886640a0813850122b' ),
( '5', 'Giulia', 'Gialli', 'giulia.gialli@example.com', '8b2c86ea9cf2ea4eb517fd1e06b74f399e7fec0fef92e3b482a6cf2e2b092023' ),
( '6', 'Giovanni', 'Verdi', 'giovanni.verdi@example.com', '598a1a400c1dfdf36974e69d7e1bc98593f2e15015eed8e9b7e47a83b31693d5' );
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


