package com.MowItNow.mower.entities;

import com.MowItNow.mower.enumeration.Orientation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Mower {
    private Coordonnees coordonnees;
    private Orientation orientation;
}
