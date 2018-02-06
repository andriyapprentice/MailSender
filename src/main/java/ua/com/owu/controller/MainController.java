package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ua.com.owu.entity.User;
import ua.com.owu.servsice.MailService;
import ua.com.owu.servsice.UserService;

import java.io.File;
import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestParam String name, @RequestParam MultipartFile avatar, @RequestParam String email) throws IOException {

        String filename = avatar.getOriginalFilename();
        String path = System.getProperty("user.home") + File.separator + "images" + File.separator;
        avatar.transferTo(new File(path + filename));

        System.out.println(filename);
        System.out.println(path);

        User user = User.builder()
                .name(name)
                .avatar("/avatarka/" + filename)
                .email(email)
                .build();
        userService.save(user);
        mailService.sendEmail(user);

        return "redirect:/";


    }


}
