package my.test.cdek.model;

import lombok.Data;

import java.util.Date;

@Data
public class App {
    private int id;
    private String phone;
    private Date created;
    private int statusId;
}
