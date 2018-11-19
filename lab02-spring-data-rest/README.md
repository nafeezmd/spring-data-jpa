#Lab
Project: https://spring.io/guides/gs/accessing-data-rest/

#FAQ

###Test the application
Now that the application is running, you can test it. You can also use postman to test the following API calls.


```js
$ curl http://localhost:8080
```
```json
{
  "_links" : {
    "customers" : {
      "href" : "http://localhost:8080/customers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile"
    }
  }
}
```

####Get Customers
```js
$ curl http://localhost:8080/customers
```

```json
{
  "_embedded" : {
    "customers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/customers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/customers"
    },
    "search" : {
      "href" : "http://localhost:8080/customers/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 0,
    "totalPages" : 0,
    "number" : 0
  }
}
```

####Create a Customer
```js
$ curl -i -X POST -H "Content-Type:application/json" -d '{"firstName": "Frodo", "lastName": "Baggins"}' http://localhost:8080/customers
```
```json
HTTP/1.1 201 
Location: http://localhost:8080/customers/1
Content-Type: application/hal+json;charset=UTF-8
Transfer-Encoding: chunked
Date: Mon, 19 Nov 2018 01:41:10 GMT

{
  "firstName" : "Frodo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/customers/1"
    },
    "customer" : {
      "href" : "http://localhost:8080/customers/1"
    }
  }
}
```

####Get created Customers
```js
$ curl http://localhost:8080/customers
```
```json
{
  "_embedded" : {
    "customers" : [ {
      "firstName" : "Frodo",
      "lastName" : "Baggins",
      "_links" : {
        "self" : {
          "href" : "http://localhost:8080/customers/1"
        },
        "customer" : {
          "href" : "http://localhost:8080/customers/1"
        }
      }
    } ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/customers{?page,size,sort}",
      "templated" : true
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/customers"
    },
    "search" : {
      "href" : "http://localhost:8080/customers/search"
    }
  },
  "page" : {
    "size" : 20,
    "totalElements" : 1,
    "totalPages" : 1,
    "number" : 0
  }
}
```

####You can query directly for the individual record:
```js
$ curl http://localhost:8080/customers/1

```
```json
{
  "firstName" : "Frodo",
  "lastName" : "Baggins",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/customers/1"
    },
    "customer" : {
      "href" : "http://localhost:8080/customers/1"
    }
  }
}
```

