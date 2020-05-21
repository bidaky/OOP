package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }
  /*

    @PostMapping("/")
    public String signUp(String name, HttpServletResponse response ) {
        Cookie cookie = new Cookie("username", name);
        response.addCookie(cookie);
        return "redirect:/sale";
    }


    @GetMapping("/sale")
    public ModelAndView sale(@CookieValue(value = "username") String username) {
        ModelAndView modelAndView = modelAndView = new ModelAndView("sale");
        modelAndView.addObject("username", username);
        modelAndView.addObject("bids", bidRepository.findAll());
        return modelAndView;
    }
*/
    @PostMapping("/")
    public String addBid(String name , String service , String time, String date) {
        Client client = new Client(name, service , time, date);
        clientRepository.save(client);
        return "redirect:/sale";
    }
    @GetMapping("/sale")
    public ModelAndView sale() {
        ModelAndView modelAndView = modelAndView = new ModelAndView("sale");
        modelAndView.addObject("bids", clientRepository.findAll());
        return modelAndView;
    }
}
