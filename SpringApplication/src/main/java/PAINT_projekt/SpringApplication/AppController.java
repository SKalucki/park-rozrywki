package PAINT_projekt.SpringApplication;

import PAINT_projekt.SpringApplication.DAO.AtrakcjeDAO;
import PAINT_projekt.SpringApplication.DAO.PracownicyDAO;
import PAINT_projekt.SpringApplication.DAO.RezerwacjeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Configuration
public class AppController implements WebMvcConfigurer {



    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
    }

    @Controller
    public class DashboardController {
        @RequestMapping(value={"/main_admin"})
        public String showAdminPage(Model model) {
            return "admin/main_admin";
        }
        @RequestMapping(value={"/main_user"})
        public String showUserPage(Model model) {
            return "user/main_user";
        }

        @Autowired
        private AtrakcjeDAO dao;
        @Autowired
        private PracownicyDAO daoP;
        @Autowired
        private RezerwacjeDAO daoR;


        @RestController
        @RequestMapping("/api/atrakcje")
        public class AtrakcjeController {

            @Autowired
            private AtrakcjeDAO atrakcjeDAO;


            @GetMapping("/atrakcje")
            public List<Atrakcje> getAtrakcja() {
                return atrakcjeDAO.getAtrakcja();
            }
        }

        @RestController
        @RequestMapping("/api/koszyk")
        public class KoszykController {
            @Autowired
            private RezerwacjeDAO rezerwacjeDAO2;

            @GetMapping("/koszyk")
            public List<Rezerwacje> getRezerwacja2() {return rezerwacjeDAO2.getRezerwacja2();}

        }


        @RestController
        @RequestMapping("/api/rezerwacje")
        public class RezerwacjeController {

            @Autowired
            private RezerwacjeDAO rezerwacjeDAO;

            @GetMapping("/main_admin/rezerwacje")
            public List<Rezerwacje> getRezerwacja() {return rezerwacjeDAO.getRezerwacja();}


        }


            @RestController
        @RequestMapping("/api/main_admin/pracownicy")
        public class PracownicyController {

            @Autowired
            private PracownicyDAO pracownicyDAO;

            @GetMapping("/main_admin/pracownicy")
            public List<Pracownicy> getPracownik() { return pracownicyDAO.getPracownik();}

        }






        @RequestMapping("/index")
        public String viewHomePage1(Model model) {
            List<Atrakcje> listaAtrakcji1 = dao.list();
            model.addAttribute("listaAtrakcji1", listaAtrakcji1);

            return "index";
        }

        @RequestMapping("/koszykbl")
        public String viewHomePageBL(Model model) {
            return "koszykbl";
        }




        @RequestMapping("/atrakcje")
        public String viewHomePage(Model model) {
            List<Atrakcje> listaAtrakcji = dao.list();
            model.addAttribute("listaAtrakcji", listaAtrakcji);

            return "atrakcje";
        }

        @RequestMapping("/main_admin/rezerwacje")
        public String viewHomePageR(Model model) {
            List<Rezerwacje> listaRezerwacje = daoR.list();
            model.addAttribute("listaRezerwacje", listaRezerwacje);

            return "rezerwacje";
        }
        @RequestMapping("/main_admin/rezerwacje/new")
        public String showNewFormR(Model model) {
            Rezerwacje rezerwacja = new Rezerwacje();
            model.addAttribute("rezerwacje", rezerwacja);

            return "nowa_rezerwacja";
        }
        @RequestMapping("/koszyk")
        public String showNewFormRU(Model model) {
            Rezerwacje rezerwacja = new Rezerwacje();
            model.addAttribute("rezerwacje", rezerwacja);

            return "koszyk";
        }
        @RequestMapping(value = "/saveR", method = RequestMethod.POST)
        public String saveR(@ModelAttribute("rezerwacje") Rezerwacje rezerwacje) {
            daoR.saveR(rezerwacje);
            return "redirect:/main_admin/rezerwacje";
        }
        @RequestMapping(value = "/saveRUser", method = RequestMethod.POST)
        public String saveRUser(@ModelAttribute("rezerwacje") Rezerwacje rezerwacje) {
            daoR.saveRUser(rezerwacje);
            return "redirect:/koszyk";
        }
        @RequestMapping("/main_admin/rezerwacje/edit/{id}")
        public ModelAndView showEditFormR(@PathVariable(name= "id") int id) {
            ModelAndView mavR = new ModelAndView("edytuj_rezerwacje");
            Rezerwacje rezerwacja = daoR.getR(id);
            mavR.addObject("rezerwacje",rezerwacja);
            return mavR;
        }
        @RequestMapping(value = "/updateR", method = RequestMethod.POST)
        public String updateR(@ModelAttribute("rezerwacje") Rezerwacje rezerwacje){
            daoR.updateR(rezerwacje);

            return "redirect:/main_admin/rezerwacje";
        }
        @RequestMapping("main_admin/rezerwacje/delete/{id}")
        public String deleteR(@PathVariable(name = "id") int id) {
            daoR.deleteR(id);

            return "redirect:/main_admin/rezerwacje";
        }






        @RequestMapping("/main_admin/pracownicy")
        public String viewHomePageP(Model model) {
            List<Pracownicy> listaPracownicy = daoP.list();
            model.addAttribute("listaPracownicy", listaPracownicy);

            return "pracownicy";
        }


        @RequestMapping("/main_admin/pracownicy/new")
        public String showNewFormP(Model model) {
            Pracownicy pracownik = new Pracownicy();
            model.addAttribute("pracownicy", pracownik);

            return "nowy_pracownik";
        }
        @RequestMapping(value = "/saveP", method = RequestMethod.POST)
        public String saveP(@ModelAttribute("pracownicy") Pracownicy pracownicy) {
            daoP.saveP(pracownicy);
            return "redirect:/main_admin/pracownicy";
        }
        @RequestMapping("/main_admin/pracownicy/edit/{id_pracownika}")
        public ModelAndView showEditFormP(@PathVariable(name= "id_pracownika") int id_pracownika) {
            ModelAndView mavP = new ModelAndView("edytuj_pracownika");
            Pracownicy pracownik = daoP.getP(id_pracownika);
            mavP.addObject("pracownicy",pracownik);
            return mavP;
        }
        @RequestMapping(value = "/updateP", method = RequestMethod.POST)
        public String updateP(@ModelAttribute("pracownicy") Pracownicy pracownicy){
            daoP.updateP(pracownicy);

            return "redirect:/main_admin/pracownicy";
        }
        @RequestMapping("main_admin/pracownicy/delete/{id}")
        public String deleteP(@PathVariable(name = "id") int id_pracownika) {
            daoP.deleteP(id_pracownika);

            return "redirect:/main_admin/pracownicy";
        }


        @RequestMapping("/atrakcje/new")
        public String showNewForm(Model model) {
            Atrakcje atrakcja = new Atrakcje();
            model.addAttribute("atrakcja", atrakcja);

            return "new_form";
        }

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(@ModelAttribute("atrakcje") Atrakcje atrakcje) {
            dao.save(atrakcje);
            return "redirect:/atrakcje";
        }
        @RequestMapping("/atrakcje/edit/{id}")
        public ModelAndView showEditForm(@PathVariable(name= "id") int id) {
            ModelAndView mav = new ModelAndView("edit_form");
            Atrakcje atrakcja = dao.get(id);
            mav.addObject("atrakcja",atrakcja);
            return mav;
        }
        @RequestMapping(value = "/update", method = RequestMethod.POST)
        public String update(@ModelAttribute("atrakcje") Atrakcje atrakcje){
            dao.update(atrakcje);

            return "redirect:/atrakcje";
        }
        @RequestMapping("atrakcje/delete/{id}")
        public String delete(@PathVariable(name = "id") int id) {
            dao.delete(id);

            return "redirect:/atrakcje";
        }



        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }
}