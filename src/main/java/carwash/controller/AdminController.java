package carwash.controller;

import carwash.model.Customer;
import carwash.model.ServiceType;
import carwash.service.CarwashService;
import carwash.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private CarwashService carwashService;
    private CustomerService customerService;

    @Autowired
    public void setCarwashService(CarwashService carwashService) {
        this.carwashService = carwashService;
    }

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ModelAndView allServiceType() {
        List<ServiceType> serviceTypes = carwashService.allServiceType();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminAllServiceType");
        modelAndView.addObject("serviceTypeList", serviceTypes);
        return modelAndView;
    }

    @GetMapping(value = "/calendar")
    public ModelAndView allCustomers() {
        List<Customer> customerList = customerService.allCustomers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calendar");
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }


    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("service", carwashService.getById(id));
        return modelAndView;
    }
    @PostMapping(value = "/edit")
    public ModelAndView editServiceType(@ModelAttribute("service") ServiceType serviceType) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        carwashService.edit(serviceType);
        return modelAndView;
    }


    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @PostMapping(value = "/add")
    public ModelAndView addServiceType(@ModelAttribute("service") ServiceType serviceType) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        carwashService.add(serviceType);
        return modelAndView;
    }


    @GetMapping(value="/delete/{id}")
    public ModelAndView deleteServiceType(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        ServiceType serviceType = carwashService.getById(id);
        carwashService.delete(serviceType);
        return modelAndView;
    }
}