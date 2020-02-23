package de.ccd.training.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Column {

    private List<String> cells = new ArrayList<>();

    public Column(String ... cells){
        this(List.of(cells));
    }

}
