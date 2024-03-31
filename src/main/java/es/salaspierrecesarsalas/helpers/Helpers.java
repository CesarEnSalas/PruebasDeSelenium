package es.salaspierrecesarsalas.helpers;

public class Helpers {

    public void dormir(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
