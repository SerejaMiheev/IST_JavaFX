package gw;

import models.Person;

public class PersonGateway extends SimpleGateway<Person> {
    public PersonGateway() {
        this.insert(new Person("Сыропоршнев Феликс Самуилович",1));
        this.insert(new Person("Никологорский Григорий Богданович",2));
        this.insert(new Person("Яшуков Лев Измаилович",3));
        this.insert(new Person("Юракин Платон Прокофиевич",4));
        this.insert(new Person("Галиаскарова Эмилия Тихоновна",5));
    }
}
