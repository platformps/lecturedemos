package com.github.perscholas.jpa.personaspect.personrepository;

import com.github.perscholas.DatabaseConnection;
import com.github.perscholas.config.JpaConfigurator;
import com.github.perscholas.dao.PersonJpaRepository;
import com.github.perscholas.dao.RepositoryInterface;
import com.github.perscholas.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public class FindAllTest {

    @Before
    public void setup() {
        // given
        DatabaseConnection.TESTING_DATABASE.drop(); // TODO - configure in `persistence.xml`
        DatabaseConnection.TESTING_DATABASE.create(); // TODO - configure in `persistence.xml`
        JpaConfigurator configurator = new JpaConfigurator("testing");
        configurator.appendSqlScript("testing.person_create-table.sql");
        configurator.appendSqlScript("testing.person_populate-table.sql");
        configurator.initialize();
    }

    @Test
    public void test() {
        // given
        RepositoryInterface<Long, Person> repository = new PersonJpaRepository("testing");

        // when
        List<Person> personList = repository.findAll();

        // then
        Assert.assertFalse(personList.isEmpty());
    }
}
