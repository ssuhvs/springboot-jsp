package com.lostad.app.demo.models;

import javax.persistence.*;
import java.util.Date;
/**
 * 测试bean描述
 * @author sszvip
 *
 */
@Entity(name="t_task")
public class Task {
	  /** 测试属性 注释java Doc name */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /** 测试属性 注释java Doc name */
    private String name;
    /** 测试属性 注释java Doc description */
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    private boolean finished;

    public Task(){}
    public Task(String name, String description, Date dateCreated, boolean finished) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.finished = finished;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	  /** 测试方法注释 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}


}
