CREATE USER 'user'@'%' IDENTIFIED BY 'user';
GRANT all privileges on *.* to 'user'@'%' WITH GRANT OPTION;
FLUSH privileges;
