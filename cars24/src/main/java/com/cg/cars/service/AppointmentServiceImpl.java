package com.cg.cars.service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.cg.cars.dao.IAppointmentRepository;
import com.cg.cars.entities.Appointment;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.utils.AppointmentUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

    @Autowired
    IAppointmentRepository repo;

    @Override
    public AppointmentDTO addAppointment(Appointment appointment) {
        Appointment app=repo.save(appointment);
        return AppointmentUtils.convertToAppointmentDTO(app);
        
    }

    @Override
    public AppointmentDTO removeAppointment(int id) {
        
        Appointment appointment=repo.getOne(id);
        repo.deleteById(id);
        return AppointmentUtils.convertToAppointmentDTO(appointment);
    }

    @Override
    public AppointmentDTO updateAppointment(int id, Appointment appointment) {
        this.removeAppointment(id);
        return this.addAppointment(appointment);
    }

    @Override
    public AppointmentDTO getAppointment(int id) {
        return AppointmentUtils.convertToAppointmentDTO(repo.getOne(id));
    }

    @Override
    public List<AppointmentDTO> getAllAppointments() {
        return AppointmentUtils.convertToAppointmentDTOList(repo.findAll());
    }

    @Override
    public List<AppointmentDTO> getOpenAppointments() {
        return AppointmentUtils.convertToAppointmentDTOList(repo.getOpenAppointments(new Date(), LocalTime.now()));
    }

    
    
    
}
