package controllers;

import play.*;
import play.mvc.*;
import views.html.*;
import models.Person;
import play.data.Form;
import java.util.List;

import static play.libs.Json.*;

public class Application extends Controller {

    public Result index() {
        return ok(index.render());
    }

    public Result addPerson() {
        // Person person = Form.form(Person.class).bindFromRequest().get();
        // JPA.em().persist(person);
        Person person = Form.form(Person.class).bindFromRequest().get();
        person.save();
        return redirect(routes.Application.index());
    }

    public Result getPersons() {
      List<Person> persons  = Person.FIND.findList();
        //List<Person> persons = (List<Person>) JPA.em().createQuery("select p from Person p").getResultList();
        return ok(toJson(persons));
    }
}
