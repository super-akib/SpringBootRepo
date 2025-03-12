package com.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Component("team")
@ConfigurationProperties(prefix = "team")
@Setter
@Getter
@ToString
@Profile({"india","england","southafrica","australia"})
public class Team {
     private Integer teamId;
     private String teamName;
     private String teamCoach;
     private Integer foundedYear;
}
