# DerekLibrary

 **新增一本書籍**
----
回覆新增成功

* **URL**

  /books

* **Method:**

  `POST`

* **URL Params**
  
    None

* **Data Params**

    ```json
    {
        "name": "哈利波特. 1, 神秘的魔法石(繁體中文版20週年紀念)",
        "author": "J.K.羅琳(J. K. Rowling)",
        "translator": "彭倩文",
        "isbn": "97895733355666",
        "publisher": "皇冠",
        "publicationDate": "2020-08-05",
        "price": 420
    }
    ```

* **Success Response:**

    * **Code:** 201 Created <br />
      **Content:** None

* **Error Response:**

    * **Code:** 400 Bad Request <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T14:52:38.236+00:00",
          "status": 400,
          "error": "Bad Request",
          "path": "/books"
      }
      ```
  OR
    * **Code:** 500 Internal Server Error <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T15:20:47.560+00:00",
          "status": 500,
          "error": "Internal Server Error",
          "path": "/books"
      }
      ```
* **Sample Call:**

  ```shell
    curl --location --request POST 'http://localhost:8080/books' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "name": "哈利波特. 1, 神秘的魔法石(繁體中文版20週年紀念)",
        "author": "J.K.羅琳(J. K. Rowling)",
        "translator": "彭倩文",
        "isbn": "97895733355666",
        "publisher": "皇冠",
        "publicationDate": "2020-08-05",
        "price": 420
    }'
  ```

**更新一本書籍**
----
回覆更新成功,並回傳該書籍資料

* **URL**

  /books

* **Method:**

  `PUT`

* **URL Params**

  None

* **Data Params**
  ```json
    {
        "id": 2,
        "name": "射鵰英雄傳. 1, 大漠風沙(大字版)",
        "author": "金庸",
        "translator": "彭倩文",
        "isbn": "9789573281139",
        "publisher": "遠流",
        "publicationDate": "2017-10-05",
        "price": 380
    }
  ```

* **Success Response:**

    * **Code:** 200 OK <br />
      **Content:** 
      ```json
      {
          "id": 2,
          "name": "射鵰英雄傳. 1, 大漠風沙(大字版)",
          "author": "金庸",
          "translator": "彭倩文",
          "isbn": "9789573281139",
          "publisher": "遠流",
          "publicationDate": "2017-10-05",
          "price": 380
      }
      ```

* **Error Response:**

    * **Code:** 400 Bad Request <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T14:52:38.236+00:00",
          "status": 400,
          "error": "Bad Request",
          "path": "/books"
      }
      ```
    OR
    * **Code:** 500 Internal Server Error <br />
      **Content:** 
      ```json
      {
          "timestamp": "2022-04-16T15:20:47.560+00:00",
          "status": 500,
          "error": "Internal Server Error",
          "path": "/books"
      }
      ```

* **Sample Call:**

  ```shell
    curl --location --request PUT 'http://localhost:8080/books' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "id": 2,
        "name": "射鵰英雄傳. 1, 大漠風沙(大字版)",
        "author": "金庸",
        "translator": "彭倩文",
        "isbn": "9789573281139",
        "publisher": "遠流",
        "publicationDate": "2017-10-05",
        "price": 380
    }'
  ```

**列出所有書籍**
----
回覆所有書籍資料

* **URL**

  /books

* **Method:**

  `GET`

* **URL Params**

  None

* **Data Params**

  None

* **Success Response:**

    * **Code:** 200 Ok <br />
      **Content:** 
    ```json
    [
        {
            "id": 1,
            "name": "哈利波特. 1, 神秘的魔法石(繁體中文版20週年紀念)",
            "author": "J.K.羅琳(J. K. Rowling)",
            "translator": "彭倩文",
            "isbn": "97895733355666",
            "publisher": "皇冠",
            "publicationDate": "2020-08-05",
            "price": 420.00
        },
        {
            "id": 2,
            "name": "射鵰英雄傳. 1, 大漠風沙(大字版)",
            "author": "金庸",
            "translator": "彭倩文",
            "isbn": "9789573281139",
            "publisher": "遠流",
            "publicationDate": "2017-10-05",
            "price": 380.00
        }
    ]
    ```

* **Error Response:**

  * **Code:** 400 Bad Request <br />
    **Content:**
    ```json
    {
        "timestamp": "2022-04-16T14:52:38.236+00:00",
        "status": 400,
        "error": "Bad Request",
        "path": "/books"
    }
    ```
  OR
    * **Code:** 500 Internal Server Error <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T15:20:47.560+00:00",
          "status": 500,
          "error": "Internal Server Error",
          "path": "/books"
      }
      ```

* **Sample Call:**

  ```shell
  curl --location --request GET 'http://localhost:8080/books'
  ```

**刪除一本書籍**
----
回覆刪除成功

* **URL**

  /books/:id

* **Method:**

  `DELETE`

* **URL Params**

  id=[long]

* **Data Params**

  None

* **Success Response:**

    * **Code:** 200 Ok <br />
      **Content:** None

* **Error Response:**

    * **Code:** 400 Bad Request <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T14:52:38.236+00:00",
          "status": 400,
          "error": "Bad Request",
          "path": "/books"
      }
      ```
  OR
    * **Code:** 500 Internal Server Error <br />
      **Content:**
      ```json
      {
          "timestamp": "2022-04-16T15:20:47.560+00:00",
          "status": 500,
          "error": "Internal Server Error",
          "path": "/books"
      }
      ```

* **Sample Call:**

  ```shell
  curl --location --request DELETE 'http://localhost:8080/books/2'
  ```


## DockerImage
### Quick Start
commend line run
```shell
./buildDockerImage.sh
```
    