create table song (id binary(16) not null, name varchar(255), artists varchar(255), genre varchar(255), primary key (id));
insert into song (id,name,artists,genre) values(UUID(),'bohordos song', 'bohordo', 'boho-metal');
create table user (id binary(16) not null, username varchar(255), primary key (id));
insert into user (id,username) values(UUID(),'bohordo');