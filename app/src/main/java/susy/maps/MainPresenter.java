package susy.maps;

import java.util.ArrayList;

import nucleus.presenter.Presenter;

/**
 * Created by susy on 24/03/17.
 */

public class MainPresenter extends Presenter<MainActivity> {

    private ArrayList<Marker> markers;

    public ArrayList<Marker> getMarkers1(){
        markers = new ArrayList<>();
        markers.add(new Marker(39.4872,-0.36,"marker1"));
        markers.add(new Marker(39.4732,-0.37,"marker1"));
        markers.add(new Marker(39.4972,-0.35,"marker1"));
        markers.add(new Marker(39.4832,-0.3678,"marker1"));
        return markers;

    }

    public ArrayList<Marker> getMarkers2(){
        markers = new ArrayList<>();
        markers.add(new Marker(39.4872,-0.3623,"marker2"));
        markers.add(new Marker(39.4899,-0.37123,"marker2"));
        markers.add(new Marker(39.4672,-0.3543,"marker2"));
        return markers;

    }

    public void requestArray1(){
        ArrayList<Marker> list = getMarkers1();
        getView().onSuccess(list);
    }

    public void requestArray2(){
        ArrayList<Marker> list = getMarkers2();
        getView().onSuccess(list);
    }


}
