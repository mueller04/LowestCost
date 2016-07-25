package com.example.mike.lowestcostpathandroid;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class GridFragment extends Fragment {

    private ArrayAdapter<String> gridAdapter;
    Grid grid1;
    Grid grid2;
    Grid grid3;
    AlertDialog.Builder alertBuilder;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        alertBuilder = new AlertDialog.Builder(getActivity());

        gridAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.list_grid,
                R.id.list_grid_textview);

        View rootView = inflater.inflate(R.layout.fragment_grid, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.listview_grid);
        listView.setAdapter(gridAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                Grid grid;
                String gridStr = gridAdapter.getItem(position);
                if (gridStr == grid1.getGridString()) {
                    grid = grid1;
                } else if (gridStr == grid2.getGridString()) {
                    grid = grid2;
                } else if (gridStr == grid3.getGridString()) {
                    grid = grid3;
                } else {
                    grid = null;
                }

                PathResult pathResult = Path.navigate(grid.getGridArray());
                String message = pathResult.toString();

                alertBuilder.setTitle("Path Navigation Results");
                alertBuilder.setMessage(message);
                AlertDialog dialog = alertBuilder.create();
                dialog.show();
                dialog.setCanceledOnTouchOutside(true);
            }
        });
        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();
        createGrid();
    }

    @Override
    public void onPause() {
        gridAdapter.clear();
    }

    private void createGrid() {
        grid1 = Grid.createGrid(5, 5);
        grid2 = Grid.createGrid(5, 5);
        grid3 = Grid.createGrid(5, 5);

        gridAdapter.add(grid1.getGridString());
        gridAdapter.add(grid2.getGridString());
        gridAdapter.add(grid3.getGridString());
    }
}
