package com.lekwacious.guestbook.web;

import com.lekwacious.guestbook.Data.Payloads.request.GuestBookRequest;
import com.lekwacious.guestbook.Data.models.GuestBook;
import com.lekwacious.guestbook.Data.repository.GuestBookRepository;
import com.lekwacious.guestbook.service.GuestBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class GuestBookController {
    private GuestBookService guestBookService;
    @Autowired
    private GuestBookRepository guestBookRepository;
    public GuestBookController(GuestBookService guestBookService) {
        this.guestBookService = guestBookService;
    }

    @GetMapping("/home")
    public String getAGuestBook(ModelMap modelMap){
        List<GuestBook> allGuestBook = guestBookService.getAllGuestBook();
        modelMap.put("allGuestBook", allGuestBook);
        return "homei";

    }
    @GetMapping("/showNewGuestBookForm")
    public String showNewGuestBookForm(Model model){
        GuestBook guestBook = new GuestBook();
        model.addAttribute("guestBook",guestBook);
        return "new_guestbook";
    }
    @PostMapping("/create")
    public String createGuestBook(@ModelAttribute("guestBook") GuestBook guestBook){
        guestBookService.createGuestBook(guestBook);
        return "redirect:home";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") Integer id, Model model) {
        GuestBook guestBook = guestBookService.getGuessBookById(id);
        model.addAttribute("guestBook", guestBook);
        return "update";

    }

    @GetMapping("/update/{id}")
    public String updateGuestBook(@PathVariable(value = "id") Integer id, Model model){
     Optional<GuestBook> guestBook = guestBookRepository.findById(id);
     model.addAttribute("guestBook", guestBook );
        return "update";
    }
    @GetMapping("/guestboot/{guestBookId}")
    public String GetASingleGuestBook(@PathVariable Integer guestBookId,ModelMap modelMap){
       GuestBook guestbook = guestBookRepository.findById(guestBookId).orElse(null);
       modelMap.put("guestbook", guestbook);
       return "details";
    }
    @GetMapping("/delete-guestbook/{id}")
    public String deleteNote(@PathVariable(value ="id") Integer id ){
        guestBookService.deleteGuestBook(id);
        return "redirect:/home";
    }
}
