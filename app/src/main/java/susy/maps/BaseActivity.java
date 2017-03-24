package susy.maps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import nucleus.presenter.Presenter;
import nucleus.view.NucleusAppCompatActivity;

/**
 * Created by susy on 24/03/17.
 */
public abstract class BaseActivity<P extends Presenter> extends NucleusAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        Toast.makeText(this, "Cargado guay", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        try {
            super.onResume();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public P getPresenter() {
        return (P) super.getPresenter();
    }


    protected abstract int getLayoutId();
}

