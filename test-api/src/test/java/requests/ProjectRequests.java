package requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import entities.projects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectRequests extends BaseRequests {

    private static final String PROJECT_ENDPOINT = "/projects/";
    private static final String SUBPROJECT_ENDPOINT = "/projects/{project_id}/subprojects";


    public Response addProject(Project project) {
        return given()
                .spec(getRequestSpecificationWithBody(project))
                .when()
                .post(PROJECT_ENDPOINT);
    }

    public Response addSubproject(SubProject subProject, long mainProjectId) {
        Map<String, Long> mapPathParams = new HashMap<>();
        mapPathParams.put("project_id", mainProjectId);
        return given()
                .spec(getRequestSpecificationWithBody(subProject, mapPathParams))
                .when()
                .post(SUBPROJECT_ENDPOINT);
    }

    public Response deleteProject(long projectId) {
        return given()
                .spec(getRequestSpecification())
                .pathParam("project_id", projectId)
                .when()
                .delete(PROJECT_ENDPOINT + "{project_id}");
    }

    private Response getAllProjects() {
        return given()
                .spec(getRequestSpecification())
                .when()
                .get(PROJECT_ENDPOINT);
    }

    public long getMaxProjectId() {

        Response response = getAllProjects();

        response.then()
                .statusCode(200);

        JsonPath jsonPath = new JsonPath(response.asString());

        // Получить список всех id проектов
        List<Integer> projectIdList = jsonPath.getList("projects.id");
        if (projectIdList.isEmpty()) {
            return 0;
        } else {
            projectIdList.sort(Integer::compareTo);
            return projectIdList.get(projectIdList.size() - 1);
        }
    }

}
