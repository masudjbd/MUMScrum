/* employee dataset */
insert  into `employee`(`id`,`address`,`birthDate`,`dateOfJoin`,`department`,`designation`,`email`,`empcode`,`enabled`,`firstname`,`gender`,`lastname`,`mobile`,`password`,`salary`,`ssnNo`,`username`,`upperPos_id`) values (1,'1000 N. 4th Street','2016-07-05','2016-03-05','Sample','Sample','masudjbd@gmail.com','52557','','product ','M','owner','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'6665151','powner',NULL),(2,'1000 N. 4th Street','2016-06-05','2016-06-05','Sample','Sample','masudjbd@gmail.com','001','','scrum','M','master','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'545454','smaster',NULL),(3,'1000 N. 4th Street','2016-07-05','2016-03-05','Sample','Sample','masudjbd@gmail.com','52557','','developer','M','dev','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'6665151','developer',NULL),(4,'1000 N. 4th Street','2016-07-05','2016-03-05','Sample','Sample','masudjbd@gmail.com','52557','','tester','M','test','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'6665151','tester',NULL),(5,'1000 N. 4th Street','2016-07-05','2016-03-05','Sample','Sample','masudjbd@gmail.com','52557','','admin','M','adm','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'6665151','admin',NULL),(6,'1000 N. 4th Street','2016-07-05','2016-03-05','Sample','Sample','masudjbd@gmail.com','52557','','Masudur','M','Rahman','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',0,'6665151','masud',NULL),(7,'1000 N. 4th Street','2016-06-05','2016-06-05','Sample','Sample','masudjbd@gmail.com','52557','','Masudur','M','Rahman','17027632261','$2a$10$CtSxnoFhXPsMFeJOX8/CF.Owid/z3d43GpJQchNQ6pu/HfG3BIdZu',4444,'6665151','rhyhan88',NULL),(10,'1000 N. 4th Street','2015-11-05','2016-08-05','Sample','Sample','habib@gmail.com','51515','','Habib','M','Rahman','5514','$2a$10$khtbSR00iox09qLtLArYuugJyoO3Pthjv4c50DH6esh7UaqbZxIMq',180000,'6665151','habib',NULL);

 /* employee role dataset */
insert  into `role`(`roleId`,`roleName`,`roleLabel`) values (1,'ROLE_ADMIN','Admin'),(2,'ROLE_PRODUCT_OWNER','Product Owner'),(3,'ROLE_SCRUM_MASTER','Scrum Master'),(4,'ROLE_DEVELOPER','Developer'),(5,'ROLE_TESTER','Tester');

/* employee and role relation dataset */
insert  into `employee_role`(`Employee_id`,`roles_roleId`) values (1,2),(2,3),(3,4),(4,5),(5,1),(6,1),(7,2),(7,3),(10,4);
 
/* employee vacation dataset */
insert  into `employeevacation`(`leaveId`,`availabeleave`,`enddate`,`startdate`,`employee_id`,`leavetype_Id`) values (2,34,'2016-09-05','2016-08-05',1,2);

/* employee insurance type dataset */
insert  into `insurancetype`(`typeId`,`companyName`,`typeName`) values (1,'Alico','Health Insurance'),(2,'SateFarm','Dental Insurance');

/* employee leave type dataset */
insert  into `leavetype`(`Id`,`defaultvalue`,`typename`) values (1,10,'Sick Leave'),(2,15,'Casual Leave'),(3,5,'Earned Leave');
