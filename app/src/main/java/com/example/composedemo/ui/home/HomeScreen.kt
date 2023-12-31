package com.example.composedemo.ui.home

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.ui.dashboard.DashboardActivity
import com.example.composedemo.mvvm.model.Details
import com.example.composedemo.mvvm.model.EmployDetails

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewModelScope
import com.example.composedemo.mvvm.view.activity.CreditCardScreenAcivity
import dagger.hilt.android.scopes.ViewScoped
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@Composable
fun HomeScreen() {
    DetailsContent()
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

@Composable
fun DetailsContent(productViewModel: HomeViewModel = hiltViewModel()) {
     productViewModel.fetchEmpDetails()
    val employees = remember {
        productViewModel._empDetails
    }
        //productViewModel._empDetails
        //remember { Details.EmployDetailsList }
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            employees
        ) {
            EmployeeCard(emp = it)
           // insertData
            //{
            LaunchedEffect(Unit) {
                productViewModel.viewModelScope.launch {
                    productViewModel.insertData()
                }
            }

                try {
                //   productViewModel.insertData()
                }catch (e:Exception){
                    e.printStackTrace()
                }
            //}

        }
    }
}
@Composable
fun EmployeeCard(emp: List<EmployDetails>) {
    var context= LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable(onClick = {
                context.startActivity((Intent(context, DashboardActivity::class.java)))

                //  startActivity(Intent(this@MainActivity, CreditCardScreenAcivity::class.java))
                /* val intent= Intent(this, NavigationDrawerActivity::class.java)
                intent.putExtra("name","Snehal")
                startActivity(intent)*/
            }),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        for (i in emp.indices) {
        Row(modifier = Modifier.padding(20.dp)) {

            Column(
                modifier = Modifier.weight(1f),
                Arrangement.Center
            ) {

                    Text(
                        text = emp.get(i).title,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    )
                    Text(
                        text = "Age :- " + emp.get(i).age.toString(),
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )
                    Text(
                        text = "Sex :- " + emp.get(i).sex,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 15.sp
                        )
                    )


                }
                Image(
                    painter = painterResource(emp.get(i).ImageId), contentDescription = "Profile Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .padding(8.dp)
                        .size(60.dp)
                        .clip((CircleShape))
                )
            }
        }
    }
}
