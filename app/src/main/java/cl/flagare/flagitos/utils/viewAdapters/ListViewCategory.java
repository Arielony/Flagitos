package cl.flagare.flagitos.utils.viewAdapters;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

import cl.flagare.flagitos.utils.dataAdapters.ListViewUtilities;

/**
 * Created by arielsalas on 25-10-17.
 */

public class ListViewCategory extends ListView {


    public ListViewCategory(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        ListViewUtilities.setListViewHeightBasedOnChildren(this);

        super.onDraw(canvas);
    }
}
