Db name = librarydb \
Db user = libraryuser \
Db password = password

## API

### Get books by author name
`curl http://localhost:8090/api/library/books/get?mode=AUTHOR&value=Author2`

### Get books by book name
`curl http://localhost:8090/api/library/books/get?mode=BOOKNAME&value=book1`

### Checkout book

`curl -X POST -H "content-type: application/json" -i http://localhost:8090/api/library/checkout --data '{"bookId":1,"userId":1}'`

### Return book
`curl -X POST -H "content-type: application/json" -i http://localhost:8090/api/library/return-book --data '{"checkoutId":1}'`

### Discontinue book
`curl -X POST -H "content-type: application/json" -i http://localhost:8090/api/library/books/discontinue --data '{"bookId":1}'`

### Extend return time of checkout
`curl -X POST -H "content-type: application/json" "http://localhost:8090/api/library/extend-time" --data '{"checkoutId":2, "newDate":"2021-04-12T18:48:38"}'`

### Create a book
`curl -X POST -H "content-type: application/json" "http://localhost:8090/api/library/books/create" --data '{"isbn":"aedvwegwevwe","bookName":"book4","authorId":1,"quantity":10}'`
