package org.esfe.Test02JAVAEEAMMA.controladores;

import org.esfe.Test02JAVAEEAMMA.modelos.DetalleOrdenAMMA;
import org.esfe.Test02JAVAEEAMMA.modelos.OrdenAMMA;
import org.esfe.Test02JAVAEEAMMA.modelos.ProductoAMMA;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IDetalleOrdenAMMAService;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IOrdenAMMAService;
import org.esfe.Test02JAVAEEAMMA.servicios.interfaces.IProductoAMMAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/detallesOrdenAMMA") 
public class DetalleOrdenAMMAController {

    @Autowired
    private IDetalleOrdenAMMAService detalleOrdenService; @Autowired 
    private IProductoAMMAService productoService; 

    @Autowired
    private IOrdenAMMAService ordenService; 

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page,
                        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
    
        Page<DetalleOrdenAMMA> detalleOrdenPage = detalleOrdenService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("detallesOrden", detalleOrdenPage);
    
        int totalPages = detalleOrdenPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
    
        return "detallesOrden/index"; 
    }
    
    @GetMapping("/create")
public String create(Model model) {
    model.addAttribute("detalleOrden", new DetalleOrdenAMMA());

    List<ProductoAMMA> productos = productoService.obtenerTodos();
    List<OrdenAMMA> ordenes = ordenService.obtenerTodos();

    model.addAttribute("productos", productos);
    model.addAttribute("ordenes", ordenes);

    return "detallesOrden/create"; 
}



    @PostMapping("/save")
    public String save(@ModelAttribute("detalleOrden") DetalleOrdenAMMA detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden guardado exitosamente!");
        return "redirect:/detallesOrdenAMMA"; 
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        DetalleOrdenAMMA detalleOrden = detalleOrdenService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
            List<ProductoAMMA> productos = productoService.obtenerTodos();
            List<OrdenAMMA> ordenes = ordenService.obtenerTodos();

                model.addAttribute("productos", productos);
            model.addAttribute("ordenes", ordenes);

            return "detallesOrden/edit"; 
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("detalleOrden") DetalleOrdenAMMA detalleOrden, RedirectAttributes redirectAttributes) {
        detalleOrdenService.crearOEditar(detalleOrden);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden actualizado exitosamente!");
        return "redirect:/detallesOrdenAMMA"; 
    }

    @GetMapping("/remove/{id}")
public String remove(@PathVariable Long id, Model model) {
    DetalleOrdenAMMA detalleOrden = detalleOrdenService.buscarPorId(id);
    model.addAttribute("detalleOrden", detalleOrden);
    return "detallesOrden/delete"; 
}



    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        detalleOrdenService.eliminarPorId(id);
        redirectAttributes.addFlashAttribute("msg", "Detalle de orden eliminado exitosamente!");
        return "redirect:/detallesOrdenAMMA"; 
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable Long id, Model model) {
        DetalleOrdenAMMA detalleOrden = detalleOrdenService.buscarPorId(id);
        model.addAttribute("detalleOrden", detalleOrden);
        return "detallesOrden/details"; 
    }
}
