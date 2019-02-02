//package ifmo.javaDeveloper.DiplomProject.controller;
//
//import ifmo.javaDeveloper.DiplomProject.entity.Player;
//import ifmo.javaDeveloper.DiplomProject.repository.PlayerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//public class UserController {
//    @Autowired
//    private PlayerRepository repository;
//
//    @RequestMapping("/")
//    public String goHome() {
//        return "home";
//    }
//
//    @RequestMapping(value = "/player/create", method = RequestMethod.GET)
//    public String createUser(@ModelAttribute Player player, Model model) {
//        model.addAttribute ("player", new Player ());
//        return "add_user";
//    }
//
//    @RequestMapping(value = "/player/create", method = RequestMethod.POST)
//    public String saveUser(@ModelAttribute Player player, Model model) {
//        if(!repository.existsById (player.getId ())) {
//            repository.save (player);
//            model.addAttribute ("findUser", player.getLogin ());
//            return "main_account_menu";
//        }else{
//            return "add_user";
//        }
//    }
//
//    @RequestMapping(value = "/player/enter", method = RequestMethod.GET)
//    public String enterUser(@ModelAttribute Player player, Model model){
//        return "enter_user";
//    }
//    @RequestMapping(value = "/Main_menu", method = RequestMethod.GET)
//    public String enterMain(@ModelAttribute Player player, Model model){
//        return "main_account_menu";
//    }
////    @RequestMapping(value = "/Main_menu", method = RequestMethod.POST)
////    public String findUser(@ModelAttribute Player user, Model model){
////        model.containsAttribute ("findUser");
////        if(repository.findById (user.getId ()).isPresent ()) {
////            Player findUser = repository.findById (user.getId ()).get ();
////            return "main_account_menu";
////        }else{
////            return "Не верно введен логин или пароль";
////        }
////    }
//}