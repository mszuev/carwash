package carwash.service;

import carwash.model.ServiceType;
import java.util.List;

public interface CarwashService {
    List<ServiceType> allServiceType();
    void add(ServiceType object);
    void delete(ServiceType object);
    void edit(ServiceType object);
    ServiceType getById(int id);
}
