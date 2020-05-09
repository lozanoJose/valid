# valid
proceso laboral en valid.


Descripción del proceso

EndPoints 


-------     http://localhost:9090/client/saves-clients

Request: 

[
    {
        "id": 3,
        "name": "jose",
        "lastName": "lozano",
        "processed": true
    }
]

Response : 
 [

    {
        "id": 1,
         "name": "jose",
        "lastName": "lozano",
        "processed": true
    }
 ]


- endpoint para consultar por id metodo -> GET

-------      http://localhost:9090/client/find-id-client/1 

Response : 

{

    "id": 1,
    "nombre": "Jesus",
    "apellido": "Lozano",
    "procesado": false
}



-------      http://localhost:9090/client//find-all-client

Response : 

[
    {
        "id": 1,
        "name": "Dora",
        "lastName": "Tamayo",
        "processed": true
    }
]


- endpoint para insertar en la base de datos h2,  metodo -> POST

-------      http://localhost:9090/client/save-client

request :
{
    "name": "Carlos",
    "lastName": "Tamayo",
    "processed": true
}

response -> retorna el objeto insertado

{
    "id": 1,
    "nombre": "carlos",
    "apellido": "tamayo",
    "procesado": true
}

