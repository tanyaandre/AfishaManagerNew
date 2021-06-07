package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AfishaItem {
    private int movieId;
    private String movieName;
    private String movieUrl;
    private String movieGenre;
}
