LOAD DATA INFILE 'districts.csv' INTO TABLE District FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n' IGNORE 1 ROWS;

LOAD DATA INFILE 'municipalities.csv' INTO TABLE Municipality FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n' IGNORE 1 ROWS;