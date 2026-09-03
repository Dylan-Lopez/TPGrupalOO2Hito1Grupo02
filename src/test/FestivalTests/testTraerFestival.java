package test.FestivalTests;


import datos.Festival;
import negocio.FestivalABM;

public class testTraerFestival {
	
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        Festival f = abm.traer(1);
        System.out.println(f);
    }
	
}
