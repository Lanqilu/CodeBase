create table if not exists mybatiss.user
(
    id   int          not null
    primary key,
    name varchar(255) not null,
    pwd  varchar(255) not null
    );



INSERT INTO mybatis.user (id, name, pwd) VALUES (1, 'halo', 'halo');
INSERT INTO mybatis.user (id, name, pwd) VALUES (2, 'hi', 'hi');
INSERT INTO mybatis.user (id, name, pwd) VALUES (3, 'admin', 'admin');