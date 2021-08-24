package main.ug.kamilw.model;

public class Wartosc {
    private double _wartosc;

    public Wartosc(){};
    public Wartosc(double wartosc){
        this._wartosc = wartosc;
    }
    public  double getWartosc(){
        return _wartosc;
    }
    public void setWartosc(double wartosc){
        this._wartosc = wartosc;
    }

    @Override
    public String toString() {
        return String.format("Wartosc [%.5f]", _wartosc);
    }
}
