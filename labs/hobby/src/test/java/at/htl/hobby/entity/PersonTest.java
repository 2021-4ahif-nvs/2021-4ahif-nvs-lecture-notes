package at.htl.hobby.entity;

import io.quarkus.test.junit.QuarkusTest;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PersonTest {

    /**
     * the logger works only when tests are running in a quarkus instance (@QuarkusTest)
     */
    private static final Logger log = Logger.getLogger(PersonTest.class.getSimpleName());

    @DisplayName("Insert hobby into person")
    @Test
    void t010_insertHobby() {
        Person susi = new Person("Susi");
        Hobby netflixen = new Hobby("NETFLIX", "watch Netflix, ...");

        susi.setHobby(netflixen);
        //netflixen.addPerson(susi);

        assertThat(netflixen.getPersons()).hasSize(1);
        assertThat(susi.getHobby()).isEqualTo(netflixen);

        for (Person person : netflixen.getPersons()) {
            log.info("->" + person);
            System.out.println(person);
        }
    }


    @DisplayName("Delete Hobby from Person")
    @Test
    void t020_deleteHobby() {
        Person susi = new Person("Susi");
        Hobby netflixen = new Hobby("NETFLIX", "watch Netflix, ...");

        susi.setHobby(netflixen);
        assertThat(netflixen.getPersons()).hasSize(1);
        assertThat(susi.getHobby()).isEqualTo(netflixen);

        susi.setHobby(null);
        assertThat(netflixen.getPersons()).hasSize(0);
        assertThat(susi.getHobby()).isNull();
    }

    @DisplayName("Update Hobby from Person")
    @Test
    void t030_updateHobby() {
        Person susi = new Person("Susi");
        Hobby netflixen = new Hobby("NETFLIX", "watch Netflix, ...");

        susi.setHobby(netflixen);
        assertThat(netflixen.getPersons()).hasSize(1);
        assertThat(susi.getHobby()).isEqualTo(netflixen);

        Hobby gamblen = new Hobby("GAMBLE", "power player");
        susi.setHobby(gamblen);
        assertThat(netflixen.getPersons()).hasSize(0);
        assertThat(gamblen.getPersons()).hasSize(1);
        assertThat(gamblen.getPersons()).contains(susi);
        assertThat(susi.getHobby()).isEqualTo(gamblen);
    }

}
