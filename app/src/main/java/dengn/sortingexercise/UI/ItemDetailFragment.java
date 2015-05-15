package dengn.sortingexercise.UI;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import dengn.sortingexercise.R;
import dengn.sortingexercise.Sort.BubbleSort;
import dengn.sortingexercise.Sort.HeapSort;
import dengn.sortingexercise.Sort.InsertionSort;
import dengn.sortingexercise.Sort.MergeSort;
import dengn.sortingexercise.Sort.QuickSort;
import dengn.sortingexercise.Sort.RadixSort;
import dengn.sortingexercise.Sort.SelectionSort;
import dengn.sortingexercise.Sort.ShellSort;
import dengn.sortingexercise.Utils.Constant;
import dengn.sortingexercise.Utils.RandomUtils;
import dengn.sortingexercise.dummy.DummyContent;
import dengn.sortingexercise.models.SortResult;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    private Context context;

    /**
     * The list id this fragment is related.
     */
    private String id;

    private int[] randomArrayValues;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            id = getArguments().getString(ARG_ITEM_ID);
        }
    }

    @Override
    public void onAttach(Activity activity){
        context = activity;
        super.onAttach(activity);
    }

    private SortResult sortFunction(String id, int[] array){
        int idValue = Integer.valueOf(id);
        switch (idValue){
            case 1:
                return InsertionSort.InsertionSortProposed(array);
            case 2:
                return ShellSort.ShellSort(array);
            case 3:
                return SelectionSort.SelectionSort(array);
            case 4:
                return HeapSort.HeapSort(array);
            case 5:
                return BubbleSort.BubbleSort(array);
            case 6:
                return QuickSort.QuickSort(array);
            case 7:
                return MergeSort.MergeSort(array);
            case 8:
                return RadixSort.RadixSort(array);
            default:
                return new SortResult(array, 0);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_item_detail, container, false);
        //UI init
        final TextView randomArray = (TextView) rootView.findViewById(R.id.random_array);
        final TextView sortedArray = (TextView) rootView.findViewById(R.id.sorted_array);
        final TextView sortedTime = (TextView) rootView.findViewById(R.id.sorted_time);
        Button randomArrayGenerate = (Button) rootView.findViewById(R.id.random_array_generate);
        Button sort = (Button) rootView.findViewById(R.id.sort);

        sort.setText(DummyContent.ITEM_MAP.get(id).toString());

        sort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(randomArrayValues==null){
                    Toast.makeText(context, "Please firstly generate Random Array", Toast.LENGTH_SHORT).show();
                }
                else if(randomArrayValues.length==0){
                    Toast.makeText(context, "Please firstly generate Random Array", Toast.LENGTH_SHORT).show();
                }
                else {
                    SortResult sortResult = sortFunction(id, randomArrayValues);
                    sortedArray.setText(RandomUtils.getRandomArrayString(sortResult.getArray()));
                    sortedTime.setText(String.valueOf(sortResult.getTime()) + "ns");
                }
            }
        });

        //Generate random array list
        randomArrayGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomMin = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("min_value", String.valueOf(Constant.RANDOM_MIN)));
                int randomMax = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("max_value", String.valueOf(Constant.RANDOM_MAX)));
                int arrayNumber = Integer.parseInt(PreferenceManager.getDefaultSharedPreferences(context).getString("array_num", String.valueOf(Constant.RANDOM_NUMBER)));
                randomArrayValues = RandomUtils.randomCommon(randomMin, randomMax, arrayNumber);
                randomArray.setText(RandomUtils.getRandomArrayString(randomArrayValues));
            }
        });



        return rootView;
    }
}
