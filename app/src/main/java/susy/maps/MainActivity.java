package susy.maps;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import nucleus.factory.RequiresPresenter;

@RequiresPresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MainPresenter> implements OnMapReadyCallback{

    //Example Valencia

    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Button btadd1;
    Button btadd2;
    Button btclear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.map);
        setUpViews();
        btadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().requestArray1();
            }
        });

        btadd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().requestArray2();
            }
        });

        btclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMap.clear();
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //BENIMACLET

    }

    public void setUpViews(){
        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        btadd1 = (Button) findViewById(R.id.btadd1);
        btadd2 = (Button) findViewById(R.id.btadd2);
        btclear = (Button) findViewById(R.id.btclear);
    }

    public void onSuccess (ArrayList<Marker> markers){
        drawMarkers(markers);
    }

    public void drawMarkers(ArrayList<Marker> markers){
        for ( int i = 0; i < markers.size();i++){
            mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(
                            markers.get(i).getLatitude(),
                            markers.get(i).getLongitude()
                    )).title(
                            markers.get(i).getDescription()
                    ));

        }
    }
}
