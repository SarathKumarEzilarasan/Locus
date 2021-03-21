package models;

public class Movie {
    String _id;
    String name;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRuntimeInMinutes() {
        return runtimeInMinutes;
    }

    public void setRuntimeInMinutes(int runtimeInMinutes) {
        this.runtimeInMinutes = runtimeInMinutes;
    }

    public int getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(int budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }

    public int getBoxOfficeRevenueInMillions() {
        return boxOfficeRevenueInMillions;
    }

    public void setBoxOfficeRevenueInMillions(int boxOfficeRevenueInMillions) {
        this.boxOfficeRevenueInMillions = boxOfficeRevenueInMillions;
    }

    public int getAcademyAwardNominations() {
        return academyAwardNominations;
    }

    public void setAcademyAwardNominations(int academyAwardNominations) {
        this.academyAwardNominations = academyAwardNominations;
    }

    public int getAcademyAwardWins() {
        return academyAwardWins;
    }

    public void setAcademyAwardWins(int academyAwardWins) {
        this.academyAwardWins = academyAwardWins;
    }

    public int getRottenTomatesScore() {
        return rottenTomatesScore;
    }

    public void setRottenTomatesScore(int rottenTomatesScore) {
        this.rottenTomatesScore = rottenTomatesScore;
    }

    int runtimeInMinutes;
    int budgetInMillions;
    int boxOfficeRevenueInMillions;
    int academyAwardNominations;
    int academyAwardWins;
    int rottenTomatesScore;
}
