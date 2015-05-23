# MUMScrum
MUM Scrum project

<a title="GitHub MUMScrum" href="https://github.com/masudjbd/MUMScrum" >
<img src="https://travis-ci.org/masudjbd/MUMScrum.svg?branch=master" alt="Build Pass" />
</a>

@Configuration: 
1. Need to install mysql and create a new database called mumscrum.
2. Another changes you have to make as follows:
Location:
/WEB-INF/spring/webcontext/DispatcherServlet-context.xml
from:
<!-- < prop key="hibernate.hbm2ddl.auto" >create</prop>-->
to
<prop key="hibernate.hbm2ddl.auto">create</prop>



 
user credentials as follows:- 

//HR System Admin
user: Admin
pass: 123456


//Product Owner
user: powner
pass: 123456

//Scrum Master
user: smaster
pass: 123456

//Developer
user: developer
pass: 123456

//Tester
user: tester
pass: 123456