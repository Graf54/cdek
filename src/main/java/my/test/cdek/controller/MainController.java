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

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AppService appService;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("apps", appService.getList(10, 0));
        model.addAttribute("idNotFound", 0);

        return "index";
    }

    /*@RequestMapping(value = "/search", method = RequestMethod.GET)
    public String find(@ModelAttribute("id") int id, Model model) {
        if (appService.isExist(id)) {
            List<App> apps = new LinkedList<>();
            apps.add(appService.get(id));
            model.addAttribute("idNotFound", 0);
            model.addAttribute("apps", apps);
            return "index";
        } else {
            model.addAttribute("idNotFound", id);
            model.addAttribute("apps", appService.getList(10, 0));
            return "index";
        }
    }*/

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String find(@ModelAttribute("id") String idStr, Model model) {
        if (idStr != null && !idStr.isEmpty()) {
            int id = Integer.parseInt(idStr);
            if (appService.isExist(id)) {
                List<App> apps = new LinkedList<>();
                apps.add(appService.get(id));
                model.addAttribute("idNotFound", 0);
                model.addAttribute("apps", apps);
                return "index";

            } else {
                model.addAttribute("idNotFound", id);
                model.addAttribute("apps", appService.getList(10, 0));
                return "index";
            }
        } else {
            return "redirect:/index";
        }
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
