package Domain;

import java.time.LocalDate;

public class Puppy {

    private String name;

    private LocalDate birthDate;

    private int weight;

    private String snack;

    public Puppy(String aName, LocalDate birthDate, int weight, String snack){
        name = aName;
        this.birthDate = birthDate;
        this.weight = weight;
        this.snack = snack;

    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate(){
        return birthDate;
    }

    public int getWeight(){
        return weight;
    }
    public String getSnack(){
        return snack;
    }
}