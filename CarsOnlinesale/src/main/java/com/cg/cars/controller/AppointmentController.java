package com.cg.cars.controller;

import java.util.List;

import com.cg.cars.entities.Appointment;
import com.cg.cars.exception.InvalidAppointmentDateException;
import com.cg.cars.exception.InvalidAppointmentInspectionTypeException;
import com.cg.cars.exception.InvalidAppointmentLocationException;
import com.cg.cars.exception.InvalidAppointmentTimeException;
import com.cg.cars.service.AppointmentServiceImpl;
import com.cg.cars.service.IAppointmentService;
import com.cg.cars.utils.AppointmentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

	@Autowired
	private IAppointmentService service;

	@GetMapping(path = "/allAppointments", produces = "application/json")
	public ResponseEntity<List<Appointment>> getAllAppointment() {
		return new ResponseEntity<List<Appointment>>(
				AppointmentUtils.convertToAppointmentList(service.getAllAppointments()), HttpStatus.OK);
	}

	@GetMapping(path = "/getAppointment/{id}", produces = "application/json")
	public ResponseEntity<Appointment> getAppointentById(@PathVariable("id") int id) {
		return new ResponseEntity<Appointment>(AppointmentUtils.convertToAppointment(service.getAppointment(id)),
				HttpStatus.OK);
	}

	@PostMapping(path = "/addAppointment", consumes = "application/json", produces = "application/json")
	@ExceptionHandler({ InvalidAppointmentDateException.class, InvalidAppointmentInspectionTypeException.class,
			InvalidAppointmentLocationException.class, InvalidAppointmentTimeException.class })
	public ResponseEntity<Appointment> addAppointment(@RequestBody Appointment appointment) {
		return new ResponseEntity<Appointment>(
				AppointmentUtils.convertToAppointment(service.addAppointment(appointment)), HttpStatus.OK);
	}

	@GetMapping(path = "getOpenAppointments", produces = "application/json")
	public ResponseEntity<List<Appointment>> getOpenAppointments() {
		return new ResponseEntity<List<Appointment>>(
				AppointmentUtils.convertToAppointmentList(service.getOpenAppointments()), HttpStatus.OK);
	}

	@DeleteMapping(path = "deleteAppointment/{id}", produces = "application/json")
	public ResponseEntity<Appointment> deleteAppointment(@PathVariable("id") int id) {
		return new ResponseEntity<Appointment>(AppointmentUtils.convertToAppointment(service.removeAppointment(id)),
				HttpStatus.OK);
	}

	@PostMapping(path = "updataAppointment/{id}", produces = "application/json", consumes = "application/json")
	@ExceptionHandler({ InvalidAppointmentDateException.class, InvalidAppointmentInspectionTypeException.class,
			InvalidAppointmentLocationException.class, InvalidAppointmentTimeException.class })
	public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment)
			throws InvalidAppointmentDateException, InvalidAppointmentTimeException {
		if (AppointmentServiceImpl.isValidAppointment(appointment))
			return new ResponseEntity<Appointment>(AppointmentUtils.convertToAppointment(
					service.updateAppointment(appointment.getAppointmentId(), appointment)), HttpStatus.OK);
		return new ResponseEntity<Appointment>(new Appointment(), HttpStatus.BAD_REQUEST);
	}
}