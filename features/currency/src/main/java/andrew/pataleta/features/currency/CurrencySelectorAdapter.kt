package andrew.pataleta.features.currency


import andrew.pataleta.domain.model.SymbolItem
import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CurrencySelectorAdapter(context: Context, var symbols: List<SymbolItem>, var viewModel: CurrencyViewModel) :
    BaseAdapter() {

    private val mInflator: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return symbols.size
    }

    override fun getItem(position: Int): Any {
        return symbols[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val symbolItem: SymbolItem = symbols.get(position)
        val view: View? = this.mInflator.inflate(R.layout.item_currency_selector, parent, false)
        view?.findViewById<TextView>(R.id.name)!!.text = symbolItem.key
        view.findViewById<TextView>(R.id.description)!!.text = symbolItem.value
        return view
    }

}