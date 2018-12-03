package com.dicoding.crips.katalogkomik;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.dicoding.crips.katalogkomik.R.id.btn_set_details;

public class CardViewKomikAdapter extends RecyclerView.Adapter<CardViewKomikAdapter.CardViewViewHolder> {
    private ArrayList<Komik> listKomik;
    private Context context;

    public CardViewKomikAdapter(Context context)
    {
        this.context = context;
    }

    public ArrayList<Komik> getListKomik()
    {
        return listKomik;
    }

    public void setListKomik(ArrayList<Komik> listKomik)
    {
        this.listKomik = listKomik;
    }

    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_komik, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CardViewViewHolder holder, int position) {
        Komik ko = getListKomik().get(position);

        Glide.with(context)
                .load(ko.getPhoto())
                .override(350,350)
                .into(holder.imgPhoto);

        holder.tvName.setText(ko.getName());
        holder.tvWriter.setText(ko.getWriter());
        holder.tvPrice.setText(ko.getPrice());
        holder.tvUrl.setText(ko.getURL());

        holder.btDetails.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Intent moveWithDataIntent = new Intent(view.getContext(), detail_activity.class);
                moveWithDataIntent.putExtra(detail_activity.EXTRA_NAME, getListKomik().get(position).getName());
                moveWithDataIntent.putExtra("book_url", getListKomik().get(position).getURL());
                moveWithDataIntent.putExtra("book_writer", getListKomik().get(position).getWriter());
                moveWithDataIntent.putExtra("book_price", getListKomik().get(position).getPrice());
                moveWithDataIntent.putExtra("book_year", getListKomik().get(position).getYear());
                moveWithDataIntent.putExtra("book_description", getListKomik().get(position).getDescription());
                context.startActivity(moveWithDataIntent);
            }
        }));

        holder.btShare.setOnClickListener(new CustomOnClickListener(position, new CustomOnClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareBody = getListKomik().get(position).getName() + " Tersedia di \n" + getListKomik().get(position).getPhoto();
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, getListKomik().get(position).getPhoto());
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                context.startActivity(Intent.createChooser(shareIntent, "share via"));
            }
        }));
    }
    @Override
    public int getItemCount()
    {
        return getListKomik().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvPrice, tvWriter, tvUrl;
        Button btDetails, btShare;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvWriter = itemView.findViewById(R.id.tv_item_writer);
            tvPrice = itemView.findViewById(R.id.tv_item_price);
            tvUrl = itemView.findViewById(R.id.tv_item_url);
            btDetails = itemView.findViewById(btn_set_details);
            btShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}