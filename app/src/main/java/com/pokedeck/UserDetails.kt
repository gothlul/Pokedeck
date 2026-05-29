package com.pokedeck

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CartaPokemon(
    val imagem: Int,
    val quantidade: Int
)

@Composable
fun UserDetails() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Cabeçalho (seu componente já pronto)
        // Cabecalho()

        // Conteúdo do meio: ocupa o espaço restante e rola
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            SecaoPerfil()
            Vitrine()
        }

        // Navegação inferior (seu componente já pronto)
        // NavegacaoInferior()
    }
}

@Composable
fun SecaoPerfil() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Foto de perfil (avatar redondo)
            Image(
                painter = painterResource(id = R.drawable.user_icon),
                contentDescription = "Avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "chermatth",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Matthieu Cherbonnier",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                BarraProgresso(progresso = 0.8f)

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "8/10 - REPETIDAS: 67",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Beaupreau",
                        fontWeight = FontWeight.Bold
                    )
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Localização"
                    )
                }
            }
        }
    }
}


@Composable
fun BarraProgresso(progresso: Float) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(14.dp)
            .clip(RoundedCornerShape(50))
            .background(Color(0xFFE0E0E0))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progresso)
                .fillMaxHeight()
                .clip(RoundedCornerShape(50))
                .background(Color(0xFFE91E63))
        )
    }
}


@Composable
fun Vitrine() {

    // Lista das cartas que vão aparecer na vitrine
    val cartas = listOf(
        CartaPokemon(R.drawable.carta1, 1),
        CartaPokemon(R.drawable.carta2, 2),
        CartaPokemon(R.drawable.carta3, 1),
        CartaPokemon(R.drawable.carta4, 12),
        CartaPokemon(R.drawable.carta5, 6),
        CartaPokemon(R.drawable.carta6, 7)
    )

    Column(
        modifier = Modifier.padding(16.dp)
    ) {

        Text(
            text = "Vitrine",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        HorizontalDivider(
            modifier = Modifier.padding(bottom = 32.dp).padding(top = 8.dp),
            thickness = 4.dp,
            color = Color.Black
        )

        cartas.chunked(3).forEach { linha ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                linha.forEach { carta ->
                    CartaItem(
                        carta = carta,
                        modifier = Modifier.weight(1f)
                    )
                }

                if (linha.size < 3) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}


@Composable
fun CartaItem(
    carta: CartaPokemon,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.height(200.dp)
    ) {
        Image(
            painter = painterResource(id = carta.imagem),
            contentDescription = "Carta",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF1A1A1A))
                .padding(horizontal = 8.dp, vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("QUANTIDADE:", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
            Text(carta.quantidade.toString(), color = Color(0xFFE91E63), fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}