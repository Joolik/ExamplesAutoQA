package entities.issues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import utils.HelperFiles;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Attachment {

    private String name;
    private String content;

    public Attachment(String filePath, String name) {
        this.name = name;
        this.content = HelperFiles.convertFileToBase64(filePath + name);
    }

}
