package spring.model;

import java.time.LocalDate;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"latitude"})
public class Spittle {
  private Long id;
  private String message;
 // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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



public Spittle(String message, LocalDate date) {

	
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
public boolean equals(Object arg0) {
	// TODO Auto-generated method stub
	return EqualsBuilder.reflectionEquals(this,arg0, "id","time");
}



@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return HashCodeBuilder.reflectionHashCode(this,"id","time");
}

  
}
