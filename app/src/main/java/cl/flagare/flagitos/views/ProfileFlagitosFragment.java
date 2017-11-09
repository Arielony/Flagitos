package cl.flagare.flagitos.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MotionEvent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.flagare.flagitos.R;

/**
 * Created by arielsalas on 22-10-17.
 */

public class ProfileFlagitosFragment extends Fragment implements View.OnClickListener,
        SearchView.OnQueryTextListener,
        AdapterView.OnItemClickListener,
        View.OnTouchListener {


    // UI Components
    private SearchView search;
    private ListView list;
    private EditText txtCategoria;
    private Button btnGracias;
    private Button btnDevolver;


    // Variables
    private String[] arrayCategories;



    public ProfileFlagitosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the view for this Fragment
        View root = inflater.inflate(R.layout.profilefragment_tab_flagitos, null);


        // UI Components
        search = root.findViewById(R.id.profilefragment_tabflagitos_searchCategoria);
        list = root.findViewById(R.id.profilefragment_tabflagitos_listcategoria);
        txtCategoria = root.findViewById(R.id.profilefragment_tabflagitos_txtCategoria);
        btnGracias = root.findViewById(R.id.profilefragment_tabflagitos_btnGracias);
        btnDevolver = root.findViewById(R.id.profilefragment_btn_btnDevolver);

        // Adapting DATA
        arrayCategories = getResources().getStringArray(R.array.ArrayCategorias);

        // Search Config
        setupSearchView();

        // List Config
        list.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayCategories));
        list.setTextFilterEnabled(true);
        list.setOnItemClickListener(this);
        list.setOnTouchListener(this);

        // Btn Config
        btnDevolver.setOnClickListener(this);
        btnGracias.setOnClickListener(this);

        return root;
    }


    private void setupSearchView() {
        search.setIconifiedByDefault(false);
        search.setOnQueryTextListener(this);
        search.setSubmitButtonEnabled(false);
        search.setSuggestionsAdapter(null);
        search.setQueryHint("Buscar Categoria");
        search.clearFocus();
    }


    /* SEARCH FILTERS */
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            list.clearTextFilter();
        } else {
            list.setFilterText(newText.toString());
        }
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

        String seleccion = (String) list.getItemAtPosition(position);
        txtCategoria.setText(seleccion);

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        // Disallow the touch request for parent scroll on touch of
        // child view
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.profilefragment_tabflagitos_btnGracias:
                Toast.makeText(getContext(), "Haz dado Gracias!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.profilefragment_btn_btnDevolver:
                Toast.makeText(getContext(), "Devuelve el favor...", Toast.LENGTH_SHORT).show();

                break;
            default:
        }
    }
}
