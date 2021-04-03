create table authors (
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(30)
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    isbn VARCHAR(50) UNIQUE,
    book_name VARCHAR(30),
    author_id INTEGER REFERENCES authors(author_id)
);

create table books_store (
    books_store_id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES books(book_id),
    quantity INTEGER
);

create table book_expiry (
    book_expiry_id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES books(book_id),
    discontinued BOOLEAN
);

create table users (
    user_id SERIAL PRIMARY KEY,
    user_name VARCHAR(30)
);

create table checkouts (
    checkout_id SERIAL PRIMARY KEY,
    book_id INTEGER REFERENCES books(book_id),
    taken_by INTEGER REFERENCES users(user_id),
    return_time timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
);