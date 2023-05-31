package person.man;

import com.rd.world.Man;
import com.rd.world.Person;
import dataProviders.TestDataProviderMan;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManIsRetiredTest {
    private Man men;
    private Man menSecond;

//    @BeforeClass
//    public void addNewMenObject(){
//        Person partner = new Woman("Marta", "Kosenko", 59, men, "Kosenko");
//        Person partnerSecond = new Woman("Alina", "Lysenko", 50, menSecond, "maidenAlina");
//        men = new Man("Dmytro", "Shevchenko", 65, partner);
//        menSecond = new Man("Yaroslav", "Lysenko", 55, partnerSecond);
//    }
    //test is retired
    @Test(dataProvider = "menAfterRetired", dataProviderClass = TestDataProviderMan.class, groups = {"TestIsRetired"})
    public void testIsRetired(String firstName, String lastName, int age, Person partner){
        men = new Man(firstName, lastName, age, partner);
        Assert.assertTrue(men.isRetired(), "Статус перевірки isRetired повинен бути true");
    }

    //test is not retired
    @Test(dataProvider = "menBeforeRetired", dataProviderClass = TestDataProviderMan.class, groups = {"TestIsNotRetired"})
    public void testIsNotRetired(String firstName, String lastName, int age, Person partner){
        menSecond = new Man(firstName, lastName, age, partner);
        Assert.assertFalse(menSecond.isRetired(), "Статус перевірки isRetired повинен бути false");
    }
}
