package spring.course.forms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.course.forms.models.User;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formView(Model model) {
        model.addAttribute("title", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String formHandler(Model model,
                              @RequestParam String username,
                              @RequestParam String password,
                              @RequestParam String email) {

        User user = new User(); //no es necesario inyectar con Autowired

        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        model.addAttribute("title", "Resultado de formulario");
        model.addAttribute("usuario",user);

        return "resultado";
    }
}
