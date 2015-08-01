CREATE DATABASE ncc;

USE ncc;

CREATE TABLE isp
(
  id BIGINT,
  companyName varchar(255),
  website varchar(255),
  ipv4Prefix varchar(255),
  totalAddresses BIGINT
);