INSERT INTO MAILING_SERVER(SERVER_ID, SERVER_NAME, SERVER_PROVIDER) VALUES(1, 'SRVCLDBEN001', 'AMAZON');
INSERT INTO MAILING_SERVER(SERVER_ID, SERVER_NAME, SERVER_PROVIDER) VALUES(2, 'SRVCLDBEN002', 'Digital Ocean');

INSERT INTO MAILING_MTA(MTA_ID, MTA_NAME, MTA_IP, MTA_SERVER_ID) VALUES(1, 'V_MTA1', '192.168.0.1', 1);
INSERT INTO MAILING_MTA(MTA_ID, MTA_NAME, MTA_IP, MTA_SERVER_ID) VALUES(2, 'V_MTA2', '192.168.0.2', 1);
INSERT INTO MAILING_MTA(MTA_ID, MTA_NAME, MTA_IP, MTA_SERVER_ID) VALUES(3, 'V_MTA_X', '192.168.0.3', 2);