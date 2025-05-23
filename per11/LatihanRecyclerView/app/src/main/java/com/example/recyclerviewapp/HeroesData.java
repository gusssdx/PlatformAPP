package com.example.recyclerviewapp;

import java.util.ArrayList;

public class HeroesData {
    private static String[] heroNames = {
            "Kylian Mbappé",
            "Erling Haaland",
            "Jude Bellingham",
            "Harry Kane",
            "Vinícius Júnior",
            "Kevin De Bruyne",
            "Mohamed Salah",
            "Rodri",
            "Bukayo Saka",
            "Victor Osimhen",
            "Lautaro Martínez",
            "Martin Ødegaard",
            "Bruno Fernandes",
            "Robert Lewandowski",
            "Lionel Messi"
    };

    private static String[] heroDetails = {
            "Kylian Mbappé adalah bintang muda Prancis yang luar biasa dan dikenal sebagai salah satu pemain tercepat di dunia. Musim ini ia mencetak puluhan gol untuk Paris Saint-Germain, menjadi top skor Ligue 1, serta memimpin timnya ke berbagai kemenangan. Selain kecepatan dan teknik tinggi, Mbappé juga dikenal dengan kepemimpinannya dan kontribusinya di luar lapangan. Ia resmi akan bergabung dengan Real Madrid musim depan dalam transfer besar yang sangat dinantikan penggemar sepak bola.",
            "Erling Haaland adalah penyerang Norwegia milik Manchester City yang dikenal sebagai mesin gol. Dengan kekuatan fisik luar biasa, penyelesaian klinis, dan kemampuan membaca permainan, Haaland menjadi kunci keberhasilan City di Premier League dan Liga Champions. Di musim ini, ia kembali menjadi pencetak gol terbanyak klubnya meski sempat mengalami cedera. Keberadaannya selalu menjadi ancaman besar bagi pertahanan lawan.",
            "Jude Bellingham, gelandang muda asal Inggris, menjadi pusat perhatian setelah bergabung dengan Real Madrid. Meski masih berusia 20 tahun, ia menunjukkan kematangan luar biasa dalam mengontrol lini tengah, mencetak gol penting, dan memberikan assist. Gaya bermainnya yang agresif namun elegan menjadikannya salah satu pemain paling berpengaruh di La Liga musim ini, bahkan mendapat julukan sebagai 'The New Galáctico' oleh media Spanyol.",
            "Harry Kane adalah striker utama timnas Inggris yang musim ini bermain gemilang bersama Bayern Munich. Di musim debutnya di Bundesliga, ia langsung menjadi pencetak gol terbanyak dengan torehan luar biasa. Selain kemampuan mencetak gol, Kane juga dikenal dengan visi bermain dan kontribusinya dalam membangun serangan tim. Ia menjadi andalan utama dalam perebutan gelar Bundesliga dan Liga Champions bersama Bayern.",
            "Vinícius Júnior adalah winger asal Brasil yang bermain untuk Real Madrid. Ia dikenal dengan kecepatan, kelincahan, dan kemampuan dribbling luar biasa. Musim ini, Vinícius menunjukkan konsistensi luar biasa dengan kontribusi gol dan assist penting, terutama di laga-laga krusial seperti El Clásico. Ia juga mulai berkembang sebagai pemain yang matang secara taktik, menjadi salah satu penyerang terbaik di dunia.",
            "Kevin De Bruyne adalah playmaker utama Manchester City dan timnas Belgia. Meski sempat cedera panjang di awal musim, ia kembali dan langsung memberikan dampak besar bagi permainan City. Kemampuannya dalam mengirim umpan terukur, membaca permainan, dan menciptakan peluang menjadikannya motor serangan utama. Ia juga dikenal sebagai salah satu gelandang terbaik dunia dalam satu dekade terakhir.",
            "Mohamed Salah adalah bintang Liverpool asal Mesir yang tetap konsisten mencetak gol setiap musim. Di musim ini, ia mencatatkan lebih dari 20 gol dan beberapa assist, serta menjadi pemain kunci dalam persaingan Liverpool di papan atas Premier League. Salah juga dikenal dengan kerja kerasnya, loyalitasnya kepada klub, dan menjadi ikon sepak bola Afrika modern.",
            "Rodri, gelandang bertahan asal Spanyol yang bermain untuk Manchester City, tampil luar biasa di musim ini. Ia memiliki peran sentral dalam menjaga keseimbangan tim dengan kemampuan bertahan, distribusi bola akurat, dan ketenangan di bawah tekanan. Ia dikenal sebagai 'jantung' permainan City yang tidak tergantikan dan salah satu alasan utama kesuksesan tim dalam meraih trofi.",
            "Bukayo Saka adalah pemain muda berbakat dari Arsenal dan timnas Inggris yang terus berkembang menjadi salah satu winger terbaik di Premier League. Musim ini ia mencetak banyak gol penting, menciptakan assist, dan menjadi bagian penting dari strategi ofensif Mikel Arteta. Saka dikenal dengan kecepatan, etos kerja tinggi, serta kemampuannya dalam duel satu lawan satu.",
            "Victor Osimhen adalah striker asal Nigeria yang memperkuat Napoli. Ia tampil luar biasa dengan mencetak banyak gol dan membantu timnya mempertahankan posisi di papan atas Serie A. Dikenal dengan kecepatan, duel udara kuat, dan naluri gol tajam, Osimhen menjadi salah satu striker paling dicari di Eropa dan telah menarik perhatian klub-klub besar lainnya.",
            "Lautaro Martínez, penyerang Inter Milan asal Argentina, menunjukkan performa luar biasa musim ini dengan menjadi top skor Serie A. Ia dikenal dengan kerja keras, insting mencetak gol, dan kepemimpinannya sebagai kapten Inter. Lautaro membantu timnya dalam meraih gelar dan terus berkembang menjadi salah satu striker paling komplet di Eropa.",
            "Martin Ødegaard adalah kapten Arsenal dan gelandang kreatif asal Norwegia. Ia memiliki visi bermain luar biasa, teknik tinggi, dan menjadi otak serangan Arsenal. Musim ini Ødegaard tampil impresif dengan kontribusi besar dalam membangun permainan tim serta mencetak gol dari lini kedua. Ia juga menjadi inspirasi bagi pemain muda lainnya.",
            "Bruno Fernandes, gelandang asal Portugal, tetap menjadi andalan utama Manchester United. Meskipun timnya mengalami naik turun, Bruno tampil konsisten dengan banyak kontribusi gol dan assist. Ia juga dikenal sebagai pemimpin di lapangan yang mampu mengangkat semangat tim. Visi bermainnya dan kemampuan mengatur tempo menjadikannya sangat penting bagi tim.",
            "Robert Lewandowski, striker legendaris asal Polandia, masih menunjukkan kualitasnya bersama Barcelona di musim ini. Ia mencetak banyak gol penting dan membantu perkembangan pemain muda di tim. Lewandowski dikenal dengan insting mencetak gol, pergerakan tanpa bola, dan pengalaman luas di level tertinggi Eropa.",
            "Lionel Messi, meskipun kini bermain di MLS bersama Inter Miami, tetap menjadi ikon dunia sepak bola. Musim ini ia mencatatkan banyak gol dan assist, serta membawa timnya menjadi juara Leagues Cup. Selain kontribusi di lapangan, Messi juga terus menginspirasi jutaan penggemar di seluruh dunia dengan gaya bermain yang magis dan kepribadian rendah hati."
    };

    private static int[] heroesImages = {
            R.drawable.kylian_mbappe,
            R.drawable.erling_haaland,
            R.drawable.jude_bellingham,
            R.drawable.harry_kane,
            R.drawable.vinicius_junior,
            R.drawable.kevin_de_bruyne,
            R.drawable.mohamed_salah,
            R.drawable.rodri,
            R.drawable.bukayo_saka,
            R.drawable.victor_osimhen,
            R.drawable.lautaro_martinez,
            R.drawable.martin_odegaard,
            R.drawable.bruno_fernandes,
            R.drawable.robert_lewandowski,
            R.drawable.lionel_messi
    };

    static ArrayList<Hero> getListData() {
        ArrayList<Hero> list = new ArrayList<>();
        for (int position = 0; position < heroNames.length; position++) {
            Hero hero = new Hero();
            hero.setName(heroNames[position]);
            hero.setDetail(heroDetails[position]);
            hero.setPhoto(heroesImages[position]);
            list.add(hero);
        }
        return list;
    }
}
