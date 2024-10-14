package com.example.stars;

import static com.example.stars.R.id.toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.MenuItemCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stars.adapter.StartAdapter;
import com.example.stars.beans.Star;
import com.example.stars.service.StarService;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.List;

public class ListActivity extends AppCompatActivity {
 private List<Star> stars;
 private RecyclerView recyclerView;
 private StarService service;

 private StartAdapter starAdapter=null;
 private void init() {
     service.creat(new Star("Lionel Messi", "https://upload.wikimedia.org/wikipedia/commons/b/b4/Lionel-Messi-Argentina-2022-FIFA-World-Cup_%28cropped%29.jpg", 3.5f));
     service.creat(new Star("Cristiano Ronaldo", "https://hips.hearstapps.com/hmg-prod/images/cristiano-ronaldo-of-portugal-reacts-as-he-looks-on-during-news-photo-1725633476.jpg?crop=0.666xw:1.00xh;0.180xw,0&resize=1200:*", 3.5f));
     service.creat(new Star("Kylian Mbappé", "https://static.cnews.fr/sites/default/files/styles/image_750_422/public/iconsport_189085_0012-taille1200_65fc3abac8a4c_0.jpg?itok=mNz7F5an", 3.5f));
     service.creat(new Star("Neymar Jr", "https://media.lesechos.com/api/v1/images/view/6239ac01c503af4ffa6f7055/1024x576-webp/0701192247383-web-tete.webp", 3.5f));
     service.creat(new Star("Mohamed Salah", "https://media.sudouest.fr/12521551/1000x500/98269212.jpg?v=1665169767", 3.5f));
     service.creat(new Star("Kevin De Bruyne", "https://medias.lequipe.fr/img-photo-jpg/hakim-ziyech-titulaire-pour-la-premiere-fois-avec-chelsea-face-a-krasnodar-ce-mercredi-alastair-g/1500000001403273/0:34,1911:1309-624-468-75/b480a.jpg", 3.5f));
     service.creat(new Star("Robert Lewandowski", "https://www.lavieeco.com/wp-content/uploads/2024/01/achraf-hakimi-1536x864.jpg", 3.5f));
     service.creat(new Star("Sadio Mané", "https://ichef.bbci.co.uk/ace/ws/800/cpsprodpb/DF08/production/_123169075_gettyimages-sadiomanor.jpg.webp", 3.5f));
     service.creat(new Star("Gareth Bale", "https://assets.goal.com/images/v3/bltf19d7c09e53510e3/Brahim_Diaz_Real_Madrid_2023-24_(4).jpg?auto=webp&format=pjpg&width=640&quality=60", 3.5f));
     service.creat(new Star("Karim Benzema", "https://prod-media.beinsports.com/image/1699549307752_51c7e9b0-44cd-4958-94a1-db05106615c8.1080.jpg?ver=28-06-2024", 3.5f));
     service.creat(new Star("Luka Modrić", "https://media.ouest-france.fr/v1/pictures/MjAyNDA2MGM4NDU1N2ZjZWM2MzUzY2M0YjQ2YmQ0OTJiNmY0YTM?width=630&height=354&focuspoint=50%2C25&cropresize=1&client_id=bpeditorial&sign=76b034e69c74420008749c074c8ec3e655be700c1fbfba000718db829c46e492", 3.5f));
     service.creat(new Star("Virgil van Dijk", "https://prod-media.beinsports.com/image/1708344035090_b5d76e78-e451-4e2a-be8b-02692b8dfebf.1080.jpg?ver=28-06-2024", 3.5f));
     service.creat(new Star("Zlatan Ibrahimović", "https://assets.goal.com/images/v3/bltbb4f0acadc12a3eb/b49b1ff92300a66a3adc1fab39e8bca60bca5918.jpg?auto=webp&format=pjpg&width=640&quality=60", 3.5f));
 }
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list);
        service=StarService.getInstance();
       StarService service2=StarService.getInstance();
        init();
        System.out.println(service2.findAll().toString());
        recyclerView=findViewById(R.id.recycleView);
        starAdapter=new StartAdapter(service.findAll(),this);
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
     if(item.getItemId()==R.id.share){
         String txt="stars";
         String mimeType="text/plain";
         ShareCompat.IntentBuilder
                 .from(this)
                 .setType(mimeType)
                 .setChooserTitle("stars")
                 .startChooser();

     }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
     Log.d("de","diididif");
        getMenuInflater().inflate(R.menu.main_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.searchView);
        SearchView searchView1 = (SearchView) menuItem.getActionView();
        searchView1.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        searchView1.setBackgroundResource(R.drawable.serachview);
        searchView1.setIconifiedByDefault(false);
        searchView1.setAlpha(0f);
        searchView1.setVisibility(View.VISIBLE);
        searchView1.setTranslationX(-searchView1.getWidth());
        searchView1.setVisibility(View.VISIBLE);
        searchView1.animate()
                .translationX(0)
                .setDuration(300)
                .alpha(1f);

        searchView1.animate().alpha(1f).setDuration(300);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("Search", "Submitted: " + query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(starAdapter!=null){
                    starAdapter.getFilter().filter(newText);
                }
                Log.d("Search", "Changed: " + newText);
                return true;
            }
        });

        return true;
    }

}