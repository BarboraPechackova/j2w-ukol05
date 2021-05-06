package cz.czechitas.java2webapps.ukol5.controller;



import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.time.LocalDate;
import java.time.Period;


/**
 * Kontroler obsluhující registraci účastníků dětského tábora.
 */

@Controller
@RequestMapping("")
public class RegistraceController {

    @GetMapping("")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("formular");
        modelAndView.addObject("form", new RegistraceForm());
        return modelAndView;
    }

    @PostMapping("")
    public Object form(@ModelAttribute("form") @Valid RegistraceForm form, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        return "/formular";
      }

        Period period = form.getNarozeni().until(LocalDate.now());
        int vek = period.getYears();

        if (vek < 9 || vek > 15 || form.getSport().size() < 2) {


        if (vek < 9 || vek > 15) {
            bindingResult.rejectValue("narozeni", "", "Na tábor mohou jen děti od 9-ti do 15-ti let.");
        }
        if (form.getSport().size() < 2) {
            bindingResult.rejectValue("sport", "", "Musí být vybrány alespoň dva sporty");
        }
            return "/formular";}



      return new ModelAndView("/potvrzeni")
              .addObject("jmeno", form.getJmeno())
              .addObject("prijmeni", form.getPrijmeni())
              .addObject("narozeni", form.getNarozeni())
              .addObject("pohlavi", form.getPohlavi())
              .addObject("sport", form.getSport())
              .addObject("turnus", form.getTurnus())
              .addObject("email", form.getEmail())
              .addObject("telefon", form.getTelefon());

    }
}


