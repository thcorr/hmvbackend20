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
```javascript
{
  "drugId": 6,
  "drugName": "Neosaldina"
}
```
#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Drug not found" ou "Error " + exception message

#### Falha - HTTP Status Code: 
NOT FOUND - 404 ou BAD_REQUEST 

### DELETE /{id} - Deleta uma droga
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + nome droga

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Drug not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND

___
## Exam-Entry Controller /api/v1/examentry
###Descricao: Endpoint para incluir, alterar, excluir, e consultar entradas (registros) de exames feitos pelos pacientes.

### GET (/) - Retorna todos os registros de exame cadastrados
#### Sucesso - exemplo body: 

```javascript
{
  "content": [
    {
      "examEntryId": 12,
      "examResult": "12-8",
      "examDateTime": "2022-02-22T10:47:53.17",
      "patient": {
        "userId": 2,
        "name": "thomasATUALIZADO",
        "email": "teste@gmail.com",
        "cpf": "388123",
        "password": "123"
      },
      "examType": {
        "examTypeId": 9,
        "examName": "Pressao Arterial"
      }
    },
    {
      "examEntryId": 13,
      "examResult": "85%",
      "examDateTime": "2022-02-22T10:47:53.17",
      "patient": {
        "userId": 10,
        "name": "Fulano",
        "email": "teste@gmail.com",
        "cpf": "123456789",
        "password": "corinthians123"
      },
      "examType": {
        "examTypeId": 8,
        "examName": "Insulina"
      }
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
  "totalElements": 2,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 2,
  "first": true,
  "empty": false
}
```
#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No exam entries found"

#### Falha - HTTP Status Code:
NOT_FOUND - 404

### GET by id (/id/{id}) - Retorna registro de exame por ID
#### Sucesso - exemplo body:
```javascript
 {
  "examEntryId": 12,
  "examResult": "12-8",
  "examDateTime": "2022-02-22T10:47:53.17",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "examType": {
    "examTypeId": 9,
    "examName": "Pressao Arterial"
  }
}
```

#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No exam entry found." 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404

### POST (/) - Cria registro de exame
#### Sucesso - exemplo body:
```javascript
{
  "examEntryId": 12,
  "examResult": "12-8",
  "examDateTime": "2022-02-22T10:47:53.17",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "examType": {
    "examTypeId": 9,
    "examName": "Pressao Arterial"
  }
}
```

#### Sucesso - HTTP Status Code: 
CREATED - 201

#### Falha - exemplo body: 
String - "Error " + exception message OU "User not found" (precisa estar associado a um usuario existente) OU "Exam type not found" (Precisa estar associado a um tipo de exame)

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400 OU NOT_FOUND - 404

### PUT (/{id} - Atualiza um registro de exame
#### Sucesso - exemplo body:
```javascript
{
  "examEntryId": 12,
  "examResult": "string",
  "examDateTime": "2022-02-22T10:47:53.178",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "examType": {
    "examTypeId": 8,
    "examName": "Insulina"
  }
}
```
#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Error " + exception message OU "User not found" (precisa estar associado a um usuario existente) OU "Exam type not found" (Precisa estar associado a um tipo de exame)

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400 OU NOT_FOUND - 404

### DELETE /{id} - Deleta um registro de exame
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + ID exam entry

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Exam entry not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND


___
## Exam-Type Controller /api/v1/examtype
###Descricao: Endpoint para incluir, alterar, excluir, e consultar tipos de exames. Dado utilizado no endpoint de examentry.
### GET (/) - Retorna todos os tipos de exame
#### Sucesso - exemplo body: 

```javascript
{
  "content": [
    {
      "examTypeId": 8,
      "examName": "Oximetria"
    },
    {
      "examTypeId": 9,
      "examName": "Pressao Arterial"
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
String - "No exam types found"

#### Falha - HTTP Status Code:
NOT_FOUND - 404

### GET by id (/id/{id}) - Retorna tipo de exame por ID
#### Sucesso - exemplo body:
```javascript
 {
  "examTypeId": 8,
  "examName": "Oximetria"
}
```

#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - Exam type not found"

#### Falha - HTTP Status Code: 
NOT_FOUND - 404

### POST (/) - Cria tipo de exame
#### Sucesso - exemplo body:
```javascript
{
  "examTypeId": 8,
  "examName": "Oximetria"
}
```

#### Sucesso - HTTP Status Code: 
CREATED - 201

#### Falha - exemplo body: 
String - "Error " + exception message

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400

### PUT (/{id} - Atualiza um tipo de exame
#### Sucesso - exemplo body:
```javascript
{
  "examTypeId": 8,
  "examName": "Insulina"
}
```
#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "No exam types found" ou "Error " + exception message

#### Falha - HTTP Status Code: 
NOT FOUND - 404 ou BAD_REQUEST 

### DELETE /{id} - Deleta um tipo de exame
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + nome exame

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Exam type not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND

___
## Prescription Controller /api/v1/prescription
###Descricao: Endpoint para incluir, alterar, excluir, e consultar receitas medicas para pacientes. 
### GET (/) - Retorna todos as receitas
#### Sucesso - exemplo body (CORRIGIDO - March 8th, 2022): 

```javascript
{
  "content": [
    {
      "prescriptionId": 1,
      "prescription": "50 gotas a cada 12h - 5 dias",
      "prescriptionDate": "2022-03-09",
      "patient": {
        "userId": 1,
        "name": "Thomas",
        "email": "emailqualquer1@gmail.com",
        "cpf": "1234578910",
        "password": "admin"
      },
      "drug": {
        "drugId": 1,
        "drugName": "Novalgina"
      }
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
  "totalElements": 1,
  "last": true,
  "size": 10,
  "number": 0,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 1,
  "first": true,
  "empty": false
}
```
#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No prescriptions found"

#### Falha - HTTP Status Code:
NOT_FOUND - 404

### GET by id (/id/{id}) - Retorna receita por ID
#### Sucesso - exemplo body:
```javascript
 {
  "prescriptionId": 14,
  "prescription": "doseX",
  "prescriptionDate": "2022-02-22",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "drug": {
    "drugId": 1,
    "drugName": "Novalgina"
  }
}
```

#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No prescriptions found"

#### Falha - HTTP Status Code: 
NOT_FOUND - 404

### POST (/) - Cria receita
#### Sucesso - exemplo body:
```javascript
{
  "prescriptionId": 14,
  "prescription": "doseX",
  "prescriptionDate": "2022-02-22",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "drug": {
    "drugId": 1,
    "drugName": "Novalgina"
  }
}
```

#### Sucesso - HTTP Status Code: 
CREATED - 201

#### Falha - exemplo body: 
String - "Error " + exception message OU "User not found" (Precisa estar associado a um usuario) OU "Drug not found" (Precisa estar associada a uma medicacao)

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400 OU NOT_FOUND - 404

### PUT (/{id} - Atualiza uma receita
#### Sucesso - exemplo body:
```javascript
{
  "prescriptionId": 14,
  "prescription": "Dose ALTERADA",
  "prescriptionDate": "2022-02-22",
  "patient": {
    "userId": 2,
    "name": "thomasATUALIZADO",
    "email": "teste@gmail.com",
    "cpf": "388123",
    "password": "123"
  },
  "drug": {
    "drugId": 1,
    "drugName": "Novalgina"
  }
}

```
#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body (CORRIGIDO - March 8th, 2022): 
String - "Drug not found" ou "User not found" OU "Prescription not found" OU "Error " + exception message

#### Falha - HTTP Status Code: 
NOT FOUND - 404 ou BAD_REQUEST 400

### DELETE /{id} - Deleta uma receita
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + id receita

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "Prescription not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND


___
## User-Details Controller /api/v1/userdetails
###Descricao: Endpoint para incluir, alterar, excluir, e consultar dados de pacientes.
### GET (/) - Retorna todos os pacientes cadastrados
#### Sucesso - exemplo body: 

```javascript
{
  "content": [
    {
      "userId": 2,
      "name": "thomas",
      "email": "teste@gmail.com",
      "cpf": "388123",
      "password": "123"
    },
    {
      "userId": 10,
      "name": "Fulano",
      "email": "teste@gmail.com",
      "cpf": "123456789",
      "password": "corinthians123"
    },
    {
      "userId": 11,
      "name": "Ciclano",
      "email": "opa@gmail.com",
      "cpf": "987654321",
      "password": "senhasuperforte"
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
String - "No user details found"

#### Falha - HTTP Status Code:
NOT_FOUND - 404

### GET by id (/id/{id}) - Retorna pacientes por ID
#### Sucesso - exemplo body:
```javascript
 {
  "userId": 2,
  "name": "thomas",
  "email": "teste@gmail.com",
  "cpf": "388123",
  "password": "123"
}
```

#### Sucesso - HTTP Status Code: 
FOUND - 302

#### Falha - exemplo body: 
String - "No user details found"

#### Falha - HTTP Status Code: 
NOT_FOUND - 404

### POST (/) - Cria paciente
#### Sucesso - exemplo body:
```javascript
{
  "userId": 10,
  "name": "Fulano",
  "email": "teste@gmail.com",
  "cpf": "123456789",
  "password": "corinthians123"
}
```

#### Sucesso - HTTP Status Code: 
CREATED - 201

#### Falha - exemplo body: 
String - "Error " + exception message

#### Falha - HTTP Status Code:  
BAD_REQUEST - 400

### PUT (/{id} - Atualiza um paciente
#### Sucesso - exemplo body:
```javascript
{
  "userId": 2,
  "name": "thomasATUALIZADO",
  "email": "teste@gmail.com",
  "cpf": "388123",
  "password": "123"
}
```
#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "User not found" ou "Error " + exception message

#### Falha - HTTP Status Code: 
NOT FOUND - 404 ou BAD_REQUEST 

### DELETE /{id} - Deleta um paciente
#### Sucesso - exemplo body: 
String - "Deleted successfully: " + id usuario

#### Sucesso - HTTP Status Code: 
OK - 200

#### Falha - exemplo body: 
String - "User not found" ou "Error " + exception message 

#### Falha - HTTP Status Code: 
NOT_FOUND - 404 - NOT_FOUND

