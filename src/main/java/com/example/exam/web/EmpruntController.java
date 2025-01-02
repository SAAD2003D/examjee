package com.example.exam.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import com.example.exam.dto.EmpruntDto;
import com.example.exam.dto.LivreDto;
import com.example.exam.dto.UtilisateurDto;
import com.example.exam.service.EmpruntService;
import com.example.exam.service.LivreService;
import com.example.exam.service.UtilisateurService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class EmpruntController {
    private final EmpruntService empruntService;
    private final LivreService livreService;
    private final UtilisateurService utilisateurService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/emprunts")
    public String getEmprunts(Model model) {
        List<EmpruntDto> emprunts = empruntService.GetEmprunts();
        model.addAttribute("emprunts", emprunts);
        return "emprunts";
    }

    @GetMapping("/livres")
    public String getLivres(Model model) {
        List<LivreDto> livres = livreService.GetLivres();
        model.addAttribute("livres", livres);
        return "livres";
    }

    @GetMapping("/utilisateurs")
    public String getUtilisateurs(Model model) {
        List<UtilisateurDto> utilisateurs = utilisateurService.GetUtilisateurs();
        model.addAttribute("utilisateurs", utilisateurs);
        return "utilisateurs";
    }

    @GetMapping("/addEmprunt")
    public String addEmprunt(Model model) {
        model.addAttribute("emprunt", new EmpruntDto());
        model.addAttribute("utilisateurs", utilisateurService.GetUtilisateurs());
        model.addAttribute("livres", livreService.GetLivres());
        return "addEmprunt";
    }

    @PostMapping("/addEmprunt")
    public String addEmprunt(@Valid @ModelAttribute("emprunt") EmpruntDto empruntDto, BindingResult bindingResult, @RequestParam Integer utilisateurId, @RequestParam Integer livreId, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("utilisateurs", utilisateurService.GetUtilisateurs());
            model.addAttribute("livres", livreService.GetLivres());
            return "addEmprunt";
        }

        empruntDto.setUtilisateur(utilisateurService.GetUtilisateur(utilisateurId));
        empruntDto.setLivre(livreService.GetLivres());

        empruntService.AddEmprunt(empruntDto);
        return "redirect:emprunts";
    }
    @GetMapping("/addUtilisateur")
    public String addUtilisateur(Model model) {
        model.addAttribute("utilisateur", new UtilisateurDto());
        return "addUtilisateur";
    }
    @PostMapping("/addUtilisateur")
    public String addUtilisateur(@Valid @ModelAttribute("utilisateur") UtilisateurDto utilisateurDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addUtilisateur";
        }
        utilisateurService.AddUtilisateur(utilisateurDto);
        return "redirect:utilisateurs";
    }

    @GetMapping("/addLivre")
    public String addLivre(Model model) {
        model.addAttribute("livre", new LivreDto());
        return "addLivre";
    }
    @PostMapping("/addLivre")
    public String addLivre(@Valid @ModelAttribute("livre") LivreDto livreDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addLivre";
        }
        livreService.AddLivre(livreDto);
        return "redirect:livres";
    }
}