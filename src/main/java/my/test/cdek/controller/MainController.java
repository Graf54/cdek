package my.test.cdek.controller;

import my.test.cdek.model.App;
import my.test.cdek.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    AppService appService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("apps", appService.getList(10, 0));
        model.addAttribute("idFind", 0);

        return "index";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String find(@ModelAttribute("id") int id, Model model) {
        model.addAttribute("apps", appService.getList(10, 0));
        App app = appService.get(id);
        if (app != null) {
            model.addAttribute("idFind", id);
            model.addAttribute("findApp", app);
        }
        return "index";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String add(@ModelAttribute("appForm") App app) {
        appService.save(app);
        return "redirect:/index";
    }

    @RequestMapping(value = "/courier", method = RequestMethod.GET)
    public String courier(Model model) {

        model.addAttribute("apps", appService.getListByStatusId(0, 10, 0));

        return "courier";
    }


    @RequestMapping(value = "/cancel", method = RequestMethod.GET)
    public String cancel(@RequestParam int id) {
        App app = appService.get(id);
        app.setStatusId(1);
        appService.save(app);
        return "redirect:/courier";
    }

}
