package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.entity.BookExpiry;
import com.example.demo.entity.BooksStore;
import com.example.demo.entity.Checkout;
import com.example.demo.model.CreateBookDTO;
import com.example.demo.model.ExtendTimeDTO;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookExpiryRepo;
import com.example.demo.repository.BooksRepository;
import com.example.demo.repository.BooksStoreRepo;
import com.example.demo.repository.CheckoutsRepo;
import com.example.demo.repository.UsersRepo;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Slf4j
public class LibraryServiceImpl implements LibraryService {
    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final BookExpiryRepo bookExpiryRepo;
    private final CheckoutsRepo checkoutsRepo;
    private final UsersRepo usersRepo;
    private final BooksStoreRepo booksStoreRepo;

    // void blah() {
    // System.out.println("blah");
    // }

    public List<BooksStore> getAllBooks() {
        return booksStoreRepo.findAll();
    }

    public Optional<BooksStore> getBookByParam(BookSearchMode mode, String value) {
        log.debug("Getting book by mode = {} value = {}", mode, value);
        switch (mode) {
        case AUTHOR:
            return booksStoreRepo.getBookByAuthorName(value);
        case BOOKNAME:
            log.debug("Getting book by name {}", value);
            return booksStoreRepo.getBookByName(value);
        default:
            return Optional.empty();
        }

    }

    @Transactional
    public Optional<Integer> checkoutBook(int bookId, int userId) {
        final var user = usersRepo.findById(userId).get();
        final var store = booksStoreRepo.findById(bookId).get();
        final var book = store.getBook();
        if (store.getQuantity() > 0) {
            // var checkout =
            // checkout.book(book).takenBy(user).returnTime(LocalDateTime.now().plusDays(7)).build();
            var checkout = new Checkout();
            checkout.setBook(book);
            checkout.setTakenBy(user);
            checkout.setReturnTime(LocalDateTime.now().plusDays(7));
            booksStoreRepo.updateQuantity(bookId, store.getQuantity() - 1);
            final var checkout2 = checkoutsRepo.save(checkout);
            return Optional.of(checkout2.getCheckoutId());
        } else {
            return Optional.empty();
        }
        // log.error("Book with id {} does not exist", bookId);
    }

    @Transactional
    public void returnBook(int checkoutId) {

        final var checkout = checkoutsRepo.findById(checkoutId).get();
        final var store = booksStoreRepo.findById(checkout.getBook().getBookId()).get();
        booksStoreRepo.updateQuantity(checkout.getBook().getBookId(), store.getQuantity() + 1);
        checkoutsRepo.delete(checkout);

    }

    @Transactional
    public BooksStore createBook(CreateBookDTO dto) {
        final var author = authorRepository.findById(dto.getAuthorId()).get();
        var book = new Book();
        book.setAuthor(author);
        book.setBookName(dto.getBookName());
        book.setIsbn(dto.getIsbn());
        book = booksRepository.save(book);
        var bookExpiry = new BookExpiry();
        bookExpiry.setBook(book);
        bookExpiry.setDiscontinued(false);
        bookExpiryRepo.save(bookExpiry);
        var bs = new BooksStore();
        bs.setBook(book);
        bs.setQuantity(dto.getQuantity());
        bs = booksStoreRepo.save(bs);
        return bs;
    }

    @Transactional
    public void extendReturnTime(ExtendTimeDTO dto) {
        checkoutsRepo.updateReturnTime(dto.getCheckoutId(), dto.getNewDate());
    }

    @Transactional
    public void discontinueBook(int bookId) {
        // bookExpiryRepo.updateBookDiscontinueStatus(bookId, true);
        final var be = bookExpiryRepo.findByBookId(bookId).get();
        be.setDiscontinued(true);
        bookExpiryRepo.save(be);

    }
}
