package entities.issues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import entities.projects.Project;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonRootName(value = "issue")

public class Issue {

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private long id;

    private String summary;
    private String description;

    @JsonIgnoreProperties(value = "enabled")
    private Project project;

    private Category category;
    private Attachment[] files;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private IssueStatus status;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Handler handler;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private Priority priority;


}
