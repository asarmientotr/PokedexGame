package pe.edu.ulima.pm.work31.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.work31.R
import pe.edu.ulima.pm.work31.adapter.FavoritoListAdapter
import pe.edu.ulima.pm.work31.adapter.PokemonListAdapter
import pe.edu.ulima.pm.work31.model.Pokemon
import pe.edu.ulima.pm.work31.model.PokemonManager

class FavoritoFragment(val favoritos: List<Pokemon>):Fragment() {
    interface OnSelectFavorite{
        fun onDelete(pokemon: Pokemon)
    }

    private var listener : OnSelectFavorite?=null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnSelectFavorite
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favoritos,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycFavoritos= view.findViewById<RecyclerView>(R.id.recycFavoritos)

        recycFavoritos.adapter = FavoritoListAdapter(
            favoritos,
        ) {
                pokemon: Pokemon ->
            Log.i("FavoritoFragment",pokemon.name)
            listener?.onDelete(pokemon)
        }

    }

}