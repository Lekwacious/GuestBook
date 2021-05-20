package com.lekwacious.guestbook.service;

import com.lekwacious.guestbook.Data.Payloads.request.GuestBookRequest;
import com.lekwacious.guestbook.Data.Payloads.response.MessageResponse;
import com.lekwacious.guestbook.Data.models.GuestBook;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GuestBookService {
    MessageResponse createGuestBook(GuestBook guestBook);
    void deleteGuestBook(Integer guestBookId);
    GuestBook readGuestBook(Integer guestBookId);
    List<GuestBook> getAllGuestBook();
    GuestBook getGuessBookById(Integer id);

}
