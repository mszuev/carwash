package carwash.dao;

import carwash.model.ServiceType;
import java.util.List;

public interface CarwashDAO {
    List<ServiceType> allServiceType();
    void add(ServiceType object);
    void delete(ServiceType object);
    void edit(ServiceType object);
    ServiceType getById(int id);
}
