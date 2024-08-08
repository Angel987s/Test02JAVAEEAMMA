package org.esfe.Test02JAVAEEAMMA.controladores;

import java.util.stream.Collectors;

import org.esfe.Test02JAVAEEAMMA.modelos.OrdenAMMA;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IOrdenAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/ordenesAMMA") 
public class OrdenAMMAController {

    @Autowired
    private IOrdenAMMAService ordenService;

   @GetMapping
public String index(Model model, @RequestParam("page") Optional<Integer> page,
                    @RequestParam("size") Optional<Integer> size) {
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(5);

    Page<OrdenAMMA> 
 ordenPage = ordenService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
    model.addAttribute("ordenes", ordenPage);

    int totalPages = ordenPage.getTotalPages();
    if (totalPages > 0) {
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);

    }

    return "ordenes/index"; 
}

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("orden", new OrdenAMMA());
        return "ordenes/create"; 
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("orden") OrdenAMMA orden, RedirectAttributes redirectAttributes) {
        ordenService.crearOEditar(orden);
        redirectAttributes.addFlashAttribute("msg", "Orden guardada exitosamente!");
        return "redirect:/ordenesAMMA";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        OrdenAMMA orden = ordenService.buscarPorId(id);
        model.addAttribute("orden", orden);
        return "ordenes/edit"; 
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("orden") OrdenAMMA orden, RedirectAttributes redirectAttributes) {
        ordenService.crearOEditar(orden);
        redirectAttributes.addFlashAttribute("msg", "Orden actualizada exitosamente!");
        return "redirect:/ordenesAMMA";
    }

    @GetMapping("/remove/{id}")
public String remove(@PathVariable Long id, Model model) {
    OrdenAMMA orden = ordenService.buscarPorId(id);
    model.addAttribute("orden", orden);
    return "ordenes/delete"; 
}


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        ordenService.eliminarPorId(id);
        redirectAttributes.addFlashAttribute("msg", "Orden eliminada exitosamente!");
        return "redirect:/ordenesAMMA";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        OrdenAMMA orden = ordenService.buscarPorId(id);
        model.addAttribute("orden", orden);
        return "ordenes/details"; 
    }
}
