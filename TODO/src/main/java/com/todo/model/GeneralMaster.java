package com.todo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "generalId", "generalTypeId" }))
@Entity
public class GeneralMaster {

	@Id
	private int id;
	private Short generalId;
	private String generalTypeId;
	private String generalName;
	private String generalDescrption;

	public Short getGeneralId() {
		return generalId;
	}

	public void setGeneralId(Short generalId) {
		this.generalId = generalId;
	}

	public String getGeneralTypeId() {
		return generalTypeId;
	}

	public void setGeneralTypeId(String generalTypeId) {
		this.generalTypeId = generalTypeId;
	}

	public String getGeneralName() {
		return generalName;
	}

	public void setGeneralName(String generalName) {
		this.generalName = generalName;
	}

	public String getGeneralDescrption() {
		return generalDescrption;
	}

	public void setGeneralDescrption(String generalDescrption) {
		this.generalDescrption = generalDescrption;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GeneralMaster [generalId=").append(generalId).append(", generalTypeId=").append(generalTypeId)
				.append(", generalName=").append(generalName).append(", generalDescrption=").append(generalDescrption)
				.append("]");
		return builder.toString();
	}

}
