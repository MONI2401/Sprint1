package com.cg.cars.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.dao.IAppointmentRepository;
import com.cg.cars.entities.Appointment;
import com.cg.cars.exception.InvalidAppointmentDateException;
import com.cg.cars.exception.InvalidAppointmentInspectionTypeException;
import com.cg.cars.exception.InvalidAppointmentLocationException;
import com.cg.cars.exception.InvalidAppointmentTimeException;
import com.cg.cars.model.AppointmentDTO;
import com.cg.cars.utils.AppointmentUtils;

@Service
public class AppointmentServiceImpl implements IAppointmentService {

	@Autowired
	private IAppointmentRepository repo;

	@Override
	public AppointmentDTO addAppointment(Appointment appointment) {
		Appointment app = repo.save(appointment);
		return AppointmentUtils.convertToAppointmentDTO(app);

	}

	@Override
	public AppointmentDTO removeAppointment(long id) {

		Appointment appointment = repo.getOne(id);
		repo.deleteById(id);
		return AppointmentUtils.convertToAppointmentDTO(appointment);
	}

	@Override
	public AppointmentDTO updateAppointment(long id, Appointment appointment) {
		this.removeAppointment(id);
		return this.addAppointment(appointment);
	}

	@Override
	public AppointmentDTO getAppointment(long id) {
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

	public static boolean isValidAppointment(Appointment appointment)
			throws InvalidAppointmentDateException, InvalidAppointmentTimeException {
		return isValidAppointmentDate(appointment.getPreferredDate())
				&& isValidAppointmentTime(appointment.getPreferredTime())
				&& CustomerServiceImp.isValidCustomer(appointment.getCustomer());
	}

	public static boolean isValidAppointmentDate(LocalDate localDate) throws InvalidAppointmentDateException {
		if (LocalDate.now().compareTo(localDate) < 0) {
			throw new InvalidAppointmentDateException(localDate.toString() + " is less than today's date");
		}
		return true;
	}

	public static boolean isValidAppointmentTime(LocalTime time) throws InvalidAppointmentTimeException {
		if (LocalTime.now().compareTo(time) < 0) {
			throw new InvalidAppointmentTimeException(time.toString() + " is less than current Time");
		} else
			return true;
	}

	public static boolean isValidLocation(String location) throws InvalidAppointmentLocationException {
		if (location.length() < 4)
			throw new InvalidAppointmentLocationException(location + " is not of length greater than 3");
		return true;
	}

	public static boolean isValidInspectionType(String inspectionType)
			throws InvalidAppointmentInspectionTypeException {
		if (inspectionType.length() < 1 && inspectionType.length() > 4)
			throw new InvalidAppointmentInspectionTypeException(inspectionType + " is not of length 2 or 3 ");
		return true;
	}

}