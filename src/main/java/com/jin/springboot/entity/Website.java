package com.jin.springboot.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@ApiModel(description = "website entity object")
public class Website implements Serializable {

    @ApiModelProperty(value = "website id primary key")
    @NotBlank(message = "Website id can not be null!")
    private Integer id;

    @ApiModelProperty(value = "website name")
    @NotBlank(message = "Website name can not be null!")
    private String name;

    @ApiModelProperty(value = "website url")
    @NotBlank(message = "Website url can not be null!")
    private String url;

    @ApiModelProperty(value = "website country")
    @NotBlank(message = "Website country can not be null!")
    private String country;



    public Website(Integer id, String name, String url, String country) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.country = country;
    }


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
