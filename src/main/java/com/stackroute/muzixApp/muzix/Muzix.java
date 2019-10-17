package com.stackroute.muzixApp.muzix;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Muzix {

    @Id
    private int trackId;

    private String trackName;

    private String comments;


}
