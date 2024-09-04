import java.time.LocalDate;

public class Consomation {

    int id ;
    LocalDate StartDate;
    LocalDate EndDate;
    float valueOfCarbon;

    public Consomation(int id,LocalDate startDate, LocalDate endDate, float value) {
        StartDate = startDate;
        EndDate = endDate;
        this.valueOfCarbon = value;
        this.id = id;
    }

    public Consomation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStartDate() {

        return StartDate;
    }

    public void setStartDate(LocalDate startDate) {

        StartDate = startDate;
    }

    public LocalDate getEndDate() {

        return EndDate;
    }

    public void setEndDate(LocalDate endDate) {

        EndDate = endDate;
    }

    public float getValueOfCarbon() {
        return valueOfCarbon;
    }

    public void setValueOfCarbon(float valueOfCarbon) {

        this.valueOfCarbon = valueOfCarbon;
    }

    public String toString() {
        return "Consomation{" +
                " id = " +  id +
                " startDate=" + StartDate +
                ", endDate=" + EndDate +
                ", valeur=" + valueOfCarbon + "kg" +
                '}';
    }
}
