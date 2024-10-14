package com.example.stars.adapter;

import static android.provider.MediaStore.Images.Media.getBitmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.stars.R;
import com.example.stars.beans.Star;
import com.example.stars.service.StarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StartAdapter extends RecyclerView.Adapter<StartAdapter.StartViewHolder> implements Filterable {
    private static final String TAG = "StarAdapter";
   private List<Star> stars;
   private  List<Star> starsFilter;

    private Context context;
    private NewFilter mfilter;

    public StartAdapter(List<Star> stars, Context context) {
        this.stars = stars;
        this.context = context;
        this.starsFilter=new ArrayList<>();
        this.mfilter=new NewFilter(this);
    }

    @NonNull
    @Override

    public StartAdapter.StartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(R.layout.start_item, parent, false);
        final StartViewHolder holder = new StartViewHolder(v);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View popup = LayoutInflater.from(context).inflate(R.layout.start_edit_item, null,false);


                final ImageView img = popup.findViewById(R.id.image);
                final RatingBar bar = popup.findViewById(R.id.star);
                final TextView idss = popup.findViewById(R.id.idss);

                Bitmap bitmap = ((BitmapDrawable) holder.img.getDrawable()).getBitmap();
                img.setImageBitmap(bitmap);

                bar.setRating(holder.stars.getRating());
                idss.setText(String.valueOf(holder.getAdapterPosition()));

                AlertDialog dialog = new AlertDialog.Builder(context)
                        .setTitle("Noter :")
                        .setMessage("Noter de 1 à 5 étoiles")
                        .setView(popup)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {


                                float newRating = bar.getRating();

                                int id = Integer.parseInt(idss.getText().toString());

                                Star star = StarService.getInstance().findById(id);
                                System.out.println(star);

                                star.setStar(newRating);
                                StarService.getInstance().update(star);

                                notifyItemChanged(holder.getAdapterPosition());

                            }
                        })

                        .setNegativeButton("Annuler", null)
                        .create();

                dialog.show();
            }
        });

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull StartAdapter.StartViewHolder holder, int position) {
             Log.d(TAG,"onBindView !"+position );
        Glide.with(context)
                .asBitmap().
                load(starsFilter.get(position).getImg())
                .apply(new RequestOptions().override(100,100))
                .into(holder.img);
        holder.name.setText(starsFilter.get(position).getName());
        holder.stars.setRating(starsFilter.get(position).getStar());

    }

    @Override
    public int getItemCount() {
        return starsFilter.size();
    }

    @Override
    public Filter getFilter() {
        return mfilter;
    }

    public class StartViewHolder extends RecyclerView.ViewHolder {
        TextView idss;
        TextView name;
        RatingBar stars;
        ImageView img;
        RelativeLayout parent;
         public StartViewHolder(@NonNull View itemView){
             super(itemView);
             name=itemView.findViewById(R.id.name);
             stars=itemView.findViewById(R.id.star);
             img=itemView.findViewById(R.id.image);
             parent=itemView.findViewById(R.id.parent);
             idss=itemView.findViewById(R.id.ids);
         }

    }
    public class NewFilter extends Filter {
        public RecyclerView.Adapter mAdapter;
        public NewFilter(RecyclerView.Adapter mAdapter) {
            super();
            this.mAdapter = mAdapter;
            starsFilter.addAll(stars);
        }
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            starsFilter.clear();
            final FilterResults results=new FilterResults();
            if(constraint.length()==0){
                starsFilter.addAll(stars);
            }else{
                final String filterParttern=constraint.toString().toLowerCase().trim();
                for(Star p :stars){
                    if(p.getName().toLowerCase().startsWith(filterParttern)){
                       starsFilter.add(p);
                    }
                }


            }
            results.values=starsFilter;
            results.count=starsFilter.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                       starsFilter =(List<Star>) results.values;
                       this.mAdapter.notifyDataSetChanged();

        }
    }

}
