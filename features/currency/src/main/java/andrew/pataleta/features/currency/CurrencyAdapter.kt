package andrew.pataleta.features.currency

import andrew.pataleta.domain.model.CurrencyItem
import andrew.pataleta.features.currency.databinding.ItemCurrencyBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CurrencyAdapter(private val currencyList: List<CurrencyItem>, private val viewModel: CurrencyViewModel) : RecyclerView.Adapter<CurrencyAdapter.CurrencyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyHolder {
        val itemBinding =
            ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CurrencyHolder(itemBinding, viewModel)
    }

    override fun onBindViewHolder(holder: CurrencyHolder, position: Int) {
        val currency: CurrencyItem = currencyList[position]
        holder.bind(currency)
    }

    override fun getItemCount(): Int = currencyList.size

    class CurrencyHolder(private val itemBinding: ItemCurrencyBinding, private val viewModel: CurrencyViewModel) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(currency: CurrencyItem) {
            itemBinding.name.text = currency.key
            itemBinding.value.text = currency.value.toString()
        }
    }


}