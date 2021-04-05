package com.cg.cars.service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.cg.cars.entities.Appointment;
import com.cg.cars.exception.InvalidAppointmentDateException;
import com.cg.cars.exception.InvalidAppointmentInspectionTypeException;
import com.cg.cars.exception.InvalidAppointmentLocationException;
import com.cg.cars.exception.InvalidAppointmentTimeException;
import com.cg.cars.model.AppointmentDTO;

public interface IAppointmentService {

	public AppointmentDTO addAppointment(Appointment appointment);

	public AppointmentDTO removeAppointment(long id);

	public AppointmentDTO updateAppointment(long id, Appointment appointment);

	public AppointmentDTO getAppointment(long id);

	public List<AppointmentDTO> getAllAppointments();

	public List<AppointmentDTO> getOpenAppointments();

	public static boolean isValidAppointment(Appointment appointment)
			throws InvalidAppointmentDateException, InvalidAppointmentTimeException {
		return IAppointmentService.isValidAppointmentDate(appointment.getPreferredDate())
				&& IAppointmentService.isValidAppointmentTime(appointment.getPreferredTime())
				&& CustomerServiceImp.isValidCustomer(appointment.getCustomer());
	}

	public static boolean isValidAppointmentDate(Date date) throws InvalidAppointmentDateException {
		if (new Date().compareTo(date) < 0) {
			throw new InvalidAppointmentDateException(date.toString() + " is less than today's date");
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
