package entities.projects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonRootName(value = "project")

public class Project {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT) // не отсылать id
    private long id;

    private String name;
    private String description;
    private boolean enabled;
    private ProjectStatus status;

    @JsonProperty("view_state")
    private ProjectViewState viewState;

    @JsonProperty("file_path")
    private String filePath;

}
