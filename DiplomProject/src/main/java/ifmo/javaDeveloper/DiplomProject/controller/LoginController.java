package ifmo.javaDeveloper.DiplomProject.controller;

import javax.validation.Valid;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import ifmo.javaDeveloper.DiplomProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value={"/login"}, method = RequestMethod.POST)
    public ModelAndView enterPlayer(@Valid Player player, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Player plExists = playerService.findPlayerByEmail (player.getEmail());
        if (plExists == null) {
            bindingResult
                    .rejectValue("email", "error.player",
                            "Пользователь с указанным адресом электронной почты не зарегистрирован");
        }if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            modelAndView.setViewName("/user/home");
        }
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        Player player = new Player ();
        modelAndView.addObject("player", player);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid Player player, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Player plExists = playerService.findPlayerByEmail (player.getEmail());
        if (plExists != null) {
            bindingResult
                    .rejectValue("email", "error.player",
                            "Пользователь с указанным адресом электронной почты уже зарегистрирован");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            playerService.savePlayer (player);
            modelAndView.addObject("successMessage", "Пользователь был успешно зарегистрирован");
            modelAndView.addObject("player", new Player ());
            modelAndView.setViewName("registration");

        }
        return modelAndView;
    }

    @RequestMapping(value="/user/home", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Player player = playerService.findPlayerByEmail (auth.getName());
        modelAndView.addObject("playerLogin", "Welcome " + player.getLogin ());
        modelAndView.addObject("adminMessage","Вы вошли в свой аккаунт!");
        modelAndView.setViewName("user/home");
        return modelAndView;
    }
}
