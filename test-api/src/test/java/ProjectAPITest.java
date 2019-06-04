import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.TestData;
import entities.projects.*;
import requests.ProjectRequests;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static requests.BaseRequests.getResponseObject;

public class ProjectAPITest {

    private ProjectRequests reqProject;

    @BeforeClass
    public void setUpProject() {
        reqProject = new ProjectRequests();
    }

    /*
     *  Создание проекта
     */
    @Test(dataProvider = "projectDataProvider", dataProviderClass = TestData.class)
    public void addProjectTest(final Project project)  {
        Response response = reqProject.addProject(project);
        response.then()
                .log().status()
                .statusCode(201);
        Project responseProject = getResponseObject(response.getBody().asString(), Project.class);

        assertThat(project.getName(), equalTo(responseProject.getName()));
    }


    /*
     *  Создание подпроекта.
     *  Создаются 2 проекта. Второй проект добавляется как подпроект в первый проект.
     */
    @Test
    public void addSubprojectTest() {

        List<Project> projectsList = TestData.subprojectData();
        assertThat("Неверные тестовые данные", projectsList.size(), greaterThanOrEqualTo(2));

        // Создание первого проекта
        Response responseMainProject = reqProject.addProject(projectsList.get(0));
        responseMainProject.then()
                .statusCode(201);
        Project projectMain = getResponseObject(responseMainProject.getBody().asString(), Project.class);

        // Создание второго проекта
        Response responseSubProject = reqProject.addProject(projectsList.get(1));
        responseSubProject.then()
                .statusCode(201);
        Project projectSub = getResponseObject(responseSubProject.getBody().asString(), Project.class);

        // Создание объекта SubProject
        Project project = new Project();
        project.setName(projectSub.getName());
        SubProject subProject = new SubProject();
        subProject.setProject(project);
        subProject.setInheritParent(true);

        // Добавление проекта projectSub в проект projectMain
        Response response = reqProject.addSubproject(subProject, projectMain.getId());
        String resStatusLine = response
                .then()
                .log().status()
                .statusCode(204)
                .extract()
                .statusLine();
        String substring = "Subproject '" + projectSub.getId() + "' added to project '" + projectMain.getId() + "'";
        assertThat(resStatusLine, containsString(substring));
    }

    /*
     *  Удаление несуществующего проекта
     */
    @Test
    public void deleteProjectNonExistTest() {
        reqProject.deleteProject(reqProject.getMaxProjectId() + 100)
                .then()
                .log().status()
                .statusCode(403);
    }
}
