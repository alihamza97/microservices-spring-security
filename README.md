# microservices-spring-security"  (in progress)

create coupon first endpoint 

{"code":"SUPERSALE",
"discount":10,
"expDate":"12/12/2021"}

2ND endpoint

http://localhost:8080/couponapi/getCoupon/SUPERSALE



{
    "name" :"SAMSUNG",
    "description":"Great IPHONE",
    "price":1000,
    "couponCode":"SUPERSALE"
}



postman testing -> username doug@bailey.com 
password -> doug


## OAUTH

first send the request to localhost:8080/oauth/token
configure the headers as follows

username : john@ferguson.com
pasw : 1111
grant_type: {}
scopes:read write


get the generated token and pass into the headers of get request as follows:
Authorization Bearer {token}


incase of database token is stored in the database and resource server looks it up in the database instead of going back to authorization server
