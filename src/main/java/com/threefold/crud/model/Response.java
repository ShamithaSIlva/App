package com.threefold.crud.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Response")
public class Response
{
	@Id
	private long id;
	private int code;
	private String status;
	private String message;
	private List<Customer> payload;

	public long getId()
	{
		return id;
	}

	public void setId( long id )
	{
		this.id = id;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode( int code )
	{
		this.code = code;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus( String status )
	{
		this.status = status;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

	public List<Customer> getPayload()
	{
		return payload;
	}

	public void setPayload( List<Customer> payload )
	{
		this.payload = payload;
	}
}
