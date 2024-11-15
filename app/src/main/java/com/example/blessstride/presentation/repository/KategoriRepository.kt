package com.example.blessstride.presentation.repository

import com.example.blessstride.presentation.model.Kategori

class KategoriRepository {
    private val kategori = listOf(
        Kategori(1, "Nike", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlAHSjq7Gk3-FboSL_OMkC42bdCkxD12e4mw&s", 13, 10),
        Kategori(2, "Converse", "https://i.etsystatic.com/28004676/r/il/af811e/4790455595/il_570xN.4790455595_2c6q.jpg", 10, 2),
        Kategori(3, "Skechers", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7aNPX8tuksRa71jxFDKJA86Bqd0S3GjIptQ&s", 12, 5),
        Kategori(4, "Adidas", "https://m.media-amazon.com/images/I/610k7umwL6L.AC_UY1000.jpg", 15, 15),
        Kategori(5, "Diadora", "https://static.promediateknologi.id/crop/3x0:998x1033/750x500/webp/photo/p1/1037/2024/03/25/sepatu-diadora-2632610908.jpg", 9, 8),
        Kategori(6, "NB", "https://i5.walmartimages.com/asr/239ebc1e-5f55-473e-9e6d-7129da8796c5_1.1fe616728db3f553d66c577238fed94f.jpeg", 11, 20),
        Kategori(7, "Ardiles", "https://sportaways.com/pub/media/catalog/product/cache/cd7c6c71a47e90564e17811b95cac4e3/s/e/sepatu_running_ardiles_nfinity_raiton_-_putih-merah_1.jpg", 13, 25),
        Kategori(8, "Kronikel", "https://down-id.img.susercontent.com/file/id-11134207-7r98o-lnaz3phez4avbd", 18, 80),
        Kategori(9, "Airwalk", "https://down-id.img.susercontent.com/file/sg-11134201-22100-2ssrc01rwpiv8d", 20, 50),
        Kategori(10, "Aerostreet", "https://cf.shopee.co.id/file/5ba37e4f8fdb1485f05e2693767db4e7", 10, 4),
    )

    fun getKategori() : List<Kategori> {
        return kategori
    }
}