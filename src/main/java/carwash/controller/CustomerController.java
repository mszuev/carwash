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
@RequestMapping("/user")
public class CustomerController {
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
        modelAndView.setViewName("userAllServiceType");
        modelAndView.addObject("serviceTypeList", serviceTypes);
        return modelAndView;
    }


    @GetMapping(value = "/signup/{id}")
    public ModelAndView signUpPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("signUpTime");
        modelAndView.addObject("userinfo", carwashService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/signup")
    public ModelAndView signUp(@ModelAttribute("userinfo") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        customerService.add(customer);
        return modelAndView;
    }
}
