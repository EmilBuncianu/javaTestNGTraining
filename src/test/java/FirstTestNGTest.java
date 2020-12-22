import org.testng.Assert;
import org.testng.annotations.Test;
import app.UserManager;

@Test
public class FirstTestNGTest {
    public void SuccessfulAddUserReturnsTrue() {
        System.out.println("This is test case1");
        //arrange
        UserManager um = new UserManager();
        //act
        boolean result = um.addUser("John@email.com");
        //assert
        Assert.assertTrue(result);


    }

    public void GetUserReceivedAddedValue() {
        System.out.println("This is test case2");
        //arrange
        UserManager um = new UserManager();
        um.addUser("John@email.com");
        //act
        String user = um.getUser("John@email.com");

        //assert
        Assert.assertEquals(user, "John@email.com");
    }


    public void NonExistingUserReturnsNull() {
        System.out.println("This is test case3");
        //arrange
        UserManager um = new UserManager();
        //act
        String user = um.getUser("John@email.com");
        //assert
        Assert.assertNull(user, "This method should return null if it can not find a user");
    }
}
