package com.cg.cars.dao;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import com.cg.cars.entities.Appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {

	@Query("SELECT appointment FROM Appointment appointment where appointment.preferredDate > :date AND appointment.preferredTime > :time ")
	public List<Appointment> getOpenAppointments(@Param("date") Date date, @Param("time") LocalTime time);
}
