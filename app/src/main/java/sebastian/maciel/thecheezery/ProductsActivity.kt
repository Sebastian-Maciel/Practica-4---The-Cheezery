package sebastian.maciel.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.textclassifier.TextClassificationContext
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductsActivity : AppCompatActivity() {
    var coldDrinks = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        addProducts()

        var listView = findViewById(R.id.List_View) as ListView

        var adapter: ProductAdapter = ProductAdapter(this, coldDrinks)
        listView.adapter = adapter
    }

    fun addProducts(){
        coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "“Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.”", 5.0))
        coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.0))
        coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.0))
        coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.0))
        coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.0))
        coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream,\n" +
                "        mixed with peanut butter and chocolate.", 7.0))
    }

    private class ProductAdapter: BaseAdapter{
        var products = ArrayList<Product>()
        var context: Context? = null

        constructor(context: Context, products: ArrayList<Product>){
            this.products = products
            this.context = context
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod = products[position]
            var inflator = LayoutInflater.from(context)
            var view = inflator.inflate(R.layout.product_view, null)

            var productImage = view.findViewById(R.id.product_img) as ImageView
            var productName = view.findViewById(R.id.product_name) as TextView
            var productDescription = view.findViewById(R.id.product_description) as TextView
            var productPrice = view.findViewById(R.id.product_price) as TextView

            productImage.setImageResource(prod.image)
            productName.setText(prod.name)
            productDescription.setText(prod.description)
            productPrice.setText("$${prod.price}")

            return view
        }
    }
}