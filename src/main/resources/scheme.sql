CREATE TABLE IF NOT EXISTS MAILING_SERVER(
	SERVER_ID NUMBER PRIMARY KEY NOT NULL,
	SERVER_NAME VARCHAR(32),
	SERVER_PROVIDER VARCHAR(32)
);

CREATE TABLE IF NOT EXISTS MAILING_MTA(
	MTA_ID NUMBER PRIMARY KEY NOT NULL,
	MTA_NAME VARCHAR(32),
	MTA_DNS VARCHAR(64),
	MTA_IP VARCHAR(40),
	MTA_PORT VARCHAR(8),
	MTA_USERNAME VARCHAR(64),
	MTA_PASSWORD VARCHAR(64),
	MTA_SERVER_ID VARCHAR(32),
	FOREIGN KEY (MTA_SERVER_ID) REFERENCES MAILING_SERVER(SERVER_ID)
);
