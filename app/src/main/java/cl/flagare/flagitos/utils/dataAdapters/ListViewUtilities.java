package cl.flagare.flagitos.utils.dataAdapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * Created by arielsalas on 25-10-17.
 */

public class ListViewUtilities {

    /*
        * Uses an ListView to resize it height to full content
        * of each inner View on Adapter
         */
    public static void setListViewHeightBasedOnChildren(ListView lista) {
        ListAdapter adapter = lista.getAdapter();
        if(adapter == null) {
            return;
        }

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(lista.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;

        View view = null;
        for(int i = 0; i < adapter.getCount(); i++) {
            view = adapter.getView(i, view, lista);
            if(i == 0) {
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));
            }
            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();

        }
        ViewGroup.LayoutParams params = lista.getLayoutParams();
        params.height = totalHeight + (lista.getDividerHeight() * (adapter.getCount() - 1));
        lista.setLayoutParams(params);
    }

}
