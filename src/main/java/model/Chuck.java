package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
@Data
public class Chuck {
    ArrayList<Object> categories = new ArrayList<>();
    private String icon_url;
    private String id;
    private String url;
    private String value;
}
