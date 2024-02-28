USE `socialmedia-db`;

create table if not exists users (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

    userid VARCHAR (36) NOT NULL UNIQUE,

    username VARCHAR (50),
    first_name VARCHAR (50),
    last_name VARCHAR (50),

    email VARCHAR (50),
    password VARCHAR (50),

    bio VARCHAR (500),
    joined_date DATE,

    postal_code VARCHAR (9),
    street VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50)
);

create table if not exists admins (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

    adminid VARCHAR(36) NOT NULL UNIQUE,

    first_name VARCHAR(50),
    last_name VARCHAR(50),

    email VARCHAR(50),

    salary DECIMAL(19,2),

    postal_code VARCHAR (9),
    street VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),

    position_title VARCHAR (50),
    position_code VARCHAR (2)
);

create table if not exists admin_phonenumbers (
    id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
);

create table if not exists posts (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,

    postid VARCHAR (36) NOT NULL UNIQUE,
    userid VARCHAR (36),

    content VARCHAR (500),
    created_date DATE,

    media_type VARCHAR (50),
    media_attachment VARCHAR (500),

    FOREIGN KEY (userid) REFERENCES users(userid)
)