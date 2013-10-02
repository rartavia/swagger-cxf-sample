package com.seed.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@ApiModel(value = "A system user")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class User {
    @XmlElement
    @ApiModelProperty(value = "User's ID", required = true)
    private Long id;
    @XmlElement
    @ApiModelProperty(value = "User's email", required = true)
    private String email;
    @XmlElement
    @ApiModelProperty(value = "User's first name", required = true)
    private String firstName;
    @XmlElement
    @ApiModelProperty(value = "User's last name", required = true)
    private String lastName;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
