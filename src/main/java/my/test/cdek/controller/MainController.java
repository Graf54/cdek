package my.test.cdek.controller;

import my.test.cdek.model.App;
import my.test.cdek.services.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    AppService appService;


    @GetMapping({"/", "/index"})
    public String index(Model model) {

        model.addAttribute("apps", appService.getList(appService.count(), 0));
        model.addAttribute("idNotFound", 0);
        return "index";
    }

    @GetMapping("/search")
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
                model.addAttribute("apps", appService.getList(appService.count(), 0));
                return "index";
            }
        } else {
            return "redirect:/index";
        }
    }

    @PostMapping("/new")
    public String add(@ModelAttribute("appForm") App app) {
        appService.save(app);
        return "redirect:/index";
    }

    @GetMapping("/courier")
    public String courier(Model model) {

        model.addAttribute("apps", appService.getListByStatusId(0, appService.count(), 0));

        return "courier";
    }


    @PostMapping("/cancel")
    public String cancel(@RequestParam int id) {
        App app = appService.get(id);
        app.setStatusId(1);
        appService.save(app);
        return "redirect:/courier";
    }
}
