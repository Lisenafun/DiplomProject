//package ifmo.javaDeveloper.DiplomProject.controller;
//
//import ifmo.javaDeveloper.DiplomProject.entity.Player;
//import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.Field;
//import ifmo.javaDeveloper.DiplomProject.entity.fieldOfGame.NameOracle;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.validation.Valid;
//
//@Controller
//public class FieldController {
//
//    @RequestMapping(value = "/game", method = RequestMethod.POST)
//    public ModelAndView createNewGame(@Valid Field field, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        NameOracle nameOracle = new NameOracle ("Stepan");
//            modelAndView.addObject("field", field);
//            modelAndView.setViewName("game");
//        return modelAndView;
//    }
//}
