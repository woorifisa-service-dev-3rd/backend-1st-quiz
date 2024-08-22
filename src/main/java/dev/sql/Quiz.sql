CREATE DATABASE Quiz;
use Quiz;
create table Member(
	id INT primary key AUTO_INCREMENT,
    `name` varchar(50) not null,
    `password` varchar(100) not null,
    ban varchar(50) not null
);

create table Test(
	id INT primary key AUTO_INCREMENT,
    subject varchar(50) not null,
    type varchar(50) not null,
    question varchar(150) not null,
    answer varchar(50) not null,
    option_1 varchar(50),
    option_2 varchar(50),
    option_3 varchar(50),
    option_4 varchar(50),
    time INT
);

create table Result(
	id INT primary key AUTO_INCREMENT,
    `name` varchar(50) not null,
    `score` INT not null,
    result varchar(50) not null
);

create table Score(
	id INT primary key AUTO_INCREMENT,
    name varchar(50) not null,
    subject varchar(50) not null,
    score INT not null,
    CONSTRAINT member_id FOREIGN KEY (id) REFERENCES Member(id)
);

INSERT INTO Member (name, password, ban) VALUES ("신원섭", "03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("구자빈", "38083c7ee9121e17401883566a148aa5c2e2d55dc53bc4a94a026517dbff3c6b", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("곽지은", "ceaa28bba4caba687dc31b1bbe79eca3c70c33f871f1ce8f528cf9ab5cfd76dd", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("박준현", "db2e7f1bd5ab9968ae76199b7cc74795ca7404d5a08d78567715ce532f9d2669", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("김영성", "f8638b979b2f4f793ddb6dbd197e0ee25a7a6ea32b0ae22f5e3c5d119d839e75", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("이명렬", "499bc7df9d8873c1c38e6898177c343b2a34d2eb43178a9eb4efcb993366c8cd", "서비스");
INSERT INTO Member (name, password, ban) VALUES ("홍찬의", "6a95bbab63d587b596398c4bd7e91a132f24032d2007d107e5ea71967724b092", "서비스");

INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (1, "JAVA", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "	절차적 프로그래밍", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (2, "JAVA", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "	selected", 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (3, "JAVA", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (4, "JAVA", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (5, "JAVA", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (6, "JAVA", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (7, "JAVA", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (8, "JAVA", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (9, "JAVA", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);

INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (10, "JAVASCRIPT", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "절차적 프로그래밍", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (11, "JAVASCRIPT", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "selected", 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (12, "JAVASCRIPT", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (13, "JAVASCRIPT", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (14, "JAVASCRIPT", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (15, "JAVASCRIPT", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (16, "JAVASCRIPT", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (17, "JAVASCRIPT", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (18, "JAVASCRIPT", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);

INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (19, "REACT", "4지선다", "자바의 특징이 아닌것은?", "4", "자료 추상화", "상속", "동적 바인딩", "절차적 프로그래밍", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (20, "REACT", "4지선다", "접근제어자가 아닌것은?", "4", "privated", "public", "protected", "selected", 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (21, "REACT", "4지선다", "객체 지향적 설계원칙이 아닌것은?", "4", "SRP", "OCP", "LSP", "LOP", 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (22, "REACT", "OX문제", "자동적으로 메모리 관리가 이루어진다.", "O", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (23, "REACT", "OX문제", "자바는 객체지향 언어이다.", "O", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (24, "REACT", "OX문제", "멀티 스레드를 지원하지 않는다.", "X", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (25, "REACT", "단답형", "OOP의 4대 특징은 캡슐화, ( ), 상속, 추상화 이다.", "다형성", null, null, null, null, 10);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (26, "REACT", "단답형", "현재클래스에서 다른패키지의 클래스를 사용하려면 소스파일에 ( ) 코드를 추가해야한다.", "import", null, null, null, null, 20);
INSERT INTO Test (ID, SUBJECT, TYPE, QUESTION, ANSWER, OPTION_1, OPTION_2, OPTION_3, OPTION_4, TIME) VALUES (27, "REACT", "단답형", "( ) 정수형의 기본형, 할당 메모리 : 4byte", "int", null, null, null, null, 10);