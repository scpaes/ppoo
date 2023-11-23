package Strategy;


interface DisplayWeekday {
    void display();
}

class Monday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Monday");
    }
}

class Tuesday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Tuesday");
    }
}

class Wednesday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Wednesday");
    }
}

class Thursday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Thursday");
    }
}

class Friday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Friday");
    }
}

class Saturday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Saturday");
    }
}

class Sunday implements DisplayWeekday {
    @Override
    public void display() {
        System.out.println("Sunday");
    }
}

public class Weekday {
    private DisplayWeekday displayWeekday;

    public Weekday(DisplayWeekday displayWeekday) {
        this.displayWeekday = displayWeekday;
    }

    public static void main(String[] displayWeekdayargs) {
        Weekday monday = new Weekday(new Monday());
        monday.display();

        Weekday tuesday = new Weekday(new Tuesday());
        tuesday.display();

        Weekday wednesday = new Weekday(new Wednesday());
        wednesday.display();

        Weekday thursday = new Weekday(new Thursday());
        thursday.display();

        Weekday friday = new Weekday(new Friday());
        friday.display();

        Weekday saturday = new Weekday(new Saturday());
        saturday.display();

        Weekday sunday = new Weekday(new Sunday());
        sunday.display();
    }

    public void setDisplayWeekday(DisplayWeekday displayWeekday) {
        this.displayWeekday = displayWeekday;
    }

    public void display() {
        displayWeekday.display();
    }
}
