package ru.wenn.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.wenn.springcourse.models.Book;
import ru.wenn.springcourse.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person(FIO, yearOfBirth) VALUES(?, ?)", person.getFIO(), person.getYearOfBirth());
    }

    public Optional<Person> getPersonByFullName(String FIO) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE FIO=?", new Object[]{FIO},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Person updatedPerson) {
        jdbcTemplate.update("UPDATE Person SET FIO=?, yearOfBirth=? WHERE id=?", updatedPerson.getFIO(),
                updatedPerson.getYearOfBirth() ,id);
    }

    public List<Book> getBooksByPersonId(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class));
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
