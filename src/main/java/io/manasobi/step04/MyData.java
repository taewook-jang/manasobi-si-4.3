package io.manasobi.step04;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by tw.jang on 2017-03-15.
 */
@Data
@AllArgsConstructor
public class MyData {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "MyData [Id=" + id + ", name=" + name + "]";
    }
}
