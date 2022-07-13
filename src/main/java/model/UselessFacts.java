package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UselessFacts {
    private String id;
    private String text;
    private String source;
    private String source_url;
    private String language;
    private String permalink;
}
