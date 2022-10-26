drop database certicom_db;

create database certicom_db;

use certicom_db;
insert into cliente values (1,"MANRIQUE MAYANGA", "48459266", "CESAR.MANRIQUE1994@GMAIL.COM", "CESAR ABRAHAM", "983501261");
insert into cliente values (2,"LOPEZ PEREZ", "48459267", "LOPEZ.PEREZ@GMAIL.COM", "JOSE LUIS", "983501262");
insert into cliente values (3,"PALOMINO PALOMINO", "48459268", "JULI.PALOMINO@GMAIL.COM", "JULISSA ", "983501263");

insert into venta values (1,now(),1);
insert into venta values (2,'2022-10-25',1);
insert into venta values (3,'2021-11-19',2);
insert into venta values (4,now(),2);
insert into venta values (5,'2022-03-05',3);
insert into venta values (6,'2020-07-21',3);

insert into producto value (1,"mouse",15);
insert into producto value (2,"teclado",35.50);
insert into producto value (3,"monitor",155.50);
insert into producto value (4,"parlantes",60.50);

insert into detalle_venta values (1,30,1,1);
insert into detalle_venta values (2,10,1,1);
insert into detalle_venta values (3,23,2,1);
insert into detalle_venta values (4,17,3,2);
insert into detalle_venta values (5,15,4,3);
insert into detalle_venta values (6,15,4,4);
