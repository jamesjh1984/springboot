package com.jin.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "website entity object")
public class Website implements Serializable {

    @ApiModelProperty(value = "website id primary key")
    private Integer id;

    @ApiModelProperty(value = "website name")
    private String name;

    @ApiModelProperty(value = "website url")
    private String url;

    @ApiModelProperty(value = "website country")
    private String country;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }



    @Override
    public String toString() {
        return "Website{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
