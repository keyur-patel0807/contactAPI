# Getting Started
Contact API

[Swagger UI] http://localhost:8090/swagger-ui.html

[Post] - http://localhost:8090/contact/


```
{
    "firstName": "niraj",
    "lastName": "Mulani",
    "birthDate": "2017-01-01",
    "address": {
        "city": "ahmedabad",
        "postalcode": 382346
    }
}
```
```
[
    {
        "id": 1,
        "firstName": "Sandeep",
        "lastName": "Mulani",
        "birthDate": "2016-12-31",
        "address": {
            "id": 1,
            "city": "surat",
            "postalcode": "382345"
        }
    },
    {
        "id": 2,
        "firstName": "keyur",
        "lastName": "Mulani",
        "birthDate": "2016-12-31",
        "address": {
            "id": 2,
            "city": "ahmedabad",
            "postalcode": "382345"
        }
    },
    {
        "id": 3,
        "firstName": "niraj",
        "lastName": "Mulani",
        "birthDate": "2016-12-31",
        "address": {
            "id": 3,
            "city": "ahmedabad",
            "postalcode": "382346"
        }
    }
]
```
URL

[Get - FindAll Data]http://localhost:8090/contact/
[Get - FindByID]http://localhost:8090/contact/1
[Get - FindByCity]http://localhost:8090/contact/ahmedabad
[Get - FindByZipCode]http://localhost:8090/contact/382345