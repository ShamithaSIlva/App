package com.threefold.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer
{
	@Transient
    public static final String SEQUENCE_NAME = "customer_sequence";
	
	@Id
	private long id;
	private String name;
	private String surname;
	private String initials;
	private String mobile;
	private String idNumber;
	private int lastUpdated;

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getSurname()
	{
		return surname;
	}

	public void setSurname( String surname )
	{
		this.surname = surname;
	}

	public String getInitials()
	{
		return initials;
	}

	public void setInitials( String initials )
	{
		this.initials = initials;
	}

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile( String mobile )
	{
		this.mobile = mobile;
	}

	public String getIdNumber()
	{
		return idNumber;
	}

	public void setIdNumber( String idNumber )
	{
		this.idNumber = idNumber;
	}

	public int getLastUpdated()
	{
		return lastUpdated;
	}

	public void setLastUpdated( int lastUpdated )
	{
		this.lastUpdated = lastUpdated;
	}
}
