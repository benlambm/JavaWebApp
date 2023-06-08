package net.lamb.JavaWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
@Controller
public class JavaWebAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaWebAppApplication.class, args);
    }

    @GetMapping("/")
    public String home(@ModelAttribute("message") String message, Model model) {
        model.addAttribute("message", message);
        return "home";
    }

    @PostMapping("/")
    public String postMessage(@RequestParam("message") String message, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/";
    }
}
