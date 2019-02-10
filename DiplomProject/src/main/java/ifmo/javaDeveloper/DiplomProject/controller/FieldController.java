package ifmo.javaDeveloper.DiplomProject.controller;

import ifmo.javaDeveloper.DiplomProject.entity.Player;
import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
import ifmo.javaDeveloper.DiplomProject.service.FieldService;
import ifmo.javaDeveloper.DiplomProject.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
//@SessionAttributes("nameOracle")
@Controller
public class FieldController {

    @Autowired
    FieldService fieldService;

    @Autowired
    PlayerService playerService;

    @RequestMapping(value={"/nameOracle"}, method = RequestMethod.POST)
    public String newName(@ModelAttribute Field field, Model model){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject ("nameOracle", field.getNameOracle ());
//        modelAndView.setViewName("game");
        model.addAttribute ("nameOracle", field.getNameOracle ());
        return "game";
    }
    @RequestMapping(value={"/nameOracle"}, method = RequestMethod.GET)
    public ModelAndView submitNewName(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("nameOracle");
        return modelAndView;
    }
//    @RequestMapping(value={"/nameOracle"}, method = RequestMethod.POST)
//    public ModelAndView newName(@Valid Field field, BindingResult bindingResult){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Player player = playerService.findPlayerByEmail (auth.getName());
//        fieldService.saveField (player, field.getNameOracle ());
////        modelAndView.addObject ("nameOracle", field.getNameOracle ());
//        modelAndView.setViewName("game");
//        return modelAndView;
//    }
//    @RequestMapping(value={"/game"}, method = RequestMethod.GET)
//    public ModelAndView newGame(){
//        ModelAndView modelAndView = new ModelAndView();
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        Player player = playerService.findPlayerByEmail (auth.getName());
//        Field field = fieldService.findFieldByNameOracle ( );
//        modelAndView.addObject ("nameOracle", field.getNameOracle ());
//        modelAndView.setViewName("game");
//        return modelAndView;
//    }
}
