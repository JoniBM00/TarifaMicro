
## ***Documentation***
### ***Tarifa.java***
Clase que sirve para dar tipo a los objetos del fichero tarifas.csv
### ***Catalogo.java***
Clase que sirve para dar tipo a los objetos que puedes pasar por Json y aplicarle la tarifa
### ***MapaCatalogos.java***
Es una clase que tiene un Map para guardar los catalogos procesados del json
### ***MapaTarifas.java***
Es una clase que tiene un Map para guardar las tarifas leidas del fichero tarifas.csv
### ***CatalogoService.java***
Tiene un método que le aplica la tarifa correspondiente a cada catalogo obtenido por el controller y lo guarda en el mapa de la Clase MapaCatalogos
### ***TarifaService.java***
Tiene un método que lee del fichero tarifas.csv y guarda la informacion en un mapa de la Clase MapaTarifas
### ***MainController***
El unico controller que hay en este proyecto.
Tiene un RequestMapping con "/tarifa" y 2 gets y 1 post:

- /tarifa/getAllTarifas: Muestra todas las tarifas leidas del fichero tarifas.csv.

- /tarifa/getAllCatalogos: Muestra todos los catalogos que hay ya dentro del programa(Si no has metido ningun catalogo no te dará ninguno)

- /tarifa/addCatalogos: Si le mandas un Json por el body usando Postman te lo guarda, le aplica la tarifa correspondiente y te lo retorna en json

### ***TESTS***
Tiene un test que comprueba que /tarifa/getAllTarifas retorne las tarifas que tiene el fichero
```
[
    {
        "id": 55555,
        "tipo": "Enterprise",
        "precio": 99.99
    },
    {
        "id": 33333,
        "tipo": "Avanzado",
        "precio": 29.99
    },
    {
        "id": 11111,
        "tipo": "Básico",
        "precio": 9.99
    },
    {
        "id": 44444,
        "tipo": "Pro",
        "precio": 49.99
    },
    {
        "id": 22222,
        "tipo": "Premium",
        "precio": 19.99
    }
]
```

Otro que comprueba que se añaden y reciben correctamente los catalogos
Yo le paso esto 
```
[
    {
        "id": 55555,
        "lugar": "PENINSULA",
        "stock": 1,
        "stockReal": 1,
        "stockVirtual": 0,
        "codigo": 55555,
        "nombre": "GT  Alcatel Pixie 3"
    },
    {
        "id": 33333,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 33333,
        "nombre": "samsung galaxy 3 3"
    },
    {
        "id": 11111,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 11111,
        "nombre": "Samsung Galaxy  1"
    },
    {
        "id": 44444,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 44444,
        "nombre": "Huawei Media Pad 11"
    }
]
```
y me devuelve esto
```
[
    {
        "id": 55555,
        "lugar": "PENINSULA",
        "stock": 1,
        "stockReal": 1,
        "stockVirtual": 0,
        "codigo": 55555,
        "nombre": "GT  Alcatel Pixie 3",
        "tipo": "Enterprise",
        "precio": 99.99
    },
    {
        "id": 33333,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 33333,
        "nombre": "samsung galaxy 3 3",
        "tipo": "Avanzado",
        "precio": 29.99
    },
    {
        "id": 11111,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 11111,
        "nombre": "Samsung Galaxy  1",
        "tipo": "Básico",
        "precio": 9.99
    },
    {
        "id": 44444,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 44444,
        "nombre": "Huawei Media Pad 11",
        "tipo": "Pro",
        "precio": 49.99
    }
]
```
Y otro Test que controla que te de todos los catalogos que hay dentro del programa
```
[
    {
        "id": 55555,
        "lugar": "PENINSULA",
        "stock": 1,
        "stockReal": 1,
        "stockVirtual": 0,
        "codigo": 55555,
        "nombre": "GT  Alcatel Pixie 3",
        "tipo": "Enterprise",
        "precio": 99.99
    },
    {
        "id": 33333,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 33333,
        "nombre": "samsung galaxy 3 3",
        "tipo": "Avanzado",
        "precio": 29.99
    },
    {
        "id": 11111,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 11111,
        "nombre": "Samsung Galaxy  1",
        "tipo": "Básico",
        "precio": 9.99
    },
    {
        "id": 44444,
        "lugar": "PENINSULA",
        "stock": 5,
        "stockReal": 5,
        "stockVirtual": 0,
        "codigo": 44444,
        "nombre": "Huawei Media Pad 11",
        "tipo": "Pro",
        "precio": 49.99
    }
]
```




