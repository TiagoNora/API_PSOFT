# Endpoints

## List of the endpoints available in the api



| US   | Type	      | Endpoint                     | Permissions                      |
|------|------------|------------------------------|----------------------------------|
| US01 | **GET**    | /products                    | Anonymous or registered customer |
| US02 | **GET**    | /products/{sku}              | Anonymous or registered customer |
| US03 | **GET**    | /products/search/{skuOrName} | Anonymous or registered customer |
| US04 | **POST**   | /reviews/{sku}               | Registered customer              |
| US05 | **GET**    | /reviews/{sku}               | Anonymous or registered customer |
| US06 | **POST**   | /votes/{idReview}/{idUser}   | Registered customer              |
| US07 | **DELETE** | /reviews/{idReview}          | Registered customer              |
| US08 | **GET**    | /votes/{sku}                 | Anonymous or registered customer |
| US09 | **GET**    | /moderator/reviews           | Moderator                        |
| US10 | **PUT**    | /moderator/review/{idReview} | Moderator                        |
| US11 | **GET**    | /reviews/user/{idUser}       | Registered customer              |
| US12 | **GET**    | /products/{sku}/rating       | Anonymous or registered          |


## Additional endpoints

| Type     | Endpoint                           | Permissions                      |
|----------|------------------------------------|----------------------------------|
| **POST** | /images/uploadFile/{sku}           | Moderator                        |
| **GET**  | /images/downloadFile/{fileName:.+} | Anonymous or registered customer |
| **GET**  | /images/barcode/{sku}              | Anonymous or registered customer |


## Observations

* Uploading images to product can be also done from a graphic interface through /index.html