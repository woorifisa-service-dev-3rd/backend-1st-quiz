CREATE TABLE IF NOT EXISTS `quiz`.`member` (
  `id` INT NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `class` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `quiz`.`score` (
  `id` INT NOT NULL,
  `member_id` INT NOT NULL,
  `subject` VARCHAR(50) NOT NULL,
  `score` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `member_id`
    FOREIGN KEY (`id`)
    REFERENCES `quiz`.`member` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `quiz`.`test` (
  `id` INT NOT NULL,
  `subject` VARCHAR(50) NOT NULL,
  `type` VARCHAR(50) NOT NULL,
  `question` VARCHAR(150) NOT NULL,
  `answer` VARCHAR(50) NOT NULL,
  `option_1` VARCHAR(50) NULL DEFAULT NULL,
  `option_2` VARCHAR(50) NULL DEFAULT NULL,
  `option_3` VARCHAR(50) NULL DEFAULT NULL,
  `option_4` VARCHAR(50) NULL DEFAULT NULL,
  `time` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (1, "자바", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "	절차적 프로그래밍", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (2, "자바", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "	selected", 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (3, "자바", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (4, "자바", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (5, "자바", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (6, "자바", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (7, "자바", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (8, "자바", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (9, "자바", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);

INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (10, "자바스크립트", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "절차적 프로그래밍", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (11, "자바스크립트", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "selected", 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (12, "자바스크립트", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (13, "자바스크립트", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (14, "자바스크립트", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (15, "자바스크립트", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (16, "자바스크립트", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (17, "자바스크립트", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (18, "JAVASCRIPT", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);

INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (19, "REACT", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "절차적 프로그래밍", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (20, "REACT", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "selected", 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (21, "REACT", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (22, "REACT", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (23, "REACT", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (24, "REACT", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (25, "REACT", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (26, "REACT", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO TEST (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (27, "REACT", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);
commit;