package org.learning.basic_template.model;

import java.time.LocalDateTime;

public abstract class Auditable<T> implements Identifiable<T> {

	private T id;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime createdOn;
	private LocalDateTime modifiedOn;
	
	
	@Override
	public T getId() {
		return id;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
}
