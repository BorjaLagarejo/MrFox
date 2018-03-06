package es.dam.mrfox;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

public class MyMain extends AppCompatActivity {

    SwipeRefreshLayout mSwRellay;
    private View RltContenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSwRellay = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        mSwRellay.setOnRefreshListener(refrescarVista);
        RltContenedor = findViewById(R.id.contenedor);

    }
    
    protected SwipeRefreshLayout.OnRefreshListener refrescarVista = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Snackbar mySnackbar = Snackbar.make(RltContenedor,"Lost your FOX?",Snackbar.LENGTH_LONG);
            mySnackbar.setAction("UNDO", new MyUndoListener());
            mySnackbar.show();
            mSwRellay.setRefreshing(false);
        }
    };

    public class MyUndoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {

            // Code to undo the user's last action
        }
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_my_main,menu);
        return true;
    }
}
