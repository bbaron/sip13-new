package com.springinpractice.ch13.helpdesk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
@Entity
@Table(name = "ticket_category")
public class TicketCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "ukey")
	private String key;
	
	@Column(name = "name")
	private String name;
	
	public Long getId() { return id; }
	
	public String getKey() { return key; }
	
	public String getName() { return name; }
	
	@Override
	public int hashCode() {
		final int prime = 13;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (getClass() != obj.getClass()) { return false; }
		
		TicketCategory other = (TicketCategory) obj;
		
		if (id == null) {
			if (other.id != null) { return false; }
		} else if (!id.equals(other.id)) {
			return false;
		}
		
		if (key == null) {
			if (other.key != null) { return false; }
		} else if (!key.equals(other.key)) {
			return false;
		}
		
		if (name == null) {
			if (other.name != null) { return false; }
		} else if (!name.equals(other.name)) {
			return false;
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "TicketCategory [id=" + id + ", key=" + key + ", name=" + name + "]";
	}
}
