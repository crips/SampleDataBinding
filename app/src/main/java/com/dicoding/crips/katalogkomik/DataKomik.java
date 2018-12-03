package com.dicoding.crips.katalogkomik;

import java.util.ArrayList;

public class DataKomik {
    public static String[][] data = new String[][] {
            {"Ngopi, Yuk! Di Warkop Pak Gundul", "https://www.grobmart.com/image/cache/data/produk/9786022202462-500x500.jpg", "Assyfa S. Arum & Romi Hernadi", "65.000", "2017", "Warung kopi adalah tempat yang paling asik buat ngomongin semua hal. Semua? Iya, semua. Yuk, ikut ngobrol bareng Pak Gundul"},
            {"Si Juki: Petualangan di Korea", "https://www.grobmart.com/image/cache/data/00seller00/9786020441238_si-juki-seri-jalan-jalan_petualangan-di-korea-500x500.jpg", "Faza Ibnu Ubaydillah Salman", "65.000", "2017", "Kali ini Si Juki berpetualang ke negeri ginseng, yaitu Korea dan bertemu dengan sepasang duo larva yang sangat terkenal disana. Ayo ikuti keseruan petualangan si Juki yg lucu dan konyol abis..."},
            {"Si Juki dan Petualangan Lulus UN", "https://5hwbfg.bl.files.1drv.com/y4mnjmtD4eLZD2h7OCgixptRr88tk6CJaaPwMfJAGlX47TePd-zh_-EPrI-xayaQVh7owSwCC3WWFByy1UJPiRVYGKu0ASMcAncWEqeIsyAyF11gL89Nh_layT1Z_emHniWlLxp7Bl9yU-PujBnw-uapQVYA5JnqjO0faQhDytPU8-smEMff3sYoqOW-Mz4YK1Vt08Y52PalXoJq-YTs_NxUg?width=660&height=660&cropmode=none", "Faza Ibnu Ubaydillah Salman", "33.000", "2012", "Juki berjuang untuk lulus dari sekolahnya, segala macam cara sampai yang mainstream dicoba. Ikuti kelanjutan kisahnya"},
            {"KKPK Next G Selebgram", "https://www.grobmart.com/image/cache/data/produk/Buku/Selebgram%20Komik%20KKPK-500x500.jpg", "Aryasatya Malik A & Indha", "29.000", "2015", "Nisa yang pintar di sekolah selalu jadi andalan setiap ada lomba cerdas cermat, jadi tak punya banyak waktu untuk berteman.\n" +
                    "Sementara Dennis yang nilai Matematikanya selalu jelek sangat populer di Instagram. Bagaimana ya, Nisa dan Dennis bisa bekerja sama?"},
            {"Komikluks : Millennial Lokal", "https://www.grobmart.com/image/cache/data/Milennial%20Lokal-500x500.JPG", "Ade Lukman", "65.000", "2018", "Komik yang berani mengakat kehidupan anak zaman now dan tren millennial dengan pembawaan khas komikus, tetapi tetap memberikan sentuhan komedi. Sehingga pembaca tidak dibuat tegang apalagi sampai kesel karena mirip dengan aib dirinya."},
            {"Kkpk.Next G Boneka Jalanan", "https://www.grobmart.com/image/cache/data/00seller00/9786023673353_kkpk.next-g-boneka-jalanan-500x500.jpg", "Putri Latifa Irvi S & Nisa, Dkk", "30.000", "2017", "Nisa dan adiknya, Salsa, menemukan sebuah boneka di taman kota. Mereka sepakat untuk membawanya pulang. Anehnya, ekspresi wajah boneka itu bisa berubah-ubah. Mereka jadi ketakutan. Sepertinya, ada sesuatu tentang boneka itu"},
            {"Ghosty's Comic : Khilafpedia", "https://www.grobmart.com/image/cache/data/00seller00/Ghosty's%20Khilafpedia-500x500.png", "Raden Fajar Hardian Putra", "48.000", "2017", "Ghosty adalah komik yang ramai di komunitas pecinta action figure. Setiap kali mengadakan acara merchandise dan boothnya dipenuhi fansnya. Kini sedang mulai kiprahnya di webtoon."}
    };

    public static ArrayList<Komik> getListData() {
        Komik komik;
        ArrayList<Komik> list = new ArrayList<>();

        for (int i = 0; i < data.length; i++) {
            komik = new Komik();
            komik.setName(data[i][0]);
            komik.setPhoto(data[i][1]);
            komik.setWriter(data[i][2]);
            komik.setPrice(data[i][3]);
            komik.setYear(data[i][4]);
            komik.setDescription(data[i][5]);
            komik.setURL(data[i][1]);

            list.add(komik);
        }

        return list;
    }
}