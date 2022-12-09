package edu.upc.dsa.proyecto;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import edu.upc.dsa.proyecto.models.Ingrediente;

public class MyAdapterIngredientes extends RecyclerView.Adapter<MyAdapterIngredientes.ViewHolder> {

    private List<Ingrediente> listaIngredientes;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder

    public class ViewHolder extends RecyclerView.ViewHolder { // inner class , se encarga de guardar las referencias
        // each data item is just a string in this case
        public TextView TextViewNombreIngrediente;
        public ImageView icon;
        public View layout;

        public ViewHolder(View v) { //le pasamos la vista reciclada y nos la guardamos
            super(v);
            layout = v;
            TextViewNombreIngrediente = (TextView) v.findViewById(R.id.nombreObjeto);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }

    public void setData(List<Ingrediente> myDataset) { //muestro los contributors que me llegan
        listaIngredientes = myDataset;
        notifyDataSetChanged(); //avisamos al android que algo ha cambiado
    }

    public void add(int position, Ingrediente item) {
        listaIngredientes.add(position, item);
        notifyItemInserted(position); //avisamos al android de que ha cambiado la posición
    }

    public void remove(int position) {
        listaIngredientes.remove(position);
        notifyItemRemoved(position); //avisamos que hemos eliminado en esa posicion
    }

    public MyAdapterIngredientes() {
        listaIngredientes = new ArrayList<>();
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapterIngredientes(List<Ingrediente> myDataset) {
        listaIngredientes = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapterIngredientes.ViewHolder onCreateViewHolder(ViewGroup parent, //onCreate al hacer scroll
                                                               int viewType) {
        // create a new view, convierte xml en layout
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false); //pasamos el nombre del layout y lo colgamos en el parent
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v); //creamos un viewholder pasandole la vista
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        Ingrediente c = listaIngredientes.get(position); //me guardo la posición
        final String name = c.nombreIngrediente; //recupero el login del contributor
        holder.TextViewNombreIngrediente.setText(name);
        holder.TextViewNombreIngrediente.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) { //relaciono el holder a un evento para que haga una acción, cuando me cliques, borrame
                remove(holder.getAdapterPosition());
            }
        });
        /* //IMAGENES
        GlideApp.with(holder.icon.getContext())
                .load(c.avatar_url) //url que quiero cargar
                .into(holder.icon); //imagen que quiero cargar

         */
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listaIngredientes.size();
    }

}