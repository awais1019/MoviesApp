import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.moviesapp.models.Movie

@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(6.dp)
            .width(200.dp)
          ,
        colors = CardDefaults.cardColors(containerColor = Color.White), // Set card background color to white
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column {
            Image(
                painter = rememberImagePainter(
                    data = movie.image,
                    builder = {
                        placeholder(android.R.drawable.ic_menu_report_image) // Placeholder image while loading
                        error(android.R.drawable.ic_menu_close_clear_cancel) // Error image if failed
                    }
                ),
                contentDescription = movie.title,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )


            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${movie.title} (${movie.year})",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                text = "Rating: ${movie.imdbRating}",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun MoviesGrid(movies: List<Movie>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(movies) { movie ->
            MovieCard(movie = movie)
        }
    }
}
