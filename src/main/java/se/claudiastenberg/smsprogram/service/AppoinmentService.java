package se.claudiastenberg.smsprogram.service;

import org.springframework.stereotype.Service;
import se.claudiastenberg.smsprogram.model.Appoinment;
import se.claudiastenberg.smsprogram.repository.AppoinmentRepository;

import java.util.Optional;

@Service
public final class AppoinmentService {

    private final AppoinmentRepository appoinmentRepository;

    public AppoinmentService(AppoinmentRepository appoinmentRepository) {
        this.appoinmentRepository = appoinmentRepository;
    }


    public Appoinment addAppoinment(Appoinment appoinment){
        return appoinmentRepository.save(appoinment);
    }
    public Iterable<Appoinment> getallAppoinments(){
        return appoinmentRepository.findAll();
    }
    public Optional<Appoinment> getByID(Long id){
        return appoinmentRepository.findById(id);
    }
    public void deleteAppoinment(Long id){
        appoinmentRepository.deleteById(id);
    }

}
