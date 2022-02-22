# hmvbackend20
___
## Drug-Controller /api/v1/drug

###Descricao: Endpoint para incluir, alterar, excluir, e consultar medicacoes que serao usadas no endpoint de prescription (receitas)

### GET (/)
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

### GET by id (/id/{id})
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

### POST (/)
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

### PUT (/{id}
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

### DELETE /{id}
#### Sucesso - exemplo body:

#### Sucesso - HTTP Status Code:

#### Falha - exemplo body:

#### Falha - HTTP Status Code: 

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
