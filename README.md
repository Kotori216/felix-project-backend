# Felix 

## Examples of http requests:

### For shopper:

List all the items:

GET    10.23.227.199:8080/api/shopper/items

response:

{
"success": true,
"code": "200",
"message": "success",
"data": [
{
"id": 1,
"name": "flour",
"price": 2
},
{
"id": 2,
"name": "plant-based milk",
"price": 3
},
{
"id": 3,
"name": "chicken wing",
"price": 1
},
{
"id": 4,
"name": "oil",
"price": 2
},
{
"id": 5,
"name": "butter",
"price": 5
},
{
"id": 6,
"name": "milk",
"price": 1
}
]
}


Shop items, create an order:

POST     10.23.227.199:8080/api/shopper/shop

{
"amount": 3,
"ingredientId": 1,
"bestBefore": "2022-10-01"

}

response:
{
"success": true,
"code": "200",
"message": "success",
"data": null
}


### For housekeeper:

List all the orders:

GET    10.23.227.199:8080/api/housekeeper/list

Decide to waste:

PUT    10.23.227.199:8080/api/housekeeper/waste?id=3&amount=1

Decide to deliver or use:

PUT    10.23.227.199:8080/api/housekeeper/deliver?id=3&amount=1

### For cook:

List all the recipes based on the remaining ingredients:

GET    10.23.227.199:8080/api/cook/recipes?vegan=false



