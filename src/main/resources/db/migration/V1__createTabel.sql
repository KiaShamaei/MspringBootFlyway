CREATE TABLE user (
  id int PRIMARY KEY AUTO_INCREMENT,
  name    varchar(50)   NOT NULL,
  tech    varchar(500)  NOT NULL
);

CREATE TABLE post (
    id int PRIMARY KEY AUTO_INCREMENT,
    title        varchar(5000)      DEFAULT NULL,
    content          varchar(2000)      DEFAULT NULL,
    user_id int,
      FOREIGN KEY (user_id) REFERENCES user(id)
);
