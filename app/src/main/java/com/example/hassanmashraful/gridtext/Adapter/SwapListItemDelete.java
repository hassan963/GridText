package com.example.hassanmashraful.gridtext.Adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Hassan M.Ashraful on 9/17/2016.
 */
public class SwapListItemDelete extends ItemTouchHelper.SimpleCallback {

    private ListAdapter listAdapter;

    public SwapListItemDelete(ListAdapter listAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.listAdapter = listAdapter;

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        listAdapter.remove(viewHolder.getAdapterPosition());

    }
}
