package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MainController {

    @RequestMapping("/")
    public RedirectView redirectToFrontend() {
        return new RedirectView("/index.htmlgit "); // Remplacez par l'URL de votre frontend
    }
}