INSERT INTO company (id, name, address, post_code, city, telephone_nr, email, tax_number, account_number)
VALUES (true, 'Car-Rent 4 Team', 'ul. Zabawna 75', '92-606', 'Łódź', '+48 78 245 97 17', 'biuro@carrent.4team.pl', 'PL4678678705', 'PL11114000007658776066869505');

INSERT INTO rent_point (id, name, address, post_code, city) values (nextval('car_rent_point_seq'), '4team Rent Point Poznań', 'Samochodowa 1','60-682', 'Poznań');
INSERT INTO rent_point (id, name, address, post_code, city) values (nextval('car_rent_point_seq'), '4team Rent Point Warszawa', 'Poznańska 1','02-823', 'Warszawa');

INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Opel', 'Corsa','B','hatchback','2001','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'VW', 'Golf','C','hatchback','2011','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Opel', 'Astra','C','hatchback','2015','30000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Renault', 'Megane','C','hatchback','2017','40000');
INSERT INTO car_Model (id, mark, model, segment, type, production_Year, review_Interval) VALUES (nextval('car_model_seq'), 'Renault', 'Clio','B','hatchback','2019','40000');

INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '5', '2019-09-27', 'PO00001','VIN1','black','100','1','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '4', '2017-10-27', 'PO00002','VIN2','black','100','2','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '3', '2015-07-27', 'PO00003','VIN3','black','100','2','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '2', '2011-05-27', 'PO00004','VIN4','black','100','1','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '1', '2001-01-27', 'PO00005','VIN5','black','100','2','true');
INSERT INTO car (id, car_model_id, registration_Date, plate_Nr, vin, color, price_Per_Day, begin_rent_point_id, active) VALUES (nextval('car_seq'), '1', '2001-01-27', 'PO00006','VIN6','black','100','2','false');


INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Skipper', '64th Street and Fifth Avenue', '10021', 'New York', '0000000000', 'cpzinfo@wcs.org', '(212) 439-6500');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Kowalsky', '64th Street and Fifth Avenue', '10021', 'New York', '0000000001', 'cpzinfo@wcs.org', '(718) 220-5100');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Rico', '64th Street and Fifth Avenue', '10021', 'New York', '0000000002', 'membership@wcs.org', '(212) 439-6500');
INSERT INTO client (id, name, address, post_code, city, tax_number, email, telephone_nr) values (nextval('seq_Client'), 'Private', '64th Street and Fifth Avenue', '10021', 'New York', '0000000003', 'cpzinfo@wcs.org', '(718) 220-5111');

INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2018/1', 12.34, '2018-08-01', '2019-01-01', '2018-01-01');
INSERT INTO invoice (id, number, value, invoice_date, payment_date, sell_date) values (nextval('seq_Invoice'), '2018/2', 23.45, '2018-09-21', '2018-12-31', '2018-09-20');

INSERT INTO role (id, authority) values (nextval('seq_Role'), 'ADMIN');
INSERT INTO role (id, authority) values (nextval('seq_Role'), 'USER');

INSERT INTO employee (firstname, surname, rent_point_id, username, password, employment_date, release_date, role_id) values ('Jan', 'Pracownik', 1, 'user', '$2a$10$KvxPudrieuxpEgxw3e4yPOuYK59PgfQshx3RaVUTCpbKB82DC/0RC', '2018-09-01',null,2 );
INSERT INTO employee (firstname, surname, rent_point_id, username, password, employment_date, release_date, role_id) values ('The', 'Administrator', 2, 'admin', '$2a$10$IPJizmA0rxJBq9incE/PWub6B2nIDGm3z/2cIz6hAs/hgvKlQ5F9q', '2018-09-01',null,1 );

INSERT INTO promotion (id, name, discount_percentage, promo_start, promo_end) values (nextval('promo_Seq'), 'Opel 30%', 30, '2019-10-01', '2019-12-05');
INSERT INTO promotion (id, name, discount_percentage, promo_start, promo_end) values (nextval('promo_Seq'), 'Segment B 20%', 20, '2019-10-15', '2019-12-15');
INSERT INTO promotion (id, name, discount_percentage, promo_start, promo_end) values (nextval('promo_Seq'), 'Segment C 10%', 10, '2019-10-12', '2019-12-20');


INSERT INTO promotion_cars(promotion_id, cars_id) values (1, 3);
INSERT INTO promotion_cars(promotion_id, cars_id) values (1, 5);
INSERT INTO promotion_cars(promotion_id, cars_id) values (2, 1);
INSERT INTO promotion_cars(promotion_id, cars_id) values (2, 5);
INSERT INTO promotion_cars(promotion_id, cars_id) values (2, 6);
INSERT INTO promotion_cars(promotion_id, cars_id) values (3, 2);
INSERT INTO promotion_cars(promotion_id, cars_id) values (3, 3);
INSERT INTO promotion_cars(promotion_id, cars_id) values (3, 4);

INSERT INTO rent (id, car_id, client_id, promotion_id, rent_point_start_id, rent_time_start, employee_start_username,  counter_state_start, notes)
values (nextval('car_rent_seq'), 3, 1, 1, 1, '2019-08-01','user', 10020, 'wgniecenie drzwi kierowcy oraz zbita lampa');

INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end  , counter_state_start, counter_state_end, notes_start , notes_end      , invoice_id)
values                   (1 , 1     , 1        , 1           , 1                  , 1                , 'user'                 , 'user'                 , '2018-08-01'   , '2018-08-01' , 100                , 1000             , 'drive test','drive test end', 1);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end  , counter_state_start, counter_state_end, notes_start , notes_end      , invoice_id)
values                   (2 , 2     , 1        , null        , 2                  , 1                , 'admin'                , 'user'                 , '2018-08-01'   , '2018-08-01' , 10000              , 10010            , 'drive test','drive test end', 1);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end  , counter_state_start, counter_state_end, notes_start , notes_end      , invoice_id)
values                   (3 , 3     , 2        , null        , 2                  , 2                , 'admin'                , 'admin'                , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', 2);
INSERT INTO rent_history (id, car_id, client_id, promotion_id, rent_point_start_id, rent_point_end_id, employee_start_username, employee_end_username, rent_time_start, rent_time_end  , counter_state_start, counter_state_end, notes_start , notes_end      , invoice_id)
values                   (4 , 4     , 3        , null        , 1                  , 2                , 'user'                 , 'admin'                , '2018-08-01'   , '2018-08-01' , 0                  , 100              , 'drive test','drive test end', null);


-- invoice list view @JacobTheLiar
drop table view_invoices if exists;
create view view_invoices as
    select
        i.id,
        cli.id as client_id,
        cli.name as client_name,
        i.number,
        i.invoice_date,
        count(*) as rent_count,
        sum((datediff(day, rent_time_start, rent_time_end)+1) * c.price_per_day) as rent_value,
        count(distinct p.id) as discounts,
        sum((datediff(day, rent_time_start, rent_time_end)+1) * c.price_per_day * (100-ifNull(p.discount_percentage, 0))/100) as value,
        i.value as to_pay
    from invoice i
        join rent_history rh
            on rh.invoice_id = i.id
        join car c
            on c.id=rh.car_id
        left join promotion p
            on p.id=rh.promotion_id
        join client cli
            on cli.id = rh.client_id
    group by
        i.id, cli.id, cli.name, i.number, i.invoice_date;


drop table view_avail_invoices if exists;
create view view_avail_invoices as
    select
        rh.id,
        c.id as client_id,
        c.name as client_name,
        rh.rent_time_start,
        (datediff(day, rent_time_start, rent_time_end)+1) as rent_days,
        rh.rent_time_end,
        rh.counter_state_end-rh.counter_state_start as distance,
        ifnull(p.name, '') as promotion_name,
        cm.mark||' '||cm.model||' ('||cr.plate_nr||')' as car,
        (datediff(day, rent_time_start, rent_time_end)+1) * cr.price_per_day as rent_value,
        (datediff(day, rent_time_start, rent_time_end)+1) * cr.price_per_day * (100-ifNull(p.discount_percentage, 0))/100 as value
    from rent_history rh
        left join invoice i
            on rh.invoice_id = i.id
        join client c
            on c.id=rh.client_id
        left join promotion p
            on p.id = rh.promotion_id
        join car cr
            on cr.id = rh.car_id
        join car_model cm
            on cm.id=cr.car_model_id
    where rh.invoice_id is null;


drop table view_invoice_detail if exists;
create view view_invoice_detail as
    select distinct
        i.id,
        i.number as invoice_number,
        rp.city as invoice_city,
        i.invoice_date as invoice_date,
        c.name as client_name,
        c.address as client_address,
        c.post_code as client_post_code,
        c.city as client_city,
        c.tax_number as client_tax_number,

        cp.name as seller_name,
        cp.address as seller_address,
        cp.post_code as seller_post_code,
        cp.city as seller_city,
        cp.tax_number as seller_tax_number,
        i.payment_date as payment_date,
        'przelew' as payment_method,
        cp.account_number as payment_account,
        i.value as payment_value
        from invoice i
            left join rent_history rh
                on rh.invoice_id=i.id
            left join rent_point rp
                on rp.id=rh.rent_point_end_id
            left join client c
                on c.id = rh.client_id
            left join company cp
                on cp.id=1
;

drop table view_invoice_detail_items if exists;
create view view_invoice_detail_items as
    select
        rh.id as id,
        rh.invoice_id as invoice_id,
        cm.mark||' '||cm.model||' ['||c.plate_nr||'] od dnia '||rh.rent_time_start as car,
        rh.counter_state_end - rh.counter_state_start + 1 as distance,
        (datediff(day, rh.rent_time_start, rh.rent_time_end)+1) as rent_days,
        ifnull(p.name, '') as promotion_name,
        (datediff(day, rh.rent_time_start, rh.rent_time_end)+1) * c.price_per_day * (100-ifNull(p.discount_percentage, 0))/100 as value

    from rent_history rh
        left join car c
            on c.id = rh.car_id
        left join car_model cm
            on cm.id = c.car_model_id
        left join promotion p
            on p.id = rh.promotion_id
;


commit;