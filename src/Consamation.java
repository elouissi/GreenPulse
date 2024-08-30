import java.time.LocalDate;

public class Consamation {
    LocalDate StartDate;
    LocalDate EndDate;
    float valueOfCarbon;

    public Consamation(LocalDate startDate, LocalDate endDate, float value) {
        StartDate = startDate;
        EndDate = endDate;
        this.valueOfCarbon = value;
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
}
