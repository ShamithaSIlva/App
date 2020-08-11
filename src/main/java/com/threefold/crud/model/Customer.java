package com.threefold.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
public class Customer
{
	@Id
	private long id;
	private String name;
	private String surName;
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

	public String getSurName()
	{
		return surName;
	}

	public void setSurName( String surName )
	{
		this.surName = surName;
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
