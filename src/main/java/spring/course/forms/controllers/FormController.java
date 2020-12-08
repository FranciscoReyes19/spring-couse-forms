package spring.course.forms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.course.forms.models.User;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formView(Model model) {
        model.addAttribute("title", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String formHandler(@Valid User user, BindingResult result, Model model ) {
        model.addAttribute("title", "Resultado de formulario");
        //orden : (objeto result -> binding result -> other things)

        if (result.hasErrors()){
            Map<String, String> errors = new HashMap<>();

            //Practicing
            //int intArray[];
            //String intString[] = new String[5];

            result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error", errors);
            //model.addAttribute("user",user);  //Por defecto se mapea user a la vista por "@Valid User user..."
            //@ModelAttribute("user") User user...  // Para cambiar el nombre del objeto y por ende se mapea con ese

            return "form";
        }

        model.addAttribute("user",user);

        return "resultado";
    }
}
