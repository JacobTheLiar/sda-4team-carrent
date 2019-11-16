INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Opel', 'Corsa','B','hatchback','2001','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'VW', 'Golf','C','hatchback','2011','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Opel', 'Astra','C','hatchback','2015','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Renault', 'Megane','C','hatchback','2017','40000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Renault', 'Clio','B','hatchback','2019','40000');

INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '5', '2019-09-27', 'PO00001','VIN1','black','100','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '4', '2017-10-27', 'PO00002','VIN2','black','100','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '3', '2015-07-27', 'PO00003','VIN3','black','100','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '2', '2011-05-27', 'PO00004','VIN4','black','100','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '1', '2001-01-27', 'PO00005','WIN5','black','100','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, active) VALUES (nextval('car_seq'), '1', '2001-01-27', 'PO00006','WIN5','black','100','false');


INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Skipper', '64th Street and Fifth Avenue', '10021', 'New York', '0000000000', 'cpzinfo@wcs.org', '(212) 439-6500');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Kowalsky', '64th Street and Fifth Avenue', '10021', 'New York', '0000000001', 'cpzinfo@wcs.org', '(718) 220-5100');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Rico', '64th Street and Fifth Avenue', '10021', 'New York', '0000000002', 'membership@wcs.org', '(212) 439-6500');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Private', '64th Street and Fifth Avenue', '10021', 'New York', '0000000003', 'cpzinfo@wcs.org', '(718) 220-5111');

INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2018/1', 12.34, '2018-08-01', '2019-01-01', '2018-01-01');
INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2018/2', 23.45, '2018-09-21', '2018-12-31', '2018-09-20');
INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2019/1', 34.56, '2019-01-01', '2019-02-01', '2019-01-01');
INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2019/2', 45.67, '2019-02-01', '2019-03-01', '2019-02-01');
INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2019/3', 56.78, '2019-04-01', '2019-05-01', '2019-04-01');


INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end, counter_state_start, counter_state_end, notes_start, notes_end, invoice_id)
values                   (1 , 1     , 1        , null        , null               , null             , null             , null           , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', 1);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end, counter_state_start, counter_state_end, notes_start, notes_end, invoice_id)
values                   (2 , 2     , 1        , null        , null               , null             , null             , null           , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', 2);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end, counter_state_start, counter_state_end, notes_start, notes_end, invoice_id)
values                   (3 , 3     , 2        , null        , null               , null             , null             , null           , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', 3);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end, counter_state_start, counter_state_end, notes_start, notes_end, invoice_id)
values                   (4 , 4     , 3        , null        , null               , null             , null             , null           , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', 4);

commit;