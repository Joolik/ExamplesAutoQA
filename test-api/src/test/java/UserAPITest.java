import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import data.TestData;
import entities.users.User;
import requests.UserRequests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static requests.BaseRequests.getResponseObject;

public class UserAPITest {

    private long userId;

    private UserRequests reqUser;

    @BeforeClass
    public void setUpProject() {
        reqUser = new UserRequests();
    }

    /*
     * Создание пользователя (двух пользователей)
     */
    @Test(dataProvider = "userDataProvider", dataProviderClass = TestData.class)
    public void addUserTest(final User user) {
        Response response = reqUser.addUser(user);
        response.then()
                .log().status()
                .statusCode(201)
                .statusLine(containsString("User created with id"));
        User responseUser = getResponseObject(response.getBody().asString(), User.class);

        assertThat(user.getUsername(), equalTo(responseUser.getUsername()));
        assertThat(user.getRealName(), equalTo(responseUser.getRealName()));
        assertThat(user.getEmail(), equalTo(responseUser.getEmail()));

        userId = responseUser.getId();
    }

    /*
     * Удаление последнего пользователя, созданного в тесте "addUserTest"
     */
    @Test(dependsOnMethods = "addUserTest")
    public void deleteUserTest() {
        reqUser.deleteUser(userId)
        .then()
                .log().status()
                .statusCode(204);
    }

    /*
     * Удаление несуществующего пользователя (пользователя, удаленного ранее в тесте "deleteUserTest")
     */
    @Test(dependsOnMethods = "deleteUserTest")
    public void deleteUserNonExistTest() {
        reqUser.deleteUser(userId)
                .then()
                .log().status()
                .statusCode(404)
                .statusLine(containsString("not found"));
    }

}
