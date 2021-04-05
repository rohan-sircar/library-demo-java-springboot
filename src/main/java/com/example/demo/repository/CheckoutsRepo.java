package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import com.example.demo.entity.Checkout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutsRepo extends JpaRepository<Checkout, Integer> {
    @Query("select c from Checkout c join fetch c.book b join fetch c.takenBy user where b.bookId = ?1 and user.userId = ?2")
    Optional<Checkout> getByIds(int bookId, int user);

    @Modifying
    @Query("update Checkout c set c.returnTime = ?2 where c.checkoutId = ?1")
    void updateReturnTime(int checkoutId, LocalDateTime newDate);
}
