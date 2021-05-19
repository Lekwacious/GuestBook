package com.lekwacious.guestbook.Data.repository;

import com.lekwacious.guestbook.Data.models.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestBookRepository  extends JpaRepository<GuestBook, Integer> {
}
