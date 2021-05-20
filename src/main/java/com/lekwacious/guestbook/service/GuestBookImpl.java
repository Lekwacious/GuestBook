package com.lekwacious.guestbook.service;

import com.lekwacious.guestbook.Data.Payloads.request.GuestBookRequest;
import com.lekwacious.guestbook.Data.Payloads.response.MessageResponse;
import com.lekwacious.guestbook.Data.models.GuestBook;
import com.lekwacious.guestbook.Data.repository.GuestBookRepository;
import com.lekwacious.guestbook.exception.GuestBookException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuestBookImpl implements GuestBookService{
    @Autowired
    private GuestBookRepository guestBookRepository;
    @Override
    public MessageResponse createGuestBook(GuestBook guestBook) {
        guestBookRepository.save(guestBook);

        return new MessageResponse("Guest Book created successfully");
    }

    @Override
    public void deleteGuestBook(Integer guestBookId) {
        guestBookRepository.deleteById(guestBookId);

    }

    @Override
    public GuestBook readGuestBook(Integer guestBookId) {
        return guestBookRepository.findById(guestBookId).orElseThrow(() -> new GuestBookException("No Note with such" + guestBookId+ "Id"));

    }

    @Override
    public List<GuestBook> getAllGuestBook() {
        return guestBookRepository.findAll();
    }

    @Override
    public GuestBook getGuessBookById(Integer id) {

            Optional<GuestBook> optional = guestBookRepository.findById(id);
            GuestBook guestBook = null;
            if (optional.isPresent()) {
                guestBook = optional.get();
            } else {
                throw new RuntimeException(" Employee not found for id :: " + id);
            }
            return guestBook;

    }


}
