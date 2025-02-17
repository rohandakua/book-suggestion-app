package com.example.bookssuggestionapp.ui_screens
import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.example.bookssuggestionapp.R
import com.example.bookssuggestionapp.data.DataX
import com.example.bookssuggestionapp.data.ImageLinks
import com.example.bookssuggestionapp.data.IndustryIdentifier
import com.example.bookssuggestionapp.data.PanelizationSummary
import com.example.bookssuggestionapp.data.ReadingModes
import com.example.bookssuggestionapp.data.VolumeInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.http.GET

val demo = DataX(
    etag = "ZK8ST3zhg0U",
    id = 43,
    kind = "books#volume",
    volumeInfo = VolumeInfo(
        allowAnonLogging = false,
        authors = listOf("W. Bernard Carlson"),
        averageRating = 4.0,
        canonicalVolumeLink = "https://books.google.co.in/books/about/Tesla.html?hl=&id=VWyYDwAAQBAJ&redir_esc=y",
        categories = listOf("Biography & Autobiography"),
        contentVersion = "0.0.1.0.preview.1",
        description = "Nikola Tesla was a major contributor to the electrical revolution that transformed daily life at the turn of the twentieth century. His inventions, patents, and theoretical work formed the basis of modern AC electricity, and contributed to the development of radio and television. Like his competitor Thomas Edison, Tesla was one of America's first celebrity scientists, enjoying the company of New York high society and dazzling the likes of Mark Twain with his electrical demonstrations. An astute self-promoter and gifted showman, he cultivated a public image of the eccentric genius. Even at the end of his life when he was living in poverty, Tesla still attracted reporters to his annual birthday interview, regaling them with claims that he had invented a particle-beam weapon capable of bringing down enemy aircraft. Plenty of biographies glamorize Tesla and his eccentricities, but until now none has carefully examined what, how, and why he invented. In this groundbreaking book, W. Bernard Carlson demystifies the legendary inventor, placing him within the cultural and technological context of his time, and focusing on his inventions themselves as well as the creation and maintenance of his celebrity. Drawing on original documents from Tesla's private and public life, Carlson shows how he was an \\\"idealist\\\" inventor who sought the perfect experimental realization of a great idea or principle, and who skillfully sold his inventions to the public through mythmaking and illusion. This major biography sheds new light on Tesla's visionary approach to invention and the business strategies behind his most important technological breakthroughs.",
        imageLinks = ImageLinks(smallThumbnail = "http://books.google.com/books/content?id=VWyYDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api", thumbnail = "http://books.google.com/books/content?id=VWyYDwAAQBAJ&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"),
        industryIdentifiers = listOf(IndustryIdentifier(identifier = "9780691165615", type = "ISBN_13")),
        infoLink = "http://books.google.co.in/books?id=VWyYDwAAQBAJ&dq=tesla&hl=&source=gbs_api",
        language = "en",
        maturityRating = "NOT_MATURE",
        pageCount = 516,
        panelizationSummary = PanelizationSummary(containsEpubBubbles = false,false),
        previewLink = "http://books.google.co.in/books?id=VWyYDwAAQBAJ&printsec=frontcover&dq=tesla&hl=&cd=3&source=gbs_api",
        printType = "BOOK",
        publishedDate = "2015-04-27",
        publisher = "Princeton University Press",
        ratingsCount = 3,
        readingModes = ReadingModes(image = true, text = false),
        subtitle = "Inventor of the Electrical Age",
        title = "Tesla"
    )
)




@Composable
@Preview
fun eachItemClicked(modifier: Modifier = Modifier
    .fillMaxSize()
    .background(colorResource(id = R.color.backgroundCustom))
         ,book : DataX=demo) {
    val painterof = rememberAsyncImagePainter("https://fastly.picsum.photos/id/24/4855/1803.jpg?hmac=ICVhP1pUXDLXaTkgwDJinSUS59UWalMxf4SOIWb9Ui4")

    Box(modifier = modifier,){
        Column {
            Spacer(modifier = Modifier.size(50.dp))
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
            Card (
                modifier= Modifier
                    .heightIn(min = 100.dp, max = 200.dp),
                colors = CardDefaults.cardColors(containerColor = Color.Cyan),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
            ){

                    Image(painter = painterof,
                        contentScale = ContentScale.Crop,
                        contentDescription = null ,
                        modifier = Modifier.size(width = 200.dp, height = 180.dp))
                }
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column (modifier= Modifier
                .fillMaxSize()
                .padding(10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start){

                Text(text = book.volumeInfo.title ?: "kfjdskfsd",
                    style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 30.sp, fontWeight = FontWeight.ExtraBold),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(text = book.volumeInfo.subtitle ?: "kfjdskfsd",
                    style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 25.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier.padding(bottom = 3.dp)
                )

                Box(modifier = Modifier
                    .size(width = 300.dp, height = 1.dp)
                    .border(
                        BorderStroke(2.dp, color = Color.LightGray),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(bottom = 8.dp))
                Spacer(modifier = Modifier.size(10.dp))

                Box(modifier = Modifier
                    .heightIn(min = 200.dp, max = 200.dp)
                    .fillMaxWidth()){
                    Text(text = book.volumeInfo.description  ?: "kfjdskfsd",
                        style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 20.sp, fontWeight = FontWeight.ExtraLight),
                        modifier = Modifier.verticalScroll(rememberScrollState())
                            )

                }
                Spacer(modifier = Modifier.size(40.dp))

                Row (modifier=Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Text(text = book.volumeInfo.averageRating.toString()  ?: "kfjdskfsd",
                        style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 25.sp, fontWeight = FontWeight.Light))
                    Text(text = book.volumeInfo.authors.joinToString(separator = " ")  ?: "kfjdskfsd",
                        style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 20.sp, fontWeight = FontWeight.SemiBold))


                }
                Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                    ){
                    Text(text = book.volumeInfo.canonicalVolumeLink)
                }



            }
        }









    }

}

