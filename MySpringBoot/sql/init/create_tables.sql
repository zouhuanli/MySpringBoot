CREATE TABLE `actor`
(
    `actor_id`    smallint unsigned NOT NULL AUTO_INCREMENT,
    `first_name`  varchar(45)       NOT NULL,
    `last_name`   varchar(45)       NOT NULL,
    `last_update` timestamp         NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`actor_id`),
    KEY `idx_actor_last_name` (`last_name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 201
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `user`
(
    `uid`      int NOT NULL AUTO_INCREMENT,
    `uname`    varchar(255) DEFAULT NULL,
    `password` varchar(255) DEFAULT NULL,
    `gender`   varchar(255) DEFAULT NULL,
    `phone`    varchar(255) DEFAULT NULL,
    `email`    varchar(255) DEFAULT NULL,
    `address`  varchar(255) DEFAULT NULL,
    PRIMARY KEY (`uid`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2102567375
  DEFAULT CHARSET = utf8mb3;