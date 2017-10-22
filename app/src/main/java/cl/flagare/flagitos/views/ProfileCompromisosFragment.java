package cl.flagare.flagitos.views;


import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.flagare.flagitos.R;

/**
 * Created by arielsalas on 22-10-17.
 */
public class ProfileCompromisosFragment extends Fragment implements View.OnClickListener {


    // UI Components
    private EditText txtCompromiso;
    private EditText txtFecha;
    private Button btnCrear;



    public ProfileCompromisosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.profilefragment_tab_compromisos, null);


        // UI Components
        txtCompromiso = root.findViewById(R.id.profilefragment_tabcompromiso_txtCompromiso);
        txtFecha = root.findViewById(R.id.profilefragment_tabcompromiso_txtFecha);
        btnCrear = root.findViewById(R.id.profilefragment_tabcompromiso_btnGuardar);


        // Listeners Settings
        btnCrear.setOnClickListener(this);

        return root;
    }




    /* EVENTS */
    public void createNewCompromiso() {

        // Validate before
        if(validateInputs()) {

            // Get values
            String compromiso = txtCompromiso.getText().toString();
            String fecha = txtFecha.getText().toString();

            // Notify to user
            notify("Nuevo Compromiso!", compromiso, "Compromiso: " + compromiso + "\nFecha: " + fecha);

        }
    }


    /* NOTIFICATIONS METHODS */
    public void notify(String title, String content, String description) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(getContext())
                        .setSmallIcon(R.mipmap.logo_flame)
                        .setContentTitle(title)
                        .setContentText(content)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(description));

        NotificationManager mNotificationManager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(1, mBuilder.build());
    }


    /* BUSINESS RULES */
    public boolean validateInputs() {

        if(txtCompromiso.getText().toString().length() < 1) {
            Toast.makeText(getContext(), "Debe ingresar un compromiso", Toast.LENGTH_SHORT).show();
            return false;
        }


        if(txtFecha.getText().toString().length() < 1) {
            Toast.makeText(getContext(), "Debe ingresar una fecha", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    /* INTERFACES METHODS */
    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.profilefragment_tabcompromiso_btnGuardar:
                createNewCompromiso();
                break;
            default:
        }


    }
}
