package tgs.app.aneka_makanan_indonesia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import tgs.app.aneka_makanan_indonesia.databinding.ActivityDetailBinding
import tgs.app.aneka_makanan_indonesia.model.Food

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    companion object {
        val DATA_FOOD = "data_food"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Food>(DATA_FOOD)

        if (data != null) {
            binding.imgFood.setImageResource(data.photo)
            binding.textTitle.text = data.name
            binding.textDescription.text = data.description
            binding.textIngredient.text = data.ingredient
            binding.textProcedure.text = data.procedure
        }

        supportActionBar?.title = data?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}