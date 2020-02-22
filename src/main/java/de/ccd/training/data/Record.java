package de.ccd.training.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Record {

    private List<String> values = new ArrayList<>();

    public Record(String... values){
        this.values = Arrays.asList(values);
    }
}
