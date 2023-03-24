CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';
SET PASSWORD FOR 'user'@'localhost' = PASSWORD('user');
GRANT Create user ON *.* TO 'user'@'%';
GRANT Event ON *.* TO 'user'@'%';
GRANT File ON *.* TO 'user'@'%';
GRANT Process ON *.* TO 'user'@'%';
GRANT Reload ON *.* TO 'user'@'%';
GRANT Replication client ON *.* TO 'user'@'%';
GRANT Replication slave ON *.* TO 'user'@'%';
GRANT Show databases ON *.* TO 'user'@'%';
GRANT Shutdown ON *.* TO 'user'@'%';
GRANT Super ON *.* TO 'user'@'%';
GRANT Create tablespace ON *.* TO 'user'@'%';
GRANT Usage ON *.* TO 'user'@'%';
GRANT Grant option ON *.* TO 'user'@'%';

