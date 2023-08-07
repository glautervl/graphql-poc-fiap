
# Requisitos

* Maven 3.6+
* Java 17+

# Iniciar aplicação
```
mvn spring-boot:run
```
## GraphQL Console
[GraphQL Explorer](http://localhost:8080/graphiql?path=/graphql)

```
query BuscarTodos{
  findAll{
    id 
    name 
    role
  }
}

mutation SalvarNovo{
  create(name: "Luan", role: ADMIN) {
    id
    name
    role
  }
}

query BuscarUsuarioPorId{
  findOne(id: 2){
    id
    name
    role
  }
}

mutation AtualizaUsuario {
  update(id: 2, name: "Paulo", role: MANAGER){
    id
    name
    role
  }
}

mutation DeletarUsuario {
  delete(id: 2){id name}
}
```