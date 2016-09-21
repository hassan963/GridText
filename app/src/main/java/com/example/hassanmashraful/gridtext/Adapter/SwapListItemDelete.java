package com.example.hassanmashraful.gridtext.Adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.hassanmashraful.gridtext.FragmentView.FragmentListView;

/**
 * Created by Hassan M.Ashraful on 9/17/2016.
 */
public class SwapListItemDelete extends ItemTouchHelper.SimpleCallback {

    private ListAdapter listAdapter;
    private FragmentListView fragmentListView;

    public SwapListItemDelete(ListAdapter listAdapter, FragmentListView fragmentListView) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.listAdapter = listAdapter;
        this.fragmentListView = fragmentListView;


    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        listAdapter.remove(viewHolder.getAdapterPosition());
        fragmentListView.showFOOD();
    }
}
