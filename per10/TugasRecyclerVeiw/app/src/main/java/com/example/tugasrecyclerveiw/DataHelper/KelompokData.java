package com.example.tugasrecyclerveiw.DataHelper;

import com.example.tugasrecyclerveiw.Kelompok;
import com.example.tugasrecyclerveiw.R;

import java.util.ArrayList;

public class KelompokData {
    private static String[] kelompokNames = {
            "Elvira Zaretti",
            "Hary Capri",
            "Iqbal Fardhani Pohan",
            "Bagus Tri Handoko",
            "Muhammad Hunaify Mu’izzy",
            "Elvira Zaretti",
            "Hary Capri",
            "Iqbal Fardhani Pohan",
            "Bagus Tri Handoko",
            "Muhammad Hunaify Mu’izzy"
    };

    private static String[] kelompokDetails = {
            "Lahir di Jakarta, 9 mei 2005. Anak ke-2 dari 3 bersaudara. Tinggal di Tangerang Selatan. Mempunyai hobi berbelanja dan mengoleksi mainan lucu. Sedang berkuliah di prodi S1 Informatika dan bercita-cita menjadi data scientist atau data analyst.",
            "Lahir di Bekasi, 22 April 2004. Anak ke-3 dari 3 bersaudara. Tinggal di Kab Bekasi. Memiliki hobi membaca buku dan bernyanyi. Sedang menempuh dan bertekad untuk bekerja pada bidang Software Developer salah satu fokusnya adalah Fullstack Developer.",
            "Lahir di Jakarta, 3 Juni 2005. Anak tunggal. Tinggal di Depok. Suka bermain video game dan membaca novel. Sedang berkuliah di prodi S1 Informatika dan memiliki impian bekerja sebagai Front-End Web Developer atau Game Developer.",
            "Nama saya Bagus Tri Handoko, lahir di Jakarta, 15 Agustus 2004, anak ke-3 dari 3 bersaudara. Saya tinggal di CIbinong, Bogor. Hobi saya adalah berolahraga seperti joging dan bermain bulu tangkis. Harapan saya dapat bekerja dibidang Data science atau Data analyst.",
            "Lahir di Jakarta, 26 Juni 2003. Anak ke-3. Tinggal di Jakarta Pusat. Suka bermain game. Ingin bekerja di bidang yang berkaitan dengan pemrograman dan visual seperti game development, dsb.",
            "Lahir di Jakarta, 9 mei 2005. Anak ke-2 dari 3 bersaudara. Tinggal di Tangerang Selatan. Mempunyai hobi berbelanja dan mengoleksi mainan lucu. Sedang berkuliah di prodi S1 Informatika dan bercita-cita menjadi data scientist atau data analyst.",
            "Lahir di Bekasi, 22 April 2004. Anak ke-3 dari 3 bersaudara. Tinggal di Kab Bekasi. Memiliki hobi membaca buku dan bernyanyi. Sedang menempuh dan bertekad untuk bekerja pada bidang Software Developer salah satu fokusnya adalah Fullstack Developer.",
            "Lahir di Jakarta, 3 Juni 2005. Anak tunggal. Tinggal di Depok. Suka bermain video game dan membaca novel. Sedang berkuliah di prodi S1 Informatika dan memiliki impian bekerja sebagai Front-End Web Developer atau Game Developer.",
            "Nama saya Bagus Tri Handoko, lahir di Jakarta, 15 Agustus 2004, anak ke-3 dari 3 bersaudara. Saya tinggal di CIbinong, Bogor. Hobi saya adalah berolahraga seperti joging dan bermain bulu tangkis. Harapan saya dapat bekerja dibidang Data science atau Data analyst.",
            "Lahir di Jakarta, 26 Juni 2003. Anak ke-3. Tinggal di Jakarta Pusat. Suka bermain game. Ingin bekerja di bidang yang berkaitan dengan pemrograman dan visual seperti game development, dsb."
    };

    private static int[] kelompokImages = {
            R.drawable.elvira_zaretti,
            R.drawable.hary_capri,
            R.drawable.iqbal_fardhani_pohan,
            R.drawable.bagus_tri_handoko,
            R.drawable.muhammad_hunaify_muizzy,
            R.drawable.elvira_zaretti,
            R.drawable.hary_capri,
            R.drawable.iqbal_fardhani_pohan,
            R.drawable.bagus_tri_handoko,
            R.drawable.muhammad_hunaify_muizzy
    };

    public static ArrayList<Kelompok> getListData() {
        ArrayList<Kelompok> list = new ArrayList<>();
        for (int position = 0; position < kelompokNames.length; position++) {
            Kelompok kelompok = new Kelompok();
            kelompok.setName(kelompokNames[position]);
            kelompok.setDetail(kelompokDetails[position]);
            kelompok.setPhoto(kelompokImages[position]);
            list.add(kelompok);
        }
        return list;
    }
}

