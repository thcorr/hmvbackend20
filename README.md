# hmvbackend20 - Abaixo o RETORNO do Body e do HTTP Status Code pos chamada do endpoint
___
## Drug-Controller /api/v1/drug

### Descricao: Endpoint para incluir, alterar, excluir, e consultar medicacoes que serao usadas no endpoint de prescription (receitas)

### GET (/) - Retorna todas as drogas
#### Sucesso - exemplo body: 

```javascript
{
  "content": [
    {
      "drugId": 6,
      "drugName": "Novalgina"
    },
    {
      "drugId": 7,
      "drugName": "Tilenol"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "pageNumber": 0,
    "pageSize": 10,
    "paged": true,
    "unpaged": false
  },
  "totalPages": 1,
  "totalElements": 3,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 3,
  "first": true,
  "empty": false
}
```
#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No Drugs found"

#### Falha - HTTP Status Code:
NOT_FOUND - 404

### GET by id (/id/{id}) - Retorna droga por ID
#### Sucesso - exemplo body:
```javascript
{
  "drugId": 6,
  "drugName": "Novalgina"
}
```

#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No Drugs found"

#### Falha - HTTP Status Code: 
NOT_FOUND - 404

### POST (/) - Cria uma nova droga
#### Sucesso - exemplo body:
```javascript
{
  "drugId": 6,
  "drugName": "Novalgina"
}
```

#### Sucesso - HTTP Status Code: 
CREATED - 201

#### Falha - exemplo body: 
String - "Error " + exception message

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400

### PUT (/{id} - Atualiza uma droga
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Drug not found" ou "Error " + exception message

#### Falha - HTTP Status Code: 
NOT FOUND - 404 ou BAD_REQUEST 

### DELETE /{id} - Deleta uma droga
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + drug name

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Drug not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND

___
## Exam-Entry Controller /api/v1/examentry
###Descricao: Endpoint para incluir, alterar, excluir, e consultar entradas (registros) de exames feitos pelos pacientes.

### GET
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

### GET by id

### POST

### PUT

### DELETE

___
## Exam-Type Controller /api/v1/examtype
###Descricao: Endpoint para incluir, alterar, excluir, e consultar tipos de exames. Dado utilizado no endpoint de examentry.
### GET

### GET by id

### POST

### PUT

### DELETE

___
## Prescription Controller /api/v1/prescription
###Descricao: Endpoint para incluir, alterar, excluir, e consultar receitas medicas para pacientes. 
### GET

### GET by id

### POST

### PUT

### DELETE

___
## User-Details Controller /api/v1/userdetails
###Descricao: Endpoint para incluir, alterar, excluir, e consultar dados de pacientes.
### GET

### GET by id

### POST

### PUT

### DELETE
