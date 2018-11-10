package example.com.presentation.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import example.com.presentation.R;
import example.com.presentation.models.GithubRepositoryModel;

/**
 * Created by Mohammad Jafarzadeh Rezvan on 10/11/2018.
 */
public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    private List<GithubRepositoryModel> mModels;

    @Inject
    public ExampleAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_example, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GithubRepositoryModel model = mModels.get(position);

        holder.mNameTitle.setText(model.name);
        holder.mURLTitle.setText(model.url);
    }

    @Override
    public int getItemCount() {
        return mModels == null ? 0 : mModels.size();
    }

    public void setData(Collection<GithubRepositoryModel> githubRepositoryModels) {
        mModels = (List<GithubRepositoryModel>) githubRepositoryModels;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mNameTitle;
        TextView mURLTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameTitle = itemView.findViewById(R.id.git_name);
            mURLTitle  = itemView.findViewById(R.id.git_url);
        }
    }
}
