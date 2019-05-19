package com.habuma.spittr.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties("time")
public class Spittle implements Serializable {
	  private static final long serialVersionUID = 1563056272025335248L;
  private Long id;
  private String message;
  private LocalDate time;
  private Double latitude;
  private Double longitude;
public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public void setMessage(String message) {
	this.message = message;
}


public void setTime(LocalDate time) {
	this.time = time;
}

public void setLatitude(Double latitude) {
	this.latitude = latitude;
}



public void setLongitude(Double longitude) {
	this.longitude = longitude;
}



public Spittle(String message,LocalDate date) {

	
	this(message,date,null,null);
}



public Spittle(String message, LocalDate time, Double latitude, Double longitude) {
 id=null;
	this.message = message;
	this.time = time;
	this.latitude = latitude;
	this.longitude = longitude;
}



public Spittle() {
	this(null, null);
	
	// TODO Auto-generated constructor stub
}

public String getMessage() {
	return message;
}
public LocalDate getTime() {
	return time;
}
public Double getLatitude() {
	return latitude;
}
public Double getLongitude() {
	return longitude;
}

@Override
public String toString() {
	return "Spittle [id=" + id + ", message=" + message + ", time=" + time + ", latitude=" + latitude + ", longitude="
			+ longitude + "]";
}

  
}
